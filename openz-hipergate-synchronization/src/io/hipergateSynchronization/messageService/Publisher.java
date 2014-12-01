/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package io.hipergateSynchronization.messageService;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import java.io.IOException;

/**
 *
 * @author Hawai
 */
public class Publisher<T> {

    public final String outputQueue;
    private Connection connection = null;

    public Publisher(Connection con, String outputQueue) throws IOException {
        this.connection = con;
        this.outputQueue = outputQueue;
    }

    public void publish(String message) throws IOException {
        Channel channel = connection.createChannel();
        channel.queueDeclarePassive(this.outputQueue);
        channel.basicPublish("", this.outputQueue, null, message.getBytes());
    }

    public void publish(T message) throws IOException {
        Channel channel = connection.createChannel();
        channel.queueDeclarePassive(this.outputQueue);
        channel.basicPublish("", this.outputQueue, null, Converter.serialize(message));
    }

    void purge() throws IOException {
        Channel channel = connection.createChannel();
        channel.queuePurge(this.outputQueue);
    }
    
    public void pushTo(String queue, T message) throws IOException{
        Channel channel = connection.createChannel();
        channel.queueDeclarePassive(queue);
        channel.basicPublish("", queue, null, Converter.serialize(message));
    }

}
