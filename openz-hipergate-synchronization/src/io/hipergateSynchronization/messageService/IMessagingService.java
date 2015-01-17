/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package io.hipergateSynchronization.messageService;

import java.util.List;

/**
 * Interface for MessagingService. Provides methods which
 * must be implementend by a MessagingService for 
 * interactions with a Message Queue.
 *
 * @author Hawai
 */
public interface IMessagingService<T> {

	/**
	 * Delivers the content of a message as String.
	 * Returns null if an error happened.
	 * @return Content of a message as String. <code>null</code>, if an error happened.
	 */
    public String warteSynchronAufNachrichten();

    /**
     * Pushes a message to the specified queue.
     * @param obj The object to push.
     * @param queue The queue.
     */
    public void pushMessage(T obj, String queue);
    
    /**
     * Pushes a message.
     */
    public void pushMessage(T obj);
    
    /**
     * Pulls a message with the specified string.
     * @param string The specified string.
     * @return Message with the specified String.
     */
    public T pullMessage(String string);
    
    /**
     * Pulls a message.
     * @return Pulled object from the message.
     */
    public T pullMessage();
    
    /**
     * Retrieves a list with all pushed messages.
     * @return List with all pushed messages.
     */
	public List<T> pullMessages();
    
	
    public void purgeAllQueues();
    
    /**
     * Retrieves the OutputQueueName as String.
     * @return OutputQueueName as String.
     */
    public String getOutputQueueName();
    
    /**
     * Retrieves the InputQueueName as String.
     * @return InputQueueName as String.
     */
    public String getInputQueueName();
}
