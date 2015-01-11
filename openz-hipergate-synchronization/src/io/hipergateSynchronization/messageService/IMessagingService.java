/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package io.hipergateSynchronization.messageService;

import java.util.List;

import pojo.OpenZGeschaeftspartner;

/**
 * Interface for MessagingService. Provides methods which
 * must be implementend by a MessagingService for 
 * interactions with a Message Queue.
 *
 * @author Hawai
 */
public interface IMessagingService<T> {

	/**
	 * 
	 * @return
	 */
    public String warteSynchronAufNachrichten();

    public void pushMessage(T obj, String queue);
    
    public void pushMessage(T obj);
    
    public T pullMessage(String string);
    
    public T pullMessage();
    
	public List<T> pullMessages();
    
    public void purgeAllQueues();
    
    public String getOutputQueueName();
    
    public String getInputQueueName();
}
