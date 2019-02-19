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
public class Jugador extends GameObject {

    private Random r;
    private Handler handler;
    
    public Jugador(float x, float y, ID id,Handler handler) {
        super(x, y, id);
        this.handler = handler;
        r = new Random();
      
    }
    
    public  Rectangle getBounds(){
        return new Rectangle((int)x,(int)y,32,32);
    }
    
    public void tick() {
        x +=velX;
        y +=velY;
        
        x = Juego.clamp(x, 0, Juego.ancho-37);
        y = Juego.clamp(y, 0, Juego.alto-60);
        //handler.addObject(new Trial(x,y,ID.Jugador,handler,Color.BLUE,32,32,0.09f));
        colision();
       
    }
    
    private void colision() {
        boolean collisionOccured;
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject obj = handler.object.get(i);
            if (obj.getId() != ID.Jugador) {
                Rectangle rec1 = getBounds();
                Rectangle rec2 = obj.getBounds();
                if (rec2 != null && rec1 != null) {
                    collisionOccured = rec1.intersects(rec2);
                    if (collisionOccured) {
                     HUD.vida -=2;   
                    }
                }
            }
        }
    }
    
    

    
    public void render(Graphics g) {
        
        g.setColor(Color.blue);
        g.fillRect((int)x,(int)y, 32, 32);
        
    }
    
    
    
    
}
