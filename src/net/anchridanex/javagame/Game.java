package net.anchridanex.javagame;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 1024;
	public static final int HEIGHT = WIDTH / 12 * 9;
	private Thread thread;
	private boolean running = false;
	private Handler h;
	
	public Game() {
		h = new Handler();
		this.addKeyListener(new KeyInput(h));
		
		new Window(WIDTH, HEIGHT, "This is a test in Java!", this);
		Random r = new Random();
		
		h.addObject(new Player(100, 100, ObjectType.Player));
		h.addObject(new Player(200, 200, ObjectType.Player2));
		
		for(int i = 1; i <= 125; i++) {
			BadGuy p = new BadGuy(r.nextInt(WIDTH), r.nextInt(HEIGHT), ObjectType.Baddie);
			p.setVelX(r.nextInt(4) + 1);
			p.setVelY(r.nextInt(4) + 1);
			
			h.addObject(p);
			
		}
	}
	
	public static void main(String args[]) {
		new Game();
	}
	
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop() {
		try
		{
			thread.join();
			running = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			
			while(delta >= 1) {
				tick();
				delta--;
			}
			
			if(running)
				render();
			
			frames++; 
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		
		stop();
	}
	
	private void tick() {
		h.tick();
	}
	
	private void render() {
		BufferStrategy bufStrat = this.getBufferStrategy();
		if(bufStrat == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bufStrat.getDrawGraphics();
		g.setColor(Color.white);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		
		h.render(g);
		
		g.dispose();
		bufStrat.show();
	}
}
