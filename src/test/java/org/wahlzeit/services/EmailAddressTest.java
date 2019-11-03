/*
 * Copyright (c) 2006-2009 by Dirk Riehle, http://dirkriehle.com
 *
 * This file is part of the Wahlzeit photo rating application.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */

package org.wahlzeit.services;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

/**
 * Test cases for the EmailAddress class.
 */
public class EmailAddressTest extends TestCase {


	/**
	 *
	 */
	public EmailAddressTest(String name) {
		super(name);
	}


	/**
	 *
	 */
	public void testGetEmailAddressFromString() {
		// invalid email addresses are allowed for local testing and online avoided by
		// Google

		assertTrue(createEmailAddressIgnoreException("bingo@bongo"));
		assertTrue(createEmailAddressIgnoreException("bingo@bongo.com"));
		assertTrue(createEmailAddressIgnoreException("bingo.bongo@bongo.com"));
		assertTrue(createEmailAddressIgnoreException("bingo+bongo@bango"));
	}


	@Test
	public void testEmailEquals() {
		 String addressName1 = "bingo@bongo";
		 String addressName2 = "bango@bongo";
		 String addressName3 = "bingo@bongo";

		 EmailAddress address1 = EmailAddress.doGetFromString(addressName1);
		 EmailAddress address2 = EmailAddress.doGetFromString(addressName2);
		 EmailAddress address3 = EmailAddress.doGetFromString(addressName3);
		
		assertTrue(address1.isEqual(address3));
		assertFalse(address1.isEqual(address2));
	}

	@Test
	public void testStringConversion() {
		 String addressName1 = "bingo@bongo";
		 EmailAddress address1 = EmailAddress.doGetFromString(addressName1);
		 
		assertTrue(address1.asString() == addressName1);
	}

	@Test
	public void testValidInternetAddressConversion() {
		 String addressName1 = "bingo@bongo";
		 EmailAddress address1 = EmailAddress.doGetFromString(addressName1);
		 
		InternetAddress internetAddress1 = address1.asInternetAddress();
		assertNotNull(internetAddress1.getAddress());
	}


	/**
	 *
	 */
	protected boolean createEmailAddressIgnoreException(String ea) {
		try {
			EmailAddress.getFromString(ea);
			return true;
		} catch (IllegalArgumentException ex) {
			// creation failed
			return false;
		}
	}

	/**
	 *
	 */
	public void testEmptyEmailAddressIsInvalid() {
		assertFalse(EmailAddress.EMPTY.isValid());
	}
	public void testEmptyEmailAddressIsValid() {
		 String addressName1 = "bingo@bongo";
		 EmailAddress address1 = EmailAddress.doGetFromString(addressName1);
		 
		assertTrue(address1.isValid());
	}

}
