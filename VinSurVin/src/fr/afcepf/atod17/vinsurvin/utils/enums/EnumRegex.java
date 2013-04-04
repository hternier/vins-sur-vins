package fr.afcepf.atod17.vinsurvin.utils.enums;

public enum EnumRegex {
	
	PRIX("^[$]?[0-9]*(\\.|\\,)?[0-9]?[0-9]?$"),
	ANNEE("^\\d{4}$"),
	CODE_POSTAL("^((0[1-9])|([1-8][0-9])|(9[0-8])|(2A)|(2B))[0-9]{3}$"),
	MAIL("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?");
	
	
	private String pattern;

	private EnumRegex(String pattern) {
		this.pattern = pattern;
	}

	public String getPattern() {
		return pattern;
	}
	
}
