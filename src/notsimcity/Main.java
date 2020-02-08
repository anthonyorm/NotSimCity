package notsimcity;

import java.io.PrintWriter;
import java.util.Random;

import processing.core.PApplet;

public class Main extends PApplet {

	public static void main(String[] args) {
		PApplet.main("notsimcity.Main");
	}
	
	// TODO Get rid of (or comment out) println and other diagnostic things so console isnt cluttered

	// Creating variables for later use in game
	int currentScreen = 0;
	int width = 1152;
	int height = 648;
	static Random random = new Random();
	int[] buttonX = { 476, 476, 10, width-90 }, buttonY = { 175, 250, height-50 , 325}, buttonW = { 200, 200, 80 }, buttonH = { 50, 50, 40 };
	Object button1, button2;
	String[] region = { "Saskatchewan", "Alberta", "British Columbia", "Yukon" };
	String[] name1 = { "Shelby", "Spring", "Cow", "Happy", "Steam", "Flower", "Frank", "Calgary" };
	String[] name2 = { "ville", "field", " Town", " City", " Village", " Hat", " Island", "" };
	String[] sortedLines = null;
	String choice = "";
	int regNum = 0;
	public String gen = "";
	public String name = "";
	static boolean sandbox;
	boolean sortedYet = false;
	Game game;

	public void setup() {
		frameRate(30);
		surface.setTitle("NotSimCity"); // Window Title
	}

	/*
	 * Generates a name from 2 arrays, merges into 1 name
	 * Returns the resulting name
	 */
	public String genName() {
		int rand1 = random.nextInt(8);
		int rand2 = random.nextInt(8);
		name = name1[rand1] + name2[rand2];
		return name;
	}

	/*
	 * Generates a region from an array, sets to gen variable
	 */
	public void genRegion() {
		if (regNum < 3) {
			regNum++;
			gen = region[regNum];
		} else {
			regNum = 0;
			gen = region[regNum];
		}
	}

	/*
	 * Draws the city customization screen
	 */
	public void drawCityCust() {
		push();
		background(255, 132, 80);
		fill(0);
		textSize(26);
		textAlign(CENTER);
		text("City Creation", width/2, 100);

		// buttons
		fill(200);
		// Top Button
		if (mouseY > 175 && mouseY < 225 && mouseX > 476 && mouseX < 676) {
			fill(100);
		}
		rect(buttonX[0], buttonY[0], buttonW[0], buttonH[0]);
		// Bottom Button
		fill(200);
		if (mouseY > 250 && mouseY < 300 && mouseX > 476 && mouseX < 676) {
			fill(100);
		}
		rect(buttonX[1], buttonY[1], buttonW[1], buttonH[1]);
		fill(0);
		textSize(14);
		text(name, width/2, 206);
		text(gen, width/2, 283);

		// back button
		textSize(20);
		fill(200);
		if (mouseY > height-48 && mouseY < height-5 && mouseX > 10 && mouseX < 90) {
			fill(100);
		}
		textSize(20);
		rect(buttonX[2], buttonY[2], buttonW[2], buttonH[2]);
		fill(0);
		text("Back", 50, height-22);

		// start button
		textSize(20);
		fill(200);
		if (mouseY > height-48 && mouseY < height-5 && mouseX > width-90 && mouseX < width-10) {
			fill(100);
		}
		rect(buttonX[3], buttonY[2], buttonW[2], buttonH[2]);
		fill(0);
		text("Start", width - 50, height-22);
		pop();
	}

