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
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author gustavo
 */
public class Boss extends GameObject{

    private Handler handler;
    Random r = new Random();
    private  short life = 200;
    private int timer=70;
    private int timer2=50;
    
    
    public Boss(int x, int y, ID id,Handler handler) {
        super(x, y, id);
        this.handler = handler;;
        velX=0;
        velY=2;
        
    }

    public void tick() {
        if (!muerte()) {
           colision(); 
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
                if (x <=0 || x > Juego.ancho-96) velX *= -1;
            }
        }else handler.removeObject(this);;
        //if (y <=0 || y > Juego.alto-32) velY *= -1;
    }
    
    private void colision() {
        boolean collisionOccured;
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject obj = handler.object.get(i);
            if (obj.getId() == ID.Jugador) {
                Rectangle rec1 = getBounds();
                Rectangle rec2 = obj.getBounds();
                if (rec2 != null && rec1 != null) {
                    collisionOccured = rec1.intersects(rec2);
                    if (collisionOccured) {
                     life -=50;   
                    }
                }
            }
        }
    }
    
    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect((int)x,(int)y, 64, 64);
        
    }
    
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,64,64);
    }
    
    public boolean muerte(){
        if(life <=0)return true;
        else        return false;
    }
}
