package notsimcity;

import processing.core.PApplet; 

public class Map {
	
	PApplet app;
	
	// array of tiles
	static Tile[][] tiles = new Tile[20][11];
	
	/*
	 * Constructor
	 */
	Map(PApplet app) {
		this.app = app;
		
		// populating the array of tiles
		int temp1 = 0;
		int temp2 = 0;
		for (int j = 0; j < 11; j++) { // Y
			temp1 = (temp1 + 50);
			temp2 = 0;
			for (int i = 0; i < 20; i++) { // X
				temp2 = (temp2 + 50);
				tiles[i][j] = new Tile(app, temp2, temp1);
			}
		}
	}
	
	/*
	 * Draws an array of map tiles onto the actual map
	 */
	public void drawMapTiles () {
		for (int j = 0; j < 11; j++) { // Y
			for (int i = 0; i < 20; i++) { // X
				tiles[i][j].drawTile();
			}
		}
	}
	
	public void drawMap () {
		app.push();
		app.push();
		app.background(255, 153, 102);
		app.fill(0);
		app.strokeWeight(4);
		app.rect(50, 50, 999, 549);
		app.pop();
		drawMapTiles();
		app.pop();
	}
}