	/*
	 * Draws the gamemode selection screen
	 */
	public void drawGameSelect() {
		push();
		background(255, 132, 80);
		fill(0);
		textSize(26);
		textAlign(CENTER);
		text("Game Modes", width/2, 100);
		fill(200);
		if (mouseY > 175 && mouseY < 225 && mouseX > 476 && mouseX < 676) {
			fill(100);
		}
		rect(buttonX[0], buttonY[0], buttonW[0], buttonH[0]);
		fill(200);
		if (mouseY > 250 && mouseY < 300 && mouseX > 476 && mouseX < 676) {
			fill(100);
		}
		rect(buttonX[1], buttonY[1], buttonW[1], buttonH[1]);
		fill(0);
		text("Normal", width/2, 209);
		text("Sandbox", width/2, 283);
		textSize(20);
		fill(200);
		if (mouseY > height-48 && mouseY < height-5 && mouseX > 10 && mouseX < 90) {
			fill(100);
		}
		textSize(20);
		rect(buttonX[2], buttonY[2], buttonW[2], buttonH[2]);
		fill(0);
		text("Back", 50, height-22);
		pop();
	}

	/*
	 * Draws the instructions/about screen
	 */
	public void drawAbout() {
		push();
		textAlign(CENTER);
		textSize(16);
		background(255, 132, 80);
		fill(0);
		text("NotSimCity is based on the hit \ncity-builder game SimCity \nreleased by Maxis in 1989. \n\nYou can eliminate block rows by\nconnecting blocks horizontally.\n\nTo move blocks left and right, \nuse the left/right arrow keys.\n\nTo flip blocks, use space bar or up key.",
				width/2, 50);
		fill(200);
		if (mouseY > height-48 && mouseY < height-5 && mouseX > 10 && mouseX < 90) {
			fill(100);
		}
		textSize(20);
		rect(buttonX[2], buttonY[2], buttonW[2], buttonH[2]);
		fill(0);
		text("Back", 50, height-22);
		pop();
	}

	/*
	 * Draws the high score screen
	 */
	public void drawHighScores() {
		if (sortedYet == false) {
			sortScore();
		}
		
		push();
		background(255, 132, 80);
		textAlign(CENTER);
		textSize(26);
		fill(0);
		text("High Scores", width/2, 100);
		textSize(16);
		//text("NotSimCity is based on the hit \ncity-builder game SimCity \nreleased by Maxis in 1989. \n\nYou can eliminate block rows by\nconnecting blocks horizontally.\n\nTo move blocks left and right, \nuse the left/right arrow keys.\n\nTo flip blocks, use space bar or up key.",
		//		width/2, 50);
		text(sortedLines[0], width/2, 150);
		text(sortedLines[1], width/2, 170);
		text(sortedLines[2], width/2, 190);
		text(sortedLines[3], width/2, 210);
		text(sortedLines[4], width/2, 230);
		text(sortedLines[5], width/2, 250);
		fill(200);
		if (mouseY > height-48 && mouseY < height-5 && mouseX > 10 && mouseX < 90) {
			fill(100);
		}
		textSize(20);
		rect(buttonX[2], buttonY[2], buttonW[2], buttonH[2]);
		fill(0);
		text("Back", 50, height-22);
		pop();
	}
	
	/*
	 * Draws the menu screen
	 */
	public void drawMenu() {
		push();
		background(255, 132, 80);
		fill(0);
		textSize(42);
		textAlign(CENTER);
		text("NotSimCity", width/2, 100);
		textSize(26);
		fill(200);
		if (mouseY > 175 && mouseY < 225 && mouseX > 476 && mouseX < 676) { // About
			fill(100);
		}
		rect(buttonX[0], buttonY[0], buttonW[0], buttonH[0]);
		fill(200);
		if (mouseY > 250 && mouseY < 300 && mouseX > 476 && mouseX < 676) { // Play
			fill(100);
		}
		rect(buttonX[1], buttonY[1], buttonW[1], buttonH[1]);
		fill(200);
		if (mouseY > 325 && mouseY < 375 && mouseX > 476 && mouseX < 676) { // High Scores
			fill(100);
		}
		rect(buttonX[1], buttonY[3], buttonW[1], buttonH[1]);
		fill(0);
		text("About", width/2, 208);
		text("Play", width/2, 282);
		text("High Scores", width/2, 358);
		textSize(13);
		text("2020 Anthony Ormerod", 90, height-18);
		pop();
	}

