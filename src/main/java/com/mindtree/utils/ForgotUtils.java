package com.mindtree.utils;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.mindtree.entity.OTP;

public class ForgotUtils {
	public OTP sendMail(String email) throws MessagingException {

		String toAddress = email;

		String from = "rohitshetty474@gmail.com";
		final String username = "rohitshetty474@gmail.com";
		final String password = "Mindtree@12";

		String host = "smtp.gmail.com";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");
		props.put("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		Message message = new MimeMessage(session);

		message.setFrom(new InternetAddress(from));

		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toAddress));

		message.setSubject("Password Reset Request");

		OTP otp = new OTP();

		String genratedOtp = generateOtp();

		otp.setOtp(genratedOtp);
		otp.setEmailId(toAddress);
		message.setText("Did you just make a request to reset your password? \r\n"
				+ "Yes? Go right ahead.Please enter the following otp to change your password." + "\n" + "OTP: "
				+ otp.getOtp());

		Transport.send(message);

		return otp;
	}

	static String generateOtp() {

		String otp = "";

		for (int i = 0; i < 6; i++) {
			int random = (int) (Math.random() * 9 + 0);
			otp = otp + random;

		}
		return otp;
	}

}
