import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

/**
 * This is the main class file for WorldTools
 * @author Glacksy
 */

public class CanaryGoblins extends Plugin {

	  static final GoblinsListener listener = new GoblinsListener();
	  
	  private static Logger log = Logger.getLogger("Minecraft");
	  
	  static String pluginName = "Goblins";
	  static String version = "1";
	  static String Author = "Glacksy";
	  static String Updatr = "Updatr";
	  public static String Ver = "1.0";
	  
	  private final static String Dir = "plugins/config/Goblins/"; 
	  private final static String Set = "Goblins.properties";

	  Server server = etc.getServer();


public void enable()
{
	log.info(pluginName + " " + version + " by " + Author + " Enabled");
	if(Listener.isLatest()){
	log.info("There is an update available for Goblins ");}
}

public void disable()
{
	log.info(pluginName + " " + version + " by " + Author + " Disabled");
}

public void initialize()
{ 
  PluginLoader loader = etc.getLoader();
  loader.addListener(PluginLoader.Hook.COMMAND, listener, this, PluginListener.Priority.MEDIUM);
  loader.addListener(PluginLoader.Hook.ITEM_PICK_UP, listener, this, PluginListener.Priority.MEDIUM);
  loader.addListener(PluginLoader.Hook.ITEM_DROP, listener, this, PluginListener.Priority.MEDIUM);
  loader.addListener(PluginLoader.Hook.HEALTH_CHANGE, listener, this, PluginListener.Priority.MEDIUM);
  loader.addListener(PluginLoader.Hook.LOGIN, listener, this, PluginListener.Priority.MEDIUM);
  loader.addListener(PluginLoader.Hook.DISCONNECT, listener, this, PluginListener.Priority.MEDIUM);
  loader.addListener(PluginLoader.Hook.BLOCK_PLACE, listener, this, PluginListener.Priority.MEDIUM);
  loader.addListener(PluginLoader.Hook.BLOCK_DESTROYED, listener, this, PluginListener.Priority.MEDIUM);
  loader.addListener(PluginLoader.Hook.DAMAGE, listener, this, PluginListener.Priority.HIGH);
  loader.addListener(PluginLoader.Hook.EAT, listener, this, PluginListener.Priority.MEDIUM);
  loader.addListener(PluginLoader.Hook.LIGHTNING_STRIKE, listener, this, PluginListener.Priority.MEDIUM);
  loader.addListener(PluginLoader.Hook.WEATHER_CHANGE, listener, this, PluginListener.Priority.MEDIUM);
  loader.addListener(PluginLoader.Hook.THUNDER_CHANGE, listener, this, PluginListener.Priority.MEDIUM);
  log.info(pluginName + " " + version + " by " + Author + " initialized");
}

 public static class Listener extends PluginListener {

	 /**
	  * Check if your running latest version
	  * @author darkdiplomat
	  * @return
	  */
	    public static boolean isLatest(){
		String address = "http://www.topica-rp.com/Download/version.html";
		URL url = null;
		try {
			url = new URL(address);
		} catch (MalformedURLException e) {
			return true;
		}
		String[] Vpre = new String[1]; 
		BufferedReader in;
		try {
			in = new BufferedReader(new InputStreamReader(url.openStream()));
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				if (inputLine.contains("Goblins=")){
					Vpre = inputLine.split("=");
					Ver = Vpre[1].replace("</p>", "");
				}
			}
			in.close();
		} catch (IOException e) {
			return true;
		}
		return (version.equals(Ver));
	} 
	}
}