	/*
	 * Sorts scores from high to low - from high score .txt file
	 */
	public void sortScore () {
		String[] lines = loadStrings("HighScores.txt"); // Loading high scores
	    String tempStr;
	    boolean sorted = false;
	    	while (sorted == false) {
	    		sorted = true;
	            for (int j = 0; j < (lines.length-1); j++) {

	            	int val = 0;
	            	int val2 = 0;
	            	
	            	// 3 digit
	            	if (lines[j].charAt(2) != ' ') {
	            		System.out.println(lines[j].charAt(0));
	            	 String valTmp = "" + lines[j].charAt(0) + lines[j].charAt(1) + lines[j].charAt(2);
	            	 String valTmp2 = null;
	            	 if (lines[j+1].charAt(2) != ' ') { // 3 digit
	            		 valTmp2 = "" + lines[j+1].charAt(0) + lines[j+1].charAt(1) + lines[j+1].charAt(2);
	            	 } else if (lines[j+1].charAt(1) != ' ') { // 2 digit
	            		 valTmp2 = "" + lines[j+1].charAt(0) + lines[j+1].charAt(1);
	            	 } else if (lines[j+1].charAt(0) != ' ') { // 1 digit
	            		 valTmp2 = "" + lines[j+1].charAt(0);
	            	 }
	            	 
	            	 val = Integer.parseInt(valTmp);
	            	 val2 = Integer.parseInt(valTmp2);
	            	
	            	// 2 digit
	            	} else if (lines[j].charAt(1) != ' ') {
	            		System.out.println(lines[j].charAt(0));
	            		String valTmp = "" + lines[j].charAt(0) + lines[j].charAt(1);
	            		String valTmp2 = null;
		            	 if (lines[j+1].charAt(2) != ' ') { // 3 digit
		            		 valTmp2 = "" + lines[j+1].charAt(0) + lines[j+1].charAt(1) + lines[j+1].charAt(2);
		            	 } else if (lines[j+1].charAt(1) != ' ') { // 2 digit
		            		 valTmp2 = "" + lines[j+1].charAt(0) + lines[j+1].charAt(1);
		            	 } else if (lines[j+1].charAt(0) != ' ') { // 1 digit
		            		 valTmp2 = "" + lines[j+1].charAt(0);
		            	 }
		            	 
		            	 val = Integer.parseInt(valTmp);
		            	 val2 = Integer.parseInt(valTmp2);
	            	
		            // 1 digit
	            	} else if (lines[j].charAt(0) != ' ') {
	            		System.out.println(lines[j].charAt(0));
	            		String valTmp = "" + lines[j].charAt(0);
	            		String valTmp2 = null;
		            	 if (lines[j+1].charAt(2) != ' ') { // 3 digit
		            		 valTmp2 = "" + lines[j+1].charAt(0) + lines[j+1].charAt(1) + lines[j+1].charAt(2);
		            	 } else if (lines[j+1].charAt(1) != ' ') { // 2 digit
		            		 valTmp2 = "" + lines[j+1].charAt(0) + lines[j+1].charAt(1);
		            	 } else if (lines[j+1].charAt(0) != ' ') { // 1 digit
		            		 valTmp2 = "" + lines[j+1].charAt(0);
		            	 }
		            	 
		            	 val = Integer.parseInt(valTmp);
		            	 val2 = Integer.parseInt(valTmp2);

	            }
	            	// Comparing Values
	            	if (val2 > val) {
	                	
	                	tempStr = lines[j+1];
	                	lines[j+1] = lines[j];
	                	lines[j] = tempStr;
	                	sorted = false;
	                	
	                } 
	            }
	    	}
	            sortedLines = lines;
	            sortedYet = true;
	}
	
