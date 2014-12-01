package io.hipergateSynchronization;

import pojo.BusinessPartner;
import pojo.OpenZGeschaeftspartner;
import io.hipergateSynchronization.messageService.IMessagingService;
import io.hipergateSynchronization.messageService.MessagingServiceFacade;

public class Synchronization {
	
	private Synchronization(){}
	
	public static void hipergatePush(BusinessPartner bp){
		IMessagingService<OpenZGeschaeftspartner> iService = new MessagingServiceFacade<OpenZGeschaeftspartner>();
		iService.pushMessage(logic.Converter.convertToOpenZGeschaftspartner(bp));
		
	}
	
	public static void hipergatePull(){
		IMessagingService<OpenZGeschaeftspartner> iService = new MessagingServiceFacade<OpenZGeschaeftspartner>();
		BusinessPartner bp = logic.Converter.convertToBusinessPartner(iService.pullMessage());
		bp.persist();
	}
	
}
