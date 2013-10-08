package at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.enums;

public enum StatusCode {
	STATUS_404(404, false), STATUS_200(200, true), STATUS_500(500,false);

	private StatusCode(int code, boolean ok) {
		this.code = code;
		this.ok = ok;
	}

	private int code;
	private boolean ok;

	public int getCode() {
		return code;
	}
	
	public boolean getOk(){
		return ok;
	}

}
