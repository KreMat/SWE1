package at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.enums;

/**
 * 
 * Aufaehlung aller Fehlercodes
 *
 */

public enum StatusCode {
	STATUS_404(404, false), STATUS_200(200, true), STATUS_500(500,false);

	/**
	 * 
	 * @param code nimmt den Fehlercode als INT entgegen und waehlt den richtigen emum aus.
	 * @param ok status des aufrufes
	 */
	private StatusCode(int code, boolean ok) {
		this.code = code;
		this.ok = ok;
	}

	private int code;
	private boolean ok;

	/**
	 * 
	 * @return Gibt den Fehlercode zurueck
	 */
	public int getCode() {
		return code;
	}
	
	/**
	 * 
	 * @return gibt TRUE zurueck die Seite gefunden wurde und ob der Status Ok ist, andersfalls wird FALSE zurueckgegeben
	 */
	public boolean getOk(){
		return ok;
	}

}
