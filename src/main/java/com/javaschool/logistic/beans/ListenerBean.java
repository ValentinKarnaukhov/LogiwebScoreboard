package com.javaschool.logistic.beans;


import com.rabbitmq.client.*;


import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;
import javax.inject.Singleton;
import java.io.IOException;
import java.io.Serializable;
import java.util.concurrent.TimeoutException;


@Singleton
public class ListenerBean implements Serializable {

    private final static String QUEUE_NAME="infoQueue";

    private Connection connection;
    private Channel channel;

    @Inject
    private BeanManager beanManager;

    public void receive() throws IOException, TimeoutException {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("206.189.24.66");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");
        connection= connectionFactory.newConnection();
        channel=connection.createChannel();

        channel.queueDeclare(QUEUE_NAME,true,false,false,null);

        channel.basicRecover();
        channel.queuePurge(QUEUE_NAME);

        final Consumer consumer = new DefaultConsumer(channel){

            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println("handelDelivery");
                beanManager.fireEvent(message);
            }
        };

        channel.basicConsume(QUEUE_NAME,true,consumer);
    }


    @PreDestroy
    public void destroy() throws IOException, TimeoutException {
        channel.close();
        connection.close();
    }

}
