/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heroezombie;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        if(scoreKeep >= 100){
            scoreKeep =0;
            hud.setLevel(hud.getLevel()+1 );
            
            
            switch(level){//cada nivel -1 va spawnear un enemigo dependiendo del case
                case 1: handler.addObject(new EnemigoBasico(r.nextInt(Juego.ancho)-100, r.nextInt(Juego.alto)-100,ID.EnemigoBasico,handler));
                        break;
                case 2: handler.addObject(new EnemigoBasico(r.nextInt(Juego.ancho)-100, r.nextInt(Juego.alto)-100,ID.EnemigoBasico,handler));
                        break;
                case 4: handler.addObject(new EnemigoRapido(r.nextInt(Juego.ancho)-100, r.nextInt(Juego.alto)-100,ID.EnemigoRapido,handler));
                        break;
                case 6: handler.addObject(new EnemigoRapido(r.nextInt(Juego.ancho)-100, r.nextInt(Juego.alto)-100,ID.EnemigoRapido,handler));
                        break;
                case 7: handler.addObject(new EnemigoBasico(r.nextInt(Juego.ancho)-100, r.nextInt(Juego.alto)-100,ID.EnemigoBasico,handler));
                        break;
            }
            
            if (hud.getLevel() == 10) {
                handler.limpiarEnemigos();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Spawner.class.getName()).log(Level.SEVERE, null, ex);
                }
                handler.addObject(new Boss((Juego.ancho / 2)-48,-120,ID.Boss,handler));
                
            }   
                
             
        }
        
    }
    
    
}
