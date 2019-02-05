/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heroezombie;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 *
 * @author gustavo
 */
public class Jugador extends GameObject {

    private Random r;
    
    public Jugador(int x, int y, ID id) {
        super(x, y, id);
        r = new Random();
      
    }

    
    public void tick() {
        x +=velX;
        y +=velY;
    }

    
    public void render(Graphics g) {
        if(id == ID.Jugador)g.setColor(Color.blue);
        else if(id == ID.Jugador2)g.setColor(Color.red);
        g.fillRect(x, y, 32, 32);
        
    }
    
    
    
    
}
