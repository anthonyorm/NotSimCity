package notsimcity;

import processing.core.PApplet;
import processing.core.PConstants; 

public class Game {
	
		  // Setting up variables for later use
		  static int currentScreen = 0;
		  static int balance = 20000;
		  static int population = 0;
		  static int powerUsg = 0;
		  static int waterUsg = 0;
		  static String region = "";
		  static String cityName = "";
		  static boolean mode;
		  static boolean guiNormal = true;
		  static boolean info = false;
		  static Map gameMap;
		  static PApplet app;
		  
		  Game(PApplet app) {
			  Game.app = app;
			  gameMap = new Map(app);
		  }
		  
		  /*
		   * This method gets the city name & region type from the Main class and sets them in this class
		   */
		  public void setVars (String name, String gen, boolean wmode) {
			  cityName = name;
			  region = gen;
			  mode = wmode;
		  }
		  
		  /*
		   * Draws the normal GUI
		   */
		  public static void drawNormalGui () {
			  // Services
			  app.fill(200);
			  if (app.mouseY > 50 && app.mouseY < 100 && app.mouseX > 1075 && app.mouseX < 1125) {
				  app.fill(100);
			  }
			  app.rect(1075, 50, 50, 50);
			  app.fill(255, 10, 25);
			  app.textSize(30);
			  app.textAlign(PConstants.CENTER);
			  app.text("!", 1101, 86);
			  app.fill(0);
			  app.textSize(15);
			  app.textAlign(PConstants.CENTER);
			  app.text("Services", 1101, 115);
			  
			  // Utilities
			  app.fill(200);
			  if (app.mouseY >150 && app.mouseY < 200 && app.mouseX > 1075 && app.mouseX < 1125) {
				  app.fill(100);
			  }
			  app.rect(1075, 150, 50, 50);
			  app.fill(255, 10, 25);
			  app.textSize(30);
			  app.textAlign(PConstants.CENTER);
			  app.text("?", 1101, 186);
			  app.fill(0);
			  app.textSize(15);
			  app.textAlign(PConstants.CENTER);
			  app.text("Utilities", 1101, 215);
			  
			  // Transportation
			  app.fill(200);
			  if (app.mouseY >250 && app.mouseY < 300 && app.mouseX > 1075 && app.mouseX < 1125) {
				  app.fill(100);
			  }
			  app.rect(1075, 250, 50, 50);
			  app.fill(255, 10, 25);
			  app.textSize(30);
			  app.textAlign(PConstants.CENTER);
			  app.text("T", 1100, 286);
			  app.fill(0);
			  app.textSize(12);
			  app.textAlign(PConstants.CENTER);
			  app.text("Transportation", 1101, 315);
			  
			  // Zoning
			  app.fill(200);
			  if (app.mouseY > 350 && app.mouseY < 400 && app.mouseX > 1075 && app.mouseX < 1125) {
				  app.fill(100);
			  }
			  app.rect(1075, 350, 50, 50);
			  app.fill(255, 10, 25);
			  app.textSize(30);
			  app.textAlign(PConstants.CENTER);
			  app.text("Z", 1100, 386);
			  app.fill(0);
			  app.textSize(15);
			  app.textAlign(PConstants.CENTER);
			  app.text("Zoning", 1101, 415);
			  
			  // Leisure
			  app.fill(200);
			  if (app.mouseY > 450 && app.mouseY < 500 && app.mouseX > 1075 && app.mouseX < 1125) {
				  app.fill(100);
			  }
			  app.rect(1075, 450, 50, 50);
			  app.fill(255, 10, 25);
			  app.textSize(30);
			  app.textAlign(PConstants.CENTER);
			  app.text("L", 1100, 486);
			  app.fill(0);
			  app.textSize(15);
			  app.textAlign(PConstants.CENTER);
			  app.text("Leisure", 1101, 515);
		  }
		  
