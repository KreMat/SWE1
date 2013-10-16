package at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.enums;

public enum Protocol {
	HTTP;
	
	public static Protocol getByProtocolString(String protocolString){
		for (Protocol p : Protocol.values()) {
			if (protocolString.equals(p.name())) {
				return p;
			}
		}
		return null;
	}

}
