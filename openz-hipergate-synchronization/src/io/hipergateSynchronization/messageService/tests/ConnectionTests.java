package io.hipergateSynchronization.messageService.tests;

import static org.junit.Assert.*;
import io.hipergateSynchronization.messageService.IMessagingService;
import io.hipergateSynchronization.messageService.MessagingServiceFacade;

import org.junit.Test;

import pojo.OpenZGeschaeftspartner;

public class ConnectionTests {

	@Test
	public void getObjectTest() {
		IMessagingService<OpenZGeschaeftspartner> messagingService = new MessagingServiceFacade<OpenZGeschaeftspartner>();
		OpenZGeschaeftspartner oZ = new OpenZGeschaeftspartner();
		oZ.beschreibung = "Test";
		oZ.land = "Deutschland";
		oZ.steuernummer = "1";
		messagingService.pushMessage(oZ);
		OpenZGeschaeftspartner obj = messagingService.pullMessageFromOutputQueue();
		assertTrue(obj.beschreibung.equals(oZ.beschreibung));
		assertTrue(obj.land.equals(oZ.land));
		assertTrue(obj.steuernummer.equals(oZ.steuernummer));	
		assertTrue(obj.equals(oZ));
	}
}
