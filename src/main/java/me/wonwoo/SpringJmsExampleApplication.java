package me.wonwoo;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.DefaultClassMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringJmsExampleApplication {

	public final static String QUEUE_NAME = "spring-boot-sample";

	public static void main(String[] args) {
		SpringApplication.run(SpringJmsExampleApplication.class, args);
	}

	//create ERROR ?
	@Bean
	public Queue incomingQueue() {
		return new Queue(QUEUE_NAME);
	}

	@Bean
	MessageConverter messageConverter() {
		Jackson2JsonMessageConverter jsonMessageConverter = new Jackson2JsonMessageConverter();
		DefaultClassMapper mapper = new DefaultClassMapper();
		mapper.setDefaultHashtableClass(Person.class);
		jsonMessageConverter.setClassMapper(mapper);
		return jsonMessageConverter;
	}
}
