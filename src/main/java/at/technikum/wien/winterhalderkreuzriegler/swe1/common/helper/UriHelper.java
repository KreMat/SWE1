package at.technikum.wien.winterhalderkreuzriegler.swe1.common.helper;

public class UriHelper {

	/**
	 * Extrahiert aus dem Path den zweiten URI-Teil
	 * 
	 * <pre>
	 * z.B.: /static/index.html -> index.html
	 * </pre>
	 * 
	 * @param path
	 *            zu konvertierender Path
	 * @return extrahierter Zweiter URL-Teil
	 */
	public static String convertPath(String path) {
		path = path.substring(1);
		return path.indexOf('/') == -1 ? "" : path.substring(path.indexOf('/'));
	}

}
