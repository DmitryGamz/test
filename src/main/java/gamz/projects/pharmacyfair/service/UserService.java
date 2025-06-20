package gamz.projects.pharmacyfair.service;

import gamz.projects.pharmacyfair.model.dto.UserDTO;
import gamz.projects.pharmacyfair.model.entity.User;
import gamz.projects.pharmacyfair.model.exception.UserNotFoundException;
import gamz.projects.pharmacyfair.model.mapper.UserMapper;
import gamz.projects.pharmacyfair.model.request.ChangePasswordRequest;
import gamz.projects.pharmacyfair.model.request.UserRequest;
import gamz.projects.pharmacyfair.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Transactional(readOnly = true)
    public UserDTO getCurrentUserProfile() {
        User user = this.getUserBySecurityContext();
        return userMapper.toUserDTOFromUser(user);
    }

    @Transactional
    public UserDTO updateCurrentUserProfile(UserRequest request) {
        User user = this.getUserBySecurityContext();

        userMapper.updateUserFromDTO(request, user);

        userRepository.save(user);
        return userMapper.toUserDTOFromUser(user);
    }

    @Transactional
    public void changePassword(ChangePasswordRequest request) {
        User user = this.getUserBySecurityContext();

        if (passwordEncoder.matches(request.getNewPassword(), user.getPassword())) {
            throw new IllegalArgumentException("Новый пароль должен отличаться от старого");
        }

        user.setPassword(passwordEncoder.encode(request.getNewPassword()));
        userRepository.save(user);
    }

    @Transactional()
    public User getUserBySecurityContext() {
        UserDetails userDetails = this.getUserDetails();
        return userRepository.findByEmail(userDetails.getUsername())
                .orElseThrow(() -> new UserNotFoundException("Пользователь с таким именем не существует"));
    }

    public UserDetails getUserDetails() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails userDetails) {
            return userDetails;
        }
        else {
            throw new UserNotFoundException("Authentication failure");
        }
    }

    @Transactional(readOnly = true, propagation = Propagation.MANDATORY)
    public Page<UserDTO> findAllByPage(int page, int size) {
        if (page < 0 || size <= 0) {
            throw new IllegalArgumentException("Invalid page or size");
        }
        Pageable pageable = PageRequest.of(page, size, Sort.by("username").ascending());

        Page<User> usersPage = userRepository.findAll(pageable);
        return usersPage.map(this::convertToDTO);
    }

    @Transactional(readOnly = true)
    public User findById(long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Пользователь с таким ID не существует"));
    }

    @Transactional(readOnly = true)
    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("Пользователь с таким ID не существует"));
    }

    private UserDTO convertToDTO(User user) {
        return userMapper.toUserDTOFromUser(user);
    }

    @Transactional
    public void deleteCurrentUser() {
        User user = getUserBySecurityContext();
        userRepository.delete(user);
    }
}