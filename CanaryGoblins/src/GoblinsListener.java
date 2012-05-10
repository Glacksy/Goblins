import java.util.Random;
import java.util.logging.Logger;



public class GoblinsListener extends PluginListener {

	private static Logger log = Logger.getLogger("Minecraft");
	
	
	
	public void onLogin(Player player) {
		player.sendMessage("Gmonur greets you, 'Welcome master!'");
	}
	
}

//test

