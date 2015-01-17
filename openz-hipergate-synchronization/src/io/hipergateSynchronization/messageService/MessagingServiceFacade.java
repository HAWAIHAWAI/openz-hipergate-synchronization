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
 * Implementation of IMessagingService.
 * MessagingServiceFacade is responsible for receiving and sending messages to queues.
 * Fixed to InputQueue "FROM_HIPERGATE_TO_OPENZ" and OutputQueue "FROM_OPENZ_TO_HIPERGATE".
 *
 * @author Daniel Glake, cglaeser
 */
public class MessagingServiceFacade<T> implements IMessagingService<T> {

	/**
	 * Settings for the MessagingServiceFacade.
	 */
	private Settings settings;
	
	/**
	 * Name of the InputQueue.
	 */
    private final String inputQueue = "FROM_HIPERGATE_TO_OPENZ";
    
    /**
     * Name of the OutputQueue.
     */
    private final String outputQueue = "FROM_OPENZ_TO_HIPERGATE";
    
    /**
     * Factory for a Connection.
     */
    public ConnectionFactory factory = null;
    
    /**
     * Connection to RabbitMQ.
     */
    public Connection rabbitConnection = null;
    
    /**
     * For receiving messages.
     */
    private Receiver<T> receiver = null;
    
    /**
     * For publishing messages.
     */
    private Publisher<T> publisher = null;

    /**
     * Constructor.
     */
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
            this.receiver = new Receiver<T>(this.rabbitConnection, inputQueue);
        } catch (IOException ex) {
            Logger.getLogger(MessagingServiceFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            this.publisher = new Publisher<T>(this.rabbitConnection, outputQueue);
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

    public T pullMessage(){
        return pullMessage(inputQueue);
    }
    
    public T pullMessage(String queue){
        try {
            return this.receiver.receiveFrom(queue);
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
        pushMessage(obj, outputQueue);
    }
    
    public void pushMessage(T obj,String queue) {
        try {
            this.publisher.pushTo(queue, obj);
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

	@Override
	public String getOutputQueueName() {
		return this.outputQueue;
	}

	@Override
	public String getInputQueueName() {
		return this.inputQueue;
	}
}
