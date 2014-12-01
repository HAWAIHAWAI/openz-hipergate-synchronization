/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package io.hipergateSynchronization.messageService;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;

import global.Settings;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Daniel Glake, cglaeser
 */
public class MessagingServiceFacade<T> implements IMessagingService<T> {

	private Settings settings;
    private final String InputQueueName = "HAWAI_QUEUE_INPUT";
    private final String OutputQueueName = "HAWAI_QUEUE_OUTPUT";
    public ConnectionFactory factory = null;
    public Connection rabbitConnection = null;
    private Receiver<T> receiver = null;
    private Publisher<T> publisher = null;

    public MessagingServiceFacade() {
    	try {
			settings = io.SettingsInstantiation.getSettings();
		} catch (IOException e) {
			settings = new Settings();
			settings.setHipergateLocation("localhost");
		}
        this.factory = new ConnectionFactory();
        factory.setHost(settings.getHipergateLocation());
        try {
            //ExecutorService executor = Executors.newFixedThreadPool(nThreads);
            //this.rabbitConnection = factory.newConnection(executor);
            this.rabbitConnection = factory.newConnection();
        } catch (IOException ex) {
            Logger.getLogger(MessagingServiceFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            this.receiver = new Receiver<T>(this.rabbitConnection, InputQueueName);
        } catch (IOException ex) {
            Logger.getLogger(MessagingServiceFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            this.publisher = new Publisher<T>(this.rabbitConnection, OutputQueueName);
        } catch (IOException ex) {
            Logger.getLogger(MessagingServiceFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*
     * Gibt den Inhalt einer Nachricht, als String zurück.
     * Gibt null zurück, wenn Fehler beim Abruf aufgetreten sind.
     */
    @SuppressWarnings("unchecked")
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

    public T pullMessage(){
        try {
            return this.receiver.receive();
        } catch (InterruptedException ex) {
            Logger.getLogger(MessagingServiceFacade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MessagingServiceFacade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MessagingServiceFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
	@Override
	public List<T> pullMessages() {
		try {
            return this.receiver.receiveAll();
        } catch (InterruptedException ex) {
            Logger.getLogger(MessagingServiceFacade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MessagingServiceFacade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MessagingServiceFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
	}

    public void pushMessage(T obj) {
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

    public T pullMessageFromOutputQueue() {
        try {
            return (T) this.receiver.receiveFrom(OutputQueueName);
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
