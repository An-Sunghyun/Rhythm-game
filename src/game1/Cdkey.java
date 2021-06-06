package game1;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.net.*;
import java.io.*;

public class Cdkey extends JFrame {
	
	public JLabel user;
	public JLabel cdkey1;
	public JLabel cdkey2;
	public JTextField Tuser;
	public JTextField Tcdkey1;
	public JTextField Tcdkey2;
	public JButton register;
	Database db = new Database();
	
	Cdkey(){
		setTitle("CD KEY Register");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,200);
		setLocation(500,300);
		setResizable(false);
		Container c = getContentPane();
		JPanel p = new JPanel();
		c.setLayout(new BorderLayout());
		p.setLayout(new GridLayout(3,2));
		
		//Component Setting
		register = new JButton("Register");
		user = new JLabel("       I      D");
		cdkey1 = new JLabel("      Cd  key 1");
		cdkey2 = new JLabel("      Cd  key 2");
		Tuser = new JTextField("");
		Tcdkey1 = new JTextField("");
		Tcdkey2 = new JTextField("");
		p.setBackground(new Color(255,235,254));
		register.setBackground(new Color(255,250,255));
		register.addActionListener(new MyAC());
		
		c.add(p,BorderLayout.CENTER);
		c.add(register,BorderLayout.SOUTH);
		p.add(user);
		p.add(Tuser);
		p.add(cdkey1);
		p.add(Tcdkey1);
		p.add(cdkey2);
		p.add(Tcdkey2);
		
		setVisible(true);
	}
	
	//ActionListner that sends information to Login Class
	class MyAC implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if((JButton)e.getSource()==register) {
				String id = Tuser.getText();
				String Scdkey1 = Tcdkey1.getText();
				String Scdkey2 = Tcdkey2.getText();
				String cdkeyP = Scdkey1+Scdkey2;
				int cdkeyNum = Integer.parseInt(cdkeyP);
				db.updateCdkey(cdkeyNum,id);
				}
			}
		}
    	
}