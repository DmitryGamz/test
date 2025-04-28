package gamz.projects.pharmacyfair.model.dto;

import java.util.List;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class UserDTO {
	private final int id;
	@NonNull
	private final String email;
	private final String firstName;
	private final String lastName;
	private final String middleName;
	private final String organization;
	private final String jobTitle;
	private final String phone;
	private final String sharingConsent;
	private final String participationStatus;
	private final String verificationStatus;
	private final String lastLogin;
	private final boolean isActive;
	private final String avatarPath;
	private final String createdAt;
	private final String updatedAt;
	private final String lastActivity;
	private final List<String> roles;
}
