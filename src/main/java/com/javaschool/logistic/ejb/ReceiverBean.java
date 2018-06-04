package com.javaschool.logistic.ejb;


import com.rabbitmq.client.*;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.Startup;
import javax.ejb.Stateful;
import java.io.IOException;
import java.io.Serializable;
import java.util.concurrent.TimeoutException;


@Stateful
@Startup
public class ReceiverBean implements Serializable {

    private final static String QUEUE_NAME="infoQueue";

    private Connection connection;
    private Channel channel;

    @EJB
    private InformationBean informationBean;

    public void receive() throws IOException, TimeoutException {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        connection= connectionFactory.newConnection();
        channel=connection.createChannel();

        channel.queueDeclare(QUEUE_NAME,true,false,false,null);

        channel.basicRecover();
        channel.queuePurge(QUEUE_NAME);

        final Consumer consumer=new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println(message);
                informationBean.update();
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
