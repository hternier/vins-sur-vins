package fr.afcepf.al18.framework.vingtSurStruts.commons.utils;

import org.apache.commons.lang.StringUtils;

public class UrlPatternUtils {
	
	public static String toActionKey(String urlPattern) {
		return StringUtils.substringBetween(urlPattern, "/", ".perform");
	}

}
