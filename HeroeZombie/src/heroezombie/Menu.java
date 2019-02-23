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
	private Music music;
	private HUD hud;
	
	
	public Menu(Juego juego , Handler handler, HUD hud) {
		this.juego = juego;
		this.handler = handler;
		this.hud = hud;
		r = new Random();
		music = new Music();
		
		
	}
	
	public void mousePressed(MouseEvent e) {
		
		int mx = e.getX();
		int my = e.getY();
		

		
			if(juego.gameState == STATE.Menu) {
				//play button
				if(mouseOver(mx,my,255, 215, 100, 50)) {
				 juego.gameState = STATE.Game;
				 handler.addObject(new EnemigoBasico(Juego.ancho-50,Juego.alto-50,ID.EnemigoBasico,handler));
				 handler.addObject(new Jugador(Juego.ancho/2-32,Juego.alto/2-32,ID.Jugador,handler));
	        	 
				}
				
			
				//quit button
				if(mouseOver(mx,my,255, 355, 100, 50)) {
				System.exit(1);
				}
				
				//ayuda button
				if(mouseOver(mx,my,255, 285, 100, 50)) {
					juego.gameState = STATE.Help;
				}
			}
			
			if(juego.gameState == STATE.Help) {
				//volver button
				if(mouseOver(mx,my,255, 255, 100, 50)) {
					juego.gameState = STATE.Menu;
				}
			}
			
			if(juego.gameState == STATE.End) {
				//volver button
				if(mouseOver(mx,my,255, 255, 100, 50)) {
					juego.gameState = STATE.Game;
					hud.setLevel(1);
		        	hud.setScore(0);
					handler.addObject(new Jugador(Juego.ancho/2-32,Juego.alto/2-32,ID.Jugador,handler));		        	
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
		if(juego.gameState == STATE.Menu) {
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
			
		}else if(juego.gameState == STATE.Help) {
			Font font = new Font("consolas",1,40);
			Font font2 = new Font("consolas",1,25);
			g.setFont(font);
			g.setColor(Color.WHITE);
			g.drawString("Ayuda", 255, 60);
			g.setFont(font2);
			g.setColor(Color.white);
			g.drawString("Esquiva a los enemigos\n", 164, 140);
			g.drawString("moviendote con WASD!",164,170);
			
			g.drawRect(255, 255, 100, 50);
			g.drawString("Volver", 264, 290);
			
			
		}else if(juego.gameState == STATE.End) {
			Font font = new Font("consolas",1,40);
			Font font2 = new Font("consolas",1,25);
			g.setFont(font);
			g.setColor(Color.WHITE);
			g.drawString("Game Over!", 200, 60);
			
			g.setFont(font2);
			g.setColor(Color.white);
			g.drawString("Tu puntacion fue de : " + hud.getScore(),128,170);		
			
			g.drawRect(255, 255, 100, 50);
			g.drawString("Volver", 264, 290);
			
		}
		
	}
	
	public void tick() {
		
		
	}
}


