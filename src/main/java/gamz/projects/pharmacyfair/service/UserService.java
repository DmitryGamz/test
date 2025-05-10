package gamz.projects.pharmacyfair.service;

import gamz.projects.pharmacyfair.model.dto.UserDTO;
import gamz.projects.pharmacyfair.model.entity.User;
import gamz.projects.pharmacyfair.model.mapper.UserMapper;
import gamz.projects.pharmacyfair.model.mapper.UserMapperImpl;
import gamz.projects.pharmacyfair.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    @Transactional(readOnly = true)
    public Page<UserDTO> findAllByPage(int page, int size) {
        // Проверка на валидность параметров
        if (page < 0 || size <= 0) {
            throw new IllegalArgumentException("Invalid page or size");
        }
        // Используем PageRequest для пагинации
        Pageable pageable = PageRequest.of(page, size, Sort.by("username").ascending());

        Page<User> usersPage = userRepository.findAll(pageable);
        return usersPage.map(this::convertToDTO);
    }

    private UserDTO convertToDTO(User user) {
        return userMapper.toUserDTOFromUser(user);
    }
}