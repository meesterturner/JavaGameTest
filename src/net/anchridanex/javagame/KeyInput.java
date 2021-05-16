package net.anchridanex.javagame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{

	private Handler h;
	
	public KeyInput(Handler h) {
		this.h = h;
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		for(int i = 0; i < h.objects.size(); i++) {
			GameObject o = h.objects.get(i);
			
			switch(o.getType()) {
				case Player: 
					if(key == KeyEvent.VK_W) o.setVelY(-4);
					if(key == KeyEvent.VK_A) o.setVelX(-4);
					if(key == KeyEvent.VK_S) o.setVelY(4);
					if(key == KeyEvent.VK_D) o.setVelX(4);
					break;
					
				case Player2:
					if(key == KeyEvent.VK_UP) o.setVelY(-4);
					if(key == KeyEvent.VK_LEFT) o.setVelX(-4);
					if(key == KeyEvent.VK_DOWN) o.setVelY(4);
					if(key == KeyEvent.VK_RIGHT) o.setVelX(4);
					break;
					
				default:
					break;
			}
			
		}
	}
	
	
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		for(int i = 0; i < h.objects.size(); i++) {
			GameObject o = h.objects.get(i);
			
			switch(o.getType()) {
			case Player: 
				if(key == KeyEvent.VK_W) o.setVelY(0);
				if(key == KeyEvent.VK_A) o.setVelX(0);
				if(key == KeyEvent.VK_S) o.setVelY(0);
				if(key == KeyEvent.VK_D) o.setVelX(0);
				break;
				
			case Player2:
				if(key == KeyEvent.VK_UP) o.setVelY(0);
				if(key == KeyEvent.VK_LEFT) o.setVelX(0);
				if(key == KeyEvent.VK_DOWN) o.setVelY(0);
				if(key == KeyEvent.VK_RIGHT) o.setVelX(0);
				break;
				
			default:
				break;
			}
			
		}
	}
	
}
