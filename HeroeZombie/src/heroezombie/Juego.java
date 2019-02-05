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
import java.util.Random;

/**
 *
 * @author gustavo
 */
public class Juego extends Canvas implements Runnable {

    /**
     * @param args the command line arguments
     */
    public static final int ancho = 640, alto= ancho / 12 * 9;
    
    private Thread thread;
    
    private boolean running=false;
    
    private Handler handler;
    
    private Random r;
    
    public Juego(){
        handler = new Handler();
        
        this.addKeyListener(new KeyInput(handler));
        
        new Ventana (ancho, alto,"Heroe Zombie",this);
        
    
        r = new Random();
        
        
        handler.addObject(new Jugador(ancho/2-32,alto/2-32,ID.Jugador));
        handler.addObject(new Jugador(ancho/2+64,alto/2-32,ID.Jugador2));
        
        
        
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
                                System.out.println("FPS: "+ frames);
                                frames = 0;
                            }
        }
                stop();
    
    }
    
    private void tick(){
        handler.tick();
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
      
      g.dispose();
      bs.show();
    }
    
    
 
    public static void main(String[] args) {
        // TODO code application logic here
        new Juego();
        
    }
    
}
