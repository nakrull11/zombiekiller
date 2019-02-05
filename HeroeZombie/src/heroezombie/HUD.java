/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heroezombie;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author gustavo
 */
public class HUD {
    
    public static int vida = 100;
    
    
    public void tick(){
        
        vida= Juego.clamp(vida, 0, 100);
    }
    
    public void render(Graphics g){
        g.setColor(Color.red);
        g.fillRect(15, 15,200 , 32);
        g.setColor(Color.green);
        g.fillRect(15, 15,vida*2 , 32);
         g.setColor(Color.white);
        g.drawRect(15, 15,200 , 32);
    }
    
}
