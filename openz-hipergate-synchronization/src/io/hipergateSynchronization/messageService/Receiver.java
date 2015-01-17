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
 * Class for receiving messages.
 * @author Hawai
 */
public class Receiver<T> {

	/**
	 * Name of the InputQueue.
	 */
    private final String inputQueue;
    
    /**
     * Connection to the InputQueue.
     */
    public Connection connection = null;

    /**
     * Constructor.
     * @param con The connection to the InputQueue.
     * @param inputQueue The name of the InputQueue.
     * @throws IOException If an error occurred...
     */
    public Receiver(Connection con, String inputQueue) throws IOException{
        this.connection = con;
        this.inputQueue = inputQueue;
        

    }
    
    /**
     * Receives the next message in the queue.
     * @return The next message.
     * @throws InterruptedException if an interrupt is received while waiting.
     * @throws IOException if an error occurred while waiting.
     * @throws ClassNotFoundException Class of the message object not found.
     */
    @SuppressWarnings("unchecked")
	public T receive() throws InterruptedException, IOException, ClassNotFoundException{
        Channel channel = this.connection.createChannel();
        QueueingConsumer consumer = new QueueingConsumer(channel);
        channel.queueDeclarePassive(this.inputQueue);
        channel.basicConsume(this.inputQueue, true, consumer);
        Delivery deliver = consumer.nextDelivery();
        return (T) Converter.deserialize(deliver.getBody());
    }
    
    /**
     * Receives all messages from the InputQueue.
     * @return All messages as list.
     * @throws InterruptedException if an interrupt is received while waiting.
     * @throws IOException if an error occurred while waiting.
     * @throws ClassNotFoundException Class of the message object not found.
     */
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

    /**
     * Purges the InputQueue.
     * @throws IOException If an error occurred...
     */
    void purge() throws IOException {
        Channel channel = connection.createChannel();
        channel.queuePurge(this.inputQueue);
    }
    
    /**
     * Receives a message from a specified queue.
     * @param queue The specified queue.
     * @return A message from the specified queue.
     * @throws InterruptedException if an interrupt is received while waiting.
     * @throws IOException if an error occurred while waiting.
     * @throws ClassNotFoundException Class of the message object not found.
     */
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
