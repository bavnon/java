package com.benny;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTextField;

import javax.swing.JLabel;
import javax.swing.JPanel;
//import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.border.Border;
import javax.swing.border.StrokeBorder;

//Made By Benny Avnon

public class Window {
	public static final int WIDTH = 300, HEIGHT = 220;
	public static final int CWIDTH = 20;
	private JFrame window;
	JTextField txtDigits = new JTextField("                   ");
	//private JLabel lblInfo = new JLabel("");
	//final Matrix pnl = new Matrix(WIDTH, HEIGHT, lblInfo);
	CalculatorManager manager = new CalculatorManager(this);
	public Window() {
		window = new JFrame("Benny's Calc");
		window.setSize(WIDTH, HEIGHT);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setLocationRelativeTo(null);
		window.setLayout(new FlowLayout());
		
		
		//txtDigits.setEditable(false);
		txtDigits.setBackground(Color.lightGray);
		window.add(txtDigits);
		
		JPanel bts = new JPanel();
		
		bts.setLayout( new GridLayout(4,4)); 
		bts.setSize(150, 150);
		//bts.setBorder(new StrokeBorder(null));
		for ( int i = 1; i < 10 ; i++)
		{
			DigitBtn btn = new DigitBtn(i, manager);
			bts.add(btn);
		}
		//bts.add(new DigitBtn(0, manager).setVisible(false));
		bts.add(new DigitBtn(0, manager));
		
		
		JPanel actions = new JPanel();
		
		actions.setLayout( new GridLayout(2,3)); 
		actions.setSize(Window.CWIDTH, 150);
		actions.add(new ActionBtn("+", manager));
		actions.add(new ActionBtn("-", manager));
		actions.add(new ActionBtn("X", manager));
		actions.add(new ActionBtn("/", manager));
		actions.add(new ActionBtn("C", manager));
		actions.add(new ActionBtn("CE", manager));
		actions.add(new EqualsBtn("=", manager));
		KeyStroke ksR = KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, false);
		//btnRight.getInputMap().put(ksR, "pressedRight");
		//btnRight.getActionMap().put("pressedRight", pressedRight);
		//btnRight.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ksR, "pressedRight");
		Action pressedFire = new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				//pnl.fire();
				//pnl.update();
			}
		};
		KeyStroke ksFR = KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, false);
		//btnFire.getInputMap().put(ksFR, "presseFire");
		//btnFire.getActionMap().put("pressedFire", pressedFire);
		//btnFire.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ksFR, "pressedFire");
		//bts.add(btnLeft);
		//bts.add(btnRight);
		//bts.add(btnFire);
		window.add(bts);
		window.add(actions);
		window.setVisible(true);
	}

	public static void main(String[] args) {
		new Window();
	}

	public void setText(String accomulator) {
		txtDigits.setText(accomulator);
		window.repaint();
	}
}


class DigitBtn extends JButton{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int _val;
	CalculatorManager _manager;
	public DigitBtn(int val ,CalculatorManager manager)
	{
		super(""+val);
		setSize(Window.CWIDTH, Window.CWIDTH);
		_val = val;
		_manager = manager;
		 
		this.setAction(new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				manager.pressedDigit(val);
			}
		});
		setText("" + val);  // After - no problem!
		
	}
}


class ActionBtn extends JButton{
	
	private static final long serialVersionUID = 1L;
	String _val;
	CalculatorManager _manager;
	public  ActionBtn(String val ,CalculatorManager manager)
	{
		super(val);
		setSize(Window.CWIDTH, Window.CWIDTH);
		_val = val;
		_manager = manager;
		 
		this.setAction(new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				manager.pressedAction(val);
			}
		});
		setText(val);  // After - no problem!
		
	}
}

class EqualsBtn extends JButton{
	
	private static final long serialVersionUID = 1L;
	String _val;
	CalculatorManager _manager;
	public  EqualsBtn(String val ,CalculatorManager manager)
	{
		super(val);
		setSize(Window.CWIDTH, Window.CWIDTH);
		_val = val;
		_manager = manager;
		 
		this.setAction(new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				manager.pressedEQUAL(val);
			}
		});
		setText(val);  // After - no problem!
		
	}
}