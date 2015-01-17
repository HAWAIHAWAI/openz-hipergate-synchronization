package io.hipergateSynchronization;

import java.util.Calendar;
import java.util.List;

import com.knowgate.hipergate.InformationsKomponente.OpenZGeschaeftspartner;

import logic.exceptions.UnknownGroupException;
import pojo.BusinessPartner;
import pojo.LogEntry;
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
	
	/**
	 * Private Constructor - No instantiation.
	 */
	private Synchronization() {
	}

	/**
	 * Method to push a BusinessParter to Hipergate.
	 * @param bp BusinessPartner, which shall be pushed.
	 */
	public static void hipergatePush(BusinessPartner bp) {
		IMessagingService<OpenZGeschaeftspartner> iService = new MessagingServiceFacade<OpenZGeschaeftspartner>();
		iService.pushMessage(logic.Converter.convertToOpenZGeschaftspartner(bp));

	}

	/**
	 * Pulls all new and/or updated Partners from RabbitMQ-MessageQueue.
	 * @return Number of edited businessPartners
	 */
	public static void hipergatePull() {
		IMessagingService<OpenZGeschaeftspartner> iService =  new MessagingServiceFacade<OpenZGeschaeftspartner>();
		List<OpenZGeschaeftspartner> list = iService.pullMessages();
		System.out.println("ListSize: " + list.size());
		for (OpenZGeschaeftspartner partner : list) {
			BusinessPartner bp;
			try {
				bp = logic.Converter.convertToBusinessPartner(partner);
				String bpAsString = bp.toString();
				System.out.println("BusinessPartnerToBePersisted" + bp);
				bp.persist();
				System.out.println("BusinessPartner persisted");
				LogEntry logEntry = new LogEntry();
				logEntry.setTimestamp(new java.sql.Timestamp(Calendar.getInstance().getTime().getTime()));
				logEntry.setDescription("BusinessPartner persisted: " + bpAsString);
				System.out.println(logEntry);
				logEntry.persist();
			} catch (UnknownGroupException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
