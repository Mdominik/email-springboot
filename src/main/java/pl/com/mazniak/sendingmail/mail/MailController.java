package pl.com.mazniak.sendingmail.mail;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {

    private MailService mailService;

    public MailController(MailService mailService) {
        this.mailService = mailService;
    }

    @GetMapping("/sendemail")
    public String sendEmail() {
        mailService.sendSimpleEmail();
        return "E-mail sent!";
    }
}