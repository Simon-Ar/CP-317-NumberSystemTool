package src;

import static java.lang.String.format;
import static src.Calculator.DecimalToBinary;
import static src.Calculator.DecimalToHex;
import static src.Calculator.DecimalToOct;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GameSnake extends JPanel implements Runnable {

	enum Dir {
		up(0, -1), right(1, 0), down(0, 1), left(-1, 0);

		Dir(int x, int y) {
			this.x = x;
			this.y = y;
		}

		final int x, y;
	}

	static final Random RAND = new Random();
	static final int WALL = -1;

	volatile boolean gameOver = true;

	Thread gameThread;
	private JButton playBin, playHex, playOct;
	int score, mode;
	String printedScore;
	int nRows = 32;
	int nCols = 32;
	Dir dir;

	int[][] grid;
	List<Point> snake;
	List<Treat> treats;
	Font smallFont;
	Font smallerFont;
	DoubleDeque<Character> val = new DoubleDeque<Character>();
	char[] chTarget;
	int numTarget;
	String strTarget = "";
	private String currentStr;

	public GameSnake() {

		currentStr = "";

		setPreferredSize(new Dimension(308, 308));
		setBackground(Color.white);
		setFont(new Font("SansSerif", Font.BOLD, 48));
		setFocusable(true);

		smallFont = getFont().deriveFont(Font.BOLD, 18);
		smallerFont = getFont().deriveFont(Font.PLAIN, 12);
		initGrid();

		playBin = new JButton("Play in Binary");
		playBin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (gameOver) {
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
				if (gameOver) {
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
				if (gameOver) {
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
					if (dir != Dir.down)
						dir = Dir.up;
					break;
				case KeyEvent.VK_W:
					if (dir != Dir.down)
						dir = Dir.up;
					break;
				case KeyEvent.VK_LEFT:
					if (dir != Dir.right)
						dir = Dir.left;
					break;
				case KeyEvent.VK_A:
					if (dir != Dir.right)
						dir = Dir.left;
					break;
				case KeyEvent.VK_RIGHT:
					if (dir != Dir.left)
						dir = Dir.right;
					break;
				case KeyEvent.VK_D:
					if (dir != Dir.left)
						dir = Dir.right;
					break;
				case KeyEvent.VK_DOWN:
					if (dir != Dir.up)
						dir = Dir.down;
					break;
				case KeyEvent.VK_S:
					if (dir != Dir.up)
						dir = Dir.down;
					break;
				}

				repaint();
			}
		});

		JFrame f = new JFrame();
		f.setTitle("Snake");
		f.setResizable(false);
		f.add(this, BorderLayout.CENTER);
		f.pack();
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}

	void startNewGame() {
		gameOver = false;
		stop();
		initGrid();
		treats = new LinkedList<>();

		newTarget();

		dir = Dir.up;

		score = 0;

		snake = new ArrayList<>();
		for (int x = 0; x < 7; x++)
			snake.add(new Point(nCols / 2 + x, nRows / 2));

		do
			addTreat();
		while (treats.isEmpty());

		(gameThread = new Thread(this)).start();
	}

	void newTarget() {

		val = new DoubleDeque<Character>();

		switch (mode) {
		case 0:
			numTarget = RAND.nextInt(252) + 4;
			strTarget = DecimalToBinary(numTarget);
			break;
		case 1:
			numTarget = RAND.nextInt(4080) + 16;
			strTarget = DecimalToHex(numTarget);
			break;
		case 2:
			numTarget = RAND.nextInt(4088) + 8;
			strTarget = DecimalToOct(numTarget);
			break;
		}

		chTarget = strTarget.toCharArray();
		for (char c : chTarget) {
			val.addRear(c);
		}

		currentStr = "";

		repaint();

	}

	void stop() {
		if (gameThread != null) {
			Thread tmp = gameThread;
			gameThread = null;
			tmp.interrupt();
		}
	}

	void initGrid() {
		grid = new int[nRows][nCols];
		for (int r = 0; r < nRows; r++) {
			for (int c = 0; c < nCols; c++) {
				if (c == 0 || c == nCols - 1 || r == 0 || r == nRows - 1)
					grid[r][c] = WALL;
			}
		}
	}

	@Override
	public void run() {

		while (Thread.currentThread() == gameThread) {

			try {
				Thread.sleep(Math.max(75 - score, 25));
			} catch (InterruptedException e) {
				return;
			}

			if (hitsWall() || hitsSnake()) {
				gameOver();
			} else {
				if (eatsTreat()) {
					score++;
					growSnake();
				}
				moveSnake();
				addTreat();
			}
			repaint();
		}
	}

	boolean checkVal() {
		boolean flag = false;
		return flag;
	}

	boolean hitsWall() {
		Point head = snake.get(0);
		int nextCol = head.x + dir.x;
		int nextRow = head.y + dir.y;
		return grid[nextRow][nextCol] == WALL;
	}

	boolean hitsSnake() {
		Point head = snake.get(0);
		int nextCol = head.x + dir.x;
		int nextRow = head.y + dir.y;
		for (Point p : snake)
			if (p.x == nextCol && p.y == nextRow)
				return true;
		return false;
	}

	boolean eatsTreat() {

		Point head = snake.get(0);
		int nextCol = head.x + dir.x;
		int nextRow = head.y + dir.y;
		for (Treat t : treats)
			if (t.location.x == nextCol && t.location.y == nextRow) {
				Treat currentTreat = treats.remove(treats.indexOf(t));
				if (val.removeFront().equals(currentTreat.charVal)) {
					currentStr += currentTreat.charVal;
					score += 5;
				} else {
					newTarget();
				}

				if (val.isEmpty()) {
					newTarget();
					score += 100;
				} else {

				}

				treats.clear();
				do
					addTreat();
				while (treats.isEmpty());

				return true;
			}
		return false;
	}

	void gameOver() {
		gameOver = true;
		stop();
	}

	void moveSnake() {
		for (int i = snake.size() - 1; i > 0; i--) {
			Point p1 = snake.get(i - 1);
			Point p2 = snake.get(i);
			p2.x = p1.x;
			p2.y = p1.y;
		}
		Point head = snake.get(0);
		head.x += dir.x;
		head.y += dir.y;
	}

	void growSnake() {
		Point tail = snake.get(snake.size() - 1);
		int x = tail.x + dir.x;
		int y = tail.y + dir.y;
		snake.add(new Point(x, y));
	}

	void addTreat() {
		if (treats.size() < 3) {

			if (RAND.nextInt(10) == 0) { // 1 in 10

				if (RAND.nextInt(4) != 0) { // 3 in 4
					int x, y;
					while (true) {

						x = RAND.nextInt(nCols);
						y = RAND.nextInt(nRows);
						if (grid[y][x] != 0)
							continue;

						Point p = new Point(x, y);
						Treat t = new Treat(p, mode);
						if (snake.contains(t.location) || treats.contains(t.location))
							continue;

						treats.add(t);
						break;
					}
				} else if (treats.size() > 1)
					treats.remove(0);
			}
		}
	}

	void drawGrid(Graphics2D g) {
		g.setColor(Color.lightGray);
		for (int r = 0; r < nRows; r++) {
			for (int c = 0; c < nCols; c++) {
				if (grid[r][c] == WALL)
					g.fillRect(c * 10, r * 10, 10, 10);
			}
		}
	}

	void drawSnake(Graphics2D g) {
		g.setColor(Color.blue);
		for (Point p : snake)
			g.fillRect(p.x * 10, p.y * 10, 10, 10);

		Point head = snake.get(0);
		g.fillRect(head.x * 10, head.y * 10, 10, 10);
	}

	void drawTreats(Graphics2D g) {

		g.setFont(smallerFont);
		for (Treat t : treats) {
			String s = String.valueOf(t.charVal);
			g.setColor(Color.green);
			g.fillRect(t.location.x * 10, t.location.y * 10, 10, 10);
			g.setColor(Color.black);
			g.drawString(s, t.location.x * 10 + 1, t.location.y * 10 + 10);
		}
		g.setFont(g.getFont());
	}

	void drawStartScreen(Graphics2D g) {
		g.setColor(Color.blue);
		g.setFont(getFont());
		g.drawString("Snake", 90, 140);
		g.setColor(Color.orange);
		g.setFont(smallFont);
		g.drawString("(click to start)", 100, 190);
		playBin.setVisible(true);
		playHex.setVisible(true);
		playOct.setVisible(true);

	}

	void drawScore(Graphics2D g) {
		int h = getHeight();

		g.setFont(smallFont);
		g.setColor(getForeground());
		switch (mode) {
		case 0:
			printedScore = DecimalToBinary(score);
			break;
		case 1:
			printedScore = DecimalToHex(score);
			break;
		case 2:
			printedScore = DecimalToOct(score);
			break;
		default:
			break;
		}
		String s = format("Score:  %s   Count: %d", printedScore, score);
		g.drawString(s, 30, h - 30);

		s = format("Word:  %s    Current: %s", strTarget, currentStr);
		g.drawString(s, 30, h - 60);
	}

	@Override
	public void paintComponent(Graphics gg) {
		super.paintComponent(gg);
		Graphics2D g = (Graphics2D) gg;
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		drawGrid(g);

		if (gameOver) {
			drawStartScreen(g);
		} else {
			drawSnake(g);
			drawTreats(g);
			drawScore(g);
		}
	}

}
