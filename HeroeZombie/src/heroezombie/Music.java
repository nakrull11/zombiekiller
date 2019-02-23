package heroezombie;

import java.awt.Toolkit;
import java.io.File;
import java.net.URL;

import com.sun.xml.internal.ws.api.ResourceLoader;

import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public  class Music {
	MediaPlayer player;
	
	public Music() {
		final JFXPanel jfxpanel = new JFXPanel();
	}
	
	public void play(URL filename) {
		
		URL url = ResourceLoader.class.getResource(filename.toString());
		
		Media hit = new Media(url.toString());
		player = new MediaPlayer(hit);
		player.play();
	}
	
	public  void play(String filename)
	{	
		Media hit = new Media(new File(filename).toURI().toString());
		player = new MediaPlayer(hit);
		player.play();
	}
}

