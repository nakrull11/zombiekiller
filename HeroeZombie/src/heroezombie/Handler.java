/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heroezombie;

import static heroezombie.Juego.alto;
import static heroezombie.Juego.ancho;
import java.awt.Graphics;
import java.util.LinkedList;

/**
 *
 * @author gustavo
 */
public class Handler {
    
    LinkedList<GameObject> object = new LinkedList<GameObject>();
    
    public void tick(){
        for (int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);
            tempObject.tick();
            
            
        }
    }
    
    public void render(Graphics g){
        for (int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);
            
            tempObject.render(g);
        }
    }
    
    public void addObject(GameObject object){
        this.object.add(object);
        
        
    }
    
    public void removeObject(GameObject object){
        this.object.remove(object);
    }
    
    public void limpiarEnemigos(){
        for (int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);
            
            if (tempObject.getId() == ID.Jugador) {
                
                object.clear();
                
                addObject(new Jugador(ancho/2-32,alto/2-32,ID.Jugador,this));
                //el jugador va a aparecer en la posicion en la que estaba
                //addObject(new Jugador((int)tempObject.getX(),(int)tempObject.getY(),ID.Jugador,this));
                
            }
        }
    }
    
}
