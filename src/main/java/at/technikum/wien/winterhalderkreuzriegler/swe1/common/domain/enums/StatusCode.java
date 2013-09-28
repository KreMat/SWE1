package at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.enums;

public enum StatusCode {
	STATUS_404(404), STATUS_200(200);

	private StatusCode(int code) {
		this.code = code;
	}

	private int code;

	public int getCode() {
		return code;
	}

}
