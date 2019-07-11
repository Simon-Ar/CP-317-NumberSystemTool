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
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


// break when its too large
public class GUI implements ActionListener, KeyListener{
	
	private static final int WIDTH = 1900;
    private static final int HEIGHT = 1000;
    private JLabel 	displayField, hexField, decField, binField, octField;
    private JRadioButton hex, dec, oct, bin;
    private String base;
    private JButton oneBtn, twoBtn, threeBtn, fourBtn, fiveBtn, sixBtn, sevenBtn, eightBtn, nineBtn, zeroBtn;
    private JButton aBtn, bBtn, cBtn, dBtn, eBtn, fBtn;
    private JButton addBtn, subBtn, multBtn, divBtn,equalsBtn, clearBtn;
    static int operator=0;
    
    public GUI() {
    	
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
    	
    	ButtonGroup group = new ButtonGroup();
    	group.add(hex);
    	group.add(oct);
    	group.add(bin);
    	group.add(dec);
    	
    	JPanel one = new JPanel();
    	JPanel two = new JPanel();
    	JPanel five = new JPanel();
    	JPanel six = new JPanel();
    	JPanel textPanel = new JPanel(new GridLayout(4, 2));
    	textPanel.add(hex);
    	textPanel.add(hexField);
    	textPanel.add(oct);
    	textPanel.add(octField);
    	textPanel.add(dec);
    	textPanel.add(decField);
    	textPanel.add(bin);
    	textPanel.add(binField);
    	
    	JFrame frame = new JFrame("Calculator");
        frame.setTitle("Calculator");
        frame.setSize(WIDTH, HEIGHT);

        JPanel buttonPanel = new JPanel(new GridLayout(4, 3));        
        displayField = new JLabel("0");  
        displayField.setFont(new Font("Times New Roman", Font.BOLD, 40));
        
        frame.setLayout( new GridLayout(3,3));
        
        frame.add(one);
        frame.add(two);
        frame.add(displayField);
    	
    	zeroBtn = new JButton("0");
    	zeroBtn.addActionListener(this);
    	zeroBtn.setBackground(Color.WHITE);
    	buttonPanel.add(zeroBtn);
    	
    	oneBtn = new JButton("1");
    	oneBtn.addActionListener(this);
    	oneBtn.setBackground(Color.WHITE);
    	buttonPanel.add(oneBtn);
    	
    	twoBtn = new JButton("2");
    	twoBtn.addActionListener(this);
    	twoBtn.setBackground(Color.WHITE);
    	buttonPanel.add(twoBtn);
    	
    	threeBtn = new JButton("3");
    	threeBtn.addActionListener(this);
    	threeBtn.setBackground(Color.WHITE);
    	buttonPanel.add(threeBtn);
    	
    	fourBtn = new JButton("4");
    	fourBtn.addActionListener(this);
    	fourBtn.setBackground(Color.WHITE);
    	buttonPanel.add(fourBtn);
    	
    	fiveBtn = new JButton("5");
    	fiveBtn.addActionListener(this);
    	fiveBtn.setBackground(Color.WHITE);
    	buttonPanel.add(fiveBtn);
    	
    	sixBtn = new JButton("6");
    	sixBtn.addActionListener(this);
    	sixBtn.setBackground(Color.WHITE);
    	buttonPanel.add(sixBtn);
    	
    	sevenBtn = new JButton("7");
    	sevenBtn.addActionListener(this);
    	sevenBtn.setBackground(Color.WHITE);
    	buttonPanel.add(sevenBtn);
    	
    	eightBtn = new JButton("8");
    	eightBtn.addActionListener(this);
    	eightBtn.setBackground(Color.WHITE);
    	buttonPanel.add(eightBtn);
    	
    	nineBtn = new JButton("9");
    	nineBtn.addActionListener(this);
    	nineBtn.setBackground(Color.WHITE);
    	buttonPanel.add(nineBtn);
    	
    	JPanel alpPanel = new JPanel(new GridLayout(4, 3));
    	
    	aBtn = new JButton("A");
    	aBtn.addActionListener(this);
    	aBtn.setBackground(Color.WHITE);
    	aBtn.setEnabled(false);
    	alpPanel.add(aBtn);
    	
    	bBtn = new JButton("B");
    	bBtn.addActionListener(this);
    	bBtn.setBackground(Color.WHITE);
    	bBtn.setEnabled(false);
    	alpPanel.add(bBtn);
    	
    	cBtn = new JButton("C");
    	cBtn.addActionListener(this);
    	cBtn.setBackground(Color.WHITE);
    	cBtn.setEnabled(false);
    	alpPanel.add(cBtn);
    	
    	dBtn = new JButton("D");
    	dBtn.addActionListener(this);
    	dBtn.setBackground(Color.WHITE);
    	dBtn.setEnabled(false);
    	alpPanel.add(dBtn);
    	
    	eBtn = new JButton("E");
    	eBtn.addActionListener(this);
    	eBtn.setBackground(Color.WHITE);
    	eBtn.setEnabled(false);
    	alpPanel.add(eBtn);
    	
    	fBtn = new JButton("F");
    	fBtn.addActionListener(this);
    	fBtn.setBackground(Color.WHITE);
    	fBtn.setEnabled(false);
    	alpPanel.add(fBtn);
    	
    	JPanel fPanel = new JPanel(new GridLayout(5, 1));
    	
    	
    	addBtn = new JButton("+");
    	addBtn.setBackground(Color.WHITE);
    	addBtn.addActionListener(this);
    	
    	subBtn = new JButton("-");
    	subBtn.setBackground(Color.WHITE);
    	subBtn.addActionListener(this);
    	
    	multBtn = new JButton("*");
    	multBtn.setBackground(Color.WHITE);
    	multBtn.addActionListener(this);
    	
    	divBtn = new JButton("/");
    	divBtn.setBackground(Color.WHITE);
    	divBtn.addActionListener(this);
    	
    	equalsBtn = new JButton("=");
    	equalsBtn.setBackground(Color.WHITE);
    	equalsBtn.addActionListener(this);
    	
    	clearBtn = new JButton("C");
    	clearBtn.setBackground(Color.WHITE);
    	clearBtn.addActionListener(this);
    	
    	fPanel.add(addBtn);
    	fPanel.add(subBtn);
    	fPanel.add(multBtn);
    	fPanel.add(divBtn);
    	fPanel.add(equalsBtn);
    	fPanel.add(clearBtn);
    	
    	
    	frame.add(textPanel);
    	frame.add(five);
    	frame.add(six); 
    	frame.add(fPanel);
    	frame.add(alpPanel);
    	frame.add(buttonPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    	
    }

	public static void main(String[] args) {
    	
    	new GUI();
        
    }
    
    public void actionPerformed(ActionEvent e){
    	
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
    		
    	}
    	
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
    		
    	}
    	
