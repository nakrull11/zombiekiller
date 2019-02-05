/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heroezombie;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author gustavo
 */
public class Ventana extends Canvas{
    
    public Ventana (int ancho, int altura, String titulo, Juego juego){
        JFrame jframe = new JFrame(titulo);
        
        jframe.setPreferredSize(new Dimension(ancho,altura));
        jframe.setMaximumSize(new Dimension(ancho,altura));
        jframe.setMinimumSize(new Dimension(ancho,altura));
        
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setResizable(false);
        jframe.setLocationRelativeTo(null);
        jframe.add(juego);
        jframe.setVisible(true);
        juego.start();
        
        
    
    
    }
}
