/**
 * CSCI 205 - Software Design and Engineering
 * Name(s): Seline Tan-Torres
 *
 * Work: Final Project
 * Created: Nov 18, 2014, 12:31:01 PM
 */
package model;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author satt001
 *
 */
public class Player {
	private String myColor;
	private Board theBoard;
	private ArrayList<Card> myHand;
	private ArrayList<Card> DevCards;
	private int settlements = 0;
	private int cities = 0;
	private int longestRoad = 0;
	private int VPcount = 0;

	public Player(Board theBoard, String myColor) {
		this.theBoard = theBoard;
		this.myColor = myColor;
	}

	public int rollDie() {
		Random rand = new Random();
		int firstRoll = rand.nextInt(7) + 1;
		int secondRoll = rand.nextInt(7) + 1;
		return firstRoll + secondRoll;

	}

	public void buildCity() {

	}

	public void buildSettlement() {

	}

	public void buildRoad() {

	}

	public void addResource(Card resource) {
		this.myHand.add(resource);

	}

	public void addDevCard(Card dev) {
		this.DevCards.add(dev);
		if (dev.equals(Card.VP)) {
			VPcount += 1;
		}
	}

	public void removeResource(Card resource) {
		this.myHand.remove(resource);
	}

	public void removeDevcard(Card dev) {
		this.DevCards.remove(dev);
	}

	public boolean hasWon() {
		if (VPcount == 10) {
			return true;
		} else
			return false;
	}

	public void moveRobber() {

	}

	/**
	 * @return the myColor
	 */
	public String getMyColor() {
		return myColor;
	}

	/**
	 * @return the theBoard
	 */
	public Board getTheBoard() {
		return theBoard;
	}

	/**
	 * @return the myHand
	 */
	public ArrayList<Card> getMyHand() {
		return myHand;
	}

	/**
	 * @return the devCards
	 */
	public ArrayList<Card> getDevCards() {
		return DevCards;
	}

	/**
	 * @return the settlements
	 */
	public int getSettlements() {
		return settlements;
	}

	/**
	 * @return the cities
	 */
	public int getCities() {
		return cities;
	}

	/**
	 * @return the roads
	 */
	public int getLongestRoad() {
		return longestRoad;
	}

	/**
	 * @return the vPcount
	 */
	public int getVPcount() {
		return VPcount;
	}

}
