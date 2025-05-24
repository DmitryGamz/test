package gamz.projects.pharmacyfair.service;

import gamz.projects.pharmacyfair.util.Constants;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;

    public void sendEmail(String to, String subject, String text) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, "utf-8");

            helper.setText(text, true);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setFrom("super.vvebmaster@gmail.com");

            mailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException("Не удалось отправить письмо: " + e.getMessage());
        }
    }

    public void sendVerificationLink(String to, String token) {
        this.sendEmail(
                to,
                "Подтверждение регистрации",
                "<p>Здравствуйте!</p><p>Перейдите по <a href=\"" + Constants.BASE_URL + "verify/" + token + "\">ссылке</a> для подтверждения.</p>"
        );
    }
}
