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
public class ProyectilBoss extends GameObject{

    private Handler handler;
    private Random r;
    
    public ProyectilBoss(float x, float y, ID id,Handler handler) {
        super(x, y, id);
        r = new Random();
        this.handler = handler;
        
        velX=(r.nextInt(7 - -7) + -7);
        velY=7;
        
    }

    public void tick() {
        
        x += velX;
        y += velY;
        
        //if (y <=0 || y > Juego.alto-32) velY *= -1;
        //if (x <=0 || x > Juego.ancho-16) velX *= -1;
        
        if(y >= Juego.alto) handler.removeObject(this);
        
        handler.addObject(new Trial(x,y,ID.ProyectilBoss,handler,Color.yellow,4,4,0.04f));
        
        
        
        

    }

    
    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect((int)x,(int)y, 8, 8);
    }

    
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,8,8);
    }
    
}