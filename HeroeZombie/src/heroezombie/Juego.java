/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heroezombie;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import javax.swing.JOptionPane;

import heroezombie.Juego.STATE;

/**
 *
 * @author gustavo
 */
public class Juego extends Canvas implements Runnable {

    /**
     * @param args the command line arguments
     */
    
    //////////VARIABLES/////////
    public static final int ancho = 1366 , alto = 768;
    // alto = ancho /12*9;
    private Thread thread;
    
    private BufferedImage levelLayout = null;
    
    private boolean running=false;
    
    public static boolean paused = false;
    
    private Handler handler;
    
    private Random r;
    
    private HUD hud;
    
    private Spawner spawner;
    
    private Menu menu;
    
    private URL url;
    
    private AudioPlayer audioPlayer;
          
    public enum STATE{
        Menu,
        Help,
        End,
        Game
    };
    
    public static STATE gameState = STATE.Menu;
    
    //////////METODOS//////////
    
    public Juego(){
        
        new Ventana (ancho, alto,"Heroe Zombie",this);
        
        handler = new Handler();
        
        hud = new HUD();
        
        menu = new Menu(this,handler,hud);
        
        this.addKeyListener(new KeyInput(handler,this));
        
        this.addMouseListener(menu);
        
        BufferedImageLoader loader = new BufferedImageLoader();
        levelLayout = loader.loadImage("/zombiemapLayoutt.png");
        LoadLevel(levelLayout);      
        
        spawner = new Spawner (handler, hud);
        
        r = new Random();
        
        
        
//        audioPlayer = new AudioPlayer();
//        
//        audioPlayer.load("C:\\Users\\gustavo\\Desktop\\gitProjects\\zombiekiller\\res\\TeknoAXE.ogg");
//        
//        AudioPlayer.getMusic("music").loop();;
    	
     
        
    }
    
    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        running=true;
        
    }
    
    public synchronized void stop(){
        try{
            
            thread.join();
            running=false;
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void run(){
        this.requestFocus();
        
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running)
        {
                    long now = System.nanoTime();
                    delta += (now - lastTime) / ns;
                    lastTime = now;
                    while(delta >=1)
                            {
                                tick();
                                delta--;
                            }
                            if(running)
                                render();
                            frames++;
                            
                            if(System.currentTimeMillis() - timer > 1000)
                            {
                                timer += 1000;
                                //System.out.println("FPS: "+ frames);
                                frames = 0;
                            }
        }
                stop();
    
    }
    
    private void tick(){
   
        if (gameState == STATE.Game) {
        	if(!paused) {
        		hud.tick();
                spawner.tick();
                handler.tick();
                if(HUD.vida <= 0) {
                	HUD.vida = 100;      
                	gameState = STATE.End;
                	handler.limpiarEnemigos();
        	}
        
        	
        	
        }
        
        }else if(gameState == STATE.Menu || gameState == STATE.Help || gameState == STATE.End) {
        	menu.tick();
        	handler.tick();
        }
    }
    
    private void render(){
    	 
      BufferStrategy bs = this.getBufferStrategy();
      if(bs == null){
          this.createBufferStrategy(3);
          return;
      }
      Graphics g = bs.getDrawGraphics();
      
      /////////////////////////////Fondo de la pantalla/////////////////////////////
      g.setColor(Color.black);
      g.fillRect(0, 0, ancho, alto);
      /////////////////////////////
      handler.render(g);
      
        if (gameState == STATE.Game) {
            hud.render(g);
            if(paused) {
            	g.drawString("PAUSA", 150, 150);
            }
        }else if(gameState == STATE.Menu || gameState == STATE.Help || gameState == STATE.End){
        	menu.render(g);
        }
      g.dispose();
      bs.show();
    }
    
    private void LoadLevel(BufferedImage image){
        int anchura = image.getWidth();
        int largo = image.getHeight();
        
        for (int i = 0; i < anchura; i++) {
            for (int j = 0; j < largo; j++) {
            int pixel = image.getRGB(i, j);
            
            int red = (pixel >> 16) & 0xff;
            System.out.printf(" "+ red);
            
            
            int green = (pixel >> 8) & 0xff;
            
            
            int blue = (pixel) & 0xff;
            
            if(red == 255){
                handler.addObject(new Bloque(i*32,j*32,ID.Bloque));
            }
            
            if(blue == 255){
                handler.addObject(new Jugador(i*32,j*32,ID.Jugador,handler));
            }
            }
            
        }
    }
    
    public static float clamp(float var, float min, float max){
        //metodo clamp para colisiones de ventana
        if (var>=max) {
            return var = max;
        }else if (var <=min) {
            return var = min;
        }else return var;
        
    }
    
    public static void main(String[] args) {
        
        new Juego();
              
    }
    
}