		  /*
		   * Draws the Services GUI
		   */
		  public static void drawServicesGui () {
			// Back
			  app.fill(200);
			  if (app.mouseY > 50 && app.mouseY < 100 && app.mouseX > 1075 && app.mouseX < 1125) {
				  app.fill(100);
			  }
			  app.rect(1075, 50, 50, 50);
			  app.fill(255, 10, 25);
			  app.textSize(30);
			  app.textAlign(PConstants.CENTER);
			  app.text("<-", 1101, 86);
			  app.fill(0);
			  app.textSize(15);
			  app.textAlign(PConstants.CENTER);
			  app.text("Back", 1101, 115);
			  
			  // Police Station
			  app.fill(200);
			  if (app.mouseY >150 && app.mouseY < 200 && app.mouseX > 1075 && app.mouseX < 1125) {
				  app.fill(100);
			  }
			  app.rect(1075, 150, 50, 50);
			  app.fill(255, 10, 25);
			  app.textSize(30);
			  app.textAlign(PConstants.CENTER);
			  app.text("PS", 1101, 186);
			  app.fill(0);
			  app.textSize(12);
			  app.textAlign(PConstants.CENTER);
			  app.text("Police Station", 1101, 215);
			  
			  // Fire Station
			  app.fill(200);
			  if (app.mouseY >250 && app.mouseY < 300 && app.mouseX > 1075 && app.mouseX < 1125) {
				  app.fill(100);
			  }
			  app.rect(1075, 250, 50, 50);
			  app.fill(255, 10, 25);
			  app.textSize(30);
			  app.textAlign(PConstants.CENTER);
			  app.text("FS", 1100, 286);
			  app.fill(0);
			  app.textSize(12);
			  app.textAlign(PConstants.CENTER);
			  app.text("Fire Station", 1101, 315);
			  
			  // Clinic
			  app.fill(200);
			  if (app.mouseY > 350 && app.mouseY < 400 && app.mouseX > 1075 && app.mouseX < 1125) {
				  app.fill(100);
			  }
			  app.rect(1075, 350, 50, 50);
			  app.fill(255, 10, 25);
			  app.textSize(30);
			  app.textAlign(PConstants.CENTER);
			  app.text("C", 1100, 386);
			  app.fill(0);
			  app.textSize(15);
			  app.textAlign(PConstants.CENTER);
			  app.text("Clinic", 1101, 415);
		  }
		  
		  /*
		   * Draws the Utility GUI
		   */
		  public static void drawUtilitiesGui () {
			  // Back
			  app.fill(200);
			  if (app.mouseY > 50 && app.mouseY < 100 && app.mouseX > 1075 && app.mouseX < 1125) {
				  app.fill(100);
			  }
			  app.rect(1075, 50, 50, 50);
			  app.fill(255, 10, 25);
			  app.textSize(30);
			  app.textAlign(PConstants.CENTER);
			  app.text("<-", 1101, 86);
			  app.fill(0);
			  app.textSize(15);
			  app.textAlign(PConstants.CENTER);
			  app.text("Back", 1101, 115);
			  
			  // Power Plant
			  app.fill(200);
			  if (app.mouseY >150 && app.mouseY < 200 && app.mouseX > 1075 && app.mouseX < 1125) {
				  app.fill(100);
			  }
			  app.rect(1075, 150, 50, 50);
			  app.fill(255, 10, 25);
			  app.textSize(30);
			  app.textAlign(PConstants.CENTER);
			  app.text("PP", 1101, 186);
			  app.fill(0);
			  app.textSize(15);
			  app.textAlign(PConstants.CENTER);
			  app.text("Power Plant", 1101, 215);
			  
			  // Water Tower
			  app.fill(200);
			  if (app.mouseY >250 && app.mouseY < 300 && app.mouseX > 1075 && app.mouseX < 1125) {
				  app.fill(100);
			  }
			  app.rect(1075, 250, 50, 50);
			  app.fill(255, 10, 25);
			  app.textSize(30);
			  app.textAlign(PConstants.CENTER);
			  app.text("WT", 1100, 286);
			  app.fill(0);
			  app.textSize(15);
			  app.textAlign(PConstants.CENTER);
			  app.text("Water Tower", 1101, 315);
			  
			  // Garbage Dump
			  app.fill(200);
			  if (app.mouseY > 350 && app.mouseY < 400 && app.mouseX > 1075 && app.mouseX < 1125) {
				  app.fill(100);
			  }
			  app.rect(1075, 350, 50, 50);
			  app.fill(255, 10, 25);
			  app.textSize(30);
			  app.textAlign(PConstants.CENTER);
			  app.text("GD", 1100, 386);
			  app.fill(0);
			  app.textSize(12);
			  app.textAlign(PConstants.CENTER);
			  app.text("Garbage Dump", 1101, 415);
		  }
		  
