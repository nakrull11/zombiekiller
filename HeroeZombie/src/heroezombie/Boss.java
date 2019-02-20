/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heroezombie;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;


/**
 *
 * @author gustavo
 */
public class Boss extends GameObject{

    private Handler handler;
    Random r = new Random();
    private int timer=70;
    private int timer2=50;
    
    
    public Boss(int x, int y, ID id,Handler handler) {
        super(x, y, id);
        this.handler = handler;
        velX=0;
        velY=2;
        
    }

    public void tick() {
        
        x += velX;
        y += velY;
        
        if(timer <= 0) velY=0;
        else timer--;
        
        if(timer <=0) timer2--;
        if(timer2 <=0){
            if(velX == 0) velX =2;
            int spawn = r.nextInt(10);
            
            if (velX > 0)velX+=0.005f;
            else if(velX < 0)velX -=0.005f;
            
            velX= Juego.clamp(velX, -10, 10);
            
            if(spawn == 0) handler.addObject(new ProyectilBoss(x,y,ID.ProyectilBoss,handler));
            
            
                    
        }
        
        //if (y <=0 || y > Juego.alto-32) velY *= -1;
        if (x <=0 || x > Juego.ancho-96) velX *= -1;
        
        //handler.addObject(new Trial(x,y,ID.EnemigoBasico,handler,Color.yellow,50,50,0.04f));
        
        

    }

    
    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect((int)x,(int)y, 64, 64);
        
    }

    
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,64,64);
    }
    
}
