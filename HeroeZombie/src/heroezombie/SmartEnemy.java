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
public class SmartEnemy extends GameObject{

    private Handler handler;
    private GameObject player; 
    
    public SmartEnemy(float x, float y, ID id,Handler handler) {
        super(x, y, id);
        this.handler = handler;
        for (int i = 0; i < handler.object.size(); i++) {
            if (handler.object.get(i).getId() == ID.Jugador) {
                player = handler.object.get(i);
            }
        }
        
    }

    public void tick() {
        
        x += velX;
        y += velY;
        
        if(x < player.getX())
            velX = (float) 0.5;
        if(x > player.getX())
            velX = (float) -0.5;
        if(y < player.getY())
            velY = (float) 0.5;
        if(y > player.getY())
            velY = (float) -0.5;
        
       handler.addObject(new Trial(x,y,ID.SmartEnemy,handler,Color.red,16,8,0.04f));
        
        

    }

    
    public void render(Graphics g) {
        g.setColor(Color.green);
        g.fillRect((int)x,(int)y, 16, 16);
    }

    
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,16,16);
    }
    
}