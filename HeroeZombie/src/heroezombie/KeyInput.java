/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heroezombie;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author gustavo
 */
public class KeyInput extends KeyAdapter {
    
    private Handler handler;
    
    public KeyInput(Handler handler){
        this.handler = handler;
    }
    
    
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);
            if(tempObject.getId() == ID.Jugador){
              //EVENTOS DE TECLA JUGADOR 1
              
                if (key == KeyEvent.VK_W) tempObject.setVelY(-4);
                if (key == KeyEvent.VK_S) tempObject.setVelY(4);
                if (key == KeyEvent.VK_D) tempObject.setVelX(4);
                if (key == KeyEvent.VK_A) tempObject.setVelX(-4);
            }
            
            
        }
        
        if (key == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }
        
    }
    
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);
            if(tempObject.getId() == ID.Jugador){
              //EVENTOS DE TECLA JUGADOR 1
              
                if (key == KeyEvent.VK_W) tempObject.setVelY(0);
                if (key == KeyEvent.VK_S) tempObject.setVelY(0);
                if (key == KeyEvent.VK_D) tempObject.setVelX(0);
                if (key == KeyEvent.VK_A) tempObject.setVelX(0);
            }
            
            
        }
    }
    
}
