/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heroezombie;

import java.awt.Color;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import heroezombie.Juego.STATE;

/**
 *
 * @author gustavo
 */
public class Spawner {
    
    private Handler handler;
    private HUD hud;
    private int scoreKeep = 0;
    private Random r= new Random();
    private int level;
    
    public Spawner(Handler handler, HUD hud){
        this.handler = handler;
        this.hud = hud;
        
    }
    
    public void tick(){
        level = hud.getLevel();
        scoreKeep++;
        if(scoreKeep >= 200){
            scoreKeep =0;
            hud.setLevel(hud.getLevel()+1 );
            
            
            switch(level){//cada (nivel -1) va spawnear un enemigo dependiendo del case
            	case 1: handler.addObject(new SmartEnemy(Juego.ancho/2-32,Juego.alto/2-32,ID.SmartEnemy,handler));                        
        			break;           	
                case 3: handler.addObject(new SmartEnemy(Juego.ancho/2-64,Juego.alto/2-32,ID.SmartEnemy,handler));
        			break;
                case 4: handler.addObject(new SmartEnemy(Juego.ancho/2-80,Juego.alto/2-32,ID.SmartEnemy,handler));
        			break;
                case 5: handler.addObject(new SmartEnemy(Juego.ancho/2-128,Juego.alto/2-32,ID.SmartEnemy,handler));
        			break;
                case 8: handler.addObject(new SmartEnemy(Juego.ancho/2-164,Juego.alto/2-32,ID.SmartEnemy,handler));
        			break;
                case 9: handler.addObject(new SmartEnemy(Juego.ancho/2-228,Juego.alto/2-32,ID.SmartEnemy,handler));
        			break;
                case 10:handler.addObject(new SmartEnemy(Juego.ancho/2-264,Juego.alto/2-32,ID.SmartEnemy,handler));
                	break;
            }
            
            if (hud.getLevel() == 15) {
                handler.limpiarEnemigos();
                handler.addObject(new Boss((Juego.ancho / 2)-48,-120,ID.Boss,handler,Color.red));
               
            }   
                
             
        }
    }
    
    
    
}
