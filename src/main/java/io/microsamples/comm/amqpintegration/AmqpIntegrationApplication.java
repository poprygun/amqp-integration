package io.microsamples.comm.amqpintegration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.config.EnableIntegration;

@SpringBootApplication

@ImportResource("classpath*:/spring/integration/tcp-amqp.xml")
public class AmqpIntegrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmqpIntegrationApplication.class, args);
	}
}
