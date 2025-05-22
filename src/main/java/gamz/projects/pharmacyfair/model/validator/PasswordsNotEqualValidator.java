package gamz.projects.pharmacyfair.model.validator;

import gamz.projects.pharmacyfair.model.annotation.PasswordsNotEqual;
import gamz.projects.pharmacyfair.model.request.ChangePasswordRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordsNotEqualValidator implements ConstraintValidator<PasswordsNotEqual, ChangePasswordRequest> {

    @Override
    public boolean isValid(ChangePasswordRequest request, ConstraintValidatorContext context) {
        if (request == null) return true;

        String newPassword = request.getNewPassword();
        String newPasswordRepeat = request.getNewPasswordRepeat();

        return newPasswordRepeat.equals(newPassword);
    }
}
