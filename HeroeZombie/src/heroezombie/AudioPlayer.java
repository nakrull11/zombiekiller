package heroezombie;

import java.net.URL;
import java.util.HashMap;

import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;


public class AudioPlayer {

	public static HashMap<String, Sound> soundMap = new HashMap<String, Sound>();
	public static HashMap<String, Music> musicMap = new HashMap<String,Music>();
	
	public void load(URL filePath) {
		
		try {
			java.net.URL res = getClass().getResource(filePath.toString());
			musicMap.put("music",new Music(res));
			
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static Music getMusic (String key) {
		return  musicMap.get(key);
	}
	
} 
