package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

@SpringBootApplication
public class MailTest02Application {

	public static void main(String[] args) {
		try (ConfigurableApplicationContext ctx = SpringApplication.run(MailTest02Application.class, args)) {
			ctx.getBean(MailTest02Application.class).sendMail();
		}
	}

	@Autowired
	private MailSender sender;

	public void sendMail() {
		SimpleMailMessage msg = new SimpleMailMessage();

		msg.setFrom("liangjiesengu743@gmail.com");
		msg.setTo("sessyomaru427@gmail.com");
		msg.setSubject("テストメール");// タイトルの設定
		msg.setText("Spring Boot より本文送信"); // 本文の設定

		this.sender.send(msg);
	}
}