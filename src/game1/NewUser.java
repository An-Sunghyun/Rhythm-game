package game1;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.net.*;
import java.io.*;

public class NewUser extends JFrame {
	
	public JLabel id;
	public JLabel pass;
	public JLabel name;
	public JTextField Tid;
	public JTextField Tpass;
	public JTextField Tname;
	public JButton register;
	Database db = new Database();
	
	NewUser(){
		setTitle("New Client Register");
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
		id = new JLabel("    I    D");
		pass = new JLabel("    Password");
		name = new JLabel("    Nickname");
		Tid = new JTextField("");
		Tpass = new JTextField("");
		Tname = new JTextField("");
		p.setBackground(new Color(255,235,254));
		register.setBackground(new Color(255,250,255));
		register.addActionListener(new MyAC());
		
		c.add(p,BorderLayout.CENTER);
		c.add(register,BorderLayout.SOUTH);
		p.add(id);
		p.add(Tid);
		p.add(name);
		p.add(Tname);
		p.add(pass);
		p.add(Tpass);
		
		setVisible(true);
	}
	
	//ActionListner that sends information to Login Class
	class MyAC implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if((JButton)e.getSource()==register) {
				String id = Tid.getText();
				String pass = Tpass.getText();
				String name = Tname.getText();
				String confirm = db.newUser(id, pass, name);
				if(confirm.equals("Success")) {
					setVisible(false);
					new Login();
				}
				}
			}
		}
	
    	
}