package cn.itcast.mq.listener;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.ui.context.Theme;

import java.time.LocalDateTime;

@Component
public class SpringRabbitListener {
//    @RabbitListener(queues = "simple.queue")
//    public void ListenSimpleQueue(String msg){
//        System.out.println("message from simple.queue: [" + msg + "]");
//    }
    @RabbitListener(queues = "simple.queue")
    public void ListenSimpleQueue1(String msg) throws InterruptedException {
        System.out.println("message1 from simple.queue: [" + msg + "]" + LocalDateTime.now());
        Thread.sleep(20);
    }

    @RabbitListener(queues = "simple.queue")
    public void ListenSimpleQueue2(String msg) throws InterruptedException {
        System.err.println("message2 from simple.queue: [" + msg + "]" + LocalDateTime.now());
        Thread.sleep(200);
    }


    @RabbitListener(queues = "fanout.queue1")
    public void ListenFanoutQueue1(String msg){
        System.out.println("message from fanout.queue1: [" + msg + "]");
    }

    @RabbitListener(queues = "fanout.queue2")
    public void ListenFanoutQueue2(String msg){
        System.out.println("message from fanout.queue2: [" + msg + "]");
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "direct.queue1"),
            exchange = @Exchange(name = "itcast.direct", type = ExchangeTypes.DIRECT),
            key = {"red", "blue"}
    ))
    public void listenDirectQueue1(String msg){
        System.out.println("message from direct.queue1: [" + msg + "]");
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "direct.queue2"),
            exchange = @Exchange(name = "itcast.direct", type = ExchangeTypes.DIRECT),
            key = {"red", "yellow"}
    ))
    public void listenDirectQueue2(String msg){
        System.out.println("message from direct.queue2: [" + msg + "]");
    }
}
