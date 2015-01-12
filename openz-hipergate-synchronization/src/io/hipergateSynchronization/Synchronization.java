package io.hipergateSynchronization;

import java.util.List;

import com.knowgate.hipergate.InformationsKomponente.OpenZGeschaeftspartner;

import logic.exceptions.UnknownGroupException;
import pojo.BusinessPartner;
import io.hipergateSynchronization.messageService.IMessagingService;
import io.hipergateSynchronization.messageService.MessagingServiceFacade;

/**
 * This class provides methods to pull Business Partners from Hipergate or to
 * push Business Partners to Hipergate.
 * 
 * @author HAWAI
 *
 */
public class Synchronization {
	
	
	private Synchronization() {
	}

	/**
	 * @param bp
	 *            Pushes BusinessPartner to Hipergate
	 */
	public static void hipergatePush(BusinessPartner bp) {
		IMessagingService<OpenZGeschaeftspartner> iService = new MessagingServiceFacade<OpenZGeschaeftspartner>();
		iService.pushMessage(logic.Converter.convertToOpenZGeschaftspartner(bp));

	}

	/**
	 * Pulls all new and/or updated Partners from RabbitMQ-MessageQueue
	 */
	public static void hipergatePull() {
		IMessagingService<OpenZGeschaeftspartner> iService =  new MessagingServiceFacade<OpenZGeschaeftspartner>();
		List<OpenZGeschaeftspartner> list = iService.pullMessages();
		System.out.println("ListSize: " + list.size());
		for (OpenZGeschaeftspartner partner : list) {
			BusinessPartner bp;
			try {
				bp = logic.Converter.convertToBusinessPartner(partner);
				System.out.println("BusinessPartnerToBePersisted" + bp);
				bp.persist();
			} catch (UnknownGroupException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
