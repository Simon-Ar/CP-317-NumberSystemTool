package calculator_gui;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class GUI implements ActionListener, KeyListener {
	
	private static final int WIDTH = 1900;
    private static final int HEIGHT = 1000;
    private JLabel 	displayField, hexField, decField, binField, octField;
    private JRadioButton hex, dec, oct, bin;
    private String base = "dec";
    private JButton oneBtn, twoBtn, threeBtn, fourBtn, fiveBtn, sixBtn, sevenBtn, eightBtn, nineBtn, zeroBtn;
    private JButton aBtn, bBtn, cBtn, dBtn, eBtn, fBtn;
    private JButton addBtn, subBtn, multBtn, divBtn,equalsBtn, clearBtn; 
    private JButton decimalBtn, negBtn, backBtn, squareBtn, expBtn, firstBtn, secondBtn, button;
    static int op =0;
    static String first = "", second = "";
	static int result = 0;
	private JPanel textPanel = new JPanel(new GridLayout(4, 2));
	JPanel fPanel = new JPanel(new GridLayout(5, 3));
	JPanel alpPanel = new JPanel(new GridLayout(5, 3));
	JPanel one = new JPanel();
	JPanel two = new JPanel();
	JPanel five = new JPanel();
	JPanel six = new JPanel();
	private final JMenuBar menuBar = new JMenuBar();
	private final JMenu calculator = new JMenu("Calculator");
	private final JMenu game1 = new JMenu("2048");
	private final JMenu game2 = new JMenu("Snake");
	private final JMenu game3 = new JMenu("Game3");
	private final JMenu themes = new JMenu("Themes");
	private final JMenuItem dark = new JMenuItem("Dark Theme");
	private final JMenuItem light = new JMenuItem("Light Theme");
	private final JMenuItem blue = new JMenuItem("Blue Theme");
	private final JMenu achive = new JMenu("Achivements");

    
    
    public GUI() {
    	
    	// adds action listeners to all the menu items
    	dark.addActionListener(this);
    	light.addActionListener(this);
    	blue.addActionListener(this);
    	game1.addActionListener(this);
    	game2.addActionListener(this);
    	game3.addActionListener(this);
    	themes.addActionListener(this);
    	achive.addActionListener(this);
    	
    	themes.add(dark);
    	themes.add(light);
    	themes.add(blue);
    	
    	menuBar.add(calculator);
    	menuBar.add(game1);
    	menuBar.add(game2);
    	menuBar.add(game3);
    	menuBar.add(themes);
    	menuBar.add(achive);
    	
    	hex = new JRadioButton("HEX");
    	hexField = new JLabel("0");
    	hexField.setFont(new Font("Times New Roman", Font.BOLD, 20));
    	hex.addActionListener(this);
    	
    	oct = new JRadioButton("OCT");
    	octField = new JLabel("0");
    	octField.setFont(new Font("Times New Roman", Font.BOLD, 20));
    	oct.addActionListener(this);
    	
    	dec = new JRadioButton("DEC");
    	decField = new JLabel("0");
    	decField.setFont(new Font("Times New Roman", Font.BOLD, 20));
    	dec.setSelected(true);
    	dec.addActionListener(this);
    	
    	bin = new JRadioButton("BIN");
    	binField = new JLabel("0");
    	binField.setFont(new Font("Times New Roman", Font.BOLD, 20));
    	bin.addActionListener(this);
    	
        displayField = new JLabel("0");  
        displayField.setFont(new Font("Times New Roman", Font.BOLD, 60));
        	
    	zeroBtn = new JButton("0");
    	zeroBtn.addActionListener(this);
    	zeroBtn.setBackground(Color.WHITE);
    	zeroBtn.setFont(new Font("Times New Roman", Font.BOLD, 18));
    	
    	oneBtn = new JButton("1");
    	oneBtn.addActionListener(this);
    	oneBtn.setBackground(Color.WHITE);
    	oneBtn.setFont(new Font("Times New Roman", Font.BOLD, 18));
    	
    	twoBtn = new JButton("2");
    	twoBtn.addActionListener(this);
    	twoBtn.setBackground(Color.WHITE);
    	twoBtn.setFont(new Font("Times New Roman", Font.BOLD, 18));
    	
    	threeBtn = new JButton("3");
    	threeBtn.addActionListener(this);
    	threeBtn.setBackground(Color.WHITE);
    	threeBtn.setFont(new Font("Times New Roman", Font.BOLD, 18));
    	
    	fourBtn = new JButton("4");
    	fourBtn.addActionListener(this);
    	fourBtn.setBackground(Color.WHITE);
    	fourBtn.setFont(new Font("Times New Roman", Font.BOLD, 18));
    	
    	fiveBtn = new JButton("5");
    	fiveBtn.addActionListener(this);
    	fiveBtn.setBackground(Color.WHITE);
    	fiveBtn.setFont(new Font("Times New Roman", Font.BOLD, 18));
    	
    	sixBtn = new JButton("6");
    	sixBtn.addActionListener(this);
    	sixBtn.setBackground(Color.WHITE);
    	sixBtn.setFont(new Font("Times New Roman", Font.BOLD, 18));
    	
    	sevenBtn = new JButton("7");
    	sevenBtn.addActionListener(this);
    	sevenBtn.setBackground(Color.WHITE);
    	sevenBtn.setFont(new Font("Times New Roman", Font.BOLD, 18));
    	
    	eightBtn = new JButton("8");
    	eightBtn.addActionListener(this);
    	eightBtn.setBackground(Color.WHITE);
    	eightBtn.setFont(new Font("Times New Roman", Font.BOLD, 18));
    	
    	nineBtn = new JButton("9");
    	nineBtn.addActionListener(this);
    	nineBtn.setBackground(Color.WHITE);
    	nineBtn.setFont(new Font("Times New Roman", Font.BOLD, 18));
    	
    	aBtn = new JButton("A");
    	aBtn.addActionListener(this);
    	aBtn.setBackground(Color.WHITE);
    	aBtn.setFont(new Font("Times New Roman", Font.BOLD, 18));
    	aBtn.setEnabled(false);
    	
    	bBtn = new JButton("B");
    	bBtn.addActionListener(this);
    	bBtn.setBackground(Color.WHITE);
    	bBtn.setFont(new Font("Times New Roman", Font.BOLD, 18));
    	bBtn.setEnabled(false);
    	
    	cBtn = new JButton("C");
    	cBtn.addActionListener(this);
    	cBtn.setBackground(Color.WHITE);
    	cBtn.setFont(new Font("Times New Roman", Font.BOLD, 18));
    	cBtn.setEnabled(false);
    	
    	dBtn = new JButton("D");
    	dBtn.addActionListener(this);
    	dBtn.setBackground(Color.WHITE);
    	dBtn.setFont(new Font("Times New Roman", Font.BOLD, 18));
    	dBtn.setEnabled(false);
    	
    	eBtn = new JButton("E");
    	eBtn.addActionListener(this);
    	eBtn.setBackground(Color.WHITE);
    	eBtn.setFont(new Font("Times New Roman", Font.BOLD, 18));
    	eBtn.setEnabled(false);
    	
    	fBtn = new JButton("F");
    	fBtn.addActionListener(this);
    	fBtn.setBackground(Color.WHITE);
    	fBtn.setFont(new Font("Times New Roman", Font.BOLD, 18));
    	fBtn.setEnabled(false);
    	
    	addBtn = new JButton("+");
    	addBtn.setBackground(Color.WHITE);
    	addBtn.setFont(new Font("Times New Roman", Font.BOLD, 18));
    	addBtn.addActionListener(this);
    	
    	subBtn = new JButton("-");
    	subBtn.setBackground(Color.WHITE);
    	subBtn.setFont(new Font("Times New Roman", Font.BOLD, 18));
    	subBtn.addActionListener(this);
    	
    	multBtn = new JButton("*");
    	multBtn.setBackground(Color.WHITE);
    	multBtn.setFont(new Font("Times New Roman", Font.BOLD, 18));
    	multBtn.addActionListener(this);
    	
    	divBtn = new JButton("/");
    	divBtn.setBackground(Color.WHITE);
    	divBtn.setFont(new Font("Times New Roman", Font.BOLD, 18));
    	divBtn.addActionListener(this);
    	
    	equalsBtn = new JButton("=");
    	equalsBtn.setBackground(Color.WHITE);
    	equalsBtn.setFont(new Font("Times New Roman", Font.BOLD, 18));
    	equalsBtn.addActionListener(this);
    	
    	clearBtn = new JButton("C");
    	clearBtn.setBackground(Color.WHITE);
    	clearBtn.setFont(new Font("Times New Roman", Font.BOLD, 18));
    	clearBtn.addActionListener(this);
    	
    	decimalBtn = new JButton(".");
    	decimalBtn.addActionListener(this);
    	decimalBtn.setBackground(Color.WHITE);
    	decimalBtn.setFont(new Font("Times New Roman", Font.BOLD, 18));
    	
    	negBtn = new JButton("-(x)");
    	negBtn.addActionListener(this);
    	negBtn.setBackground(Color.WHITE);
    	negBtn.setFont(new Font("Times New Roman", Font.BOLD, 18));
    	
    	backBtn = new JButton("Delete");
    	backBtn.addActionListener(this);
    	backBtn.setBackground(Color.WHITE);
    	backBtn.setFont(new Font("Times New Roman", Font.BOLD, 18));
    	
    	squareBtn = new JButton("sqrt");
    	squareBtn.addActionListener(this);
    	squareBtn.setBackground(Color.WHITE);
    	squareBtn.setFont(new Font("Times New Roman", Font.BOLD, 18));
    	
    	expBtn = new JButton("^");
    	expBtn.addActionListener(this);
    	expBtn.setBackground(Color.WHITE);
    	expBtn.setFont(new Font("Times New Roman", Font.BOLD, 18));
    	
    	firstBtn = new JButton("1st");
    	firstBtn.addActionListener(this);
    	firstBtn.setBackground(Color.WHITE);
    	firstBtn.setFont(new Font("Times New Roman", Font.BOLD, 18));
    	
    	secondBtn = new JButton("2nd");
    	secondBtn.addActionListener(this);
    	secondBtn.setBackground(Color.WHITE);
    	secondBtn.setFont(new Font("Times New Roman", Font.BOLD, 18));
    	
    	firstBtn.setEnabled(false);
		secondBtn.setEnabled(false);
    	
    	button = new JButton(" ");
    	button.addActionListener(this);
    	button.setBackground(Color.WHITE);
    	button.setFont(new Font("Times New Roman", Font.BOLD, 18));
    	
    	textPanel.add(hex);
    	textPanel.add(hexField);
    	textPanel.add(oct);
    	textPanel.add(octField);
    	textPanel.add(dec);
    	textPanel.add(decField);
    	textPanel.add(bin);
    	textPanel.add(binField);
    	
    	ButtonGroup group = new ButtonGroup();
    	group.add(hex);
    	group.add(oct);
    	group.add(bin);
    	group.add(dec);
    	
    	JPanel fPanel = new JPanel(new GridLayout(5, 3));
    	fPanel.add(expBtn);
    	fPanel.add(squareBtn);
    	fPanel.add(button);
    	fPanel.add(aBtn);
    	fPanel.add(bBtn);
    	fPanel.add(sevenBtn);
    	fPanel.add(cBtn);
    	fPanel.add(dBtn);
    	fPanel.add(fourBtn);
    	fPanel.add(eBtn);
    	fPanel.add(fBtn);
    	fPanel.add(oneBtn);
    	fPanel.add(firstBtn);
    	fPanel.add(secondBtn);
    	fPanel.add(negBtn);
    	
    	alpPanel.add(clearBtn);
    	alpPanel.add(backBtn);
    	alpPanel.add(divBtn);
    	alpPanel.add(eightBtn);
    	alpPanel.add(nineBtn);
    	alpPanel.add(multBtn);
    	alpPanel.add(fiveBtn);
    	alpPanel.add(sixBtn);
    	alpPanel.add(subBtn);
    	alpPanel.add(twoBtn);
    	alpPanel.add(threeBtn);
    	alpPanel.add(addBtn);
    	alpPanel.add(zeroBtn);
    	alpPanel.add(decimalBtn);
    	alpPanel.add(equalsBtn);
    	
    	JFrame frame = new JFrame("Calculator");
        frame.setTitle("Calculator");
        frame.setSize(WIDTH, HEIGHT);
    	frame.add(one);
        frame.add(two);
        frame.add(displayField);
    	frame.add(textPanel);
    	frame.add(five);
    	frame.add(six); 
    	frame.add(fPanel);
    	frame.add(alpPanel);
    	frame.setLayout( new GridLayout(3,3));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setJMenuBar(menuBar);
        frame.setVisible(true);
    	
    }

	public static void main(String[] args) {
    	
    	new GUI();
        
    }
    
    public void actionPerformed(ActionEvent e){
    	
    	if (e.getSource() == dark) {
    		
    		aBtn.setBackground(Color.lightGray);
    		bBtn.setBackground(Color.lightGray);
    		cBtn.setBackground(Color.lightGray);
    		dBtn.setBackground(Color.lightGray);
    		eBtn.setBackground(Color.lightGray);
    		fBtn.setBackground(Color.lightGray);
    		
    		oneBtn.setBackground(Color.lightGray);
    		twoBtn.setBackground(Color.lightGray);
    		threeBtn.setBackground(Color.lightGray);
    		fourBtn.setBackground(Color.lightGray);
    		fiveBtn.setBackground(Color.lightGray);
    		sixBtn.setBackground(Color.lightGray);
    		sevenBtn.setBackground(Color.lightGray);
    		eightBtn.setBackground(Color.lightGray);
    		nineBtn.setBackground(Color.lightGray);
    		zeroBtn.setBackground(Color.lightGray);
    		
    		textPanel.setBackground(Color.GRAY);
    		
    	}
    	
    	if (e.getSource() == light) {
    		
    	}
    	
    	if (e.getSource() == blue) {
    		
    	}
    	
    	if (e.getSource() == game1) {
    		
    	}
    	
    	if (e.getSource() == game2) {
    		
    	}
    	
    	if (e.getSource() == game3) {
    		
    	}
    	
    	if (e.getSource() == calculator) {
    		
    	}
    	
    	if (e.getSource() == achive) {
    		
    	}
    	
    	// disables all buttons that don't apply to hex
    	if (e.getSource() == hex) {
    		displayField.setText(hexField.getText());
    		base = "hex";
    		aBtn.setEnabled(true);
    		bBtn.setEnabled(true);
    		cBtn.setEnabled(true);
    		dBtn.setEnabled(true);
    		eBtn.setEnabled(true);
    		fBtn.setEnabled(true);
    		
    		twoBtn.setEnabled(true);
    		threeBtn.setEnabled(true);
    		fourBtn.setEnabled(true);
    		fiveBtn.setEnabled(true);
    		sixBtn.setEnabled(true);
    		sevenBtn.setEnabled(true);
    		eightBtn.setEnabled(true);
    		nineBtn.setEnabled(true);
    		
    		firstBtn.setEnabled(false);
    		secondBtn.setEnabled(false);
    		
    	}
    	
    	// disables all buttons that don't apply to octal 
    	if (e.getSource() == oct) {
    		displayField.setText(octField.getText());
    		base = "oct";
    		aBtn.setEnabled(false);
    		bBtn.setEnabled(false);
    		cBtn.setEnabled(false);
    		dBtn.setEnabled(false);
    		eBtn.setEnabled(false);
    		fBtn.setEnabled(false);
    		
    		twoBtn.setEnabled(true);
    		threeBtn.setEnabled(true);
    		fourBtn.setEnabled(true);
    		fiveBtn.setEnabled(true);
    		sixBtn.setEnabled(true);
    		sevenBtn.setEnabled(true);
    		eightBtn.setEnabled(false);
    		nineBtn.setEnabled(false);
    		
    		firstBtn.setEnabled(false);
    		secondBtn.setEnabled(false);
    		
    	}
    	
    	// disables all buttons that don't apply to decimal 
    	if (e.getSource() == dec) {
    		displayField.setText(decField.getText());
    		base = "dec";
    		aBtn.setEnabled(false);
    		bBtn.setEnabled(false);
    		cBtn.setEnabled(false);
    		dBtn.setEnabled(false);
    		eBtn.setEnabled(false);
    		fBtn.setEnabled(false);
    		
    		twoBtn.setEnabled(true);
    		threeBtn.setEnabled(true);
    		fourBtn.setEnabled(true);
    		fiveBtn.setEnabled(true);
    		sixBtn.setEnabled(true);
    		sevenBtn.setEnabled(true);
    		eightBtn.setEnabled(true);
    		nineBtn.setEnabled(true);
    		
    		firstBtn.setEnabled(false);
    		secondBtn.setEnabled(false);
    		
    	}
    	// disables all buttons that don't apply to binary
    	if (e.getSource() == bin) {
    		displayField.setText(binField.getText());
    		base = "bin";
    		aBtn.setEnabled(false);
    		bBtn.setEnabled(false);
    		cBtn.setEnabled(false);
    		dBtn.setEnabled(false);
    		eBtn.setEnabled(false);
    		fBtn.setEnabled(false);
    		
    		twoBtn.setEnabled(false);
    		threeBtn.setEnabled(false);
    		fourBtn.setEnabled(false);
    		fiveBtn.setEnabled(false);
    		sixBtn.setEnabled(false);
    		sevenBtn.setEnabled(false);
    		eightBtn.setEnabled(false);
    		nineBtn.setEnabled(false);
    		
    		firstBtn.setEnabled(true);
    		secondBtn.setEnabled(true);
    		
    	}
    	
    	// adds 0 to the display field and then converts realtime because of the new value
    	if (e.getSource() == zeroBtn) {
    		displayField.setText(displayField.getText().concat("0"));
    		realtime(displayField.getText(), base);
    	}
    	
    	// adds 1 to the display field and then converts realtime because of the new value
    	if (e.getSource() == oneBtn) {
    		displayField.setText(displayField.getText().concat("1"));
    		realtime(displayField.getText(), base);
    	}
    	
    	// adds 2 to the display field and then converts realtime because of the new value
    	if (e.getSource() == twoBtn) {
    		displayField.setText(displayField.getText().concat("2"));
    		realtime(displayField.getText(), base);
    	}
    	
    	// adds 3 to the display field and then converts realtime because of the new value
    	if (e.getSource() == threeBtn) {
    		displayField.setText(displayField.getText().concat("3"));
    		realtime(displayField.getText(), base);
    	}
    	
    	// adds 4 to the display field and then converts realtime because of the new value
    	if (e.getSource() == fourBtn) {
    		displayField.setText(displayField.getText().concat("4"));
    		realtime(displayField.getText(), base);
    	}
    	
    	// adds 5 to the display field and then converts realtime because of the new value
    	if (e.getSource() == fiveBtn) {
    		displayField.setText(displayField.getText().concat("5"));
    		realtime(displayField.getText(), base);
    	}
    	
    	// adds 6 to the display field and then converts realtime because of the new value
    	if (e.getSource() == sixBtn) {
    		displayField.setText(displayField.getText().concat("6"));
    		realtime(displayField.getText(), base);
    	}
    	
    	// adds 7 to the display field and then converts realtime because of the new value
    	if (e.getSource() == sevenBtn) {
    		displayField.setText(displayField.getText().concat("7"));
    		realtime(displayField.getText(), base);
    	}
    	
    	// adds 8 to the display field and then converts realtime because of the new value
    	if (e.getSource() == eightBtn) {
    		displayField.setText(displayField.getText().concat("8"));
    		realtime(displayField.getText(), base);
    	}
    	
    	// adds 9 to the display field and then converts realtime because of the new value
    	if (e.getSource() == nineBtn) {
    		displayField.setText(displayField.getText().concat("9"));
    		realtime(displayField.getText(), base);
    	}
    	
    	// adds A to the display field and then converts realtime because of the new value
    	if (e.getSource() == aBtn) {
    		displayField.setText(displayField.getText().concat("A"));
    		realtime(displayField.getText(), base);
    	}
    	
    	// adds B to the display field and then converts realtime because of the new value
    	if (e.getSource() == bBtn) {
    		displayField.setText(displayField.getText().concat("B"));
    		realtime(displayField.getText(), base);
    	}
    	
    	// adds C to the display field and then converts realtime because of the new value
    	if (e.getSource() == cBtn) {
    		displayField.setText(displayField.getText().concat("C"));
    		realtime(displayField.getText(), base);
    	}
    	
    	// adds D to the display field and then converts realtime because of the new value
    	if (e.getSource() == dBtn) {
    		displayField.setText(displayField.getText().concat("D"));
    		realtime(displayField.getText(), base);
    	}
    	
    	// adds E to the display field and then converts realtime because of the new value
    	if (e.getSource() == eBtn) {
    		displayField.setText(displayField.getText().concat("E"));
    		realtime(displayField.getText(), base);
    	}
    	
    	// adds F to the display field and then converts realtime because of the new value
    	if (e.getSource() == fBtn) {
    		displayField.setText(displayField.getText().concat("F"));
    		realtime(displayField.getText(), base);
    	}
    	
    	// Clears all text fields
    	if (e.getSource() == clearBtn) {
    		Clear();
    	}
    	
    	// 
    	if (e.getSource() == addBtn) {
    		
    		op = 1;
    		first = decField.getText();
    		displayField.setText("0");
   		 	decField.setText("0");
   		 	hexField.setText("0");
   		 	binField.setText("0");
   		 	octField.setText("0");
    		
    	}
    	
    	if (e.getSource() == subBtn) {
    		
    		op = 2;
    		first = decField.getText();
    		displayField.setText("0");
   		 	decField.setText("0");
   		 	hexField.setText("0");
   		 	binField.setText("0");
   		 	octField.setText("0");
    		
    	}
    	
    	if (e.getSource() == multBtn) {
    		op = 3;
    		first = decField.getText();
    		displayField.setText("0");
   		 	decField.setText("0");
   		 	hexField.setText("0");
   		 	binField.setText("0");
   		 	octField.setText("0");
    	}
    	
    	if (e.getSource() == divBtn) {
    		
    		op = 4;
    		first = decField.getText();
    		displayField.setText("0");
   		 	decField.setText("0");
   		 	hexField.setText("0");
   		 	binField.setText("0");
   		 	octField.setText("0");
    	}
    	
    	if (e.getSource() == expBtn) {
    		op = 5;
    		
    		first = decField.getText();
    		displayField.setText("0");
   		 	decField.setText("0");
   		 	hexField.setText("0");
   		 	binField.setText("0");
   		 	octField.setText("0");
    	}
    	
    	if (e.getSource() == equalsBtn) {
    		
    		second = decField.getText();
    		
    		switch(op)
    		
    		{
    		
    		case 1: 
    			result = Adding(Integer.parseInt(first), Integer.parseInt(second));
    			break;
    		
    		case 2: 
    			result = Subtracting(Integer.parseInt(first), Integer.parseInt(second));;
    			break;
    		
    		case 3: 
    			result = Mult(Integer.parseInt(first), Integer.parseInt(second));;
    			break;
    		
    		case 4: 
    			result = Division(Integer.parseInt(first), Integer.parseInt(second));
    			break;
    			
    		case 5:
    			result = Exponent(Integer.parseInt(first), Integer.parseInt(second));
    			break;
    		
    		default: 
    			result= 0;
    		
    		}
    		
    		switch(base)
    		{
    		case "hex": 
    			displayField.setText(DecimalToHex(result));
    			break;
    		case "oct":
    			displayField.setText(DecimalToOct(result));
    			break;
    		case "bin":
    			displayField.setText(DecimalToBinary(result));
    			break;
    		case "dec":
    			displayField.setText(Integer.toString(result));
    			break;
    		}
    		
    		realtime(displayField.getText(), base);
    		
    	}
    	
    }
    
    // converts hex to decimal
    public static int HexToDecimal(String hex) {
		
		int decimal = Integer.parseInt(hex, 16);
		return decimal;	 
	 }
	 
    // converts octal to decimal
	 public static int OctalToDecimal(String oct) {
			
		 int decimal = Integer.parseInt(oct,8); 
		 return decimal; 
	 }
	 
	 // converts binary to decimal
	 public static int BinaryToDecimal(String binary) {
			
		 int decimal = Integer.parseInt(binary,2); 
		 return decimal; 
	 }
	 
	 // converts decimal to hex
	 public static String DecimalToHex(int decimal) {
		
		 String hex = Integer.toHexString(decimal);
		 hex = hex.toUpperCase();
		 return hex; 
	 }
	 
	 // converts decimal to octal
	 public static String DecimalToOct(int decimal) {
			
		 String octal = Integer.toOctalString(decimal);
		 return octal; 
	 }
	 
	 // converts decimal to binary
	 public static String DecimalToBinary(int decimal) {
			
		 String binary = Integer.toBinaryString(decimal);
		 return binary; 
	 }
	 
	 // addings integers
	 public static int Adding(int num1, int num2) {
		 
		 int decimal = num1 + num2;
		 return decimal;
	 }
	 
	 // subtracts integers
	 public static int Subtracting(int num1, int num2) {
		 
		 int decimal = num1 - num2;
		 return decimal;
	 }
	 
	 // multiplies integers
	 public static int Mult(int num1, int num2) {
		 
		 int decimal = num1 * num2;
		 return decimal;
	 }
	 
	 // divides integers
	 public static int Division(int num1, int num2) {
		 
		 int decimal = num1 / num2;
		 return decimal;
	 }
	 
	 // does exponents 
	 public static int Exponent(int num1, int ex) {
		 
		 int result = (int) Math.pow(num1, ex);
		 return result;
	 }
	 
	 // square roots
	 public static int square(int num1) {
		 
		 int decimal = (int) Math.sqrt(num1);
		 return decimal;
	 }
	 
	 // converts 
	 public void realtime(String value, String base) {
		 
		 
		 int number;
		 
		 // calls different functions depending on what base user is on
		 if (base == "hex") {
			 number = HexToDecimal(value);
		 }else if (base == "oct") {
			 number = OctalToDecimal(value);
		 }else if (base == "bin") {
			 number = BinaryToDecimal(value);
		 }else {
			 number = Integer.parseInt(value);
		 }
		 
		 
		 // updates all labels
		 decField.setText(Integer.toString(number));
		 hexField.setText(DecimalToHex(number));
		 binField.setText(DecimalToBinary(number));
		 octField.setText(DecimalToOct(number));
		 
	 }
	 
	 // clears all labels
	 public void Clear() {
		 
		 displayField.setText("0");
		 decField.setText("0");
		 hexField.setText("0");
		 binField.setText("0");
		 octField.setText("0");
		 op = 0;
		  
	 }

	@Override
	public void keyPressed(KeyEvent e) {
		
		
	}
	@Override
	public void keyReleased(KeyEvent arg0) {	
	}
	@Override
	public void keyTyped(KeyEvent e) {	
	}
}
