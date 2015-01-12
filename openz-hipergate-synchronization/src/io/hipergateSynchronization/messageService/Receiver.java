/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package io.hipergateSynchronization.messageService;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConsumerCancelledException;
import com.rabbitmq.client.QueueingConsumer;
import com.rabbitmq.client.QueueingConsumer.Delivery;
import com.rabbitmq.client.ShutdownSignalException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
    
    @SuppressWarnings("unchecked")
	public T receive() throws InterruptedException, IOException, ClassNotFoundException{
        Channel channel = this.connection.createChannel();
        QueueingConsumer consumer = new QueueingConsumer(channel);
        channel.queueDeclarePassive(this.inputQueue);
        channel.basicConsume(this.inputQueue, true, consumer);
        Delivery deliver = consumer.nextDelivery();
        return (T) Converter.deserialize(deliver.getBody());
    }
    
    @SuppressWarnings("unchecked")
	public List<T> receiveAll() throws InterruptedException, IOException, ClassNotFoundException{
    	System.out.println("Receiver.receiveAll started");
    	List<T> list = new ArrayList<T>();
    	System.out.println("List initialized, listSize: 0");
        Channel channel = this.connection.createChannel();
        while(channel.queueDeclarePassive(this.inputQueue).getMessageCount()>0){
        QueueingConsumer consumer = new QueueingConsumer(channel);
        channel.queueDeclarePassive(this.inputQueue);
        channel.basicConsume(this.inputQueue, true, consumer);
        Delivery deliver = consumer.nextDelivery();
        list.add((T) Converter.deserialize(deliver.getBody()));
        System.out.println("List size: " + list.size());
        }
        channel.abort();
        System.out.println("Channel closed");
        return list;
    } 

    void purge() throws IOException {
        Channel channel = connection.createChannel();
        channel.queuePurge(this.inputQueue);
    }
    
    @SuppressWarnings("unchecked")
	public T receiveFrom(String queue) throws IOException, ClassNotFoundException, InterruptedException{
        Channel channel = this.connection.createChannel();
        QueueingConsumer consumer = new QueueingConsumer(channel);
        channel.queueDeclarePassive(queue);
        channel.basicConsume(queue, true, consumer);
        Delivery deliver = consumer.nextDelivery();
        return (T) Converter.deserialize(deliver.getBody());
    }
}
