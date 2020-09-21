/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heroezombie;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


import heroezombie.Juego.STATE;
import java.awt.MouseInfo;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author gustavo
 */
public class KeyInput extends KeyAdapter{
    
    private Handler handler;
    private boolean [] keyDown = new boolean[4];
    private boolean [] click = new boolean [1];
    Juego juego;
    
    public KeyInput(Handler handler,Juego juego){
        this.handler = handler;
        this.juego = juego;
        keyDown[0]=false;
        keyDown[1]=false;
        keyDown[2]=false;
        keyDown[3]=false;
        click[0] = false;
    }
    
    
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);
            if(tempObject.getId() == ID.Jugador){
              //EVENTOS DE TECLA JUGADOR 1
              
                if (key == KeyEvent.VK_W) {tempObject.setVelY(-4);keyDown[0]=true;}
                if (key == KeyEvent.VK_S) {tempObject.setVelY(4);keyDown[1]=true;}
                if (key == KeyEvent.VK_D) {tempObject.setVelX(4);keyDown[2]=true;}
                if (key == KeyEvent.VK_A) {tempObject.setVelX(-4);keyDown[3]=true;}
                //if (key == KeyEvent.VK_Q) {handler.addObject(new ProyectilJugadorArma(tempObject.getX(),tempObject.getY(),ID.ProyectilJugadorArma,handler));}
                

            }
            
            
        }
        
        if(key == KeyEvent.VK_P) {
        	if(Juego.gameState == STATE.Game) {
        		if(Juego.paused)Juego.paused = false;
            	else Juego.paused = true;
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
              
                if (key == KeyEvent.VK_W) keyDown[0]=false;//tempObject.setVelY(0);
                if (key == KeyEvent.VK_S) keyDown[1]=false;//tempObject.setVelY(0);
                if (key == KeyEvent.VK_D) keyDown[2]=false;//tempObject.setVelX(0);
                if (key == KeyEvent.VK_A) keyDown[3]=false;//tempObject.setVelX(0);
                
                if(!keyDown[0] && !keyDown[1])tempObject.setVelY(0);
                if(!keyDown[2] && !keyDown[3])tempObject.setVelX(0);
                
                
            }
            
            
        }
    }

    public void mouseClicked(MouseEvent e) {
        int key = e.getButton();
        
          for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);
            if(tempObject.getId() == ID.Jugador){
              //EVENTOS MOUSE
              
               if(key == MouseEvent.BUTTON1){handler.addObject(new ProyectilJugadorArma(e.getXOnScreen(),e.getYOnScreen(),ID.ProyectilBoss,handler)); click[0]=true;}
                       
            }
            
            
        }
        System.out.println("POS X CLICK "+e.getPoint().getLocation().getX());
        System.out.println("POS Y CLICK "+e.getPoint().getLocation().getY());
    }
}
