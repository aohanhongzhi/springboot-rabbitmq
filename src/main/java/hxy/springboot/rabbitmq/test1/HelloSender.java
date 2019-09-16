package hxy.springboot.rabbitmq.test1;
 
import java.util.Date;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
 
@Component
public class HelloSender {
 
	protected static Logger logger=LoggerFactory.getLogger(HelloSender.class); 
	
	@Autowired
    private AmqpTemplate rabbitTemplate;
	//哪里定义了work模式
 
    public String send(String name) throws InterruptedException {
    	String context = "hello "+name+" --" + new Date();
    	String sendStr;
    	for(int i=1;i<=100;i++){
    		sendStr="第["+i+"]个 hello "+name+" --" + new Date(); 
    		logger.info("HelloSender:{},{}" ,i, sendStr);
    		this.rabbitTemplate.convertAndSend("hello", sendStr);
    		Thread.sleep(100);
    	}
		return context;
    }
}