/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heroezombie;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author gustavo
 */
public class Trial extends GameObject {

    private float alpha = 1;
    private Handler handler;
    private Color color;
    private int alto;
    private int ancho;
    private float vida;

    public Trial(int x, int y, ID id,Handler handler,Color color,int ancho,int alto,float vida) {
        super(x, y, id);
        this.handler = handler;
        this.color = color;
        this.ancho = ancho;
        this.alto = alto;
        this.vida = vida;
    }
    
    

    
    public Rectangle getBounds() {
        return null;
    }

    
    public void tick() {
        if (alpha >= vida ) {
            alpha -= vida - 0.001f;
        }else handler.removeObject(this);
    }

    
    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setComposite(makeTransparent(alpha));
        
        g.setColor(color);
        g.fillRect(x, y, ancho, alto);
        
        g2d.setComposite(makeTransparent(1));

    }
    
    private AlphaComposite makeTransparent(float alpha){
        int type = AlphaComposite.SRC_OVER;
        return (AlphaComposite.getInstance(type,alpha));
        
    }
    
    
}
