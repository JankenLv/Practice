package rocketmq.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RocketMqDemoApplicationTests {

    @Test
    public void contextLoads() {
        Properties prop = new Properties();
        InputStream is = RocketMqDemoApplicationTests.class.getClassLoader().getResourceAsStream("application.properties");
        try {
            prop.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(prop.get("apache.rocketmq.producer.producerGroup"));
    }

}
