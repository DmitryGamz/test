package gamz.projects.pharmacyfair.model.annotation;

import gamz.projects.pharmacyfair.model.validator.UniqueSettingKeyValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueSettingKeyValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueSettingKey {
    String message() default "Ключ настройки уже существует";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}