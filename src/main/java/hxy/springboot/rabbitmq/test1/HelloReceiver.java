package hxy.springboot.rabbitmq.test1;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
 
@Component
@RabbitListener(queues = "hello")
public class HelloReceiver {
	protected static Logger logger = LoggerFactory.getLogger(HelloReceiver.class);
 
	@RabbitHandler
	public void process(String hello) {
		logger.info("HelloReceiver : " + hello);
		try {
			Thread.sleep(150);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}