/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heroezombie;

import java.util.Random;

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
        if(scoreKeep >= 500){
            scoreKeep =0;
            hud.setLevel(hud.getLevel()+1 );
            
            
            switch(level){
                case 1: handler.addObject(new EnemigoBasico(r.nextInt(Juego.ancho)-100, r.nextInt(Juego.alto)-100,ID.EnemigoBasico,handler));
                        break;
                case 4: handler.addObject(new EnemigoRapido(r.nextInt(Juego.ancho)-100, r.nextInt(Juego.alto)-100,ID.EnemigoRapido,handler));
                        break;
                
            
            }
            
            /*if(hud.getScore()% 2 ==0){
                    handler.addObject(new SmartEnemy(r.nextInt(Juego.ancho)-100,r.nextInt(Juego.alto)-100,ID.SmartEnemy,handler));
                
                
                if(hud.getLevel() == 5){
                    
                }
            }*/   
                
             
        }
        
    }
    
    
}