    	if (e.getSource() == zeroBtn) {
    		displayField.setText(displayField.getText().concat("0"));
    		realtime(displayField.getText(), base);
    	}
    	
    	if (e.getSource() == oneBtn) {
    		displayField.setText(displayField.getText().concat("1"));
    		realtime(displayField.getText(), base);
    	}
    	
    	if (e.getSource() == twoBtn) {
    		displayField.setText(displayField.getText().concat("2"));
    		realtime(displayField.getText(), base);
    	}
    	
    	if (e.getSource() == threeBtn) {
    		displayField.setText(displayField.getText().concat("3"));
    		realtime(displayField.getText(), base);
    	}
    	
    	if (e.getSource() == fourBtn) {
    		displayField.setText(displayField.getText().concat("4"));
    		realtime(displayField.getText(), base);
    	}
    	
    	if (e.getSource() == fiveBtn) {
    		displayField.setText(displayField.getText().concat("5"));
    		realtime(displayField.getText(), base);
    	}
    	
    	if (e.getSource() == sixBtn) {
    		displayField.setText(displayField.getText().concat("6"));
    		realtime(displayField.getText(), base);
    	}
    	
    	
    	if (e.getSource() == sevenBtn) {
    		displayField.setText(displayField.getText().concat("7"));
    		realtime(displayField.getText(), base);
    	}
    	
