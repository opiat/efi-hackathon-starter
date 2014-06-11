import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import sample.jpa.model.SomethingToPersit;
import sample.jpa.repository.OrderRepository;

@EnableAutoConfiguration
@Configuration
@ComponentScan
// Konfiguracja JPA, konieczna gdy repozytoria i encje nie sa w tym samym
// pakiecie co Application lub bezposrednich podpakietach
@EntityScan(basePackageClasses = SomethingToPersit.class)
@EnableJpaRepositories(basePackageClasses = OrderRepository.class)
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(
				Application.class, args);

		OrderRepository orderRepository = ctx.getBean(OrderRepository.class);
		orderRepository.save(new SomethingToPersit());
		System.out.println("All orders: " + orderRepository.findAll());
	}
}
