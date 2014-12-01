/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package io.hipergateSynchronization.messageService;

/**
 *
 * @author Hawai
 */
public interface IMessagingService<T> {

    public String warteSynchronAufNachrichten();

    public void pushMessage(String message);
    
    public void pushMessage(T obj);
    
    public T pullMessage();
    
    public void purgeAllQueues();

    public T pullMessageFromOutputQueue();
}
