import java.awt.BorderLayout;

import javax.swing.JFrame;

public class MainView extends JFrame {

	private BoardPanel bPanel;

	public MainView() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Settlers of Catan");
		setLocationRelativeTo(null);
		this.bPanel = new BoardPanel();
		this.add(this.bPanel, BorderLayout.CENTER);
		this.pack();
		this.setVisible(true);
		this.bPanel.hideRoads();
	}

	public static void main(String[] args) {
		new MainView();
	}

}
