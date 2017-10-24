package me.wonwoo.receive;

import me.wonwoo.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

import static me.wonwoo.SpringJmsExampleApplication.QUEUE_NAME;

@Component
@RabbitListener(queues = QUEUE_NAME)
public class Receiver {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());


  @RabbitHandler
  public void receiveMessage(@Payload Person message) {
    logger.info("Received : {} ", message);
    try {
      TimeUnit.SECONDS.sleep(2);
    } catch (InterruptedException e) {
    }
  }
}