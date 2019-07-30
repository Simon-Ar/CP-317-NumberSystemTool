package src;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Game2048 extends JPanel {

	enum State {
		start, won, running, over
	}

	final Color[] colorTable = { new Color(0x701710), new Color(0xFFE4C3), new Color(0xfff4d3), new Color(0xffdac3),
			new Color(0xe7b08e), new Color(0xe7bf8e), new Color(0xffc4c3), new Color(0xE7948e), new Color(0xbe7e56),
			new Color(0xbe5e56), new Color(0x9c3931), new Color(0x701710) };

	final static int target = 2048;

	static int highest;
	static int score;

	private Color gridColor = new Color(0xBBADA0);
	private Color emptyColor = new Color(0xCDC1B4);
	private Color startColor = new Color(0xFFEBCD);

	private Random rand = new Random();

	private Tile[][] tiles;
	private int side = 4;
	private State gamestate = State.start;
	private boolean checkingAvailableMoves;

	private JButton playBin, playHex, playOct;
	int mode;
	Font currentFont = new Font("SansSerif", Font.BOLD, 48);

	public Game2048() {
		setPreferredSize(new Dimension(900, 700));
		setBackground(new Color(0xFAF8EF));
		setFont(currentFont);
		setFocusable(true);

		playBin = new JButton("Play in Binary");
		playBin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (gamestate != State.running) {
					mode = 0;
					playBin.setVisible(false);
					playHex.setVisible(false);
					playOct.setVisible(false);
					startNewGame();
					repaint();
				}
			}
		});
		playHex = new JButton("Play in Hex");
		playHex.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (gamestate != State.running) {
					mode = 1;
					playBin.setVisible(false);
					playHex.setVisible(false);
					playOct.setVisible(false);
					startNewGame();
					repaint();
				}
			}
		});
		playOct = new JButton("Play in Oct");
		playOct.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (gamestate != State.running) {
					mode = 2;
					playBin.setVisible(false);
					playHex.setVisible(false);
					playOct.setVisible(false);
					startNewGame();
					repaint();
				}
			}
		});

		this.add(playBin);
		this.add(playHex);
		this.add(playOct);

		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_UP:
					moveUp();
					break;
				case KeyEvent.VK_DOWN:
					moveDown();
					break;
				case KeyEvent.VK_LEFT:
					moveLeft();
					break;
				case KeyEvent.VK_RIGHT:
					moveRight();
					break;
				}
				repaint();
			}
		});

//		SwingUtilities.invokeLater(() -> {
		JFrame f = new JFrame();
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setTitle("2048");
		f.setResizable(true);
		f.add(this, BorderLayout.CENTER);
		f.pack();
		f.setLocationRelativeTo(null);
		f.setVisible(true);
