/**
 * CSCI 205 - Software Design and Engineering
 * Name(s): Seline Tan-Torres
 *
 * Work: Final Project
 * Created: Nov 19, 2014, 10:47:02 AM
 */
package theView;

import javax.swing.JOptionPane;

/**
 * @author satt001
 *
 */
public class StartUpWindow {

	private String[] colors = { "Red", "Green", "Blue", "Yellow" };

	private int playersAdded = 0;

	public StartUpWindow() {
		boolean startGame = false;
		Object[] options = { "Start Game", "Add Player" };

		while (true) {

			int option = JOptionPane.showOptionDialog(null,
					"Welcome to Settlers of Catan! Choose an option: ",
					"Settlers of Catan", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE, null,

					options, options[0]);

			if (option == 0) {
				if (playersAdded >= 2) {
					break;
				} else {
					JOptionPane.showMessageDialog(null,
							"You need to add more players!");
				}
			}
			if (option == 1) {

				if (playersAdded < 4) {
					String s = (String) JOptionPane.showInputDialog(null,
							"Choose player color", "Add Player",
							JOptionPane.PLAIN_MESSAGE, null, colors, colors[0]);
					if (s != null && !s.equals(JOptionPane.CANCEL_OPTION)) {
						// Player player1 = new Player(theboard, s);
						// theboard.addPlayer(player1);
						for (int i = 0; i < 4; i++) {
							if (colors[i] != null) {
								if (colors[i].equals(s)) {
									colors[i] = null;
								}
							}
						}
					}
					playersAdded += 1;
				}

			} else if (option == JOptionPane.CLOSED_OPTION) {
				break;
			}

		}

	}

	public static void main(String[] args) {
		StartUpWindow start = new StartUpWindow();
		TradePanel trade = new TradePanel();
	}
}