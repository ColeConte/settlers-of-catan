/**
 * CSCI 205 - Software Design and Engineering
 * Name(s): Seline Tan-Torres
 *
 * Work: Final Project
 * Created: Nov 18, 2014, 12:48:24 PM
 */
package model;

/**
 * @author satt001
 *
 */
public enum Card {
	SHEEP("image of sheep"), WHEAT("image of wheat"), BRICK("image of brick"), WOOD(
			"image of wood"), ORE("image of ore"), KNIGHT("image of knight"), VP(
			"image of vp"), ROADBUILDING("image of road");

	private final String img;

	Card(String img) {
		this.img = img;
	}

}
