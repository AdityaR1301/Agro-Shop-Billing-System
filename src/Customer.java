package Agro;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.sql.*;

public class Customer {
	JFrame f;
	JLabel l1,l2,l3,l4,l5,l6,l7;
	JTextField t1,t2,t3,t4,t5,t6;
	JPanel p1,p2,p3,p4;
	JButton b1,b2,b3,b4,b5,b6,b7,b8;
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



	public Customer() {
		int CId=0;
		DefaultTableModel model;
		JScrollPane scroll;
		JTextField textbox;
		 JTable table;
		String[] columnNames = {"CId", "CName", "CAddress", "CMoNo"};


		f=new JFrame();
	
		l7=new JLabel("Agro Shop Management System");
		l7.setBounds(240,5,500,22);
		l7.setFont(new Font("Arial",Font.BOLD,20));
		f.add(l7);
		
		l1=new JLabel("Customer Details");
		l1.setBounds(275,25,250,60);
		l1.setFont(new Font("Arial",Font.BOLD,25));
		l1.setForeground(Color.red);
		f.add(l1);
		
		 model = new DefaultTableModel();
			model.setColumnIdentifiers(columnNames);
			table = new JTable();
			table.setModel(model); 
			table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			table.setFillsViewportHeight(true);
			scroll = new JScrollPane(table);
			table.setBackground(Color.pink);
			table.setRowHeight(30);
			table.setFont(new Font("Arial",Font.BOLD,18));
			scroll.setBounds(10,100,480,180);
			
			scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		//panel1....................................................................................
				p1=new JPanel();
				p1.setBounds(150,80,500,300);
				p1.setLayout(null);
				p1.setBackground(Color.pink);
				f.add(p1);
				p1.setVisible(false);
				p1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(Color.BLACK,Color.BLACK),"Enter Record"));

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
			p2.setBackground(Color.gray);
			p2.setLayout(null);
			f.add(p2);
			p2.setVisible(false);
		
			
			b2=new JButton("Save");
			b2.setBounds(40,10,170,30);
			b2.setFont(new Font("Arial",Font.BOLD,18));
			p2.add(b2);
		

			b7=new JButton("Back");
			b7.setBounds(280,10,170,30);
			b7.setFont(new Font("Arial",Font.BOLD,18));
			p2.add(b7);
			
			
			
		//panel3 .....................................................................................
			p3=new JPanel();
			p3.setBounds(150,80,500,300);
			p3.setLayout(null);
			p3.setBackground(Color.pink);
			f.add(p3);
			p3.setVisible(true);
		
		

		b1=new JButton("Add");
		b1.setBounds(150,45,200,30);
		b1.setFont(new Font("Arial",Font.BOLD,18));
		p3.add(b1);
	
		
		b3=new JButton("Search");
		b3.setBounds(150,90,200,30);
		b3.setFont(new Font("Arial",Font.BOLD,18));
		p3.add(b3);
		
		
		b4=new JButton("Update");
		b4.setBounds(150,135,200,30);
		b4.setFont(new Font("Arial",Font.BOLD,18));
		p3.add(b4);

		
		b5=new JButton("Delete");
		b5.setBounds(150,180,200,30);
		b5.setFont(new Font("Arial",Font.BOLD,18));
		p3.add(b5);
	
	
		b6=new JButton("Exit");
		b6.setBounds(150,225,200,30);
		b6.setFont(new Font("Arial",Font.BOLD,18));
		p3.add(b6);

		
		
		
		
		//panel4 .....................................................................................
			p4=new JPanel();
			p4.setBounds(150,80,500,300);
			p4.setLayout(null);
			p4.setBackground(Color.pink);
			f.add(p4);
			p4.setVisible(false);
			
			b8=new JButton("VIEW All");
			b8.setBounds(340,20,120,30);
			b8.setFont(new Font("Arial",Font.BOLD,18));
			p4.add(b8);
			
			
			cbg=new ButtonGroup();
			ch1=new JRadioButton("By ID");
			ch1.setBounds(30, 20, 120, 30);
			ch1.setBackground(Color.pink);
			ch1.setFont(new Font("Arial",Font.BOLD,18));

			ch2=new JRadioButton("By Name");
			ch2.setBounds(30, 60, 120, 30);
			ch2.setBackground(Color.pink);
			ch2.setFont(new Font("Arial",Font.BOLD,18));

			cbg.add(ch1);
			cbg.add(ch2);
			p4.add(ch1);
			p4.add(ch2);
			t5=new JTextField();
			t5.setBounds(160,20,120,30);
			t5.setFont(new Font("Arial",Font.BOLD,18));
			p4.add(t5);
			t5.setVisible(false);
			
			t6=new JTextField();
			t6.setBounds(160,60,120,30);
			t6.setFont(new Font("Arial",Font.BOLD,18));
			p4.add(t6);
			t6.setVisible(false);
		
		//Background...........................................................
				ImageIcon bgimg=new ImageIcon("src/Agro/img/bg4.jpeg");
				Image img =bgimg.getImage();
				Image tempi=img.getScaledInstance(800, 600, Image.SCALE_SMOOTH);
				bgimg=new ImageIcon(tempi);
				JLabel bg=new JLabel("",bgimg,JLabel.CENTER);
				bg.setBackground(new Color(38,166,00));
				bg.setBounds(0,0,800,600);
				f.add(bg);
				
		f.setUndecorated(true);
		f.setSize(800,600);
		f.setLayout(null);
		f.setVisible(true);
		f.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - f.getWidth())/2,(Toolkit.getDefaultToolkit().getScreenSize().height - f.getHeight())/2);
		f.setResizable(false);
		f.toFront();
		f.requestFocus();
		f.setState(Frame.NORMAL);

		try
	{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/test?serverTimezone=UTC","root","");
			stmt=con.createStatement();
		
	}catch(Exception e){System.out.println(e);}
			
		
