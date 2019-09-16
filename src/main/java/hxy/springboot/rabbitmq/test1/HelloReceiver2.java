package hxy.springboot.rabbitmq.test1;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "hello")
public class HelloReceiver2 {
	protected static Logger logger = LoggerFactory.getLogger(HelloReceiver2.class);
 
	@RabbitHandler
	public void process(String hello) {
		logger.info("HelloReceiver2 : " + hello);
		try {
			Thread.sleep(1050);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}