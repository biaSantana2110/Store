package bia.com.projeto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjetoApplication {

	public static void main(String[] args) throws ParseException {
		SpringApplication.run(ProjetoApplication.class, args);

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Digite os dados do Client: ");
		System.out.print("Name: ");
		String clientName = sc.nextLine();
		System.out.print("Email: ");
		String clientEmail = sc.nextLine();
		System.out.print("Data de Nascimento (DD/MM/AAAA): ");
		Date clientBirthDate = sdf.parse(sc.next());
		Client client = new Client(clientName, clientEmail, clientBirthDate);

		System.out.println("Digite os dados do Pedido");
		System.out.print("Estatus do Pedido: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());

		Order order = new Order(new Date(), status, client);

		System.out.println("Quantos itens neste pedido: ");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			System.out.println("Digite os dados do " + (i + 1) + "º item");
			System.out.print("Produto: ");
			sc.nextLine();
			String productName = sc.next();
			System.out.print("Preço: ");
			double productPrice = sc.nextDouble();
			System.out.print("Quantidade: ");
			int quantity = sc.nextInt();

			Product product = new Product(productName, productPrice);

			OrderItem it = new OrderItem(quantity, productPrice, product);

			order.addItem(it);
		}

		System.out.println();
		System.out.println(order);

		sc.close();
	}

}
