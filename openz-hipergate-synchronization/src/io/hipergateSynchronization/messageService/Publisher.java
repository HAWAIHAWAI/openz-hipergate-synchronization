/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package io.hipergateSynchronization.messageService;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import java.io.IOException;

/**
 * Class for publishing messages.
 * @author Hawai
 */
public class Publisher<T> {

	/**
	 * Name of the OutputQueue.
	 */
    public final String outputQueue;
    
    /**
     * Connection to the queue.
     */
    private Connection connection = null;

    /**
     * Constructor.
     * @param con Connection to the queue.
     * @param outputQueue Name of the OutputQueue.
     * @throws IOException Error occurred during execution...
     */
    public Publisher(Connection con, String outputQueue) throws IOException {
        this.connection = con;
        this.outputQueue = outputQueue;
    }

    /**
     * Publishes a String message.
     * @param message The String message to publish.
     * @throws IOException Error occurred during execution...
     */
    public void publish(String message) throws IOException {
        Channel channel = connection.createChannel();
        channel.queueDeclarePassive(this.outputQueue);
        channel.basicPublish("", this.outputQueue, null, message.getBytes());
    }

    /**
     * Publishes a generic message.
     * @param message The generic message to publish.
     * @throws IOException Error occurred during execution...
     */
    public void publish(T message) throws IOException {
        Channel channel = connection.createChannel();
        channel.queueDeclarePassive(this.outputQueue);
        channel.basicPublish("", this.outputQueue, null, Converter.serialize(message));
    }

    /**
     * Purges the contents of the OutputQueue.
     * @throws IOException
     */
    void purge() throws IOException {
        Channel channel = connection.createChannel();
        channel.queuePurge(this.outputQueue);
    }
    
    /**
     * Pushes a message to a specified queue.
     * @param queue The name of the queue.
     * @param message The message to push.
     * @throws IOException Error occurred during execution...
     */
    public void pushTo(String queue, T message) throws IOException{
        Channel channel = connection.createChannel();
        channel.queueDeclarePassive(queue);
        channel.basicPublish("", queue, null, Converter.serialize(message));
    }

}
