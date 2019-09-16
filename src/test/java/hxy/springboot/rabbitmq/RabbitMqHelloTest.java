package hxy.springboot.rabbitmq;

import hxy.springboot.rabbitmq.test1.HelloReceiver;
import hxy.springboot.rabbitmq.test1.HelloSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqHelloTest {

    @Autowired
    private HelloSender helloSender;
    @Autowired
    private HelloReceiver helloReceiver;

    @Test
    public void hello() throws Exception {
        helloSender.send("发送消息,Hello World!");
    }


    @Test
    public void receive(){
    }


}