//Add button....................................................................	
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev) {
				l5.setText("Enter Record of New Customer");
				b2.setText("Save");
				try
				{
			
				int count=1;
				String sql;
				sql="Select * from Customer";
				rs=stmt.executeQuery(sql);
				rs.last();
				count=rs.getInt(1);
				count++;
				t1.setText(String.valueOf(count));
				
				t1.setEditable(false);
				t2.setText("");
				t3.setText("");
				t4.setText("");
				
				p1.setVisible(true);
				p2.setVisible(true);
				p3.setVisible(false);
				
				}catch(Exception ae){System.out.println(ae);}
				
		}
	});

		
		
//p2 button.....................................................................
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
//Save........................................			
				if(b2.getText()=="Save")
				{
			String CName,CAddr,CMbNo;
			int CId;
			try
			{
			 CId=Integer.parseInt(t1.getText());
			 CName=t2.getText();
			 CAddr=t3.getText();
			 CMbNo=t4.getText();
				
				if(CName.equals("") ||  CAddr.equals("") || CMbNo.equals(""))
				{
					JOptionPane.showMessageDialog(f,"Enter All Records");
				}
				else
				{
					if((CMbNo.length())==10)
					{
				pstmt=con.prepareStatement("insert into Customer values(?,?,?,?)");
				pstmt.setInt(1,CId);
				pstmt.setString(2,CName);
				pstmt.setString(3,CAddr);
				pstmt.setString(4,CMbNo);
				pstmt.executeUpdate();
				JOptionPane.showMessageDialog(f,"Record Saved Successfully");
				int count=1;
				String sql;
				sql="Select * from Customer";
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

				}
				else
				{
					JOptionPane.showMessageDialog(f,"Enter 10 Digit Mob Number");
				}
				}
				b2.setText("Save");

				
			}catch(Exception ae){
				//System.out.println(ae);
			//JOptionPane.showMessageDialog(f,"Plzz enter valid records");	
			}
				}
				
			
//p2---UPDATE BUTTON.......................				
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
					JOptionPane.showMessageDialog(f," Update Record Successfully");
					t1.setText("");
					t2.setText("");
					t3.setText("");
					t4.setText("");
					b2.setText("Update");

				}catch(Exception ae){
					//System.out.println(ae);
					}
					}
					else
					{
						JOptionPane.showMessageDialog(f,"Enter 10 Digit Mob Number");
					}	
				}
//P2---Delete--------------------------------------------------------------------------------				
				if(b2.getText()=="Delete")
				{
					int CId=Integer.parseInt(t1.getText());
					
					try
					{
						pstmt=con.prepareStatement("delete from Customer where CId=?");
						pstmt.setInt(1,CId);
						pstmt.executeUpdate();
						JOptionPane.showMessageDialog(f," Delete Record Successfully");
						b2.setText("Delete");

					}catch(Exception ae){
						//System.out.println(ae);
						}
					
				}
				
				
