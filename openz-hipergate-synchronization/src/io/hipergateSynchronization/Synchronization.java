package io.hipergateSynchronization;

import java.util.List;

import pojo.BusinessPartner;
import pojo.OpenZGeschaeftspartner;
import io.hipergateSynchronization.messageService.IMessagingService;
import io.hipergateSynchronization.messageService.MessagingServiceFacade;

public class Synchronization {
	
	private Synchronization(){}
	
	/**
	 * @param bp Pushes BusinessPartner to Hipergate
	 */
	public static void hipergatePush(BusinessPartner bp){
		IMessagingService<OpenZGeschaeftspartner> iService = new MessagingServiceFacade<OpenZGeschaeftspartner>();
		iService.pushMessage(logic.Converter.convertToOpenZGeschaftspartner(bp));
		
	}
	
	/**
	 * Pulls all new and/or updated Partners from RabbitMQ-MessageQueue
	 */
	public static void hipergatePull(){
		IMessagingService<OpenZGeschaeftspartner> iService = new MessagingServiceFacade<OpenZGeschaeftspartner>();
		List<OpenZGeschaeftspartner> list = iService.pullMessages();
		for(OpenZGeschaeftspartner partner:list){
			BusinessPartner bp = logic.Converter.convertToBusinessPartner(partner);
			bp.persist();
		}
		
	}
	
}
