/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package io.importing;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Hawai
 */
public class MessagingServiceFacade implements IMessagingService {

    private final String InputQueueName = "HAWAI_QUEUE_INPUT";
    private final String OutputQueueName = "HAWAI_QUEUE_OUTPUT";
    public ConnectionFactory factory = null;
    public Connection rabbitConnection = null;
    private Receiver receiver = null;
    private Publisher publisher = null;

    public MessagingServiceFacade() {
        this.factory = new ConnectionFactory();
        factory.setHost("localhost");
        try {
            //ExecutorService executor = Executors.newFixedThreadPool(nThreads);
            //this.rabbitConnection = factory.newConnection(executor);
            this.rabbitConnection = factory.newConnection();
        } catch (IOException ex) {
            Logger.getLogger(MessagingServiceFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            this.receiver = new Receiver(this.rabbitConnection, InputQueueName);
        } catch (IOException ex) {
            Logger.getLogger(MessagingServiceFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            this.publisher = new Publisher(this.rabbitConnection, OutputQueueName);
        } catch (IOException ex) {
            Logger.getLogger(MessagingServiceFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*
     * Gibt den Inhalt einer Nachricht, als String zurück.
     * Gibt null zurück, wenn Fehler beim Abfruf aufgetreten sind.
     */
    public String warteSynchronAufNachrichten() {
        try {
            return (String) this.receiver.receive();
        } catch (InterruptedException ex) {
            Logger.getLogger(MessagingServiceFacade.class.getName()).log(Level.SEVERE, null, ex);
            return null;
            
        } catch (IOException ex) {
            Logger.getLogger(MessagingServiceFacade.class.getName()).log(Level.SEVERE, null, ex);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MessagingServiceFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
   
    /*
     * Legt eine Nachricht message in die Output Queue
     */
    public void pushMessage(String message) {
        try {
            this.publisher.publish(message);
        } catch (IOException ex) {
            Logger.getLogger(MessagingServiceFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String pullMessage(){
        try {
            return (String) this.receiver.receive();
        } catch (InterruptedException ex) {
            Logger.getLogger(MessagingServiceFacade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MessagingServiceFacade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MessagingServiceFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void pushMessage(Object obj) {
        try {
            this.publisher.publish(obj);
        } catch (IOException ex) {
            Logger.getLogger(MessagingServiceFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void purgeAllQueues() {
        try {
            this.publisher.purge();
            this.receiver.purge();
        } catch (IOException ex) {
            Logger.getLogger(MessagingServiceFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Object pullMessageFromOutputQueue() {
        try {
            return this.receiver.receiveFrom(OutputQueueName);
        } catch (IOException ex) {
            Logger.getLogger(MessagingServiceFacade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MessagingServiceFacade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(MessagingServiceFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
