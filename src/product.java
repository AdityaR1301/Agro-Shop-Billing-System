package Agro;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.sql.*;

public class product extends JDialog{
	
	JLabel l1,l2,l3,l4,l5,l6,l7;
	JTextField t1,t2,t3,t4,t5,t6,t15;
	JPanel p1,p2,p3,p4;
	JButton b1,b2,b3,b4,b5,b6,b7,b8;
	ButtonGroup cbg;
	JRadioButton ch1,ch2;
	Connection con;
	ResultSet rs;
	Statement stmt;
	PreparedStatement pstmt;
	int pid,quan,pr;
	String pname="";
	String ptype ="";




	public product() {
			
	
		l7=new JLabel("Agro Shop Management System");
		l7.setBackground(Color.white);

		l7.setBounds(240,5,500,22);
		l7.setFont(new Font("Arial",Font.BOLD,20));
		add(l7);
		
		l1=new JLabel("Product Details");
		l1.setBackground(Color.white);

		l1.setBounds(275,25,250,60);
		l1.setFont(new Font("Arial",Font.BOLD,25));
		l1.setForeground(Color.red);
		add(l1);
		
		 	
		
		//panel1....................................................................................
				p1=new JPanel();
				p1.setBounds(150,80,500,300);
				p1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(Color.BLACK,Color.BLACK),"Add New Record"));

				p1.setLayout(null);
				p1.setBackground(new Color(255,255,255,80));
				add(p1);

		


		l2=new JLabel("Product Id:");
		l2.setBounds(80,50,160,30);
		l2.setFont(new Font("Arial",Font.BOLD,18));
		p1.add(l2);

		t1=new JTextField();
		t1.setBounds(250,50,160,30);
		t1.setFont(new Font("Arial",Font.BOLD,18));
		p1.add(t1);
		
		l3=new JLabel("Product Name:");
		l3.setBounds(80,90,160,30);
		l3.setFont(new Font("Arial",Font.BOLD,18));
		p1.add(l3);

		t2=new JTextField();
		t2.setBounds(250,90,160,30);
		t2.setFont(new Font("Arial",Font.BOLD,18));
		p1.add(t2);
		

		l4=new JLabel("Product Type:");
		l4.setBounds(80,130,190,30);
		l4.setFont(new Font("Arial",Font.BOLD,18));
		p1.add(l4);

		t3=new JTextField();
		t3.setBounds(250,130,160,30);
		t3.setFont(new Font("Arial",Font.BOLD,18));
		p1.add(t3);
		
		
		l6=new JLabel("Quantity:");
		l6.setBounds(80,170,160,30);
		l6.setFont(new Font("Arial",Font.BOLD,18));
		p1.add(l6);

		t4=new JTextField();
		t4.setBounds(250,170,160,30);
		t4.setFont(new Font("Arial",Font.BOLD,18));
		p1.add(t4);
		
		l5=new JLabel("Product Price :");
		l5.setBounds(80,210,350,30);
		l5.setFont(new Font("Arial",Font.BOLD,18));
		p1.add(l5);
		

		t15=new JTextField();
		t15.setBounds(250,210,160,30);
		t15.setFont(new Font("Arial",Font.BOLD,18));
		p1.add(t15);
		
		
		
		//panel2.................................................................................
			p2=new JPanel();
			p2.setBounds(150,440,500,50);
			p2.setFont(new Font("Arial",Font.BOLD,18));
			p2.setBackground(new Color(255,255,255,80));
			p2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(Color.BLACK,Color.BLACK),""));
			p2.setLayout(null);
			add(p2);
			p2.setVisible(false);
		
			
			b2=new JButton("Save");
			b2.setBackground(new Color(255,0,0));
			b2.setForeground(Color.white);
			
			b2.setBounds(40,10,170,30);
			b2.setFont(new Font("Arial",Font.BOLD,18));
			p2.add(b2);
		

			b7=new JButton("Back");
			b7.setBounds(280,10,170,30);
			b7.setBackground(new Color(255,69,0));
			b7.setForeground(Color.white);
			b7.setFont(new Font("Arial",Font.BOLD,18));
			p2.add(b7);
			
			
			
		
		
		//Background...........................................................
				ImageIcon bgimg=new ImageIcon("src/Agro/img/bb3.jpeg");
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
		toFront();
		requestFocus();
	

		try
	{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/test?serverTimezone=UTC","root","");
			stmt=con.createStatement();
		
	}catch(Exception e){System.out.println(e);}
			
				try
				{
			
				int count=1;
			
				rs=stmt.executeQuery("Select * from product");
				rs.last();
				count=rs.getInt(1);
				count++;
				t1.setText(String.valueOf(count));
				
					

				t1.setEditable(false);
				t2.setText("");
				t3.setText("");
				t4.setText("");
				t15.setText("");

				p1.setVisible(true);
				p2.setVisible(true);
				p3.setVisible(false);
				
				}catch(Exception ae){System.out.println(ae);}

		
		
//p2 button.....................................................................
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {

			String pName,ptype;
			int pId=0,qua=0,price=0;
			try
			{
			 pId=Integer.parseInt(t1.getText());
			 pName=t2.getText();
			 ptype=t3.getText();
			 
			 qua=Integer.parseInt(t4.getText());
			 price=Integer.parseInt(t15.getText());

	
				if(pName.equals("") ||  ptype.equals("") || (pId==0) || (qua==0) || (price==0))
				{
					JOptionPane.showMessageDialog(null,"Enter All Records");
				}
				else
				{
					
				pstmt=con.prepareStatement("insert into product values(?,?,?,?,?)");
				pstmt.setInt(1,pId);
				pstmt.setString(2,pName);
				pstmt.setString(3,ptype);
				pstmt.setInt(4,qua);
				pstmt.setInt(5,price);
				
				pstmt.executeUpdate();
				JOptionPane.showMessageDialog(null,"Record Saved Successfully");
				int count=1;
				String sql;
				sql="Select * from product";
				rs=stmt.executeQuery(sql);
				while(rs.next())
				{
					count++;
				}
				t1.setText(String.valueOf(count));
				t1.setEditable(false);
				t2.setText("");
				t3.setText("");
				t4.setText("");
				t15.setText("");

				}
				b2.setText("Save");
				}
			catch(Exception ae){
				System.out.println(ae);
			//JOptionPane.showMessageDialog(f,"Plzz enter valid records");	
			}


		}	
		});

			
//p2---Back button ----------------------------------------------------------------------------------		
	b7.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ev) {
			dispose();
					
						}	
						});		

	


	}
		

}