//p2-----search----------------------------------------------		
						if(b2.getText()=="Search")
						{
							
						
							String cn;
							 int i=0;
							 
							try
							{
								i=0;
								int CId=Integer.parseInt(t5.getText());
								cn=t6.getText();
								
								if(CId==0)
								{
									
									pstmt=con.prepareStatement("Select * from Customer where CName=?");
									pstmt.setString(1,cn);
									rs=pstmt.executeQuery();
									
								while(rs.next())
								{
									cid = rs.getInt("CId");
									cname = rs.getString("CName");
									caddr = rs.getString("CAddr");
									mob = rs.getString("CMbNo"); 
									model.addRow(new Object[]{cid, cname, caddr,mob});
									i++; 
									}
								}
								
								else
								{
									
								pstmt=con.prepareStatement("Select * from Customer where CId=?");
								pstmt.setInt(1,CId);
								rs=pstmt.executeQuery();
								
								
								while(rs.next())
								{
									cid = rs.getInt("CId");
									cname = rs.getString("CName");
									caddr = rs.getString("CAddr");
									mob = rs.getString("CMbNo"); 
									model.addRow(new Object[]{cid, cname, caddr,mob});
									i++; 
									}
								}		
							
							
								if(i <1)
									{
									JOptionPane.showMessageDialog(null, "No Record Found","Error",
									JOptionPane.ERROR_MESSAGE);
									
									}
								}
								
							catch(Exception ae){
								//System.out.println(ae);
								}
						i=0;	
						p4.add(scroll);
						}
				
			}	
			});
		

//SEARCH Button.........................................................................
	b3.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ev){
					
					p4.setVisible(true);
					p2.setVisible(true);
					p3.setVisible(false);
					b2.setText("Search");
					
				}
				});
		
	
	
	
	
	
//.....checkbox...........................

	ch1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ev) {
					t5.setVisible(true);
					t6.setVisible(false);
					t6.setText("");
					t5.setText("");

					while(model.getRowCount()>0)
					{
						model.removeRow(0);
					}
	}	
});
	
	ch2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
						t6.setVisible(true);
						t5.setText("0");
						t6.setText("");

						t5.setVisible(false);
	
						while(model.getRowCount()>0) 
						{
							model.removeRow(0);
	
						}
		}	
		});
	
//Update Button.........................................................................
			b4.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent ev){
						t1.setText("");
						b2.setText("Update");
						p1.setVisible(true);
						p2.setVisible(true);
						p3.setVisible(false);
				t1.setEditable(true);
				t4.setEditable(true);
			
			}	
			});
		

//delete Button------------------------------------------------------------------------------
			b5.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent ev){
				t1.setText("");
				t1.setEditable(true);
				b2.setText("Delete");
				p1.setVisible(true);
				p2.setVisible(true);
				p3.setVisible(false);
			
			}	
			});
			
//p2---Back button ----------------------------------------------------------------------------------		
	b7.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ev) {
					p1.setVisible(false);
					p2.setVisible(false);
					p3.setVisible(true);
					p4.setVisible(false);
					t5.setVisible(false);
					t6.setVisible(false);
					
					rs=null;
					while(model.getRowCount()>0) {
						model.removeRow(0);
					
					}
					table.setVisible(false);
					scroll.setVisible(false);
					
						}	
						});		

	//-----VIew All------
	b8.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ev) {
		

			while(model.getRowCount()>0) 
			{
				model.removeRow(0);

			}
			
			try
			{
				int i=0;
			rs=stmt.executeQuery("Select * from Customer");
			while(rs.next())
			{
				cid = rs.getInt("CId");
				cname = rs.getString("CName");
				caddr = rs.getString("CAddr");
				mob = rs.getString("CMbNo"); 
				model.addRow(new Object[]{cid, cname, caddr,mob});
				i++; 
				}
			if(i <1)
			{
			JOptionPane.showMessageDialog(null, "No Record Found","Error",
			JOptionPane.ERROR_MESSAGE);
			
			}
			
			}
			catch(Exception asa)
			{
				System.out.println(asa);
			}
			p4.add(scroll);
		}	
		});
	
			
//p3---Exit button ----------------------------------------------------------------------------------		
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
	f.setVisible(false);
	//new main_f();
			}	
			});
		


	}
		
public static void main(String args[])
{
	
	
			Customer in=new Customer();
}	
}
