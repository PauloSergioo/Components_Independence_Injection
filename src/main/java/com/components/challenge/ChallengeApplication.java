package com.components.challenge;

import com.components.entities.Order;
import com.components.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Locale;
import java.util.Scanner;

@ComponentScan({"com.components"})
@SpringBootApplication
public class ChallengeApplication implements CommandLineRunner {
	@Autowired
	private OrderService orderService;
	public static void main(String[] args) {
		SpringApplication.run(ChallengeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Digite os valores de entrada:");
		Integer code = sc.nextInt();
		Double basic = sc.nextDouble();
		Double discount = sc.nextDouble();

		Order order = new Order(code, basic, discount);

		System.out.println("Pedido código: " + order.getCode());
		System.out.printf("Valor total: R$ " + orderService.total(order));

		sc.close();
	}
}