    	if (e.getSource() == eightBtn) {
    		displayField.setText(displayField.getText().concat("8"));
    		realtime(displayField.getText(), base);
    	}
    	
    	if (e.getSource() == nineBtn) {
    		displayField.setText(displayField.getText().concat("9"));
    		realtime(displayField.getText(), base);
    	}
    	
    	if (e.getSource() == aBtn) {
    		displayField.setText(displayField.getText().concat("a"));
    		realtime(displayField.getText(), base);
    	}
    	
    	if (e.getSource() == bBtn) {
    		displayField.setText(displayField.getText().concat("b"));
    		realtime(displayField.getText(), base);
    	}
    	
    	if (e.getSource() == cBtn) {
    		displayField.setText(displayField.getText().concat("c"));
    		realtime(displayField.getText(), base);
    	}
    	
    	if (e.getSource() == dBtn) {
    		displayField.setText(displayField.getText().concat("d"));
    		realtime(displayField.getText(), base);
    	}
    	
    	if (e.getSource() == eBtn) {
    		displayField.setText(displayField.getText().concat("e"));
    		realtime(displayField.getText(), base);
    	}
    	
    	if (e.getSource() == fBtn) {
    		displayField.setText(displayField.getText().concat("f"));
    		realtime(displayField.getText(), base);
    	}
    	
    	if (e.getSource() == clearBtn) {
    		Clear();
    	}
    	
    }
    public static int HexToDecimal(String hex) {
		
		int decimal = Integer.parseInt(hex, 16);
		return decimal;	 
	 }
	 
	 public static int OctalToDecimal(String oct) {
			
		 int decimal = Integer.parseInt(oct,8); 
		 return decimal; 
	 }
	 
	 public static int BinaryToDecimal(String binary) {
			
		 int decimal = Integer.parseInt(binary,2); 
		 return decimal; 
	 }
	 
	 public static String DecimalToHex(int decimal) {
		
		 String hex = Integer.toHexString(decimal);
		 return hex; 
	 }
	 public static String DecimalToOct(int decimal) {
			
		 String octal = Integer.toOctalString(decimal);
		 return octal; 
	 }
	 public static String DecimalToBinary(int decimal) {
			
		 String binary = Integer.toBinaryString(decimal);
		 return binary; 
	 }
	 
	 public static int Adding(int num1, int num2) {
		 
		 int decimal = num1 + num2;
		 return decimal;
	 }
	 
	 public static int Subtracting(int num1, int num2) {
		 
		 int decimal = num1 - num2;
		 return decimal;
	 }
	 
	 public static int Mult(int num1, int num2) {
		 
		 int decimal = num1 * num2;
		 return decimal;
	 }
	 
	 public static int Division(int num1, int num2) {
		 
		 int decimal = num1 / num2;
		 return decimal;
	 }
	 
	 public static int Exponent(int num1, int ex) {
		 
		 int result = (int) Math.pow(num1, ex);
		 return result;
	 }

	 public static int square(int num1) {
		 
		 int decimal = (int) Math.sqrt(num1);
		 return decimal;
	 }
	 
	 public void realtime(String value, String base) {
		 
		 
		 int number;
		 if (base == "hex") {
			 number = HexToDecimal(value);
		 }else if (base == "oct") {
			 number = OctalToDecimal(value);
		 }else if (base == "bin") {
			 number = BinaryToDecimal(value);
		 }else {
			 number = Integer.parseInt(value);
		 }
		 
		 decField.setText(Integer.toString(number));
		 hexField.setText(DecimalToHex(number));
		 binField.setText(DecimalToBinary(number));
		 octField.setText(DecimalToOct(number));
		 
	 }
	 
	 public void Clear() {
		 
		 displayField.setText("0");
		 decField.setText("0");
		 hexField.setText("0");
		 binField.setText("0");
		 octField.setText("0");
		  
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
