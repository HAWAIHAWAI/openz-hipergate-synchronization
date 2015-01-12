package io.hipergateSynchronization.messageService.tests;

import static org.junit.Assert.*;

import java.util.List;

import io.hipergateSynchronization.messageService.IMessagingService;
import io.hipergateSynchronization.messageService.MessagingServiceFacade;

import org.junit.Test;

import com.knowgate.hipergate.InformationsKomponente.OpenZGeschaeftspartner;

/**
 * Test class for Connection Tests.
 * 
 * @author HAWAI
 *
 */
public class ConnectionTests {

	@Test
	public void getObjectTest() {
		IMessagingService<OpenZGeschaeftspartner> messagingService = new MessagingServiceFacade<OpenZGeschaeftspartner>();
		OpenZGeschaeftspartner oZ = new OpenZGeschaeftspartner();
		oZ.beschreibung = "Test";
		oZ.land = "Deutschland";
		oZ.steuernummer = "1";
		messagingService.pushMessage(oZ);
		OpenZGeschaeftspartner obj = messagingService
				.pullMessage(messagingService.getOutputQueueName());
		assertTrue(obj.beschreibung.equals(oZ.beschreibung));
		assertTrue(obj.land.equals(oZ.land));
		assertTrue(obj.steuernummer.equals(oZ.steuernummer));
		assertTrue(obj.equals(oZ));
	}

	@Test
	public void getNoObjectsTest() {
		IMessagingService<OpenZGeschaeftspartner> messagingService = new MessagingServiceFacade<OpenZGeschaeftspartner>();
		OpenZGeschaeftspartner oZ = new OpenZGeschaeftspartner();
		oZ.beschreibung = "Test";
		oZ.land = "Deutschland";
		oZ.steuernummer = "1";
		List<OpenZGeschaeftspartner> list = messagingService.pullMessages();
		assertTrue(list.size() == 0);
	}

	@Test
	public void getAllObjectsTest() {
		IMessagingService<OpenZGeschaeftspartner> messagingService = new MessagingServiceFacade<OpenZGeschaeftspartner>();
		OpenZGeschaeftspartner oZ = new OpenZGeschaeftspartner();
		oZ.beschreibung = "Test";
		oZ.land = "Deutschland";
		oZ.steuernummer = "1";
		messagingService.pushMessage(oZ, messagingService.getInputQueueName());
		List<OpenZGeschaeftspartner> list = messagingService.pullMessages();
		System.out.println("List with 1 business partner" + list);
		assertTrue(list.size() == 1);
	}

	@Test
	public void repeatedObjectsTest() {
		IMessagingService<OpenZGeschaeftspartner> messagingService = new MessagingServiceFacade<OpenZGeschaeftspartner>();
		OpenZGeschaeftspartner oZ = new OpenZGeschaeftspartner();
		oZ.setBeschreibung("Test");
		oZ.setLand("Deutschland");
		oZ.steuernummer = "1";

		for (Integer i = 0; i < 1000; i++) {
			oZ.steuernummer = i.toString();
			messagingService.pushMessage(oZ,
					messagingService.getInputQueueName());
			List<OpenZGeschaeftspartner> list = messagingService.pullMessages();
			System.out.println("List with 1 business partner" + list);
			// assertTrue(list.size()==1);
		}
	}

	@Test
	public void testObjectChange() {
		// Teststart
		// Aufforderung: Bitte xyz in Hipergate ändern, mit Enter bestätigen
		// synchronisieren
		// Änderung überprüfen
		// while(nicht zurückgeändert) In Hipergate Änderung rückgängig machen
		// synchronisieren
		// Änderung überprüfen
	}

	@Test
	public void testObjectInsert() {
		// Teststart
		// Aufforderung: Bitte xyz in Hipergate einfügen, und hier mit Enter
		// bestätigen
		// synchronisieren
		// Einfügen überprüfen
	}

}
