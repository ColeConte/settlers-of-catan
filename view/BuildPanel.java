/**
 * CSCI 205 - Software Design and Engineering
 * Name(s): Seline Tan-Torres
 *
 * Work: Final Project
 * Created: Nov 19, 2014, 12:46:45 AM
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
public class BuildPanel extends JPanel {
	private JButton roadBtn = new JButton("Build Road");
	private JButton cityBtn = new JButton("Build City");
	private JButton settleBtn = new JButton("Build Settlement");
	private JButton devBtn = new JButton("Buy Development Card");

	public BuildPanel() {
		this.setLayout(new GridLayout(5, 1, 5, 5));
		JLabel buildLbl = new JLabel("Build");
		buildLbl.setHorizontalAlignment(SwingConstants.CENTER);
		buildLbl.setFont(new Font("Serif", Font.PLAIN, 30));
		this.add(buildLbl);
		this.add(roadBtn);
		this.add(cityBtn);
		this.add(settleBtn);
		this.add(devBtn);

	}

	/**
	 * @return the roadBtn
	 */
	public JButton getRoadBtn() {
		return roadBtn;
	}

	/**
	 * @param roadBtn
	 *            the roadBtn to set
	 */
	public void setRoadBtn(JButton roadBtn) {
		this.roadBtn = roadBtn;
	}

	/**
	 * @return the cityBtn
	 */
	public JButton getCityBtn() {
		return cityBtn;
	}

	/**
	 * @param cityBtn
	 *            the cityBtn to set
	 */
	public void setCityBtn(JButton cityBtn) {
		this.cityBtn = cityBtn;
	}

	/**
	 * @return the settleBtn
	 */
	public JButton getSettleBtn() {
		return settleBtn;
	}

	/**
	 * @param settleBtn
	 *            the settleBtn to set
	 */
	public void setSettleBtn(JButton settleBtn) {
		this.settleBtn = settleBtn;
	}

	/**
	 * @return the devBtn
	 */
	public JButton getDevBtn() {
		return devBtn;
	}

	/**
	 * @param devBtn
	 *            the devBtn to set
	 */
	public void setDevBtn(JButton devBtn) {
		this.devBtn = devBtn;
	}

}
