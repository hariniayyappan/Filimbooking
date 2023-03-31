package com.bus;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


@Service
public class EmailService {

	@Autowired
	private static JavaMailSender javaMailSender;

	
	@SuppressWarnings({ })
	public EmailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	

	public void sendEmail(User user) throws MailException {

		

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(User.getEmail());
		mail.setSubject("Booking confirmed ");
		mail.setText("Your ticket has been booked succesfully..");

		
		javaMailSender.send(mail);
	}

	
	
	public void sendTicketDetails(String to, String movieName, String ticketDate, double ticketPrice) {
        String subject = "Ticket Details";
        String text = "Movie Name: " + movieName + "\nTicket Date: " + ticketDate + "\nTicket Price: " + ticketPrice;
        ((EmailService) javaMailSender).sendEmail(to, subject, text);
	
	}
	



	




	private void sendEmail(String to, String subject, String text) {
		// TODO Auto-generated method stub
		
	}



	



	public static void sendEmail(User user,String ticketDetails) throws MailException {

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(User.getEmail());
		mail.setSubject("Booking confirmed ");
		mail.setText("Your ticket has been booked successfully..");
		mail.setText(ticketDetails);
		
		javaMailSender.send(mail);
	
		}
	
}


	