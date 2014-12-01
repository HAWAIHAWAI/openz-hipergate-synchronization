/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package io.importing;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;
import com.rabbitmq.client.QueueingConsumer.Delivery;
import java.io.IOException;

/**
 *
 * @author Hawai
 */
public class Receiver<T> {

    private final String inputQueue;
    public Connection connection = null;

    public Receiver(Connection con, String inputQueue) throws IOException{
        this.connection = con;
        this.inputQueue = inputQueue;
        

    }
    
    public T receive() throws InterruptedException, IOException, ClassNotFoundException{
        Channel channel = this.connection.createChannel();
        QueueingConsumer consumer = new QueueingConsumer(channel);
        channel.queueDeclarePassive(this.inputQueue);
        channel.basicConsume(this.inputQueue, true, consumer);
        Delivery deliver = consumer.nextDelivery();
        return (T) Converter.deserialize(deliver.getBody());
    }

    void purge() throws IOException {
        Channel channel = connection.createChannel();
        channel.queuePurge(this.inputQueue);
    }
    
    public T receiveFrom(String queue) throws IOException, ClassNotFoundException, InterruptedException{
        Channel channel = this.connection.createChannel();
        QueueingConsumer consumer = new QueueingConsumer(channel);
        channel.queueDeclarePassive(queue);
        channel.basicConsume(queue, true, consumer);
        Delivery deliver = consumer.nextDelivery();
        return (T) Converter.deserialize(deliver.getBody());
    }
}
