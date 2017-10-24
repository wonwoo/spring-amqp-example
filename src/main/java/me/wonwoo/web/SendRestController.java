package me.wonwoo.web;

import me.wonwoo.Person;
import me.wonwoo.SpringJmsExampleApplication;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendRestController {

  private final RabbitTemplate rabbitTemplate;

  public SendRestController(RabbitTemplate rabbitTemplate) {
    this.rabbitTemplate = rabbitTemplate;
  }

  @GetMapping("/{name}")
  public String hello(@PathVariable String name) {
    rabbitTemplate.convertAndSend(SpringJmsExampleApplication.QUEUE_NAME, new Person(name));
    return "hello " + name;
  }


}
