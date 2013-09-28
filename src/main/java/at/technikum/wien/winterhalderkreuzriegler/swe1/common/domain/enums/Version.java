package at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.enums;

public enum Version {
	V1_1("1.1");

	private Version(String version) {
		this.version = version;
	}

	private String version;

	public static Version getVersion(String stringVersion) {
		for (Version v : Version.values()) {
			if (stringVersion.equals(v.version)) {
				return v;
			}
		}
		return null;
	}

}
