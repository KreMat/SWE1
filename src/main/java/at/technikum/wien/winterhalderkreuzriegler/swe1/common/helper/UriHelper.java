package at.technikum.wien.winterhalderkreuzriegler.swe1.common.helper;

public class UriHelper {

	public static String convertPath(String path) {
		path = path.substring(1);
		return path.indexOf('/') == -1 ? "" : path.substring(path.indexOf('/'));
	}

}
