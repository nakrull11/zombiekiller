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
    
    public Spawner(Handler handler, HUD hud){
        this.handler = handler;
        this.hud = hud;
    }
    
    public void tick(){
        scoreKeep++;
        if(scoreKeep >= 500){
            scoreKeep =0;
            hud.setLevel(hud.getLevel()+1 );
            
            if(hud.getScore()% 2 ==0){
                handler.addObject(new EnemigoBasico(r.nextInt(Juego.ancho),r.nextInt(Juego.alto),ID.EnemigoBasico,handler));
                
                if(hud.getLevel() %5 ==0){
                    handler.addObject(new EnemigoRapido(r.nextInt(Juego.ancho),r.nextInt(Juego.alto),ID.EnemigoRapido,handler));
                }
            }   
                
             
        }
        
    }
    
    
}
