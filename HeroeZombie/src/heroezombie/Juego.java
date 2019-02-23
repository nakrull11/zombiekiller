/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heroezombie;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.net.URL;
import java.util.Random;

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
    public static final int ancho = 640, alto= ancho / 12 * 9;
    
    private Thread thread;
    
    private boolean running=false;
    
    private Handler handler;
    
    private Random r;
    
    private HUD hud;
    
    private Spawner spawner;
    
    private Menu menu;
    
    public enum STATE{
        Menu,
        Help,
        Game
    };
    
    public static STATE gameState = STATE.Menu;
    
    //////////METODOS//////////
    
    public Juego(){
        handler = new Handler();
        
        menu = new Menu(this,handler);
        
        this.addKeyListener(new KeyInput(handler));
        
        this.addMouseListener(menu);
        
        new Ventana (ancho, alto,"Heroe Zombie",this);
        
        hud = new HUD();
        
        spawner = new Spawner (handler, hud);
        
        r = new Random();
        
        new Music();
        
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
        handler.tick();
        if (gameState == STATE.Game) {
        hud.tick();
        spawner.tick();
        }else if(gameState == STATE.Menu || gameState == STATE.Help) {
        	menu.tick();
        }
    }
    
    private void render(){
    	 
      BufferStrategy bs = this.getBufferStrategy();
      if(bs == null){
          this.createBufferStrategy(3);
          return;
      }
      
      Graphics g = bs.getDrawGraphics();
      g.setColor(Color.black);
      g.fillRect(0, 0, ancho, alto);
      handler.render(g);
      
        if (gameState == STATE.Game) {
            hud.render(g);    
        }else if(gameState == STATE.Menu || gameState == STATE.Help){
        	menu.render(g);
        }
      g.dispose();
      bs.show();
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
