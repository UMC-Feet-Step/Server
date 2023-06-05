package com.footstep.domain.mail.service;

import com.footstep.domain.base.BaseException;
import com.footstep.domain.mail.entity.MailVerification;
import com.footstep.domain.mail.repository.MailVerificationRepository;
import com.footstep.domain.users.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Random;

@RequiredArgsConstructor
@Transactional
@Service
@PropertySource("classpath:mail/email.properties")
public class MailService {

    private final JavaMailSender javaMailSender;
    private final UsersRepository usersRepository;
    private final MailVerificationRepository mailVerificationRepository;

    @Value("${spring.mail.username}")
    private String email;


    public void sendMailForBlock(String to) throws BaseException, MessagingException , UnsupportedEncodingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");

        String text = "";
        text += "<div style='margin:20px;'>";
        text += "<h1> 당신의 발자취 계정 정지안내입니다.</h1>";
        text += "<br>";
        text += "<p> 신고 접수가 3회 누적되어 계정이 한 달간 정지되었습니다. </p>";
        text += "<br>";
        text += "<p> <b>해당 계정의 게시글은 모두 삭제 처리 예정입니다.</b> </p>";
        text += "<br>";
        text += "<p> 문의할 내용이 있다면 <b>footstepdangbal@gmail.com</b>으로 문의부탁드립니다.</p>";
        text += "<p> 감사합니다.</p>";

        messageHelper.setFrom("footstepdangbal@gmail.com", "당신의 발자취");
        messageHelper.setTo(to);
        messageHelper.setSubject("당신의 발자취 계정 정지 안내드립니다.");
        messageHelper.setText(text, true);

