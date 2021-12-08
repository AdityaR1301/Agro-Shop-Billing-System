package Agro;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;

public class Customer2 extends JDialog{
	JLabel l1,l2,l3,l4,l5,l6,l7;
	JTextField t1,t2,t3,t4,t5,t6;
	JPanel p1,p2,p3,p4;
	JButton b1,b2,b3,b4,b5,b6,b7;
	ButtonGroup cbg;
	JRadioButton ch1,ch2;
	Connection con;
	ResultSet rs;
	Statement stmt;
	PreparedStatement pstmt;
	int cid;
	String cname="";
	String caddr ="";
	String mob ="";
	
//................update customer..................
	public Customer2() {
		l7=new JLabel("Agro Shop Management System");
		l7.setBounds(240,5,500,22);
		l7.setFont(new Font("Arial",Font.BOLD,20));
		add(l7);
		
		l1=new JLabel("Customer Details");
		l1.setBounds(275,25,250,60);
		l1.setFont(new Font("Arial",Font.BOLD,25));
		l1.setForeground(Color.red);
		add(l1);
		
		
		
		//panel1....................................................................................
				p1=new JPanel();
				p1.setBounds(150,80,500,300);
				p1.setLayout(null);
				p1.setBackground(new Color(255,255,255,80));
				p1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(Color.BLACK,Color.BLACK),""));

				add(p1);
		
		l5=new JLabel();
		l5.setBounds(80,20,350,30);
		l5.setFont(new Font("Arial",Font.BOLD,20));
		p1.add(l5);


		l2=new JLabel("Customer Id:");
		l2.setBounds(80,90,160,30);
		l2.setFont(new Font("Arial",Font.BOLD,18));
		p1.add(l2);

		t1=new JTextField();
		t1.setBounds(250,90,160,30);
		t1.setFont(new Font("Arial",Font.BOLD,18));
		p1.add(t1);
		
		l3=new JLabel("Customer Name:");
		l3.setBounds(80,130,160,30);
		l3.setFont(new Font("Arial",Font.BOLD,18));
		p1.add(l3);

		t2=new JTextField();
		t2.setBounds(250,130,160,30);
		t2.setFont(new Font("Arial",Font.BOLD,18));
		p1.add(t2);
		

		l4=new JLabel("Customer Address:");
		l4.setBounds(80,170,190,30);
		l4.setFont(new Font("Arial",Font.BOLD,18));
		p1.add(l4);

		t3=new JTextField();
		t3.setBounds(250,170,160,30);
		t3.setFont(new Font("Arial",Font.BOLD,18));
		p1.add(t3);
		
		
		
		

		l6=new JLabel("Mobile Number:");
		l6.setBounds(80,210,160,30);
		l6.setFont(new Font("Arial",Font.BOLD,18));
		p1.add(l6);

		t4=new JTextField();
		t4.setBounds(250,210,160,30);
		t4.setFont(new Font("Arial",Font.BOLD,18));
		p1.add(t4);
		
		
		//panel2.................................................................................
			p2=new JPanel();
			p2.setBounds(150,440,500,50);
			p2.setFont(new Font("Arial",Font.BOLD,18));
			p2.setBackground(new Color(255,255,255,0));
			//p2.setBackground(Color.gray);
			p2.setLayout(null);
			add(p2);
		
			
			b2=new JButton("Update");
			b2.setBounds(40,10,170,30);
			b2.setBackground(new Color(255,255,255));
			b2.setFont(new Font("Arial",Font.BOLD,18));
			p2.add(b2);
		

			b7=new JButton("Back");
			b7.setBounds(280,10,170,30);
			b7.setBackground(new Color(255,255,255));
			b7.setFont(new Font("Arial",Font.BOLD,18));
			p2.add(b7);
			
			
			

			//Background...........................................................
					ImageIcon bgimg=new ImageIcon("src/Agro/img/bb5.jpeg");
					Image img =bgimg.getImage();
					Image tempi=img.getScaledInstance(800, 600, Image.SCALE_SMOOTH);
					bgimg=new ImageIcon(tempi);
					JLabel bg=new JLabel("",bgimg,JLabel.CENTER);
					bg.setBackground(new Color(38,166,00));
					bg.setBounds(0,0,800,600);
					add(bg);
					
			setUndecorated(true);
			setSize(800,600);
			setLayout(null);
			setVisible(true);
			setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - 800)/2,(Toolkit.getDefaultToolkit().getScreenSize().height - 600)/2);
			setResizable(false);
				
			try
		{
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost/test?serverTimezone=UTC","root","");
				stmt=con.createStatement();
			
		}catch(Exception e){System.out.println(e);}
		
			
			b2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ev) {
					if(b2.getText()=="Update")
					{
						String CName,CAddr,CMbNo;
						int CId;
						
						 CId=Integer.parseInt(t1.getText());
						 CName=t2.getText();
						 CAddr=t3.getText();
						 CMbNo=t4.getText();

						if((CMbNo.length())==10)
						{			
					try
					{
						pstmt=con.prepareStatement("update Customer SET CName=?,CAddr=?,CMbNo=? where CId=?");
						pstmt.setString(1,CName);
						pstmt.setString(2,CAddr);
						pstmt.setString(3,CMbNo);
						pstmt.setInt(4,CId);
						pstmt.executeUpdate();
						JOptionPane.showMessageDialog(null," Update Record Successfully");
						t1.setText("");
						t2.setText("");
						t3.setText("");
						t4.setText("");
						

					}catch(Exception ae){
						//System.out.println(ae);
						}
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Enter 10 Digit Mob Number");
						}	
					}}
				});
			
			
			b7.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ev) {
				dispose();
				}});
		
		
	}

}
