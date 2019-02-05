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
        
        x = Juego.clamp(x, 0, Juego.ancho-37);
         y = Juego.clamp(y, 0, Juego.alto-60);
       
    }

    
    public void render(Graphics g) {
        g.setColor(Color.blue);
        g.fillRect(x, y, 32, 32);
        
    }
    
    
    
    
}
