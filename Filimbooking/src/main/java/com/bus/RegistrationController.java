package com.bus;

import javax.mail.MessagingException;
import javax.management.Notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@SuppressWarnings("unused")
@RestController
public class RegistrationController {

	@Autowired
	private EmailService notificationService;

	@Autowired
	private User user;

	private RegistrationController mailService;

	@PostMapping("/ticket")
    public void sendTicketDetails(@RequestParam String to, @RequestParam String movieName, @RequestParam String ticketDate, @RequestParam double ticketPrice) {
        mailService = null;
		mailService.sendTicketDetails(to, movieName, ticketDate, ticketPrice);
	}

	@GetMapping("send-mail")
	public String send() {

		
		user.setEmail("sweetyraghav24@gmail.com");  //Receiver's email address
		
		try {
			notificationService.sendEmail(user);
		} catch (MailException mailException) {
			System.out.println(mailException);
		}
		return "Congratulations! Your mail has been send to the user.";
	}

	
	
	
	@SuppressWarnings("static-access")
	@GetMapping("send-mail/{ticketDetails")
	public String send(@PathVariable String ticketDetails) {

		
		user.setEmail("sweetyraghav24@gmail.com");  //Receiver's email address
		
		try {
			notificationService.sendEmail(user,ticketDetails);
		} catch (MailException mailException) {
			System.out.println(mailException);
		}
		return "Congratulations! Your mail has been send to the user.";
	}
}