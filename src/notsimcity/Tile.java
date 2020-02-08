package notsimcity;

import java.util.Random;
import javax.swing.Timer;

import processing.core.PApplet;
import java.util.concurrent.TimeUnit;

public class Tile {
	
	// TODO make tiles see each other so they cant override
	
	static PApplet app;
	static Random random = new Random();
	int xLoc, yLoc;
	int pwrUsage = 0;
	int wtrUsage = 0;
	int pwrGive = 0;
	int wtrGive = 0;
	int cost = 0;
	static int pop = 0;
	int[] tileSet = {0, 255, 0};
	String selec = "starting";
	boolean tileModded = false;
	boolean temp = true;
	boolean tempBull = true;
	
	/*
	 * Constructor
	 */
	Tile(PApplet app, int x, int y) {
		this.app = app;
		this.xLoc = x;
		this.yLoc = y;
	}
	
	/*
	 * Sets the tile stats like pwrGive, pwrUsage, etc.
	 */
	public void checkTileStats () {
		
		// Resets bulldoze tool
		if (selec != "bulldoze") {
			tempBull = true;
		}
		
		// Usage
		if (selec == "starting") {
			tileModded = false;
		} 
		
		if (selec == "bulldoze") {
			tileModded = false;
			
			if (tempBull == true) { // Undoes altered values
				Game.powerUsg = Game.powerUsg - pwrGive;
				Game.waterUsg = Game.waterUsg - wtrGive;
				Game.powerUsg = Game.powerUsg + pwrUsage;
				Game.waterUsg = Game.waterUsg + wtrUsage;
				Game.population = Game.population - pop;
				pwrGive = 0;
				wtrGive = 0;
				pwrUsage = 0;
				wtrUsage = 0;
				pop = 0;
				temp = true;
				tempBull = false;
			}
		}

		if (selec == "police") {
			if (temp == true) {
				pwrUsage = 25;
				wtrUsage = 20;
				cost = 1000;
				Game.balance = Game.balance - cost;
				Game.powerUsg = Game.powerUsg - pwrUsage;
				Game.waterUsg = Game.waterUsg - wtrUsage;
				temp = false;
			}
			tileModded = true;
		} else if (selec == "fire") {
			if (temp == true) {
				pwrUsage = 25;
				wtrUsage = 20;
				cost = 1000;
				Game.balance = Game.balance - cost;
				Game.powerUsg = Game.powerUsg - pwrUsage;
				Game.waterUsg = Game.waterUsg - wtrUsage;
				temp = false;
			}
			tileModded = true;
		} else if (selec == "clinic") {
			if (temp == true) {
				pwrUsage = 25;
				wtrUsage = 20;
				cost = 1000;
				Game.balance = Game.balance - cost;
				Game.powerUsg = Game.powerUsg - pwrUsage;
				Game.waterUsg = Game.waterUsg - wtrUsage;
				temp = false;
			}
			tileModded = true;
		}

		if (selec == "power") {
			pwrGive = 300;
			if (temp == true) {
				Game.powerUsg = Game.powerUsg + pwrGive;
				temp = false;
			}
			if (temp == true) {
				pwrUsage = 0;
				wtrUsage = 20;
				cost = 1200;
				Game.balance = Game.balance - cost;
				Game.powerUsg = Game.powerUsg - pwrUsage;
				Game.waterUsg = Game.waterUsg - wtrUsage;
				temp = false;
			}
			tileModded = true;
		} else if (selec == "water") {
			wtrGive = 300;
			if (temp == true) {
				Game.waterUsg = Game.waterUsg + wtrGive;
			}
			if (temp == true) {
				pwrUsage = 20;
				wtrUsage = 0;
				cost = 1200;
				Game.balance = Game.balance - cost;
				Game.powerUsg = Game.powerUsg - pwrUsage;
				Game.waterUsg = Game.waterUsg - wtrUsage;
				temp = false;
				tileModded = true;
			}
		} else if (selec == "garbage") {
			if (temp == true) {
				pwrUsage = 35;
				wtrUsage = 15;
				cost = 750;
				Game.balance = Game.balance - cost;
				Game.powerUsg = Game.powerUsg - pwrUsage;
				Game.waterUsg = Game.waterUsg - wtrUsage;
				temp = false;
			}
			tileModded = true;
		}

		if (selec == "road") {
			pwrUsage = 0;
			wtrUsage = 0;
			cost = 50;
			if (temp == true) {
			Game.balance = Game.balance - cost;
			temp = false;
			}
			tileModded = true;
		}

		if (selec == "residential") {
			if (temp == true) {
				pwrUsage = 10;
				wtrUsage = 10;
				cost = 25;
				Game.balance = Game.balance - cost;
				Game.powerUsg = Game.powerUsg - pwrUsage;
				Game.waterUsg = Game.waterUsg - wtrUsage;
				int rand = random.nextInt(15);
				pop = rand;
				//Game.population = Game.population + pop;
				addPop(); //TODO do this later after main game is complete
				temp = false;
			}
			tileModded = true;
		} else if (selec == "commercial") {
			if (temp == true) {
				pwrUsage = 10;
				wtrUsage = 10;
				cost = 25;
				Game.balance = Game.balance - cost;
				Game.powerUsg = Game.powerUsg - pwrUsage;
				Game.waterUsg = Game.waterUsg - wtrUsage;
				temp = false;
			}
			tileModded = true;
		} else if (selec == "industrial") {
			if (temp == true) {
				pwrUsage = 20;
				wtrUsage = 15;
				cost = 25;
				Game.balance = Game.balance - cost;
				Game.powerUsg = Game.powerUsg - pwrUsage;
				Game.waterUsg = Game.waterUsg - wtrUsage;
				temp = false;
			}
			tileModded = true;
		}

		if (selec == "park") {
			if (temp == true) {
				pwrUsage = 5;
				wtrUsage = 1;
				cost = 350;
				Game.balance = Game.balance - cost;
				Game.powerUsg = Game.powerUsg - pwrUsage;
				Game.waterUsg = Game.waterUsg - wtrUsage;
				temp = false;
			}
			tileModded = true;
		} else if (selec == "playground") {
			if (temp == true) {
				pwrUsage = 5;
				wtrUsage = 1;
				cost = 250;
				Game.balance = Game.balance - cost;
				Game.powerUsg = Game.powerUsg - pwrUsage;
				Game.waterUsg = Game.waterUsg - wtrUsage;
				temp = false;
			}
			tileModded = true;
		} else if (selec == "pool") {
			if (temp == true) {
				pwrUsage = 10;
				wtrUsage = 20;
				cost = 300;
				Game.balance = Game.balance - cost;
				Game.powerUsg = Game.powerUsg - pwrUsage;
				Game.waterUsg = Game.waterUsg - wtrUsage;
				temp = false;
			}
			tileModded = true;
		}
	}

