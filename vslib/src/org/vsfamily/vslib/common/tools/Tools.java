package org.vsfamily.vslib.common.tools;

import java.util.Random;

/**
 * Tools class containing various manipulation tools.
 */
public class Tools {
	
	private String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmopqrstuvwxyz";
	private Random rnd = new Random();

	/**
	 * Gets a random string of a given size.
	 * @param len - the size of required random string
	 * @return the random string
	 */
	public String randomString( int len ) 
	{
	   StringBuilder sb = new StringBuilder( len );
	   for( int i = 0; i < len; i++ ) 
	      sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
	   return sb.toString();
	}
}
