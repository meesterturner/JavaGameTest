package net.anchridanex.javagame;

import java.awt.Color;
import java.awt.Graphics;

public class Player extends GameObject {

	public Player(int x, int y, ObjectType type) {
		super(x, y, type);
		// TODO Auto-generated constructor stub
	}

	public void tick() {
		// TODO Auto-generated method stub
		x += velX;
		y += velY;
		
		if(x > Game.WIDTH - 32 || x < 0) {
			velX = -velX;
			x += velX * 2;
		}
		
		if(y > Game.HEIGHT - 32 || y < 0) {
			velY = -velY;
			y += velY * 2;
		}
			
	}

	public void render(Graphics g) {
		// TODO Auto-generated method stub
		if(type == ObjectType.Player)
			g.setColor(Color.red);
		
		else
			g.setColor(Color.green);
		
		
		g.fillRect(x,  y, 32, 32);
	}

}
