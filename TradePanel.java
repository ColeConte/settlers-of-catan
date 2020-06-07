/**
 * CSCI 205 - Software Design and Engineering
 * Name(s): Seline Tan-Torres
 *
 * Work: Final Project
 * Created: Nov 19, 2014, 3:01:07 PM
 */
package theView;

import javax.swing.JOptionPane;

import model.Card;

/**
 * @author satt001
 *
 */
public class TradePanel {

	public TradePanel() {
		Object[] options = { String.valueOf(Card.BRICK),
				String.valueOf(Card.WOOD), String.valueOf(Card.ORE),
				String.valueOf(Card.SHEEP), String.valueOf(Card.WHEAT) };

		String s = (String) JOptionPane.showInputDialog(null,
				"Choose Resource", "Choose resource you wish to receive",
				JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
	}

}
