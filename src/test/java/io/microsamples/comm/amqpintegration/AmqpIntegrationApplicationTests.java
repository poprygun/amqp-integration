package io.microsamples.comm.amqpintegration;

import lombok.extern.slf4j.Slf4j;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class AmqpIntegrationApplicationTests {

    @Autowired
    @Qualifier("toRabbit")
    private DirectChannel toRabbit;

    @Autowired
    private Queue queue;

    @Autowired
    private RabbitTemplate amqpTemplate;

    @Test
    @Ignore
    /**
     * This will verify if message was posted to the queue.  TCP out section better be removed from tcp-amqp.xml, when running this test.
     */
    public void processFlow() {
        byte[] note = "Hi there".getBytes();
        org.springframework.messaging.Message<byte[]> toSend = MessageBuilder.withPayload(note).build();

        toRabbit.send(toSend);

        amqpTemplate.setQueue(queue.getName());
        Message receive = amqpTemplate.receive();
        assertThat(receive.getBody()).containsExactly(note);
    }

}
