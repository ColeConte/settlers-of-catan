/**
 * CSCI 205 - Software Design and Engineering
 * Name(s): Seline Tan-Torres
 *
 * Work: Final Project
 * Created: Nov 18, 2014, 9:34:07 PM
 */
package theView;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * @author satt001
 *
 */
public class HandPanel extends JPanel {

	private JButton brick = new JButton();
	private JButton wood = new JButton();
	private JButton ore = new JButton();
	private JButton sheep = new JButton();
	private JButton wheat = new JButton();
	private JLabel wheatCount = new JLabel();
	private JLabel brickCount = new JLabel();
	private JLabel sheepCount = new JLabel();
	private JLabel oreCount = new JLabel();
	private JLabel woodCount = new JLabel();
	private JLabel vpCount = new JLabel();

	public HandPanel() throws IOException {

		this.setLayout(new GridLayout(2, 2, 5, 5));
		this.setPreferredSize(new Dimension(5, 5));
		JLabel resources = new JLabel();
		resources.setLayout(new GridLayout(1, 4, 5, 5));
		brick.setIcon(new ImageIcon(
				"/home/accounts/student/s/satt001/csci205/Final Project/src/theView/brick.png"));
		wood.setIcon(new ImageIcon(
				"/home/accounts/student/s/satt001/csci205/Final Project/src/theView/wood.png"));
		ore.setIcon(new ImageIcon(
				"/home/accounts/student/s/satt001/csci205/Final Project/src/theView/ore.png"));
		sheep.setIcon(new ImageIcon(
				"/home/accounts/student/s/satt001/csci205/Final Project/src/theView/sheep.png"));
		wheat.setIcon(new ImageIcon("/home/accounts/student/s/satt001/csci205/Final Project/src/theView/wheat.png"));

		resources.add(brick);
		resources.add(wood);
		resources.add(ore);
		resources.add(sheep);
		resources.add(wheat);

		this.add(resources);

		JLabel handCount = new JLabel();
		handCount.setLayout(new GridLayout(1, 4, 5, 5));

		brickCount.setHorizontalAlignment(SwingConstants.CENTER);
		brickCount.setText("0");
		brickCount.setFont(new Font("Serif", Font.PLAIN, 30));

		woodCount.setHorizontalAlignment(SwingConstants.CENTER);
		woodCount.setFont(new Font("Serif", Font.PLAIN, 30));
		woodCount.setText("0");

		oreCount.setHorizontalAlignment(SwingConstants.CENTER);
		oreCount.setText("0");
		oreCount.setFont(new Font("Serif", Font.PLAIN, 30));

		sheepCount.setHorizontalAlignment(SwingConstants.CENTER);
		sheepCount.setText("0");
		sheepCount.setFont(new Font("Serif", Font.PLAIN, 30));

		wheatCount.setHorizontalAlignment(SwingConstants.CENTER);
		wheatCount.setText("0");
		wheatCount.setFont(new Font("Serif", Font.PLAIN, 30));
		handCount.add(brickCount);
		handCount.add(woodCount);
		handCount.add(oreCount);
		handCount.add(sheepCount);
		handCount.add(wheatCount);

		this.add(handCount);

	}

	/**
	 * @param string
	 * @return
	 */
	private ImageIcon createImage(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @return the wheatCount
	 */
	public JLabel getWheatCount() {
		return wheatCount;
	}

	/**
	 * @param wheatCount
	 *            the wheatCount to set
	 */
	public void setWheatCount(JLabel wheatCount) {
		this.wheatCount = wheatCount;
	}

	/**
	 * @return the brickCount
	 */
	public JLabel getBrickCount() {
		return brickCount;
	}

	/**
	 * @param brickCount
	 *            the brickCount to set
	 */
	public void setBrickCount(JLabel brickCount) {
		this.brickCount = brickCount;
	}

	/**
	 * @return the sheepCount
	 */
	public JLabel getSheepCount() {
		return sheepCount;
	}

	/**
	 * @param sheepCount
	 *            the sheepCount to set
	 */
	public void setSheepCount(JLabel sheepCount) {
		this.sheepCount = sheepCount;
	}

	/**
	 * @return the oreCount
	 */
	public JLabel getOreCount() {
		return oreCount;
	}

	/**
	 * @param oreCount
	 *            the oreCount to set
	 */
	public void setOreCount(JLabel oreCount) {
		this.oreCount = oreCount;
	}

	/**
	 * @return the woodCount
	 */
	public JLabel getWoodCount() {
		return woodCount;
	}

	/**
	 * @param woodCount
	 *            the woodCount to set
	 */
	public void setWoodCount(JLabel woodCount) {
		this.woodCount = woodCount;
	}

	/**
	 * @return the vpCount
	 */
	public JLabel getVpCount() {
		return vpCount;
	}

	/**
	 * @param vpCount
	 *            the vpCount to set
	 */
	public void setVpCount(JLabel vpCount) {
		this.vpCount = vpCount;
	}

	public static void main(String[] args) throws IOException {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Panel Tester");
		frame.getContentPane().add(new HandPanel(), BorderLayout.CENTER);
		frame.getContentPane().add(new BuildPanel(), BorderLayout.SOUTH);
		frame.getContentPane().add(new OptionsPanel(), BorderLayout.NORTH);
		frame.pack();
		frame.setVisible(true);

	}
}
