package org.tditsolutions.qa.utils;

import java.util.Arrays;
import java.util.List;

public class Constants {

	//Expected results
	public static final String LOGIN_PAGE_HEADER="TDIT Solutions";

	//Incorrect Login Credentials Popup message
	public static final String INCORRECT_LOGIN_MESSAGE="No such User exists. Invalid Credentials";

	public static final String HOME_PAGE_TITLE="TDIT Solutions";

	public static final List<String> EXPECTED_SIDE_BAR_HEADERS_HOME_PAGE= Arrays.asList(new String[]{"Trade","Account","Security"});

	public static final List<String> EXPECTED_SIDE_BAR_LINK_TEXT_HOME_PAGE=Arrays.asList(new String[]{"View Trade","Buy Trade","Sell Trade","Add Account","Update Account","Delete Account","Add Security","Update security","Delete security"});

	public static final String EXPECTED_HEADER_OF_ADD_ACCOUNT_PAGE="Add Account";
	public static final String EXPECTED_ALERT_MAG_OF_ADD_ACCOUNT_PAGE="Account Registered..";

	public static final String EXPECTED_VALIDATION_MSG="Value must be greater than or equal to 0.";

}
