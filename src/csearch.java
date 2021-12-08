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

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class csearch extends JDialog {

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
	int CId=0;
DefaultTableModel model;
JScrollPane scroll;
JTextField textbox;
static JTable table;
String[] columnNames = {"CId", "CName", "CAddress", "CMoNo"};



	public csearch() {
		l7=new JLabel("Agro Shop Management System");
		l7.setBounds(240,5,500,22);
		l7.setFont(new Font("Arial",Font.BOLD,20));
		add(l7);
		
		l1=new JLabel("Customer Details");
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
//p2-----search----------------------------------------------		
			
					
				
					String cn;
					 int i=0;
					
					try
					{
						i=0;
						CId=Integer.parseInt(t5.getText());
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
		
		
	});
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
		b8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
			

				while(model.getRowCount()>0) 
				{
					model.removeRow(0);

				}
				
				try
				{
					
				rs=stmt.executeQuery("Select * from Customer");
				while(rs.next())
				{
					cid = rs.getInt("CId");
					cname = rs.getString("CName");
					caddr = rs.getString("CAddr");
					mob = rs.getString("CMbNo"); 
					model.addRow(new Object[]{cid, cname, caddr,mob});
				
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
			}});
		
	}

}
