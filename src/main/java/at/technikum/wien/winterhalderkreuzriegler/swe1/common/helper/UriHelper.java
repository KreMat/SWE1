package at.technikum.wien.winterhalderkreuzriegler.swe1.common.helper;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Stellt saemtliche Helfermethoden fuer die UriImpl Klasse zur verfuegung.
 *
 */
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
		return path.indexOf('/') == -1 ? "" : path
				.substring(path.indexOf('/') + 1);
	}

	public static String[] splitPath(String path) {
		return path.replace(" ", "").split("/");
	}

	public static Map<String, String> getParamValue(String params) {
		if (params == null || params.length() == 0) {
			return new HashMap<String, String>();
		}
		String[] splittedParams = params.split("&");
		Map<String, String> result = new HashMap<String, String>();
		for (String par : splittedParams) {
			String[] splPar = par.split("=");
			result.put(splPar[0], splPar[1]);
		}

		return result;
	}

}
