import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.util.ArrayList;

public class HexLayout implements LayoutManager {

	private int columns;
	private int rows;

	public HexLayout(int rows, int columns) {
		this.columns = columns;
		this.rows = rows;
	}

	@Override
	public void addLayoutComponent(String name, Component comp) {
	}

	@Override
	public void layoutContainer(Container parent) {
		int hexHeight = (parent.getHeight() / (this.rows + 1)) * 2;
		int hexWidth = hexHeight;

		int currentRow = 0, currentColumn = 0, xOffset = 0, yOffset = 0, iteration = 1, cornerButtons = 0;
		boolean firstHexButton = true, firstRoad = true;
		int roadLength = hexWidth / 3, roadHeight = 10;
		ArrayList<int[]> rectCoordinates = new ArrayList<int[]>();
		for (Component component : parent.getComponents()) {
			if (component instanceof HexButton) {
				if (firstHexButton) {
					currentRow = 0;
					currentColumn = 0;
					iteration = 1;
					cornerButtons = 0;
					firstHexButton = false;
					xOffset = 0;
					yOffset = 0;
				}
				if (iteration % 2 == 0) {
					xOffset = (int) (hexWidth * 0.75) + currentColumn
							* hexWidth + currentColumn * (hexWidth / 2);
					yOffset = currentRow * (hexHeight / 2 - 6);
				} else {
					xOffset = currentColumn * hexWidth + currentColumn
							* (hexWidth / 2);
					yOffset = currentRow * (hexHeight / 2 - 6);
				}
				component.setBounds(xOffset + hexWidth / 10, yOffset
						+ hexHeight / 10, hexWidth, hexHeight);
				currentColumn++;
			} else {
				if (component instanceof Road && firstRoad) {
					currentRow = 0;
					currentColumn = 0;
					iteration = 1;
					cornerButtons = 0;
					firstRoad = false;
				}
				if (cornerButtons == 0) {
					xOffset = 0;
					yOffset = 0;
					if (iteration % 2 == 0) {
						xOffset = (int) (hexWidth * 0.75) + currentColumn
								* hexWidth + currentColumn * (hexWidth / 2);
						yOffset = currentRow * (hexHeight / 2 - 6);
					} else {
						xOffset = currentColumn * hexWidth + currentColumn
								* (hexWidth / 2);
						yOffset = currentRow * (hexHeight / 2 - 6);
					}
					currentColumn++;
				}
				int x = hexWidth
						/ 2
						+ (int) ((hexWidth - 2) / 2 * Math
								.cos((cornerButtons + 1) * 2 * Math.PI / 6));
				int y = hexHeight
						/ 2
						+ (int) ((hexHeight - 2) / 2 * Math
								.sin((cornerButtons + 1) * 2 * Math.PI / 6));
				if (!(component instanceof Road))
					component.setBounds(x + xOffset + hexWidth / 20, y
							+ yOffset + hexHeight / 20, (int) (hexWidth * .15),
							(int) (hexWidth * .15));
				else if (component.isVisible()) {
					if (cornerButtons == 0)
						component.setBounds((int) ((.6 * x)) + xOffset, y
								+ yOffset - hexHeight / 20, roadLength,
								roadLength);
					if (cornerButtons == 1) {
						component.setBounds((int) (.6 * x) + xOffset - hexWidth
								/ 20, y + yOffset - hexHeight / 4, roadLength,
								roadLength);
					}
					if (cornerButtons == 2) {
						component.setBounds((int) (.75 * x) + hexWidth / 10
								+ xOffset, y + yOffset - hexHeight / 4,
								roadLength, roadLength);
					}
					if (cornerButtons == 3) {
						component.setBounds((int) (2.7 * x) + xOffset - x, y
								+ yOffset - hexHeight / 20, roadLength,
								roadLength);
					}
					if (cornerButtons == 4) {
						component.setBounds(x + xOffset
								+ (int) (hexWidth * .08), y + yOffset
								+ (int) (hexWidth * .15), roadLength,
								roadLength);
					}
					if (cornerButtons == 5) {
						component.setBounds(x + xOffset
								- (int) (hexWidth * .15), y + yOffset
								+ hexHeight / 5, roadLength, roadLength);
					}
				}

			}
			cornerButtons = ((cornerButtons + 1) % 6);
			if ((iteration % 2 == 0 && currentColumn == this.columns - 1)
					|| (iteration % 2 == 1 && currentColumn == this.columns)) {
				currentColumn = 0;
				currentRow++;
				iteration++;
			}

		}

	}

	@Override
	public Dimension minimumLayoutSize(Container parent) {
		return new Dimension(600, 500);
	}

	@Override
	public Dimension preferredLayoutSize(Container parent) {
		return new Dimension(600, 500);
	}

	@Override
	public void removeLayoutComponent(Component comp) {
		// TODO Auto-generated method stub
	}

}
