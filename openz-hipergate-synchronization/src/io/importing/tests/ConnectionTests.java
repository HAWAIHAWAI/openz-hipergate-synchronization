package io.importing.tests;

import static org.junit.Assert.*;
import io.importing.IMessagingService;
import io.importing.MessagingServiceFacade;

import org.junit.Test;

import pojo.OpenZGeschaeftspartner;

public class ConnectionTests {

	@Test
	public void getObjectTest() {
		IMessagingService<OpenZGeschaeftspartner> messagingService = new MessagingServiceFacade();
		OpenZGeschaeftspartner oZ = new OpenZGeschaeftspartner();
		oZ.beschreibung = "Test";
		oZ.land = "Deutschland";
		oZ.steuernummer = 1;
		messagingService.pushMessage(oZ);
		OpenZGeschaeftspartner obj = messagingService.pullMessageFromOutputQueue();
		assertTrue(obj.beschreibung.equals(oZ.beschreibung));
		assertTrue(obj.land.equals(oZ.land));
		assertTrue(obj.steuernummer == oZ.steuernummer);
		assertTrue(obj.equals(oZ));
	}

}