        javaMailSender.send(message);
    }

    public void sendMailForReport(String to, String nickname, String title, String reason) throws BaseException, MessagingException , UnsupportedEncodingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
        String text = "";
        if (title.equals("")) {
            text += "<div style='margin:20px;'>";
            text += "<h1> 당신의 발자취 신고 안내입니다.</h1>";
            text += "<br>";
            text += "<p> <b>" + nickname + "</b>님은 신고당하셨습니다. </p>";
            text += "<h2> 신고 사유 </h2>";
            text += "<p>" + reason + "</p>";
            text += "<br>";
            text += "<p> 다른 사람에게 피해를 주는 말이나 도배는 삼가해주시기 바랍니다.</p>";
            text += "<br>";
            text += "<p> 문의할 내용이 있다면 <b>footstepdangbal@gmail.com</b>으로 문의부탁드립니다.</p>";
            text += "<p> 감사합니다. </p>";
        } else {
            text += "<div style='margin:20px;'>";
            text += "<h1> 당신의 발자취 신고 안내입니다.</h1>";
            text += "<br>";
            text += "<p> <b>" + nickname + "</b>님께서 작성하신 <b>'" + title  + "'</b>이 신고 당하였습니다.</p>";
            text += "<h2> 신고 사유 </h2>";
            text += "<p>" + reason + "</p>";
            text += "<br>";
            text += "<p> 다른 사람에게 피해를 주는 말이나 도배는 삼가해주시기 바랍니다.</p>";
            text += "<br>";
            text += "<p> 문의할 내용이 있다면 <b>footstepdangbal@gmail.com</b>으로 문의부탁드립니다.</p>";
            text += "<p> 감사합니다. </p>";
        }

        messageHelper.setFrom("footstepdangbal@gmail.com", "당신의 발자취");
        messageHelper.setTo(to);
        messageHelper.setSubject("당신의 발자취 신고 안내드립니다.");
        messageHelper.setText(text, true);

        javaMailSender.send(message);
    }

    public void sendVerificationMail(String to, String nickname) throws MessagingException, UnsupportedEncodingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
        String ePw = createKey();
        String text = "";
        text += " <div" +
                        "	style=\"font-family: 'Apple SD Gothic Neo', 'sans-serif' !important; width: 400px; height: 600px; border-top: 4px solid #FF8000; margin: 100px auto; padding: 30px 0; box-sizing: border-box;\">" +
                        "	<h1 style=\"margin: 0; padding: 0 5px; font-size: 28px; font-weight: 400;\">" +
                        "		<span style=\"font-size: 15px; margin: 0 0 10px 3px;\">당신의 발자취</span><br />" +
                        "		<span style=\"color: #FF8000\">메일인증</span> 안내입니다." +
                        "	</h1>\n" +
                        "	<p style=\"font-size: 16px; line-height: 26px; margin-top: 50px; padding: 0 5px;\">" +
                        nickname +
                        "		님 안녕하세요.<br />" +
                        "		당신에 발자취에 가입해 주셔서 진심으로 감사드립니다.<br />" +
                        "		아래 <b style=\"color: #FF8000\">'메일 인증'</b> 버튼을 클릭하여 회원가입을 완료해 주세요.<br />" +
                        "		감사합니다." +
                        "	</p>" +
                        "	<a style=\"color: #FFF; text-decoration: none; text-align: center;\"" +
                        "	href=\"http://52.78.49.35:8080/mail/certification?mail=" + to + "&certified=" + ePw + "\" target=\"_blank\">" +
                        "		<p" +
                        "			style=\"display: inline-block; width: 210px; height: 45px; margin: 30px 5px 40px; background: #FF8000; line-height: 45px; vertical-align: middle; font-size: 16px;\">" +
                        "			메일 인증</p>" +
                        "	</a>" +
                        "	<div style=\"border-top: 1px solid #FF8000; padding: 5px;\"></div>" +
                        " </div>";

        messageHelper.setFrom("footstepdangbal@gmail.com", "당신의 발자취");
        messageHelper.setTo(to);
        messageHelper.setSubject("당신의 발자취 인증 메일입니다.");
        messageHelper.setText(text, true);

        javaMailSender.send(message);
        mailVerificationRepository.save(new MailVerification(to, ePw));
    }

    public String sendMailForPassword(String to, String nickname) throws MessagingException, UnsupportedEncodingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
        String ePw = createKey();
        String text = "";
        text += " <div" +
                "	style=\"font-family: 'Apple SD Gothic Neo', 'sans-serif' !important; width: 400px; height: 600px; border-top: 4px solid #FF8000; margin: 100px auto; padding: 30px 0; box-sizing: border-box;\">" +
                "	<h1 style=\"margin: 0; padding: 0 5px; font-size: 28px; font-weight: 400;\">" +
                "		<span style=\"font-size: 15px; margin: 0 0 10px 3px;\">당신의 발자취</span><br />" +
                "		<span style=\"color: #FF8000\">임시 비밀번호</span> 안내입니다." +
                "	</h1>\n" +
                "	<p style=\"font-size: 16px; line-height: 26px; margin-top: 50px; padding: 0 5px;\">" +
                nickname +
                "		님 안녕하세요.<br />" +
                "		임시 비밀번호를 안내드립니다.<br />" +
                "		아래 <b style=\"color: #FF8000\">임시 비밀번호</b> 를 사용 후 반드시 비밀번호를 변경해주시기 바랍니다.<br />" +
                "		감사합니다." +
                "	</p>" +
                "		<p" +
                "			style=\"display: inline-block; width: 210px; height: 45px; margin: 30px 5px 40px; background: #FF8000; line-height: 45px; vertical-align: middle; font-size: 16px;\">" +
                "			" + ePw + "</p>" +
                "	<div style=\"border-top: 1px solid #DDD; padding: 5px;\"></div>" +
                " </div>";

        messageHelper.setFrom("footstepdangbal@gmail.com", "당신의 발자취");
        messageHelper.setTo(to);
        messageHelper.setSubject("당신의 발자취 임시 비밀번호 메일입니다.");
        messageHelper.setText(text, true);

        javaMailSender.send(message);
        return ePw;
    }

    public  String createKey() {
        StringBuffer key = new StringBuffer();
        Random rnd = new Random();

        for (int i = 0; i < 8; i++) { // 인증코드 8자리
            int index = rnd.nextInt(3); // 0~2 까지 랜덤

            switch (index) {
                case 0:
                    key.append((char) ((int) (rnd.nextInt(26)) + 97));
                    //  a~z  (ex. 1+97=98 => (char)98 = 'b')
                    break;
                case 1:
                    key.append((char) ((int) (rnd.nextInt(26)) + 65));
                    //  A~Z
                    break;
                case 2:
                    key.append((rnd.nextInt(10)));
                    // 0~9
                    break;
            }
        }
        return key.toString();
    }
}
