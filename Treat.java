/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.awt.Point;
import java.util.Random;

/**
 *
 * @author Simon
 */

public class Treat {
	char[] binChar = { '0', '1' };

	char[] hexChar = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E' };

	char[] octChar = { '0', '1', '2', '3', '4', '5', '6', '7' };

	static Random rand = new Random();
	char charVal;
	Point location;

	public Treat(Point p, int mode) {
		switch (mode) {
		case 0:
			this.charVal = binChar[rand.nextInt(2)];
			break;
		case 1:
			this.charVal = hexChar[rand.nextInt(16)];
			break;
		case 2:
			this.charVal = octChar[rand.nextInt(8)];
			break;
		}
		this.location = p;
	}
}
