package io.microsamples.comm.amqpintegration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.ip.dsl.Tcp;
import org.springframework.integration.ip.tcp.connection.TcpNetServerConnectionFactory;

@SpringBootApplication
@ImportResource("classpath*:/spring/integration/tcp-amqp.xml")
public class AmqpIntegrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmqpIntegrationApplication.class, args);
	}

}
