package game1;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.net.*;
import java.io.*;

//Class that manages all the functions to login
public class Login extends JFrame{

    private JButton btnLogin;
    private JButton btnInit;
    private JButton btnNewC;
    private JPasswordField passText;
    private JTextField userText;
    public boolean bLoginCheck;
    public boolean bRegisterCheck;
    Database db = new Database();
    
    //Constructor
    public Login() {

        // setting
        setTitle("login");
        setSize(280, 150);
        setResizable(false);
        setLocation(800, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // panel
        JPanel panel = new JPanel();
        placeLoginPanel(panel);
        panel.setBackground(new Color(255,235,254));

        // add
        add(panel);

        // visible
        setVisible(true);
    }
    //setting the Components on Panel
    public void placeLoginPanel(JPanel panel){

        panel.setLayout(null);     
        JLabel userLabel = new JLabel("   User  ID");
        userLabel.setBounds(10, 10, 80, 25);
        panel.add(userLabel);
        JLabel passLabel = new JLabel("   Password");
        passLabel.setBounds(10, 40, 80, 25);
        panel.add(passLabel);

        userText = new JTextField(20);
        userText.setBounds(100, 10, 160, 25);
        panel.add(userText);
        
        //passwordField Setting
        passText = new JPasswordField(20);
        passText.setBounds(100, 40, 160, 25);
        panel.add(passText);
        passText.addActionListener(new ActionListener() {          
            @Override
            public void actionPerformed(ActionEvent e) {
                isLoginCheck();        
            }
        });
        //Reset Button Setting
        btnInit = new JButton("Reset");
        btnInit.setBounds(5, 70, 80, 25);
        btnInit.setBackground(new Color(255,250,255));
        panel.add(btnInit);
        btnInit.addActionListener(new MyAC());
        
        //Register Button Setting
        btnNewC = new JButton("Register");
        btnNewC.setBounds(90, 70, 90, 25);
        btnNewC.setBackground(new Color(255,250,255));
        panel.add(btnNewC);
        btnNewC.addActionListener(new MyAC());
        
        //Login Button Setting
        btnLogin = new JButton("Login");
        btnLogin.setBounds(185, 70, 80, 25);
        btnLogin.setBackground(new Color(255,250,255));
        panel.add(btnLogin);
        btnLogin.addActionListener(new MyAC());
    }
    //Method that checks whether the login process succeeded or not
    public void isLoginCheck(){
    	String user = userText.getText(); 
    	String pass =  new String(passText.getPassword()).toString();
    	String dbPass = db.getPassword(user);
    	if(dbPass.equals(pass)) {
    		String confirm = db.getCdkeyResult(user);
    		if(confirm.equals("Success")) {
    		bLoginCheck = true;
    		setVisible(false);
    		new TuneOfHeart(user);
    		}
    		else {new Cdkey();
    		setVisible(false);
    		}}else
    		JOptionPane.showMessageDialog(null, "Failed");
    }
    
    //Action Listener Class
    class MyAC implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if((JButton)e.getSource()==btnInit) {
				userText.setText("");
                passText.setText("");
			}else if((JButton)e.getSource()==btnLogin) {
				isLoginCheck();
			}
			//Connect the socket and send the information to Server Class
			else if((JButton)e.getSource()==btnNewC) {
				setVisible(false);
				new NewUser();
			}
		}
    }

    //Method that returns the result of login
    public boolean isLogin() {     
        return bLoginCheck;
    }
    
  
}