//		});
	}

	@Override
	public void paintComponent(Graphics gg) {
		super.paintComponent(gg);
		Graphics2D g = (Graphics2D) gg;
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		drawGrid(g);
	}

	void startNewGame() {
		if (gamestate != State.running) {
			score = 0;
			highest = 0;
			gamestate = State.running;
			tiles = new Tile[side][side];
			addRandomTile();
			addRandomTile();
		}
	}

	void drawGrid(Graphics2D g) {
		g.setColor(gridColor);
		g.fillRoundRect(200, 100, 499, 499, 15, 15);

		if (gamestate == State.running) {

			for (int r = 0; r < side; r++) {
				for (int c = 0; c < side; c++) {
					if (tiles[r][c] == null) {
						g.setColor(emptyColor);
						g.fillRoundRect(215 + c * 121, 115 + r * 121, 106, 106, 7, 7);
					} else {
						drawTile(g, r, c);
					}
				}
			}
		} else {
			g.setColor(startColor);
			g.fillRoundRect(215, 115, 469, 469, 7, 7);

			g.setColor(gridColor.darker());
			g.setFont(new Font("SansSerif", Font.BOLD, 128));
			g.drawString("2048", 310, 270);

			g.setFont(new Font("SansSerif", Font.BOLD, 20));

			if (gamestate == State.won) {
				g.drawString("you made it!", 390, 350);

			} else if (gamestate == State.over)
				g.drawString("game over", 400, 350);

			g.setColor(gridColor);
			g.drawString("click to start a new game", 330, 470);
			g.drawString("(use arrow keys to move tiles)", 310, 530);

			playBin.setVisible(true);
			playHex.setVisible(true);
			playOct.setVisible(true);
		}
	}

	void drawTile(Graphics2D g, int r, int c) {
		int value = tiles[r][c].getValue();

		g.setColor(colorTable[(int) (Math.log(value) / Math.log(2)) + 1]);
		g.fillRoundRect(215 + c * 121, 115 + r * 121, 106, 106, 7, 7);
		String s = "";

		switch (mode) {
		case 0:
			s = Calculator.DecimalToBinary(value);
		case 1:
			s = Calculator.DecimalToHex(value);
		case 2:
			s = Calculator.DecimalToOct(value);
		}

		g.setColor(value < 128 ? colorTable[0] : colorTable[1]);

		FontMetrics fm = g.getFontMetrics();
		int asc = fm.getAscent();
		int dec = fm.getDescent();

		int x = 215 + c * 121 + (106 - fm.stringWidth(s)) / 2;
		int y = 115 + r * 121 + (asc + (106 - (asc + dec)) / 2);

		g.drawString(s, x, y);
		g.setFont(currentFont.deriveFont(Font.BOLD, 48));

	}

	private void addRandomTile() {
		int pos = rand.nextInt(side * side);
		int row, col;
		do {
			pos = (pos + 1) % (side * side);
			row = pos / side;
			col = pos % side;
		} while (tiles[row][col] != null);

		int val = rand.nextInt(10) == 0 ? 4 : 2;
		tiles[row][col] = new Tile(val);
	}

	private boolean move(int countDownFrom, int yIncr, int xIncr) {
		boolean moved = false;

		for (int i = 0; i < side * side; i++) {
			int j = Math.abs(countDownFrom - i);

			int r = j / side;
			int c = j % side;

			if (tiles[r][c] == null)
				continue;

			int nextR = r + yIncr;
			int nextC = c + xIncr;

			while (nextR >= 0 && nextR < side && nextC >= 0 && nextC < side) {

				Tile next = tiles[nextR][nextC];
				Tile curr = tiles[r][c];

				if (next == null) {

					if (checkingAvailableMoves)
						return true;

					tiles[nextR][nextC] = curr;
					tiles[r][c] = null;
					r = nextR;
					c = nextC;
					nextR += yIncr;
					nextC += xIncr;
					moved = true;

				} else if (next.canMergeWith(curr)) {

					if (checkingAvailableMoves)
						return true;

					int value = next.mergeWith(curr);
					if (value > highest)
						highest = value;
					score += value;
					tiles[r][c] = null;
					moved = true;
					break;
				} else
					break;
			}
		}

		if (moved) {
			if (highest < target) {
				clearMerged();
				addRandomTile();
				if (!movesAvailable()) {
					gamestate = State.over;
				}
			} else if (highest == target)
				gamestate = State.won;
		}

		return moved;
	}

	boolean moveUp() {
		return move(0, -1, 0);
	}

	boolean moveDown() {
		return move(side * side - 1, 1, 0);
	}

	boolean moveLeft() {
		return move(0, 0, -1);
	}

	boolean moveRight() {
		return move(side * side - 1, 0, 1);
	}

	void clearMerged() {
		for (Tile[] row : tiles)
			for (Tile tile : row)
				if (tile != null)
					tile.setMerged(false);
	}

	boolean movesAvailable() {
		checkingAvailableMoves = true;
		boolean hasMoves = moveUp() || moveDown() || moveLeft() || moveRight();
		checkingAvailableMoves = false;
		return hasMoves;
	}

}

class Tile {
	private boolean merged;
	private int value;

	Tile(int val) {
		value = val;
	}

	int getValue() {
		return value;
	}

	void setMerged(boolean m) {
		merged = m;
	}

	boolean canMergeWith(Tile other) {
		return !merged && other != null && !other.merged && value == other.getValue();
	}

	int mergeWith(Tile other) {
		if (canMergeWith(other)) {
			value *= 2;
			merged = true;
			return value;
		}
		return -1;
	}
}