	/*
	 * Unused method to add tile's population to game population
	 */
	static void addPop () {
		for (int i = 0; i < pop; i++) {
			long rand = random.nextInt(400000);
			long lastTime = System.currentTimeMillis() - rand;
			long currentTime = System.currentTimeMillis();
			if ((currentTime - lastTime) >= rand) {
				Game.population++;
			  }
			}
		}
	
	public boolean checkNextTile (String check) {
		if (check == "touching") {
			return false;
		} else if (check == "empty") {
			return false;
		} else {
			return false;
		}
	}
	
	/*
	 * Sets player selection to tile state
	 */
	public void mousePressed(String selec) {
		if (selec != "") { // Makes sure you can't draw onto a tile with nothing selected
		this.selec = selec;
		}
	}
	
	public void drawTile () {
		app.noStroke();
		 	
	if (selec == "starting" || selec == "bulldoze") {
		app.fill(0, 255, 0);
		app.rect(xLoc, yLoc, 50, 50);
	} 
	
	if (selec == "police") {
		app.fill(0, 0, 255);
		app.rect(xLoc, yLoc, 50, 50);
		app.fill(255, 255, 204);
		app.rect(xLoc+5, yLoc+5, 40, 40);
		app.fill(10, 10, 15);
		app.rect(xLoc+10, yLoc+10, 5, 5);
	} else if (selec == "fire") {
		app.fill(255, 0, 0);
		app.rect(xLoc, yLoc, 50, 50);
		app.fill(255, 255, 204);
		app.rect(xLoc+5, yLoc+5, 40, 40);
		app.fill(10, 10, 15);
		app.rect(xLoc+10, yLoc+10, 5, 5);
	} else if (selec == "clinic") {
		app.fill(255, 105, 180);
		app.rect(xLoc, yLoc, 50, 50);
		app.fill(255, 255, 204);
		app.rect(xLoc+5, yLoc+5, 40, 40);
		app.fill(10, 10, 15);
		app.rect(xLoc+10, yLoc+10, 5, 5);
	}
	
	if (selec == "power") {
		
	} else if (selec == "water") {
		
	} else if (selec == "garbage") {
		
	}
	
	if (selec == "road") {
		app.fill(25, 25, 25);
		app.rect(xLoc, yLoc, 50, 50);
	}
	
	if (selec == "residential") {
		app.fill(102, 51, 0);
		app.rect(xLoc, yLoc, 50, 50);
		app.fill(128, 64, 0);
		app.rect(xLoc+5, yLoc+5, 40, 40);
		app.fill(153, 77, 0);
		app.rect(xLoc+10, yLoc+10, 30, 30);
		app.fill(179, 89, 0);
		app.rect(xLoc+15, yLoc+15, 20, 20);
	} else if (selec == "commercial") {
		
	} else if (selec == "industrial") {
		
	}
	
	if (selec == "park") {
		
	} else if (selec == "playground") {
		
	} else if (selec == "pool") {
		
	}
	if (Main.sandbox == false) { // If sandbox is false, let this function work
		checkTileStats();
	}
	}
}
