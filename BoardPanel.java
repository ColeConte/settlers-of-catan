import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class BoardPanel extends JLayeredPane implements ActionListener {

	private ArrayList<HexButton> tiles;
	private ArrayList<JButton> corners;
	private HexButton clicked;
	private Color settlementColor;
	private ArrayList<Road> roads;
	private Color roadColor;
	private final static int[] EMPTYSPACES = new int[] { 0, 2, 20 };

	public BoardPanel() {
		this.setLayout(new HexLayout(9, 3));
		this.tiles = new ArrayList<HexButton>();
		this.corners = new ArrayList<JButton>();
		this.roads = new ArrayList<Road>();
		this.settlementColor = Color.RED;
		this.roadColor = Color.RED;
		this.addButtons();
		this.clicked.updateColor();
		// this.hideCorners();
		// for (HexButton tile : this.tiles) {
		// tile.setVisible(false);
		// }
	}

	public void hideCorners() {
		for (JButton corner : this.corners) {
			corner.setVisible(false);
		}
	}

	public void hideRoads() {
		for (Road road : this.roads) {
			if (road.getBackground().equals(Color.BLACK)
					|| road.getBackground().equals(Color.GREEN)) {
				road.setEnabled(false);
				road.setBackground(Color.BLACK);
				road.setVisible(false);
			}
		}
	}

	public void showRoads() {
		for (Road road : this.roads) {
			if (road.getBackground().equals(Color.BLACK)
					|| road.getBackground().equals(Color.GREEN)) {
				road.setVisible(true);
			}
		}
	}

	public void showAvailableRoads(JButton taken) {
		ArrayList<Road> available = new ArrayList<Road>();
		double bound = 38 * this.tiles.get(0).getWidth() / 100;
		double xTaken = taken.getX();
		double yTaken = taken.getY();
		for (Road road : this.roads) {
			if (road.getX() > xTaken - bound && road.getX() < xTaken + bound
					&& road.getY() > yTaken - bound
					&& road.getY() < yTaken + bound
					&& road.getBackground().equals(Color.BLACK)) {
				road.setBackground(Color.GREEN);
				road.setEnabled(true);
				road.setVisible(true);
			}
		}
		for (Road road : this.roads) {
			if (road.getBackground().equals(Color.BLACK))
				road.setVisible(false);
		}
	}

	public void showAvailableCorners(JButton taken) {
		ArrayList<JButton> removed = new ArrayList<JButton>();
		double bound = 3 * this.tiles.get(0).getWidth() / 5;
		double xTaken = taken.getX();
		double yTaken = taken.getY();
		this.corners.remove(taken);
		for (JButton corner : this.corners) {
			if (corner.getX() > xTaken - bound
					&& corner.getX() < xTaken + bound
					&& corner.getY() > yTaken - bound
					&& corner.getY() < yTaken + bound) {
				corner.setVisible(false);
				removed.add(corner);
			}
		}
		for (JButton remove : removed) {
			this.corners.remove(remove);
		}

	}

	public void showCorners() {
		for (JButton corner : this.corners) {
			corner.setVisible(true);
		}
	}

	public void moveRobber() {
		for (HexButton tile : this.tiles) {
			if (!tile.equals(this.clicked))
				tile.setEnabled(true);
		}
	}

	public void disableTiles() {
		for (HexButton tile : this.tiles) {
			tile.setEnabled(false);
		}
	}

	public void addButtons() {
		ArrayList<Integer> numbers = getRandomNunmbers();
		for (int x = 0; x < 22; x++) {
			HexButton hb = new HexButton();
			for (int emptySpace : this.EMPTYSPACES) {
				if (x == emptySpace) {
					hb.setVisible(false);
				}
			}
			if (hb.isVisible()) {
				this.tiles.add(hb);
				if (numbers.size() > 0) {
					if (numbers.get(0) != -1) {
						JLabel newLabel = new JLabel("    " + numbers.get(0));
						newLabel.setFont(new Font("Serif", Font.BOLD, 20));
						if (numbers.get(0) == 6 || numbers.get(0) == 8)
							newLabel.setForeground(Color.RED);
						hb.add(newLabel, BorderLayout.CENTER);
					} else
						this.clicked = hb;
					numbers.remove(0);
				}
			}
			this.add(hb, new Integer(1));
			this.addCorners(x, hb);
			hb.addActionListener(this);
			if (hb.isVisible())
				this.tiles.add(hb);
		}
	}

	public void addCorners(int x, HexButton hb) {
		for (int k = 0; k < 6; k++) {
			JButton corner = new JButton();
			Road road = new Road(k);
			road.setColor(Color.GREEN);
			if (!hb.isVisible() || x % 5 == 3 || x % 5 == 4 || x % 10 == 6
					|| x == 10 || x == 12) {
				corner.setVisible(false);
				road.setVisible(false);
			}
			if ((x == 3 && k == 3) || (x == 4 && k == 4) || (x == 18 && k == 1)
					|| (x == 19 && k == 0)
					|| ((x == 6 || x == 16) && (k == 2 || k == 5))
					|| ((x == 10 || x == 12) && (k == 5 || k == 2))) {
				corner.setVisible(true);
			}
			if (hb.isVisible()
					&& ((x < 5 && k == 3) || ((x == 12 || x == 19) && k == 5)
							|| ((x == 10 || x == 18) && k == 1)
							|| ((x % 5 == 3 || x % 5 == 4) && k == 0) || (x % 2 == 0
							&& k == 4 || ((x % 3 == 0 || ((x - 7) % 3) == 0)
							&& x != 18 && k == 2)))) {
				road.setVisible(true);
			}
			if (corner.isVisible()) {
				corner.addActionListener(this);
				this.corners.add(corner);
			}
			if (road.isVisible()) {
				road.addActionListener(this);
				this.roads.add(road);
			}
			road.setBackground(Color.BLACK);
			this.add(road, new Integer(2));
			corner.setBackground(Color.GREEN);
			this.add(corner, new Integer(3));
		}
	}

	public ArrayList<Integer> getRandomNunmbers() {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		ArrayList<Integer> mixedNums = new ArrayList<Integer>();
		Random generator = new Random();
		int removed = 0, totalNums = 0;
		numbers.add(2);
		numbers.add(12);
		for (int x = 3; x < 12; x++) {
			if (x != 7) {
				numbers.add(x);
				numbers.add(x);
			}
		}
		totalNums = numbers.size();
		for (int x = 0; x < totalNums; x++) {
			removed = generator.nextInt(numbers.size());
			mixedNums.add(numbers.get(removed));
			numbers.remove(removed);
		}
		mixedNums.add(generator.nextInt(mixedNums.size()), -1);
		return mixedNums;
	}

	public void setSettlementColor(Color color) {
		this.settlementColor = color;
	}

	public Color getSettlementColor() {
		return this.settlementColor;
	}

	public void setRoadColor(Color color) {
		this.roadColor = color;
	}

	public Color getRoadColor() {
		return this.roadColor;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().getClass().equals(HexButton.class)) {
			for (HexButton hb : this.tiles) {
				if (e.getSource().equals(hb)) {
					if (this.clicked != null) {
						this.clicked.updateColor();
						this.clicked.setEnabled(true);
					}
					hb.setEnabled(false);
					this.clicked = hb;
					break;
				}
			}
			repaint();
		} else {
			for (JButton corner : this.corners) {
				if (e.getSource().equals(corner)) {
					corner.setBackground(getSettlementColor());
					this.showAvailableCorners(corner);
					this.showRoads();
					this.showAvailableRoads(corner);
					this.setSettlementColor(Color.BLUE);
					this.hideCorners();
					break;
				}
			}
			for (Road road : this.roads) {
				if (e.getSource().equals(road)) {
					road.setBackground(getRoadColor());
					road.setEnabled(false);
					this.setRoadColor(this.getSettlementColor());
					this.roads.remove(road);
					this.hideRoads();
					this.showCorners();
					break;
				}
			}
			repaint();
		}
	}

}
