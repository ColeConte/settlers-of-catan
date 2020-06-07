import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class HexButton extends JButton implements ActionListener {

	private Polygon myBounds;
	private Boolean isClicked;
	private int[][] myCoordinates;
	private Color myColour;

	public HexButton() {
		this.setLayout(new GridLayout(1, 1, 0, 0));
		this.calculateBounds();
		this.setBackground(Color.BLUE);
		this.isClicked = false;
		this.setBorderPainted(false);
		this.setOpaque(true);
		this.addActionListener(this);
		this.myColour = Color.WHITE;
	}

	public HexButton(String text) {
		this();
		this.setText(text);
	}

	private Polygon hexagon(int width, int height, double ratio) {
		Polygon hexagon = new Polygon();
		for (int i = 0; i < 6; i++) {
			int x = width
					/ 2
					+ (int) ((width - 2) / 2 * Math.cos(i * 2 * Math.PI / 6) * ratio);
			int y = height
					/ 2
					+ (int) ((height - 2) / 2 * Math.sin(i * 2 * Math.PI / 6) * ratio);
			hexagon.addPoint(x, y);
		}
		return hexagon;
	}

	private void calculateBounds() {
		this.myBounds = this.hexagon(this.getWidth(), this.getHeight(), 1.0);
	}

	@Override
	public boolean contains(Point p) {
		return this.myBounds.contains(p);
	}

	@Override
	public boolean contains(int x, int y) {
		return this.myBounds.contains(x, y);
	}

	@Override
	public void setSize(Dimension d) {
		super.setSize(d);
		this.calculateBounds();
	}

	@Override
	public void setSize(int w, int h) {
		super.setSize(w, h);
		this.calculateBounds();
	}

	@Override
	public void setBounds(int x, int y, int width, int height) {
		super.setBounds(x, y, width, height);
		this.calculateBounds();
	}

	@Override
	public void setBounds(Rectangle r) {
		super.setBounds(r);
		this.calculateBounds();
	}

	public void updateColor() {
		if (this.myColour.equals(Color.WHITE))
			this.myColour = Color.BLACK;
		else
			this.myColour = Color.WHITE;
	}

	@Override
	protected void paintComponent(Graphics graphics) {
		graphics.setColor(Color.BLACK);
		Polygon border = this.hexagon(getWidth(), getHeight(), 1.02);
		graphics.drawPolygon(border);
		graphics.fillPolygon(border);

		Polygon inside = this.hexagon(getWidth(), getHeight(), 0.9);
		graphics.setColor(getBackground());
		graphics.drawPolygon(inside);
		graphics.fillPolygon(inside);

		graphics.setColor(this.myColour);
		graphics.fillOval(getWidth() / 3, getHeight() / 3, getWidth() / 3,
				getWidth() / 3);

	}

	public Boolean isClicked() {
		return this.isClicked;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		updateColor();
	}
}