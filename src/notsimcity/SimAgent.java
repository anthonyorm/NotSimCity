package notsimcity;

//import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import processing.core.PApplet;

public class SimAgent {

	PApplet app;
	static Random random = new Random();
	//static ArrayList<Integer> pop = new ArrayList<>();
	
	/*
	 * Constructor
	 */
	SimAgent(PApplet app, int pop) {
		this.app = app;
	}
	
	/*
	 * Manages population like adding and removing population in an inconsistent/random way
	 */
	static void calcPop (int x, int y) {
		Game.population = Game.population + Map.tiles[x][y].pop;
		}
		
//		if (pop.isEmpty()) {
//			if (Game.population != 0) {
//				int rand = random.nextInt(1500);
//				Game.population--;
//				try {
//				    Thread.sleep(rand);
//				} 
//				catch(InterruptedException ex) {
//				    Thread.currentThread().interrupt();
//				}
//			}
//		} else {
//			for (int i = 0; i < pop.size(); i++) {
//				int rand = random.nextInt(1500);
//				int rand1 = random.nextInt(10);
//				Game.population = Game.population + rand1;
//				try {
//				    Thread.sleep(rand);
//				} 
//				catch(InterruptedException ex) {
//				    Thread.currentThread().interrupt();
//				}
//			}
//			}
	
	// MONEY
	
	}
	
