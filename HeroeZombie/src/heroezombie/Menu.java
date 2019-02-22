package heroezombie;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import heroezombie.Juego.STATE;

public class Menu extends MouseAdapter {
	
	private Juego juego;
	private Handler handler;
	private Random r;
	private boolean stop=true;
	
	
	public Menu(Juego juego , Handler handler) {
		this.juego = juego;
		this.handler = handler;
		r = new Random();
	}
	
	public void mousePressed(MouseEvent e) {
		
		int mx = e.getX();
		int my = e.getY();
		

		
		if(stop) {
			//play button
			if(mouseOver(mx,my,255, 215, 100, 50)) {
			 juego.gameState = STATE.Game;
			 handler.addObject(new Jugador(Juego.ancho/2-32,Juego.alto/2-32,ID.Jugador,handler));
        	 handler.addObject(new EnemigoBasico(r.nextInt(Juego.ancho)-100, r.nextInt(Juego.alto)-100,ID.EnemigoBasico,handler));
        	 Music.play("C:/Users/gustavo/Desktop/gitProjects/zombiekiller/zombiekiller/data/audio/TeknoAXE.wav");
        	 stop=false;
			}
		
			//quit button
			if(mouseOver(mx,my,255, 355, 100, 50)) {
			System.exit(1);
			}
		}
		
		
		
	}
	
	public void mouseReleased(MouseEvent e) {
		
	}
	
	private boolean mouseOver(int mx, int my,int x, int y,int ancho,int alto) {
		if(mx > x && mx < x + ancho) {
			if(my > y && my < y + alto) {
				return true;
			}else return false;
		}else return false;
		
	}
	
	public void render(Graphics g) {
		Font font = new Font("consolas",1,50);
		Font font2 = new Font("consolas",1,30);
		g.setFont(font);
		g.setColor(Color.WHITE);
		g.drawString("ZombieHero!", 164, 90);
		
		g.setFont(font2);
		g.drawString("Jugar", 264, 250);
		
		g.setFont(font2);
		g.drawString("Ayuda", 264, 320);
		
		g.setFont(font2);
		g.drawString("Salir", 264, 390);
		
		g.setColor(Color.WHITE);
		g.drawRect(255, 215, 100, 50);
		
		g.setColor(Color.WHITE);
		g.drawRect(255, 285, 100, 50);
		
		g.setColor(Color.WHITE);
		g.drawRect(255, 355, 100, 50);
		
	}
	
	public void tick() {
	}
}
