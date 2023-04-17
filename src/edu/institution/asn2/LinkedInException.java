/* Colin Maxwell
 * Java II R01
 * Assignment 2 - The LinkedInUser Class
 *  1/29/21
 */

package edu.institution.asn2;

@SuppressWarnings("serial")
public class LinkedInException extends Exception {

	public LinkedInException() {
	}

	public LinkedInException(String arg0) {
		super(arg0);
	}

	public LinkedInException(Throwable arg0) {
		super(arg0);
	}

	public LinkedInException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public LinkedInException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

}
