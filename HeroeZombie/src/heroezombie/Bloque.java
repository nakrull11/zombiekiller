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
public class Bloque extends GameObject {
    
    public Bloque(float x, float y, ID id) {
        super(x, y, id);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,32,32);
    }

    @Override
    public void tick() {
        
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.gray);
        g.fillRect((int)x,(int)y, 32, 32);
    }
    
}