		  /*
		   * Draws the Transportation GUI
		   */
		  private static void drawTransportationGui() {
			// Back
			  app.fill(200);
			  if (app.mouseY > 50 && app.mouseY < 100 && app.mouseX > 1075 && app.mouseX < 1125) {
				  app.fill(100);
			  }
			  app.rect(1075, 50, 50, 50);
			  app.fill(255, 10, 25);
			  app.textSize(30);
			  app.textAlign(PConstants.CENTER);
			  app.text("<-", 1101, 86);
			  app.fill(0);
			  app.textSize(15);
			  app.textAlign(PConstants.CENTER);
			  app.text("Back", 1101, 115);
			  
			  // Road
			  app.fill(200);
			  if (app.mouseY >150 && app.mouseY < 200 && app.mouseX > 1075 && app.mouseX < 1125) {
				  app.fill(100);
			  }
			  app.rect(1075, 150, 50, 50);
			  app.fill(255, 10, 25);
			  app.textSize(30);
			  app.textAlign(PConstants.CENTER);
			  app.text("R", 1101, 186);
			  app.fill(0);
			  app.textSize(15);
			  app.textAlign(PConstants.CENTER);
			  app.text("Road", 1101, 215);
			}
		  
		  /*
		   * Draws the Zoning GUI
		   */
		  private static void drawZoningGui() {
			// Back
			  app.fill(200);
			  if (app.mouseY > 50 && app.mouseY < 100 && app.mouseX > 1075 && app.mouseX < 1125) {
				  app.fill(100);
			  }
			  app.rect(1075, 50, 50, 50);
			  app.fill(255, 10, 25);
			  app.textSize(30);
			  app.textAlign(PConstants.CENTER);
			  app.text("<-", 1101, 86);
			  app.fill(0);
			  app.textSize(15);
			  app.textAlign(PConstants.CENTER);
			  app.text("Back", 1101, 115);
			  
			  // Residential
			  app.fill(200);
			  if (app.mouseY >150 && app.mouseY < 200 && app.mouseX > 1075 && app.mouseX < 1125) {
				  app.fill(100);
			  }
			  app.rect(1075, 150, 50, 50);
			  app.fill(255, 10, 25);
			  app.textSize(30);
			  app.textAlign(PConstants.CENTER);
			  app.text("R", 1101, 186);
			  app.fill(0);
			  app.textSize(12);
			  app.textAlign(PConstants.CENTER);
			  app.text("Residential", 1101, 215);
			  
			  // Commercial
			  app.fill(200);
			  if (app.mouseY >250 && app.mouseY < 300 && app.mouseX > 1075 && app.mouseX < 1125) {
				  app.fill(100);
			  }
			  app.rect(1075, 250, 50, 50);
			  app.fill(255, 10, 25);
			  app.textSize(30);
			  app.textAlign(PConstants.CENTER);
			  app.text("C", 1100, 286);
			  app.fill(0);
			  app.textSize(12);
			  app.textAlign(PConstants.CENTER);
			  app.text("Commercial", 1101, 315);
			  
			  // Industrial
			  app.fill(200);
			  if (app.mouseY > 350 && app.mouseY < 400 && app.mouseX > 1075 && app.mouseX < 1125) {
				  app.fill(100);
			  }
			  app.rect(1075, 350, 50, 50);
			  app.fill(255, 10, 25);
			  app.textSize(30);
			  app.textAlign(PConstants.CENTER);
			  app.text("I", 1100, 386);
			  app.fill(0);
			  app.textSize(15);
			  app.textAlign(PConstants.CENTER);
			  app.text("Industrial", 1101, 415);
			}
		  
