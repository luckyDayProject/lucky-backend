package io.swyp.luckybackend.luckyDays.controller;

import io.swyp.luckybackend.luckyDays.service.EmailSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailSendController {
    @Autowired
    EmailSendService emailSendService;

    @GetMapping("/sendEmail")
    public String sendEmail() {
        emailSendService.sendEmail();
        return "Email sent successfully!";
    }
}
