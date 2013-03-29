package fr.afcepf.atod17.vinsurvin.utils.enums;

public enum EnumRegex {
	
	PRIX("^[$]?[0-9]*(\\.|\\,)?[0-9]?[0-9]?$"),
	ANNEE("^\\d{4}$");
	
	private String pattern;

	private EnumRegex(String pattern) {
		this.pattern = pattern;
	}

	public String getPattern() {
		return pattern;
	}
	
}