		  /*
		   * Draws the Leisure GUI
		   */
		  private static void drawLeisureGui() {
			// Back
			  app.fill(200);
			  if (app.mouseY > 50 && app.mouseY < 100 && app.mouseX > 1075 && app.mouseX < 1125) {
				  app.fill(100);
			  }
			  app.rect(1075, 50, 50, 50);
			  app.fill(255, 10, 25);
			  app.textSize(30);
			  app.textAlign(PConstants.CENTER);
			  app.text("<-", 1101, 86);
			  app.fill(0);
			  app.textSize(15);
			  app.textAlign(PConstants.CENTER);
			  app.text("Back", 1101, 115);
			  
			  // Park
			  app.fill(200);
			  if (app.mouseY >150 && app.mouseY < 200 && app.mouseX > 1075 && app.mouseX < 1125) {
				  app.fill(100);
			  }
			  app.rect(1075, 150, 50, 50);
			  app.fill(255, 10, 25);
			  app.textSize(30);
			  app.textAlign(PConstants.CENTER);
			  app.text("P", 1101, 186);
			  app.fill(0);
			  app.textSize(15);
			  app.textAlign(PConstants.CENTER);
			  app.text("Park", 1101, 215);
			  
			  // Playground
			  app.fill(200);
			  if (app.mouseY >250 && app.mouseY < 300 && app.mouseX > 1075 && app.mouseX < 1125) {
				  app.fill(100);
			  }
			  app.rect(1075, 250, 50, 50);
			  app.fill(255, 10, 25);
			  app.textSize(30);
			  app.textAlign(PConstants.CENTER);
			  app.text("P", 1100, 286);
			  app.fill(0);
			  app.textSize(12);
			  app.textAlign(PConstants.CENTER);
			  app.text("Playground", 1101, 315);
			  
			  // Pool
			  app.fill(200);
			  if (app.mouseY > 350 && app.mouseY < 400 && app.mouseX > 1075 && app.mouseX < 1125) {
				  app.fill(100);
			  }
			  app.rect(1075, 350, 50, 50);
			  app.fill(255, 10, 25);
			  app.textSize(30);
			  app.textAlign(PConstants.CENTER);
			  app.text("P", 1100, 386);
			  app.fill(0);
			  app.textSize(15);
			  app.textAlign(PConstants.CENTER);
			  app.text("Pool", 1101, 415);
			}
		  
		  /*
		   * Draws the zoning demand meter
		   */
		  public static void drawBulldoze () {
			  app.fill(200);
			  if (app.mouseY > 550 && app.mouseY < 600 && app.mouseX > 1075 && app.mouseX < 1125) {
				  app.fill(100);
			  }
			  app.rect(1075, 550, 50, 50);
			  app.fill(255, 10, 25);
			  app.textSize(30);
			  app.textAlign(PConstants.CENTER);
			  app.text("B", 1101, 585);
			  app.fill(0);
			  app.textSize(15);
			  app.textAlign(PConstants.CENTER);
			  app.text("Bulldoze", 1101, 615);
		  }
		  
		  public static void drawInfo() {
			  app.push();
				app.push();
				app.background(255, 153, 102);
				app.fill(200);
				app.strokeWeight(4);
				app.rect(50, 50, 999, 549);
				app.pop();
				app.pop();
		  }
		  
		  public static void draw() {
			if (info == false) {
				gameMap.drawMap();
			} else {
			    drawInfo();
			}
		    app.push();
		    app.fill(0);
		    if (Main.sandbox == true) {
		    	app.text("Balance: $ unlimited", 50, 629);
		    } else {
		    	app.text("Balance: $"+balance, 50, 629);
		    }
		    app.text("Population: "+population+" Citizens", 275, 629);
		    if (powerUsg < 0) {
		    	app.fill(255, 0, 0);
		    }
		    app.text("Power Available: "+powerUsg+"", 500, 629);
		    app.fill(0);
		    if (waterUsg < 0) {
		    	app.fill(255, 0, 0);
		    }
		    app.text("Water Available: "+waterUsg+"", 725, 629);
		    app.fill(0);
		    app.textSize(25);
		    app.textAlign(PConstants.CENTER);
		    app.text("City of "+cityName, 576, 31);
		    drawBulldoze();
		    if (currentScreen == 0) {
		    	drawNormalGui();
			} else if (currentScreen == 1) {
				drawServicesGui();
			} else if (currentScreen == 2) {
				drawUtilitiesGui();
			} else if (currentScreen == 3) {
				drawTransportationGui();
			} else if (currentScreen == 4) {
				drawZoningGui();
			} else if (currentScreen == 5) {
				drawLeisureGui();
			} 
		    	app.pop();
		  	if (app.mouseY > 8 && app.mouseY < 40 && app.mouseX > 456 && app.mouseX < 696) { // Info
				info = true;
				} else {
				info = false;
				}
			  }
			}
