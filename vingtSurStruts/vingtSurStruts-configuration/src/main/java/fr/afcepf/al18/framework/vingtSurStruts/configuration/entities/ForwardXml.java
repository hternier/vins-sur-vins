package fr.afcepf.al18.framework.vingtSurStruts.configuration.entities;

public class ForwardXml {
	
	private String name;
	private String path;
	
	public ForwardXml() {
		
	}
	
	public ForwardXml(String name, String path) {
		this.name = name;
		this.path = path;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
