package pl.com.mazniak.sendingmail.mail;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import org.springframework.http.ResponseEntity;
@Aspect
@Service
public class MailService {

    private JavaMailSender javaMailSender;

    @Autowired
    public MailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
        System.out.println("Created MailService");
    }

    @After("execution(* pl.com.mazniak.sendingmail.movie.MovieController.addMovie(..))")
    public void sendSimpleEmail() {
        System.out.println("Sending email");
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("mazniakd@gmail.com");
        msg.setFrom("PrzykladowyNadawca");

        msg.setSubject("You just added a movie");
        msg.setText("You added a movie");

        javaMailSender.send(msg);
    }
}