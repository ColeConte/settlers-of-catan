/**
 * CSCI 205 - Software Design and Engineering
 * Name(s): Seline Tan-Torres
 *
 * Work: Final Project
 * Created: Nov 19, 2014, 1:01:55 AM
 */
package theView;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * @author satt001
 *
 */
public class OptionsPanel extends JPanel {
	private JButton rollBtn = new JButton("Roll Dice");
	private JButton tradeBtn = new JButton("Trade");
	private JButton endTurnBtn = new JButton("End Turn");

	public OptionsPanel() {
		this.setLayout(new GridLayout(4, 1, 5, 5));
		JLabel optionsLbl = new JLabel("Options");
		optionsLbl.setHorizontalAlignment(SwingConstants.CENTER);
		optionsLbl.setFont(new Font("Serif", Font.PLAIN, 30));
		this.add(optionsLbl);
		this.add(rollBtn);
		this.add(tradeBtn);
		this.add(endTurnBtn);
	}

	/**
	 * @return the rollBtn
	 */
	public JButton getRollBtn() {
		return rollBtn;
	}

	/**
	 * @param rollBtn
	 *            the rollBtn to set
	 */
	public void setRollBtn(JButton rollBtn) {
		this.rollBtn = rollBtn;
	}

	/**
	 * @return the tradeBtn
	 */
	public JButton getTradeBtn() {
		return tradeBtn;
	}

	/**
	 * @param tradeBtn
	 *            the tradeBtn to set
	 */
	public void setTradeBtn(JButton tradeBtn) {
		this.tradeBtn = tradeBtn;
	}

	/**
	 * @return the endTurnBtn
	 */
	public JButton getEndTurnBtn() {
		return endTurnBtn;
	}

	/**
	 * @param endTurnBtn
	 *            the endTurnBtn to set
	 */
	public void setEndTurnBtn(JButton endTurnBtn) {
		this.endTurnBtn = endTurnBtn;
	}

}
