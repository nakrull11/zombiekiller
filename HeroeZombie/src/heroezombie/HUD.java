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
    
    public static float vida = 100;
    
    private float greenValue = 0;
    
    private int score = 0;
    
    private int level = 1;
    
    public void tick(){
        vida= Juego.clamp(vida, 0, 100);
        greenValue =Juego.clamp(greenValue, 0, 255);
        greenValue= vida*2;
        score++;
    }
    
    public void danio(int cantidad){
        vida -= cantidad;
    }
    
    public void render(Graphics g){
        g.setColor(Color.red);
        g.fillRect(15, 15,200 , 16);
        g.setColor(new Color (75,(int)greenValue, 0));
        g.fillRect(15, 15, (int) (vida*2), 16);
        g.setColor(Color.white);
        g.drawRect(15, 15,200 , 16);
        g.drawString("Puntuacion: " + score, 15 , 64);
        g.drawString("Nivel: " + level, 15, 80);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
        
}
