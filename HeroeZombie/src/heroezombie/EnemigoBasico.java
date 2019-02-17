/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heroezombie;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author gustavo
 */
public class EnemigoBasico extends GameObject{

    private Handler handler;
    
    public EnemigoBasico(int x, int y, ID id,Handler handler) {
        super(x, y, id);
        this.handler = handler;
        velX=5;
        velY=5;
        
    }

    public void tick() {
        
        x += velX;
        y += velY;
        
        if (y <=0 || y > Juego.alto-32) velY *= -1;
        if (x <=0 || x > Juego.ancho-16) velX *= -1;
        
        handler.addObject(new Trial(x,y,ID.EnemigoBasico,handler,Color.red,16,16,0.04f));
        
        

    }

    
    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect((int)x,(int)y, 16, 16);
    }

    
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,16,16);
    }
    
}
