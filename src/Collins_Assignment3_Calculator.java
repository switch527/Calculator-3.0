import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class Collins_Assignment3_Calculator extends JFrame {
	private JTextField answerField;
	private JButton one, two, three, four, five, six, seven, eight, nine, zero, add, sub, mult, div, 
	equ, dec, ms, mr, mc, mPlus, mMinus, clear;
	private String s1, s2, sTemp, sTemp2, sTemp3, opTemp, op1, m1, r1;
	boolean iFlag1 = false, iFlag2 = false, iFlag3 = false, opFlag1 = false, opFlag2 = false, opFlagCheck = false,
	opFlag1Temp = false, opFlag2Temp = false, haveAnswer = false;
	private boolean opNeeded = true;
	private double double1 = 0.0, double2 = 0.0, doubleAns = 0.0, dubMem = 0.0, dubModulus = 0.0;
	private int int1 = 0, int2 = 0, intMem = 0, intAns = 0;
	private JPanel contentPanel;
	Operation op = new Operation();
	
	public static void main(String[] args) {
		Collins_Assignment3_Calculator g = new Collins_Assignment3_Calculator();
		g.setSize(200, 275);
		g.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		g.setVisible(true);
		g.setResizable(false);
	}
	
	public Collins_Assignment3_Calculator() {
		super("Calculator");
		
		answerField = new JTextField(null, 16);
		answerField.setEditable(false);
		
		one = new JButton("1"); two = new JButton("2"); three = new JButton("3");
		four = new JButton("4"); five = new JButton("5"); six = new JButton("6");
		seven = new JButton("7"); eight = new JButton("8"); nine = new JButton("9");
		zero = new JButton("0");
		add = new JButton("+"); sub = new JButton("-"); mult = new JButton("*"); div = new JButton("/");
		equ = new JButton("="); dec = new JButton(".");
		ms = new JButton("MS"); mr = new JButton("MR"); mc = new JButton("MC");
		mPlus = new JButton("M+"); mMinus = new JButton("M-");
		clear = new JButton("C");
		
		Dimension z = new Dimension(87, 25);
		Dimension opDim = new Dimension(41, 25);
		Dimension num = new Dimension(41, 25);
		Dimension mem = new Dimension(56, 25);
		Dimension eq = new Dimension(180, 25);
		
		
		ms.setPreferredSize(mem); mr.setPreferredSize(mem); mc.setPreferredSize(mem); 
		mPlus.setPreferredSize(mem); mMinus.setPreferredSize(mem); clear.setPreferredSize(mem);
		add.setPreferredSize(opDim); sub.setPreferredSize(opDim); mult.setPreferredSize(opDim); div.setPreferredSize(opDim);
		one.setPreferredSize(num); two.setPreferredSize(num); three.setPreferredSize(num);
		four.setPreferredSize(num); five.setPreferredSize(num); six.setPreferredSize(num);
		seven.setPreferredSize(num); eight.setPreferredSize(num); nine.setPreferredSize(num);
		zero.setPreferredSize(z);
		dec.setPreferredSize(opDim);
		equ.setPreferredSize(eq);
		
		//Action listeners
		Number n = new Number();
		Operation o = new Operation();
		Memory m = new Memory();
		Equals e = new Equals();
		Clear c = new Clear();
		//Action listeners on buttons
		one.addActionListener(n); two.addActionListener(n); three.addActionListener(n); 
		four.addActionListener(n); five.addActionListener(n); six.addActionListener(n); 
		seven.addActionListener(n); eight.addActionListener(n); nine.addActionListener(n); 
		zero.addActionListener(n); dec.addActionListener(n); 
		add.addActionListener(o); sub.addActionListener(o); mult.addActionListener(o); div.addActionListener(o);
		ms.addActionListener(m); mr.addActionListener(m); mc.addActionListener(m); mPlus.addActionListener(m); mMinus.addActionListener(m);
		equ.addActionListener(e); 
		clear.addActionListener(c);
		
		contentPanel = new JPanel();
		contentPanel.setBackground(Color.black);
		contentPanel.setLayout(new FlowLayout());
		
		contentPanel.add(answerField, BorderLayout.NORTH);
		
		contentPanel.add(mr); contentPanel.add(ms); contentPanel.add(mc); 
		contentPanel.add(mPlus); contentPanel.add(mMinus); contentPanel.add(clear);
		contentPanel.add(one); contentPanel.add(two); contentPanel.add(three); contentPanel.add(add);
		contentPanel.add(four); contentPanel.add(five); contentPanel.add(six); contentPanel.add(sub);
		contentPanel.add(seven); contentPanel.add(eight); contentPanel.add(nine); contentPanel.add(mult);
		contentPanel.add(zero); contentPanel.add(dec); contentPanel.add(div);
		contentPanel.add(equ); 
		
		this.setContentPane(contentPanel);
	}
	
	private class Number implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			JButton src = (JButton) event.getSource();
			
			// erases temporary variables on numeric action event
			if (src.equals(one) || src.equals(two) || src.equals(three) || src.equals(four) 
			|| src.equals(five) || src.equals(six) || src.equals(seven) || src.equals(eight) 
			|| src.equals(nine) || src.equals(zero) || src.equals(dec)) {
			sTemp = null;
			sTemp2 = null;
			sTemp3 = null;
			haveAnswer = false;
			}
			// enters numbers 0 - 9 and . through string concatenation
			if(src.equals(one)) {
				if(opNeeded==true) {
					if(s1==null) {
						s1 = "1";
					} 
					else {
						s1 += "1";
					}
				} 
				else {
					if(s2==null) {
						s2 = "1";
					} 
					else {
						s2 += "1";
					}
				}
			}
			
			if(src.equals(two)) {
				if(opNeeded==true) {
					if(s1==null) {
						s1 = "2";
					} 
					else {
						s1 += "2";
					}
				} 
				else {
					if(s2==null) {
						s2 = "2";
					}
					else {
						s2 += "2";
					}
				}
			}
			
			if(src.equals(three)) {
				if(opNeeded==true) {
					if(s1==null) {
						s1 = "3";
					} 
					else {
						s1 += "3";
					}
				} 
				else {
					if(s2==null) {
						s2 = "3";
					} 
					else {
						s2 += "3";
					}
				}
			}
			
			if(src.equals(four)) {
				if(opNeeded==true) {
					if(s1==null) {
						s1 = "4";
					} 
					else {
						s1 += "4";
					}
				} 
				else {
					if(s2==null) {
						s2 = "4";
					} 
					else {
						s2 += "4";
					}
				}
			}
			
			if(src.equals(five)) {
				if(opNeeded==true) {
					if(s1==null) {
						s1 = "5";
					} 
					else {
						s1 += "5";
					}
				} 
				else {
					if(s2==null) {
						s2 = "5";
					} 
					else {
						s2 += "5";
					}
				}
			}
			
			if(src.equals(six)) {
				if(opNeeded==true) {
					if(s1==null) {
						s1 = "6";
					} 
					else {
						s1 += "6";
					}
				} 
				else {
					if(s2==null) {
						s2 = "6";
					} 
					else {
						s2 += "6";
					}
				}
			}
			
			if(src.equals(seven)) {
				if(opNeeded==true) {
					if(s1==null) {
						s1 = "7";
					} 
					else {
						s1 += "7";
					}
				} 
				else {
					if(s2==null) {
						s2 = "7";
					} 
					else {
						s2 += "7";
					}
				}
			}
			
			if(src.equals(eight)) {
				if(opNeeded==true) {
					if(s1==null) {
						s1 = "8";
					} 
					else {
						s1 += "8";
					}
				} 
				else {
					if(s2==null) {
						s2 = "8";
					} 
					else {
						s2 += "8";
					}
				}
			}
			
			if(src.equals(nine)) {
				if(opNeeded==true) {
					if(s1==null) {
						s1 = "9";
					} 
					else {
						s1 += "9";
					}
				} 
				else {
					if(s2==null) {
						s2 = "9";
					} 
					else {
						s2 += "9";
					}
				}
			}
			
			if(src.equals(zero)) {
				if(opNeeded==true) {
					if(s1==null) {
						s1 = "0";
					} 
					else {
						s1 += "0";
					}
				} 
				else {
					if(s2==null) {
						s2 = "0";
					} 
					else {
						s2 += "0";
					}
				}
			}
			
			if(src.equals(dec)) {
				if(opNeeded==true) {
					if(s1==null) {
						s1 = ".";
					} 
					else {
						s1 += ".";
					}
				} 
				else {
					if(s2==null) {
						s2 = ".";
					} 
					else {
						s2 += ".";
					}
				}
			}
			// displays either the first or second number depending on whether or not an operator has already been entered
			if(opNeeded==true) {
				answerField.setText(s1);
			} 
			else {
				answerField.setText(s2);
			}
		}
	}
	
	public class Operation implements ActionListener {
		// operation methods
		int add(int a, int b) {
			int c = a + b;
			return c;
		}
		double add(int a, double b) {
			double c = a + b;
			return c;
		}
		double add(double a, int b) {
			double c = a + b;
			return c;
		}
		double add(double a, double b) {
			double c = a + b;
			return c;
		}
		int subtract(int a, int b) {
			int c = a - b;
			return c;
		}
		double subtract(int a, double b) {
			double c = a - b;
			return c;
		}
		double subtract(double a, int b) {
			double c = a - b;
			return c;
		}
		double subtract(double a, double b) {
			double c = a - b;
			return c;
		}
		int multiply(int a, int b) {
			int c = a * b;
			return c;
		}
		double multiply(int a, double b) {
			double c = a * b;
			return c;
		}
		double multiply(double a, int b) {
			double c = a * b;
			return c;
		}
		double multiply(double a, double b) {
			double c = a * b;
			return c;
		}
		double divide(int a, double b) {
			if (a == 0 || b == 0.0) {
				return 0;
			}
			else {
			double c = a / b;
			return c;
			}
		}
		double divide(double a, int b) {
			if (a == 0.0 || b == 0) {
				return 0;
			}
			else {
			double c = a / b;
			return c;
			}
		}
		double divide(double a, double b) {
			if (a == 0.0 || b == 0.0) {
				return 0;
			}
			else {
			double c = a / b;
			return c;
			}
		}
		double modulus(int a, int b) {
			if (a == 0 || b == 0) {
				return 0;
			}
			else {
			double c = a % b;
			return c;
			}
		}
		double modulus(int a, double b) {
			if (a == 0 || b == 0.0) {
				return 0;
			}
			else {
			double c = a % b;
			return c;
			}
		}
		double modulus(double a, int b) {
			if (a == 0.0 || b == 0) {
				return 0;
			}
			else {
			double c = a % b;
			return c;
			}
		}
		double modulus(double a, double b) {
			if (a == 0.0 || b == 0.0) {
				return 0;
			}
			else {
			double c = a % b;
			return c;
			}
		}
		// what to do when an operation is pushed
		public void actionPerformed(ActionEvent event) {
			JButton src = (JButton) event.getSource();
			
			if(src.equals(add)) {
				if (s1 == null && m1 != null && m1 == sTemp && r1 == null) {
					s1 = sTemp;
				}
				else if (s1 == null && m1 == null && r1 == null) {
					s1 = "0";
				}
				else if (s1 == null && r1 != null) {
					s1 = r1;
				}
				op1 = "+";
				opFlag1 = true; opFlag2 = true; opFlagCheck = true;
				opNeeded = false;
				answerField.setText(op1);
			}
			// if entered first, makes the first number negative, entered after an operation and while second number is null, makes second number negative
			if(src.equals(sub)) {
				if (s1 == null && sTemp == null){
					s1 = "-";
					answerField.setText(s1);
				}
				else if (s1 == "-" && opNeeded == true && opFlagCheck == false) {
					
				}
				else if (s1 != null && opNeeded == false && opFlagCheck == true && s2 == null) {
					s2 = "-";
					answerField.setText(s2);
				}
				else if (s1 == null && m1 != null && m1 == sTemp && r1 == null) {
					s1 = sTemp;
					op1 = "-";
					opFlag1 = true; opFlag2 = false; opFlagCheck = true;
					opNeeded = false;
					answerField.setText(op1);
				} 
				else if (s1 == null && r1 != null) {
					s1 = r1;
					op1 = "-";
					opFlag1 = true; opFlag2 = false; opFlagCheck = true;
					opNeeded = false;
					answerField.setText(op1);
				}
				else {
					op1 = "-";
					opFlag1 = true; opFlag2 = false; opFlagCheck = true;
					opNeeded = false;
					answerField.setText(op1);
				}
			}
			
			if(src.equals(mult)) {
				if (s1 == null && m1 != null && m1 == sTemp && r1 == null) {
					s1 = sTemp;
				}
				else if (s1 == null && m1 == sTemp && r1 == null) {
					s1 = "0";
				} 
				else if (s1 == null && r1 != null) {
					s1 = r1;
				}
				op1 = "*";
				opFlag1 = false; opFlag2 = true; opFlagCheck = true;
				opNeeded = false;
				//answerField.setText(op1);
			}
			
			if(src.equals(div)) {
				if (s1 == null && m1 != null && m1 == sTemp && r1 == null) {
					s1 = sTemp;
				}
				else if (s1 == null && m1 == sTemp && r1 == null) {
					s1 = "0";
				}
				else if (s1 == null && r1 != null) {
					s1 = r1;
				}
				op1 = "/";
				opFlag1 = false; opFlag2 = false; opFlagCheck = true;
				opNeeded = false;
				answerField.setText(op1);
				if (s1 == "0") {
					clear.doClick();
					answerField.setText("Can not divide by zero");
				}
			}
		}
	}
	
	private class Equals implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			JButton src = (JButton) event.getSource();
			if(src.equals(equ)) {
			
			//String parsing
			if (opFlag1 == false && opFlag2 == false && s1 == "0" || s2 == "0") {
				clear.doClick();
				answerField.setText("Can not divide by zero");
			}
			if (opFlagCheck == true) {
				if (s2 == null && sTemp != null) {
					s2 = sTemp;	
				}
			
			iFlag1 = true;
			for (int loop = 0; loop < s1.length(); loop++) {
				if (s1.charAt(loop) == '.') iFlag1 = false;
			}
			
			if (iFlag1) int1 = Integer.parseInt(s1);
			double1 = Double.parseDouble(s1);
			
			iFlag2 = true;
			for (int loop = 0; loop < s2.length(); loop++) {
				if (s2.charAt(loop) == '.') iFlag2 = false;
			}
			
			if (iFlag2) int2 = Integer.parseInt(s2);
			double2 = Double.parseDouble(s2);
			
			if (m1 != null) {
			iFlag3 = true;
			for (int loop = 0; loop < m1.length(); loop++) {
				if (m1.charAt(loop) == '.') iFlag3 = false;
			}
			
			if (iFlag3) intMem = Integer.parseInt(m1);
			dubMem = Double.parseDouble(m1);
			}
			}
			compute();
			}
		}
			void compute() {
			//Calculation
			//Addition
				if (iFlag1 && iFlag2 && opFlagCheck && opFlag1 && opFlag2) {
					doubleAns = (double) op.add(int1, int2);
					intAns = (int) op.add(int1, int2);
					
					if (doubleAns == intAns) {
						r1 = Integer.toString(op.add(int1, int2));
					}
					else {
						r1 = Double.toString(op.add(int1, int2));
					}
					answerField.setText(r1);
				}
				else if (!iFlag1 && iFlag2 && opFlagCheck && opFlag1 && opFlag2) {
					doubleAns = (double) op.add(double1, int2);
					intAns = (int) op.add(double1, int2);
					
					if (doubleAns == intAns) {
						r1 = Integer.toString((int) op.add(double1,  int2));
					}
					else {
					r1 = Double.toString(op.add(double1, int2));
					}
					answerField.setText(r1);
				}
				else if (iFlag1 && !iFlag2 && opFlagCheck && opFlag1 && opFlag2) {
					doubleAns = (double) op.add(int1, double2);
					intAns = (int) op.add(int1, double2);
					
					if (doubleAns == intAns) {
						r1 = Integer.toString((int) op.add(int1, double2));
					}
					else {
						r1 = Double.toString(op.add(int1, double2));
					}
					answerField.setText(r1);
				}
				else if (!iFlag1 && !iFlag2 && opFlagCheck && opFlag1 && opFlag2) {
					doubleAns = (double) op.add(double1, double2);
					intAns = (int) op.add(double1, double2);
					
					if (doubleAns == intAns) {
						r1 = Integer.toString((int) op.add(double1, double2));
						
					}
					else {
						r1 = Double.toString(op.add(double1, double2));
					}
					answerField.setText(r1);
				}
				//Subtraction
				if (iFlag1 && iFlag2 && opFlagCheck && opFlag1 && !opFlag2) {
					doubleAns = (double) op.subtract(int1, int2);
					intAns = (int) op.subtract(int1, int2);
					
					if (doubleAns == intAns) {
						r1 = Integer.toString(op.subtract(int1, int2));
					}
					else {
						r1 = Double.toString(op.subtract(int1, int2));
					}
					answerField.setText(r1);
				}
				else if (!iFlag1 && iFlag2 && opFlagCheck && opFlag1 && !opFlag2) {
					doubleAns = (double) op.subtract(double1, int2);
					intAns = (int) op.subtract(double1, int2);
					
					if (doubleAns == intAns) {
						r1 = Integer.toString((int) op.subtract(double1,  int2));
					}
					else {
					r1 = Double.toString(op.subtract(double1, int2));
					}
					answerField.setText(r1);
				}
				else if (iFlag1 && !iFlag2 && opFlagCheck && opFlag1 && !opFlag2) {
					doubleAns = (double) op.subtract(int1, double2);
					intAns = (int) op.subtract(int1, double2);
					
					if (doubleAns == intAns) {
						r1 = Integer.toString((int) op.subtract(int1, double2));
					}
					else {
						r1 = Double.toString(op.subtract(int1, double2));
					}
					answerField.setText(r1);
				}
				else if (!iFlag1 && !iFlag2 && opFlagCheck && opFlag1 && !opFlag2) {
					doubleAns = (double) op.subtract(double1, double2);
					intAns = (int) op.subtract(double1, double2);
					
					if (doubleAns == intAns) {
						r1 = Integer.toString((int) op.subtract(double1, double2));
						
					}
					else {
						r1 = Double.toString(op.subtract(double1, double2));
					}
					answerField.setText(r1);
				}
				//Multiplication
				if (iFlag1 && iFlag2 && opFlagCheck && !opFlag1 && opFlag2) {
					doubleAns = (double) op.multiply(int1, int2);
					intAns = (int) op.multiply(int1, int2);
					
					if (doubleAns == intAns) {
						r1 = Integer.toString(op.multiply(int1, int2));
					}
					else {
						r1 = Double.toString(op.multiply(int1, int2));
					}
					answerField.setText(r1);
				}
				else if (!iFlag1 && iFlag2 && opFlagCheck && !opFlag1 && opFlag2) {
					doubleAns = (double) op.multiply(double1, int2);
					intAns = (int) op.multiply(double1, int2);
					
					if (doubleAns == intAns) {
						r1 = Integer.toString((int) op.multiply(double1,  int2));
					}
					else {
					r1 = Double.toString(op.multiply(double1, int2));
					}
					answerField.setText(r1);
				}
				else if (iFlag1 && !iFlag2 && opFlagCheck && !opFlag1 && opFlag2) {
					doubleAns = (double) op.multiply(int1, double2);
					intAns = (int) op.multiply(int1, double2);
					
					if (doubleAns == intAns) {
						r1 = Integer.toString((int) op.multiply(int1, double2));
					}
					else {
						r1 = Double.toString(op.multiply(int1, double2));
					}
					answerField.setText(r1);
				}
				else if (!iFlag1 && !iFlag2 && opFlagCheck && !opFlag1 && opFlag2) {
					doubleAns = (double) op.multiply(double1, double2);
					intAns = (int) op.multiply(double1, double2);
					
					if (doubleAns == intAns) {
						r1 = Integer.toString((int) op.multiply(double1, double2));
					}
					else {
						r1 = Double.toString(op.multiply(double1, double2));
					}
					answerField.setText(r1);
				}
				//Division
				else if (iFlag1 && iFlag2 && opFlagCheck && !opFlag1 && !opFlag2) {
					doubleAns = (double) op.divide(double1, double2);
					intAns = (int) op.divide(double1, double2);
					dubModulus = op.modulus(double1, double2);
					if (dubModulus == 0.0 && doubleAns == intAns) {
						r1 = Integer.toString(intAns);
						answerField.setText(r1);
					}
					else {
						r1 = Double.toString(doubleAns);
						answerField.setText(r1);
					}
				}
				else if (!iFlag1 && iFlag2 && opFlagCheck && !opFlag1 && !opFlag2) {
					doubleAns = (double) op.divide(double1, int2);
					intAns = (int) op.divide(double1, int2);
					if (doubleAns == intAns) {
						r1 = Integer.toString((int) op.divide(double1,  int2));
					}
					else {
					r1 = Double.toString(op.divide(double1, int2));
					}
					answerField.setText(r1);
				}
				else if (iFlag1 && !iFlag2 && opFlagCheck && !opFlag1 && !opFlag2) {
					doubleAns = (double) op.divide(int1, double2);
					intAns = (int) op.divide(int1, double2);
					if (doubleAns == intAns) {
						r1 = Integer.toString((int) op.divide(int1, double2));
					}
					else {
						r1 = Double.toString(op.divide(int1, double2));
					}
					answerField.setText(r1);
				}
				else if (!iFlag1 && !iFlag2 && opFlagCheck && !opFlag1 && !opFlag2) {
					doubleAns = (double) op.divide(double1, double2);
					intAns = (int) op.divide(double1, double2);
					if (doubleAns == intAns) {
						r1 = Integer.toString((int) op.divide(double1, double2));
					}
					else {
						r1 = Double.toString(op.divide(double1, double2));
					}
					answerField.setText(r1);
				}
				else if (opFlagCheck == false && sTemp != null && sTemp2 != null) {
					s1 = sTemp;
					s2 = sTemp2;
					sTemp3 = sTemp2;
					op1 = opTemp;
					opFlagCheck = true;
					opNeeded = false;
					equ.doClick();

				}
				if (s2 != null) {
					sTemp2 = s2;
				}
				else {
					sTemp2 = sTemp3;
				}
				opTemp = op1;
				sTemp = r1;
				haveAnswer = true;
				s1 = null;
				s2 = null;
				op1 = null;
				opNeeded = true;
				opFlagCheck = false;
			}	
	}	
		
	private class Memory implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			JButton src = (JButton) event.getSource();
			if(src.equals(ms)) {
				if (s1 == null && opNeeded == true && s2 == null && r1 == null) {
					m1 = null;
				}
				else if (s1 != null && opNeeded == true) {
					m1 = s1;
					sTemp = s1;
					s1 = null;
				}
				else if (s1 != null && opNeeded == false && s2 == null) {
					m1 = s1;
					sTemp = s1;
					s1 = null;
				}
				else if (opNeeded == false && s2 != null) {
					m1 = s2;
					sTemp = s2;
				}
				else if (r1 != null) {
					m1 = r1;
					sTemp = r1;
					r1 = null;
				}
				if (m1 != null) {
					ms.setBackground(Color.white);
					mr.setBackground(Color.white);
					mc.setBackground(Color.white);
					mPlus.setBackground(Color.white);
					mMinus.setBackground(Color.white);
				}
				else {
					ms.setBackground(new JButton().getBackground());
					mr.setBackground(new JButton().getBackground());
					mc.setBackground(new JButton().getBackground());
					mPlus.setBackground(new JButton().getBackground());
					mMinus.setBackground(new JButton().getBackground());
				}
			}
			if(src.equals(mr)) {
				if (m1 != null && opNeeded == true) {
					s1 = m1;
					answerField.setText(s1);
				}
				else if (m1 != null) {
					s2 = m1;
					answerField.setText(s2);
				}
			}
			if(src.equals(mc)) {
				m1 = null;
				if (sTemp != null) {
				s1 = sTemp;
				}
				if (m1 != null) {
					ms.setBackground(Color.white);
					mr.setBackground(Color.white);
					mc.setBackground(Color.white);
					mPlus.setBackground(Color.white);
					mMinus.setBackground(Color.white);
				}
				else {
					ms.setBackground(new JButton().getBackground());
					mr.setBackground(new JButton().getBackground());
					mc.setBackground(new JButton().getBackground());
					mPlus.setBackground(new JButton().getBackground());
					mMinus.setBackground(new JButton().getBackground());
				}
			}
			// M+
			if(src.equals(mPlus)) {
				//nothing in memory, save first number
				if (m1 == null && s1 != null && opNeeded == true) {
					m1 = s1;
					sTemp = s1;
					s1 = null;
				}
				// nothing in memory, save second number
				else if (m1 == null && opNeeded == false && s2 != null) {
					m1 = s2;
				}
				// nothing in memory, save result
				else if (m1 == null && s1 == null && s2 == null && r1 != null) {
					m1 = r1;
				}
				// add first number to the number in memory
				else if (opNeeded == true && s1 != null || opNeeded == false && s2 == null && s1 != null) {
					double1 = Double.parseDouble(s1);
					dubMem = Double.parseDouble(m1);
					dubMem += double1;
					intMem = (int) dubMem;
					if (dubMem == intMem) {
						m1 = Integer.toString(intMem);
					}
					else { 
						m1 = Double.toString(dubMem);
					}
					sTemp = s1;
					s1 = null;
				}
				// add second number to the number in memory
				else if (opNeeded == false && s2 != null) {
					double1 = Double.parseDouble(s2);
					dubMem = Double.parseDouble(m1);
					dubMem += double1;
					intMem = (int) dubMem;
					if (dubMem == intMem) {
						m1 = Integer.toString(intMem);
					}
					else { 
						m1 = Double.toString(dubMem);
					}
					sTemp = s2;
					s2 = null;
				}
				// continue adding first or second number to number in memory with consecutive clicks
				else if (s1 == null || s2 == null && sTemp != null) {
					double1 = Double.parseDouble(sTemp);
					dubMem = Double.parseDouble(m1);
					dubMem += double1;
					intMem = (int) dubMem;
					if (dubMem == intMem) {
						m1 = Integer.toString(intMem);
					}
					else { 
						m1 = Double.toString(dubMem);
					}
				}
				// change all memory buttons to white when there is a number in memory
				if (m1 != null) {
					ms.setBackground(Color.white);
					mr.setBackground(Color.white);
					mc.setBackground(Color.white);
					mPlus.setBackground(Color.white);
					mMinus.setBackground(Color.white);
				}
				else {
					ms.setBackground(new JButton().getBackground());
					mr.setBackground(new JButton().getBackground());
					mc.setBackground(new JButton().getBackground());
					mPlus.setBackground(new JButton().getBackground());
					mMinus.setBackground(new JButton().getBackground());
				}
				intMem = 0;
				dubMem = 0.0;
				double1 = 0.0;
			}
			// M-
			if (src.equals(mMinus)) {
				//nothing in memory, save negative first number
				if (m1 == null && s1 != null && opNeeded == true) {
					m1 = "-" + s1;
					sTemp = s1;
					s1 = null;
				}
				//nothing in memory save negative second number
				else if (m1 == null && opNeeded == false && s2 != null) {
					m1 = "-" + s2;
					sTemp = s1;
					s1 = null;
				}
				//nothing in memory save negative result
				else if (m1 == null && s1 == null && s2 == null && r1 != null) {
					m1 = "-" + r1;
				}
				else if (opNeeded == true && s1 != null || opNeeded == false && s2 == null && s1 != null) {
					double1 = Double.parseDouble(s1);
					dubMem = Double.parseDouble(m1);
					dubMem -= double1;
					intMem = (int) dubMem;
					if (dubMem == intMem) {
						m1 = Integer.toString(intMem);
					}
					else { 
						m1 = Double.toString(dubMem);
					}
					sTemp = s1;
					s1 = null;
				}
				else if (opNeeded == false && s2 == null) {
					double1 = Double.parseDouble(s1);
					dubMem = Double.parseDouble(m1);
					dubMem -= double1;
					intMem = (int) dubMem;
					if (dubMem == intMem) {
						m1 = Integer.toString(intMem);
					}
					else { 
						m1 = Double.toString(dubMem);
					}
					sTemp = s1;
					s1 = null;
				}
				else if (opNeeded == false && s2 != null) {
					double1 = Double.parseDouble(s2);
					dubMem = Double.parseDouble(m1);
					dubMem -= double1;
					intMem = (int) dubMem;
					if (dubMem == intMem) {
						m1 = Integer.toString(intMem);
					}
					else { 
						m1 = Double.toString(dubMem);
					}
					sTemp = s1;
					s1 = null;
				}
				else if (s1 == null && sTemp != null) {
					double1 = Double.parseDouble(sTemp);
					dubMem = Double.parseDouble(m1);
					dubMem -= double1;
					intMem = (int) dubMem;
					if (dubMem == intMem) {
						m1 = Integer.toString(intMem);
					}
					else { 
						m1 = Double.toString(dubMem);
					}
				}
				if (m1 != null) {
					ms.setBackground(Color.white);
					mr.setBackground(Color.white);
					mc.setBackground(Color.white);
					mPlus.setBackground(Color.white);
					mMinus.setBackground(Color.white);
				}
				else {
					ms.setBackground(new JButton().getBackground());
					mr.setBackground(new JButton().getBackground());
					mc.setBackground(new JButton().getBackground());
					mPlus.setBackground(new JButton().getBackground());
					mMinus.setBackground(new JButton().getBackground());
				}
				intMem = 0;
				dubMem = 0.0;
				double1 = 0.0;
			}
		}
	}

	private class Clear implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			JButton src = (JButton) event.getSource();
			if(src.equals(clear)) {
				s1 = null; s2 = null; op1 = null; r1 = null;
				sTemp = null; sTemp2 = null; sTemp3 = null;
				iFlag1 = false; iFlag2 = false; iFlag3 = false; opFlag1 = false; opFlag2 = false; opFlagCheck = false;
				opNeeded = true;
				double1 = 0.0; double2 = 0.0; doubleAns = 0.0; dubMem = 0.0; dubModulus = 0.0;
				int1 = 0; int2 = 0; intMem = 0; intAns = 0;
				answerField.setText(null);
				}
		}
	}
}