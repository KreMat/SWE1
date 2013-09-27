package at.technikum.wien.winterhalderkreuzriegler.swe1.plugins;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import at.technikum.wien.winterhalderkreuzriegler.swe1.common.WebserverConstants;
import at.technikum.wien.winterhalderkreuzriegler.swe1.plugins.interfaces.Pluggable;

public class PluginCache {

	public static final Map<String, Pluggable> plugins;

	static {
		plugins = new HashMap<String, Pluggable>();
		refreshPluginCache();
	}

	public static void refreshPluginCache() {
		Properties properties = new Properties();
		try {
			properties.load(new FileReader(new File(
					WebserverConstants.RELATIVE_CONFIG_FILE_PATH)));
			String pluginDirPath = properties.getProperty(
					WebserverConstants.PLUGIN_DIR_KEY,
					WebserverConstants.DEFAULT_PLUGIN_DIR_PATH);
			Map<String, String> plugins = new HashMap<String, String>();
			for (Entry<Object, Object> prop : properties.entrySet()) {
				if (!WebserverConstants.PLUGIN_DIR_KEY.equals(prop.getKey()
						.toString())) {
					plugins.put(prop.getKey().toString(), prop.getValue()
							.toString());
				}
			}
			Map<String, Pluggable> loadedPlugins = PluginLoader.loadPlugins(
					new File(pluginDirPath), plugins);
			PluginCache.plugins.putAll(loadedPlugins);
		} catch (IOException e) {
			throw new IllegalArgumentException(
					"Fehler beim auslesen des Config-Files.", e);
		}

	}

}