	public void mousePressed() {
		if (currentScreen == 1) { // Game Mode Selection
			// Moves to customization screen - normal
			if (mouseY > 175 && mouseY < 225 && mouseX > 476 && mouseX < 676) {
				currentScreen = 3;
				genRegion();
				genName();
				sandbox = false;
				System.out.println(currentScreen);
				System.out.println(sandbox);
			}
			// Moves to customization screen - sandbox
			if (mouseY > 250 && mouseY < 300 && mouseX > 476 && mouseX < 676) {
				currentScreen = 3;
				genRegion();
				genName();
				sandbox = true;
				System.out.println(currentScreen);
				System.out.println(sandbox);
			}
		}
		// TODO Fix this problem where it generates a region or name already as it changes to currentScreen 3
		if (currentScreen == 3) { // City Customization Screen
			// Region changer button
			if (mouseY > 250 && mouseY < 300 && mouseX > 476 && mouseX < 676) {
				genRegion();
			}
			// Name changer button
			else if (mouseY > 175 && mouseY < 225 && mouseX > 476 && mouseX < 676) {
				genName();
			}
		}
		if (currentScreen == 0) { // Main Menu
			if (mouseY > 175 && mouseY < 225 && mouseX > 476 && mouseX < 676) { // About button
				currentScreen = 2;
				System.out.println(currentScreen);
			}
			if (mouseY > 250 && mouseY < 300 && mouseX > 476 && mouseX < 676) { // Play button
				currentScreen = 1;
				System.out.println(currentScreen);
			}	
			if (mouseY > 325 && mouseY < 375 && mouseX > 476 && mouseX < 676) { // High Score button
				currentScreen = 5; 
				System.out.println(currentScreen);
			}
			
		} else if (currentScreen == 5 || currentScreen == 2 || currentScreen == 1) {
			// back button
			if (mouseY > height-48 && mouseY < height-5 && mouseX > 10 && mouseX < 90) {
				currentScreen = 0;
				System.out.println(currentScreen);
			}
		} else if (currentScreen == 3) {
			// cityCust back button
			if (mouseY > height-48 && mouseY < height-5 && mouseX > 10 && mouseX < 90) {
				currentScreen = 1;
				System.out.println(currentScreen);
			}
			// cityCust start button
			if (mouseY > height-48 && mouseY < height-5 && mouseX > width-90 && mouseX < width-10) {
				// launches & initializes the actual game window
				//PApplet.main("notsimcity.Game");
				// passing variables to Game.java
				game = new Game(this);
				game.setVars(name, gen, sandbox);
				currentScreen = 4;
			}
		} else if (currentScreen == 4) {
			// Gui Buttons
			
			if (mouseY > 550 && mouseY < 600 && mouseX > 1075 && mouseX < 1125) { // Bulldoze
				choice = "bulldoze";
			  }
			
			if (Game.currentScreen == 0) { // Normal
				if (mouseY > 50 && mouseY < 100 && mouseX > 1075 && mouseX < 1125) { // Services
					Game.currentScreen = 1;
				} else if (mouseY > 150 && mouseY < 200 && mouseX > 1075 && mouseX < 1125) { // Utilities
					Game.currentScreen = 2;
				} else if (mouseY > 250 && mouseY < 300 && mouseX > 1075 && mouseX < 1125) { // Transportation
					Game.currentScreen = 3;
				} else if (mouseY > 350 && mouseY < 400 && mouseX > 1075 && mouseX < 1125) { // Zoning
					Game.currentScreen = 4;
				} else if (mouseY > 450 && mouseY < 500 && mouseX > 1075 && mouseX < 1125) { // Leisure
					Game.currentScreen = 5;
				} 
			} else if (Game.currentScreen == 1) { // Services
				if (mouseY > 50 && mouseY < 100 && mouseX > 1075 && mouseX < 1125) { // Back
					Game.currentScreen = 0;
					choice = "";
				} else if (mouseY > 150 && mouseY < 200 && mouseX > 1075 && mouseX < 1125) { // Police Station
					choice = "police";
				} else if (mouseY > 250 && mouseY < 300 && mouseX > 1075 && mouseX < 1125) { // Fire Station
					choice = "fire";
				} else if (mouseY > 350 && mouseY < 400 && mouseX > 1075 && mouseX < 1125) { // Clinic
					choice = "clinic";
				}  
			} else if (Game.currentScreen == 2) { // Utilities
				if (mouseY > 50 && mouseY < 100 && mouseX > 1075 && mouseX < 1125) { // Back
					Game.currentScreen = 0;
					choice = "";
				} else if (mouseY > 150 && mouseY < 200 && mouseX > 1075 && mouseX < 1125) { // Power Plant
					choice = "power";
				} else if (mouseY > 250 && mouseY < 300 && mouseX > 1075 && mouseX < 1125) { // Water Tower
					choice = "water";
				} else if (mouseY > 350 && mouseY < 400 && mouseX > 1075 && mouseX < 1125) { // Garbage Dump
					choice = "garbage";
				} 
			} else if (Game.currentScreen == 3) { // Transportation
				if (mouseY > 50 && mouseY < 100 && mouseX > 1075 && mouseX < 1125) { // Back
					Game.currentScreen = 0;
					choice = "";
				} else if (mouseY > 150 && mouseY < 200 && mouseX > 1075 && mouseX < 1125) { // Road
					choice = "road";
				}
		} else if (Game.currentScreen == 4) { // Zoning
			if (mouseY > 50 && mouseY < 100 && mouseX > 1075 && mouseX < 1125) { // Back
				Game.currentScreen = 0;
				choice = "";
			} else if (mouseY > 150 && mouseY < 200 && mouseX > 1075 && mouseX < 1125) { // Residential
				choice = "residential";
			} else if (mouseY > 250 && mouseY < 300 && mouseX > 1075 && mouseX < 1125) { // Commercial
				choice = "commercial";
			} else if (mouseY > 350 && mouseY < 400 && mouseX > 1075 && mouseX < 1125) { // Industrial
				choice = "industrial";
			} 
		} else if (Game.currentScreen == 5) { // Leisure
			if (mouseY > 50 && mouseY < 100 && mouseX > 1075 && mouseX < 1125) { // Back
				Game.currentScreen = 0;
				choice = "";
			} else if (mouseY > 150 && mouseY < 200 && mouseX > 1075 && mouseX < 1125) { // Park
				choice = "park";
			} else if (mouseY > 250 && mouseY < 300 && mouseX > 1075 && mouseX < 1125) { // Playground
				choice = "playground";
			} else if (mouseY > 350 && mouseY < 400 && mouseX > 1075 && mouseX < 1125) { // Pool
				choice = "pool";
			} 
		}
			// If tile is pressed 
			for (int j = 0; j < 11; j++) { // Y
				for (int i = 0; i < 20; i++) { // X
					if (mouseY > Map.tiles[i][j].yLoc && mouseY < (Map.tiles[i][j].yLoc+50) && mouseX > Map.tiles[i][j].xLoc && mouseX < (Map.tiles[i][j].xLoc+50)) {
						System.out.println(i); // tester - delete later
						System.out.println(j); // tester - delete later
						Map.tiles[i][j].mousePressed(choice);
						System.out.println(choice); // tester - delete later
					}
				}
			}
		}
	}

	public void settings() {
		size(width, height);
		// 1152x648 resolution, 16:9 screen ratio 
	    //good balance between 1920x1080 (most desktops) and 1366x768 (most laptops)
	}

	/*
	 * Runs upon program exit; Writes Population & city name to file
	 */
	public void exit () {
		// Save High Score
		if (currentScreen == 4) {
			String[] lines = loadStrings("HighScores.txt");
			PrintWriter outputStream = createWriter("HighScores.txt");
			for (int i = 0; i < lines.length; i++) {
			    outputStream.println(lines[i]); 
			  }
			 
			outputStream.println(Game.population + "  citizens on " + Game.cityName);
			outputStream.flush();
			outputStream.close();
		super.exit();
		}
	}
	
	public void draw() {
		// checks what the currentScreen is, and sets the screen accordingly
		if (currentScreen == 0) {
			drawMenu();
		} else if (currentScreen == 1) {
			drawGameSelect();
		} else if (currentScreen == 2) {
			drawAbout();
		} else if (currentScreen == 3) {
			drawCityCust();
		} else if (currentScreen == 4) {
			surface.setTitle(name+" - NotSimCity");
			Game.draw();
		} else if (currentScreen == 5) {
			drawHighScores();
		}
	}
}
