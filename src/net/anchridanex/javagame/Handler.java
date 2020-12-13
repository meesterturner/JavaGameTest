package net.anchridanex.javagame;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
	LinkedList<GameObject> objects = new LinkedList<GameObject>();
	
	public void addObject(GameObject o) {
		objects.add(o);
	}
	
	public void removeObject(GameObject o) {
		objects.remove(o);
	}
	
	public void tick() {
		for(int i = 0; i < objects.size(); i++) {
			objects.get(i).tick();
		}
	}
	
	public void render(Graphics g) {
		for(int i = 0; i < objects.size(); i++) {
			objects.get(i).render(g);
		}
	}
}
