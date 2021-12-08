package Agro;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.sql.*;
public class psearch extends JDialog {


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
	
	int pId=0;
	DefaultTableModel model;
	JScrollPane scroll;
	JTextField textbox;
	 JTable table;
	String[] columnNames = {"PId", "PName", "Type", "Quantity","Price"};

	
	public psearch() {
		

	
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
		

			//panel4 .....................................................................................
				p4=new JPanel();
				p4.setBounds(150,80,500,300);
				p4.setLayout(null);
				p4.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(Color.BLACK,Color.BLACK),""));
				p4.setOpaque(true);
				p4.setBackground(new Color(255,255,255,100));
				add(p4);
				
			
				
				
				cbg=new ButtonGroup();
				ch1=new JRadioButton("By ID");
				ch1.setBounds(30, 20, 120, 30);
				//ch1.setBackground(Color.pink);
				ch1.setFont(new Font("Arial",Font.BOLD,18));

				ch2=new JRadioButton("By Name");
				ch2.setBounds(30, 60, 120, 30);
				//ch2.setBackground(Color.pink);
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
				
				//panel2.................................................................................
				p2=new JPanel();
				p2.setBounds(150,440,500,50);
				p2.setFont(new Font("Arial",Font.BOLD,18));
				//p2.setBackground(Color.gray);
				p2.setBackground( new Color(255,255,255,0));

				p2.setLayout(null);
				add(p2);
				
			
				
				b2=new JButton("Search");
				b2.setBounds(10,10,160,30);
				b2.setBackground(new Color(255,255,255));
				b2.setFont(new Font("Arial",Font.BOLD,18));
				p2.add(b2);
			
				
				b8=new JButton("VIEW All");
				b8.setBounds(200,10,120,30);
				b8.setBackground(new Color(255,255,255));
				b8.setFont(new Font("Arial",Font.BOLD,18));
				p2.add(b8);

				b7=new JButton("Back");
				b7.setBounds(340,10,160,30);
				b7.setBackground(new Color(255,255,255));
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
				//f.requestFocus();
				//f.setState(Frame.NORMAL);

				try
			{
					Class.forName("com.mysql.cj.jdbc.Driver");
					con=DriverManager.getConnection("jdbc:mysql://localhost/test?serverTimezone=UTC","root","");
					stmt=con.createStatement();
				
			}catch(Exception e){System.out.println(e);}
				
				b2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ev) {
						
						while(model.getRowCount()>0) {
							model.removeRow(0);
						
						}
					
						String pn;
						 int i=0;
						 
						try
						{
							i=0;
							int pId=Integer.parseInt(t5.getText());
							pn=t6.getText();
							
							if(pId==0)
							{
								
								pstmt=con.prepareStatement("Select * from product where PName=?");
								pstmt.setString(1,pn);
								rs=pstmt.executeQuery();
								
							while(rs.next())
							{
								pid = rs.getInt("PId");
								pname = rs.getString("PName");
								ptype = rs.getString("Type");
								quan = rs.getInt("quantity"); 
								pr = rs.getInt("price"); 

								model.addRow(new Object[]{pid, pname, ptype,quan,pr});
								i++; 
								}
							}
							
							else
							{
								
							pstmt=con.prepareStatement("Select * from product where PId=?");
							pstmt.setInt(1,pId);
							rs=pstmt.executeQuery();
							
							
							
							while(rs.next())
							{
								pid = rs.getInt("PId");
								pname = rs.getString("PName");
								ptype = rs.getString("Type");
								quan = rs.getInt("quantity"); 
								pr = rs.getInt("price"); 

								model.addRow(new Object[]{pid, pname, ptype,quan,pr});
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
							rs=stmt.executeQuery("Select * from product");

							
							while(rs.next())
							{
								pid = rs.getInt("PId");
								pname = rs.getString("PName");
								ptype = rs.getString("Type");
								quan = rs.getInt("quantity"); 
								pr = rs.getInt("price"); 

								model.addRow(new Object[]{pid, pname, ptype,quan,pr});
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
					
					b7.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent ev) {
				dispose();
							//f.setVisible(false);
				//new main_f();
						}	
						});
	
	
	}

}
