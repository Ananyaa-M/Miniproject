import java.awt.*; 
import javax.swing.*; 
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.DefaultTableCellRenderer;
import java.sql.*;
import java.lang.*;

public class miniproject{
	public static Color green=new Color(0,150,0);
	public static Color g=new Color(0,240,0);
	public static Color lb=new Color(245,245,245);
	public static Color blue=new Color(26,227,242);
	public static Color lgray=new Color(238,238,238);
    public static class adminreg extends JFrame{
		JLabel l1,l2,l3,l4;
		JTextField t1,t2;
		JPasswordField p1,p2;
		JTextArea ta=new JTextArea();
		JButton b1,b2;
		adminreg() throws ClassNotFoundException
		{
			ta.setText("\tAdmin  Registeration  Form");
			ta.setEditable(false);
			ta.setFont(new Font(Font.SERIF,Font.BOLD,16));
	        ta.setForeground(Color.white);
	        ta.setBackground(Color.gray);
	        ta.setBounds(0,0,500,50);add(ta);
			l1=new JLabel("Enter your id");l1.setBounds(100,100,100,20);add(l1);
			l2=new JLabel("Create Password");l2.setBounds(100,140,130,20);add(l2);
			l3=new JLabel("Confirm Password");l3.setBounds(100,180,130,20);add(l3);
			l4=new JLabel("Enter the Code");l4.setBounds(100,220,100,20);add(l4);
			t1=new JTextField();t1.setBounds(220,100,100,20);add(t1);
			p1=new JPasswordField();p1.setBounds(220,140,100,20);add(p1);
			p2=new JPasswordField();p2.setBounds(220,180,100,20);add(p2);
			t2=new JTextField();t2.setBounds(220,220,100,20);add(t2);
			b1=new JButton("Reset");b1.setBounds(110,260,80,20);add(b1);
			b2=new JButton("Submit");b2.setBounds(200,260,80,20);add(b2);
			b1.setBackground(green);
			b1.setForeground(Color.white);
			b2.setBackground(green);
			b2.setForeground(Color.white);
            b1.addMouseListener(new MouseAdapter()
            {
            	public void mouseClicked(MouseEvent m)
            	{
            		b1.setBackground(Color.gray);
            	}
            	public void mouseExited(MouseEvent m)
            	{
            		b1.setBackground(green);
            	}
            });
            b2.addMouseListener(new MouseAdapter(){
            	
            	public void mouseClicked(MouseEvent m)
            	{
            		b1.setBackground(Color.gray);
            	}
            	public void mouseExited(MouseEvent m)
            	{
            		b1.setBackground(green);
            	}
            });
			b1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					t1.setText("");
					p1.setText("");
					p2.setText("");
					t2.setText("");
				}
			});

			b2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					String id = t1.getText();
					String pass  = p1.getText();
					if(p1.getText().equals(p2.getText()) && t2.getText().equals("12345"))
					{
						try 
						{
					        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");     
					        Statement stmt = con.createStatement( );
					        
					        ResultSet rs=stmt.executeQuery("select Id from adminreg where Id='"+id+"'");
					        if(!rs.next())
					        {
					        	stmt.executeUpdate("insert into adminreg(Id,password) values('"+id+"','"+pass+"')");
					        	JOptionPane.showMessageDialog(null,"Successfully Registered");
					        }
					        else
					        {
					        	JOptionPane.showMessageDialog(null,"You have already  Registered");
					        }
					       
					        rs.close();
					        stmt.close();
					        con.close();
					    }
						catch(SQLException e1)
					    {
							
							System.out.println(e1);
							
				        }
					
					}
					else if(!p1.getText().equals(p2.getText()))
					{
						JOptionPane.showMessageDialog(null,"Please Check The Password Entered");
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Please Check The Code Entered");
					}
	
				}
			});
			getContentPane().setBackground(Color.white);
            setResizable(false);
			setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			setSize(500, 500); 
			setLayout(null);
			setVisible(true);
		}
    }
	
	
    public static class studentreg extends JFrame{
		JLabel l1,l2,l3,l4;
		JTextField t1;
		JPasswordField p1,p2;
		JButton b1,b2;
		JTextArea ta=new JTextArea();
		studentreg() throws ClassNotFoundException
		{
			ta.setText("\tStudent  Registeration  Form");
			ta.setEditable(false);
			ta.setFont(new Font(Font.SERIF,Font.BOLD,16));
	        ta.setForeground(Color.white);
	        ta.setBackground(Color.gray);
	        ta.setBounds(0,0,500,50);add(ta);
			l1=new JLabel("Register No.");l1.setBounds(100,100,100,20);add(l1);
			l2=new JLabel("Create Password:");l2.setBounds(100,140,130,20);add(l2);
			l3=new JLabel("Confirm Password:");l3.setBounds(100,180,130,20);add(l3);
			t1=new JTextField();t1.setBounds(220,100,100,20);add(t1);
			p1=new JPasswordField();p1.setBounds(220,140,100,20);add(p1);
			p2=new JPasswordField();p2.setBounds(220,180,100,20);add(p2);
			b1=new JButton("Reset");b1.setBounds(110,220,80,20);add(b1);
			b2=new JButton("Submit");b2.setBounds(200,220,80,20);add(b2);
			b1.setBackground(green);
			b1.setForeground(Color.white);
			b2.setBackground(green);
			b2.setForeground(Color.white);
            b1.addMouseListener(new MouseAdapter(){
            	
            	public void mouseClicked(MouseEvent m)
            	{
            		b1.setBackground(Color.gray);
            	}
            	public void mouseExited(MouseEvent m)
            	{
            		b1.setBackground(green);
            	}
            });
            b2.addMouseListener(new MouseAdapter(){
            	
            	public void mouseClicked(MouseEvent m)
            	{
            		b1.setBackground(Color.gray);
            	}
            	public void mouseExited(MouseEvent m)
            	{
            		b1.setBackground(green);
            	}
            });
			b1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					t1.setText("");
					p1.setText("");
					p2.setText("");
				}
			});

			b2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					String rno = t1.getText();
					String pass  = p1.getText();
					if(p1.getText().equals(p2.getText()))
					{
						try 
						{
					        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");     
					        Statement stmt = con.createStatement( );
					        if(con!=null)
					        	System.out.println("Connection Success");
					        ResultSet rs=stmt.executeQuery("select rollno from studentreg where rollno='"+rno+"'");
					        if(!rs.next())
					        {
					        	stmt.executeUpdate("insert into studentreg(rollno,password) values('"+rno+"','"+pass+"')");
					        	JOptionPane.showMessageDialog(null,"Successfully Registered");
					        }
					        else
					        {
					        	JOptionPane.showMessageDialog(null,"You have already  Registered");
					        }
					       
					        rs.close();
					        
					        stmt.close();
					        con.close();
					    }
						catch(SQLException e1)
					    {
							System.out.println(e1);
				        }
					
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Please Check the Password  that you Entered");
					}
				}
			});
			getContentPane().setBackground(Color.white);
			setResizable(false);
			setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			//setTitle("Student Registeration Form");
			setSize(500, 500); 
			setLayout(null);
			setVisible(true);
		}
    }
	
	public static class addseat{  
		
		JFrame f=new JFrame();
		JLabel l,l1,l2,l3,l4,l5,l6,l7;
		JComboBox cb1,cb2,cb3,cb4,cb5,cb6;
		JTextArea ta=new JTextArea();
		JButton b1;
		addseat(){  
			ta.setText("\tALLOCATE  SEAT  FOR  THE   STUDENTS ");
			ta.setEditable(false);
			ta.setFont(new Font(Font.SERIF,Font.BOLD,16));
	        ta.setForeground(Color.white);
	        ta.setBackground(Color.gray);
	        ta.setBounds(0,0,500,50);f.add(ta);
	        
			l = new JLabel("Select Student:");l.setBounds(50,60,90,20);f.add(l);
			l1 = new JLabel("Select Dept");l1.setBounds(100,100,90,20);f.add(l1); 
			String dept[]={"CSE","IT"};       
			cb1=new JComboBox(dept); cb1.setBounds(200, 100,90,20);  f.add(cb1);
			cb1.setBackground(Color.white);
		
		
		
			l2 = new JLabel("Select Section");l2.setBounds(100,140,90,20);f.add(l2); 
			String sec1[] = {"A","B","C","D"};
			cb2=new JComboBox(); cb2.setBounds(200, 140,90,20);  f.add(cb2);
			cb2.setBackground(Color.white);
		
			cb1.addItemListener(new ItemListener(){
				public void itemStateChanged(ItemEvent ie) {
				
					String s = (String) ie.getItem();
					DefaultComboBoxModel model = (DefaultComboBoxModel) cb2.getModel();
					model.removeAllElements();
				
					int i;
					if(s.equals("CSE"))
					{
						for(i=0;i<4;i++)
						{
							model.addElement(sec1[i]);
						}
					}
					else
					{
						for(i=0;i<2;i++)
						{
						model.addElement(sec1[i]);
						}
					}
				
				}
			});  
		    
			l3 = new JLabel("Select Roll No");l3.setBounds(100,180,90,20);f.add(l3);
			cb3=new JComboBox(); cb3.setBounds(200, 180,90,20);  f.add(cb3);
			cb3.setBackground(Color.white);
		
			cb2.addItemListener(new ItemListener(){
				public void itemStateChanged(ItemEvent ie) {
	
					String r = (String) cb1.getSelectedItem();
					String s = (String) ie.getItem();
					DefaultComboBoxModel model = (DefaultComboBoxModel) cb3.getModel();
					model.removeAllElements();
				
					int i;
					if(r.equals("CSE"))
					{
						if(s.equals("A"))
						{
							String p = "18CSR00";
							for(i=1;i<=9;i++) model.addElement(p+i);
							p="18CSR0";
							for(i=10;i<=60;i++) model.addElement(p+i);
						}
					
						else if(s.equals("B"))
						{
							String p = "18CSR0";
							for(i=61;i<=99;i++) model.addElement(p+i);
							p="18CSR";
							for(i=100;i<=120;i++) model.addElement(p+i);
						}
						else if(s.equals("B"))
						{
							String p = "18CSR";
							for(i=121;i<=180;i++) model.addElement(p+i);
						}
						else
						{
							String p = "18CSR";
							for(i=181;i<=240;i++) model.addElement(p+i);
						}
					}
					else
					{
						if(s.equals("A"))
						{
							String p = "18ITR00";
							for(i=1;i<=9;i++) model.addElement(p+i);
							p="18ITR0";
							for(i=10;i<=60;i++) model.addElement(p+i);
						}
					
						else if(s.equals("B"))
						{
							String p = "18ITR0";
							for(i=61;i<=99;i++) model.addElement(p+i);
							p="18ITR";
							for(i=100;i<=120;i++) model.addElement(p+i);
						}
					}
				
				}
			});  
		
			l4 = new JLabel("Select Seat:");l4.setBounds(50,220,90,20);f.add(l4);
		
			l5 = new JLabel("Select Block");l5.setBounds(100,260,90,20);f.add(l5);
			String block[] = {"IT BLOCK","CSE BLOCK"};
			cb4=new JComboBox(block); cb4.setBounds(200, 260,90,20);  f.add(cb4);
			cb4.setBackground(Color.white);
		
			l6 = new JLabel("Select Room");l6.setBounds(100,300,90,20);f.add(l6);
			cb5=new JComboBox(); cb5.setBounds(200, 300,90,20);  f.add(cb5);
			cb5.setBackground(Color.white);
			DefaultComboBoxModel model = (DefaultComboBoxModel) cb5.getModel();
			model.removeAllElements();
			for (int i=1;i<=9;i++)  model.addElement(""+i);//("00"+i);
			for (int i=10;i<=20;i++)  model.addElement(""+i);//("0"+i);
			for (int i=1;i<=9;i++)  model.addElement("10"+i);
			for (int i=10;i<=20;i++)  model.addElement("1"+i);
			for (int i=1;i<=9;i++)  model.addElement("20"+i);
			for (int i=10;i<=20;i++)  model.addElement("2"+i);
		
			l7 = new JLabel("Select Seat no");l7.setBounds(100,340,90,20);f.add(l7);
			cb6=new JComboBox(); cb6.setBounds(200, 340,90,20);  f.add(cb6);
			cb6.setBackground(Color.white);
			model = (DefaultComboBoxModel) cb6.getModel();
			model.removeAllElements();
			for (int i=1;i<=9;i++)  model.addElement(""+i);//("0"+i);
			for (int i=10;i<=20;i++)  model.addElement(""+i);
		
			b1 = new JButton("Add");b1.setBounds(140,400,90,30);f.add(b1);
			b1.setBackground(green);
			b1.setForeground(Color.white);

			b1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					String sroll,sblock,sroom,sseat;
					sroll = (String) cb3.getSelectedItem();
					sblock = (String) cb4.getSelectedItem();
					sroom = (String) cb5.getSelectedItem();
					sseat = (String) cb6.getSelectedItem();
					try 
					{
				        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");     
				        Statement stmt = con.createStatement( );
				        ResultSet rs=stmt.executeQuery("select rollno from place where rollno='"+sroll+"'");
				        int flag=0;
				        if(rs.next())
				        {
				        	JOptionPane.showMessageDialog(null,"Seat has been already allocated for this rollno");
				        	flag++;
				        }
				        rs.close();
				        ResultSet rs1=stmt.executeQuery("select block,room,seat from place where seat='"+sseat+"'");
				        if(rs1.next() && flag==0)
				        {
					        	String block1 = rs1.getString("block");
								String room1 = rs1.getString("room");
								String seat1 = rs1.getString("seat");
								if(block1.contentEquals(sblock) && room1.contentEquals(sroom)&& seat1.contentEquals(sseat))
						        {
						           JOptionPane.showMessageDialog(null,"Seat not avaliable");
						        	flag++;
						        }
								
				        }
				        if(flag==0)
				        {
				        	stmt.executeUpdate("insert into place(rollno,block,room,seat) values('"+sroll+"','"+sblock+"','"+sroom +"','"+sseat+"')");
				        	JOptionPane.showMessageDialog(null,"Successfully  allocated");
				        }
				       
				        
				        rs1.close();
				        stmt.close();
				        con.close();
				    }
					catch(SQLException e1)
				    {
						
						System.out.println(e1);
				     }
					
						
				}
			});
			f.getContentPane().setBackground(Color.white);
		    f.setResizable(false);
			f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			f.setLayout(null);    
			f.setSize(500,500);    
			f.setVisible(true);
		}
	}
	
	public static class removeseat{
		JFrame f=new JFrame();
		JLabel l,l1,l2,l3;
		JComboBox cb1,cb2,cb3;
		JButton b1;
		JTextArea ta=new JTextArea();
		removeseat(){  
			ta.setText("\tREMOVE  STUDENT ");
			ta.setEditable(false);
			ta.setFont(new Font(Font.SERIF,Font.BOLD,16));
	        ta.setForeground(Color.white);
	        ta.setBackground(Color.gray);
	        ta.setBounds(0,0,500,50);f.add(ta);
	        
			l = new JLabel("Select Student:");l.setBounds(50,100,90,20);f.add(l);
			l1 = new JLabel("Select Dept");l1.setBounds(100,150,90,20);f.add(l1); 
			String dept[]={"CSE","IT"};       
			cb1=new JComboBox(dept); cb1.setBounds(200, 150,90,20);  f.add(cb1);
			cb1.setBackground(Color.white);
		
		
			l2 = new JLabel("Select Section");l2.setBounds(100,190,90,20);f.add(l2); 
			String sec1[] = {"A","B","C","D"};
			cb2=new JComboBox(); cb2.setBounds(200, 190,90,20);  f.add(cb2);
			cb2.setBackground(Color.white);
		
			cb1.addItemListener(new ItemListener(){
				public void itemStateChanged(ItemEvent ie) {
				
					String s = (String) ie.getItem();
					DefaultComboBoxModel model = (DefaultComboBoxModel) cb2.getModel();
					model.removeAllElements();
				
					int i;
					if(s.equals("CSE"))
					{
						for(i=0;i<4;i++)
						{
							model.addElement(sec1[i]);
						}
					}
					else
					{
						for(i=0;i<2;i++)
						{
						model.addElement(sec1[i]);
						}
					}
				
				}
			});  
		    
			l3 = new JLabel("Select Roll No");l3.setBounds(100,230,90,20);f.add(l3);
			cb3=new JComboBox(); cb3.setBounds(200, 230,90,20);  f.add(cb3);
			cb3.setBackground(Color.white);
		
			cb2.addItemListener(new ItemListener(){
				public void itemStateChanged(ItemEvent ie) {
	
					String r = (String) cb1.getSelectedItem();
					String s = (String) ie.getItem();
					DefaultComboBoxModel model = (DefaultComboBoxModel) cb3.getModel();
					model.removeAllElements();
				
					int i;
					if(r.equals("CSE"))
					{
						if(s.equals("A"))
						{
							String p = "18CSR00";
							for(i=1;i<=9;i++) model.addElement(p+i);
							p="18CSR0";
							for(i=10;i<=60;i++) model.addElement(p+i);
						}
					
						else if(s.equals("B"))
						{
							String p = "18CSR0";
							for(i=61;i<=99;i++) model.addElement(p+i);
							p="18CSR";
							for(i=100;i<=120;i++) model.addElement(p+i);
						}
						else if(s.equals("B"))
						{
							String p = "18CSR";
							for(i=121;i<=180;i++) model.addElement(p+i);
						}
						else
						{
							String p = "18CSR";
							for(i=181;i<=240;i++) model.addElement(p+i);
						}
					}
					else
					{
						if(s.equals("A"))
						{
							String p = "18ITR00";
							for(i=1;i<=9;i++) model.addElement(p+i);
							p="18ITR0";
							for(i=10;i<=60;i++) model.addElement(p+i);
						}
					
						else if(s.equals("B"))
						{
							String p = "18ITR0";
							for(i=61;i<=99;i++) model.addElement(p+i);
							p="18ITR";
							for(i=100;i<=120;i++) model.addElement(p+i);
						}
					}
				
				}
			});  
		
		
			b1 = new JButton("Remove");b1.setBounds(140,270,90,30);f.add(b1);
			b1.setBackground(green);
			b1.setForeground(Color.white);
			
			b1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					String sroll,block,room,seat;
					sroll = (String) cb3.getSelectedItem();
					try 
					{
				        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");     
				        Statement stmt = con.createStatement( );
				        stmt.executeUpdate("delete from place where rollno='"+sroll+"'");
				        JOptionPane.showMessageDialog(null,"Removed successfully");
				        stmt.close();
				        con.close();
				    }
					catch(SQLException e1)
				    {
						
						System.out.println(e1);
				     }
					
						
				}
			});
			f.getContentPane().setBackground(Color.white);
		    f.setResizable(false);
			f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			f.setLayout(null);    
			f.setSize(500,500);    
			f.setVisible(true);
		}
	}
public static class addseat1{  
		
		JFrame f=new JFrame("ADD STUDENT");
		JLabel l,l1,l2,l3,l4,l5,l6,l7;
		JComboBox cb1,cb2,cb3,cb4,cb5,cb6;
		JButton b1;
		JTextArea ta=new JTextArea();
		addseat1(String block1, String room1, String seat1){  
			ta.setText("\tALLOCATE  SEAT  FOR  THE   STUDENTS ");
			ta.setEditable(false);
			ta.setFont(new Font(Font.SERIF,Font.BOLD,16));
	        ta.setForeground(Color.white);
	        ta.setBackground(Color.gray);
	        ta.setBounds(0,0,500,50);f.add(ta);
		
			l = new JLabel("Select Student");l.setBounds(50,60,90,20);f.add(l);
			l1 = new JLabel("Select Dept:");l1.setBounds(100,100,90,20);f.add(l1); 
			String dept[]={"CSE","IT"};       
			cb1=new JComboBox(dept); cb1.setBounds(200, 100,90,20);  f.add(cb1);
			cb1.setBackground(Color.white);
		
		
			l2 = new JLabel("Select Section:");l2.setBounds(100,140,90,20);f.add(l2); 
			String sec1[] = {"A","B","C","D"};
			cb2=new JComboBox(); cb2.setBounds(200, 140,90,20);  f.add(cb2);
			cb2.setBackground(Color.white);
		
			cb1.addItemListener(new ItemListener(){
				public void itemStateChanged(ItemEvent ie) {
				
					String s = (String) ie.getItem();
					DefaultComboBoxModel model = (DefaultComboBoxModel) cb2.getModel();
					model.removeAllElements();
				
					int i;
					if(s.equals("CSE"))
					{
						for(i=0;i<4;i++)
						{
							model.addElement(sec1[i]);
						}
					}
					else
					{
						for(i=0;i<2;i++)
						{
						model.addElement(sec1[i]);
						}
					}
				
				}
			});  
		    
			l3 = new JLabel("Select Roll No:");l3.setBounds(100,180,90,20);f.add(l3);
			cb3=new JComboBox(); cb3.setBounds(200, 180,90,20);  f.add(cb3);
			cb3.setBackground(Color.white);
		
			cb2.addItemListener(new ItemListener(){
				public void itemStateChanged(ItemEvent ie) {
	
					String r = (String) cb1.getSelectedItem();
					String s = (String) ie.getItem();
					DefaultComboBoxModel model = (DefaultComboBoxModel) cb3.getModel();
					model.removeAllElements();
				
					int i;
					if(r.equals("CSE"))
					{
						if(s.equals("A"))
						{
							String p = "18CSR00";
							for(i=1;i<=9;i++) model.addElement(p+i);
							p="18CSR0";
							for(i=10;i<=60;i++) model.addElement(p+i);
						}
					
						else if(s.equals("B"))
						{
							String p = "18CSR0";
							for(i=61;i<=99;i++) model.addElement(p+i);
							p="18CSR";
							for(i=100;i<=120;i++) model.addElement(p+i);
						}
						else if(s.equals("B"))
						{
							String p = "18CSR";
							for(i=121;i<=180;i++) model.addElement(p+i);
						}
						else
						{
							String p = "18CSR";
							for(i=181;i<=240;i++) model.addElement(p+i);
						}
					}
					else
					{
						if(s.equals("A"))
						{
							String p = "18ITR00";
							for(i=1;i<=9;i++) model.addElement(p+i);
							p="18ITR0";
							for(i=10;i<=60;i++) model.addElement(p+i);
						}
					
						else if(s.equals("B"))
						{
							String p = "18ITR0";
							for(i=61;i<=99;i++) model.addElement(p+i);
							p="18ITR";
							for(i=100;i<=120;i++) model.addElement(p+i);
						}
					}
				
				}
			});  
		
			l4 = new JLabel("Select Seat");l4.setBounds(50,220,90,20);f.add(l4);
		
			l5 = new JLabel("Select Block:");l5.setBounds(100,260,90,20);f.add(l5);
			String block[] = {"IT BLOCK","CSE BLOCK"};
			cb4=new JComboBox(block); cb4.setBounds(200, 260,90,20);  f.add(cb4);
			cb4.setSelectedItem(block1);
			cb4.setBackground(Color.white);
			
			l6 = new JLabel("Select Room:");l6.setBounds(100,300,90,20);f.add(l6);
			cb5=new JComboBox(); cb5.setBounds(200, 300,90,20);  f.add(cb5);
			DefaultComboBoxModel model = (DefaultComboBoxModel) cb5.getModel();
			model.removeAllElements();
			for (int i=1;i<=9;i++)  model.addElement("00"+i);
			for (int i=10;i<=20;i++)  model.addElement("0"+i);
			for (int i=1;i<=9;i++)  model.addElement("10"+i);
			for (int i=10;i<=20;i++)  model.addElement("1"+i);
			for (int i=1;i<=9;i++)  model.addElement("20"+i);
			for (int i=10;i<=20;i++)  model.addElement("2"+i);
			cb5.setSelectedItem(room1);
			cb5.setBackground(Color.white);
		
			l7 = new JLabel("Select Seat no.:");l7.setBounds(100,340,90,20);f.add(l7);
			cb6=new JComboBox(); cb6.setBounds(200, 340,90,20);  f.add(cb6);
			model = (DefaultComboBoxModel) cb6.getModel();
			model.removeAllElements();
			for (int i=1;i<=9;i++)  model.addElement("0"+i);
			for (int i=10;i<=20;i++)  model.addElement(""+i);
			cb6.setSelectedItem(seat1);
			cb6.setBackground(Color.white);
		
			b1 = new JButton("Add");b1.setBounds(140,400,90,30);f.add(b1);
			b1.setBackground(green);
			b1.setForeground(Color.white);
			
			b1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					String sroll,sblock,sroom,sseat;
					sroll = (String) cb3.getSelectedItem();
					sblock = (String) cb4.getSelectedItem();
					sroom = (String) cb5.getSelectedItem();
					sseat = (String) cb6.getSelectedItem();
					try 
					{
				        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");     
				        Statement stmt = con.createStatement( );
				        ResultSet rs=stmt.executeQuery("select rollno from place where rollno='"+sroll+"'");
				        int flag=0;
				        if(rs.next())
				        {
				        	JOptionPane.showMessageDialog(null,"Seat has been already allocated for this rollno");
				        	flag++;
				        }
				        rs.close();
				        ResultSet rs1=stmt.executeQuery("select block,room,seat from place where seat='"+sseat+"'");
				        if(rs1.next() && flag==0)
				        {
					        	String block1 = rs1.getString("block");
								String room1 = rs1.getString("room");
								String seat1 = rs1.getString("seat");
								if(block1.contentEquals(sblock) && room1.contentEquals(sroom)&& seat1.contentEquals(sseat))
						        {
						           JOptionPane.showMessageDialog(null,"Seat not avaliable");
						        	flag++;
						        }
								
				        }
				        if(flag==0)
				        {
				        	stmt.executeUpdate("insert into place(rollno,block,room,seat) values('"+sroll+"','"+sblock+"','"+sroom +"','"+sseat+"')");
				        	JOptionPane.showMessageDialog(null,"Successfully  allocated");
				        }
				       
				        
				        rs1.close();
				        stmt.close();
				        con.close();
				    }
					catch(SQLException e1)
				    {
						
						System.out.println(e1);
				     }
				}
			});
			f.getContentPane().setBackground(Color.white);
		    f.setResizable(false);
			f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			f.setLayout(null);    
			f.setSize(500,500);    
			f.setVisible(true);
		}
	}

	public static class table{
		JFrame f;
		JTable table;
		JScrollPane sp;
		static Component c;
		private TableColumn tColumn;
		JTextArea ta=new JTextArea();
		table(String sblock, String sroom)
		{
			f=new JFrame("Details");
			ta.setText("\tSEATING  ARRANGEMENT\n");
			ta.setEditable(false);
			ta.setFont(new Font(Font.SERIF,Font.BOLD,16));
	        ta.setForeground(Color.white);
	        ta.setBackground(Color.gray);
	        ta.setBounds(0,0,500,50);
	        f.add(ta);
			f.setLayout(null);
			//f.setLayout(new FlowLayout());
			String[] column = { "", "Col1", "Col2", "Col3", "Col4" };
		
			String[][] row = { 
				{ "Row1", "-", "-", "-", "-" }, 
				{ "Row2", "-", "-", "-", "-" },
				{ "Row3", "-", "-", "-", "-" },
				{ "Row4", "-", "-", "-", "-" },
				{ "Row5", "-", "-", "-", "-" },
			}; 
		
			
		
		
			DefaultTableModel tabmod=new DefaultTableModel(row,column);
			table=new JTable();
			table.setModel(tabmod);
			sp=new JScrollPane(table);
			f.add(sp);
			//f.add(new JScrollPane(table));
			
			sp.setBorder(BorderFactory.createEmptyBorder());
	        table.setRowHeight(30);
	        table.setIntercellSpacing(new Dimension(0,0));
		    JTableHeader th=table.getTableHeader();
	        th.setPreferredSize(new Dimension(0,30));
	        th.setBackground(Color.white);
			th.setForeground(green);
			sp.setBackground(Color.white);
			sp.setBounds(10,100,450,350);
			
			DefaultTableCellRenderer rendar1 = new DefaultTableCellRenderer();
			rendar1.setForeground(green);
			table.getColumnModel().getColumn(0).setCellRenderer(rendar1);
			//table.getColumnModel().getColumn(0).setHeaderRenderer(rendar1);
			//table.getColumnModel().getColumn(1).setHeaderRenderer(rendar1);
			
			f.getContentPane().setBackground(lgray);
			try 
			{
		        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");     
		        Statement stmt = con.createStatement( );
		 
		        ResultSet rs1=stmt.executeQuery("select rollno,seat from place where block='"+sblock+"' and room='"+sroom+"'");
		        while(rs1.next())
		        {
		    	   //String block1 = rs1.getString("block");
				   String rno1 = rs1.getString("rollno");
				   String seat1 = rs1.getString("seat");
					switch(seat1)
					{
						case "1":
							table.setValueAt(rno1, 0, 1);
							break;
						case "2":
							table.setValueAt(rno1, 1, 1);
							break;
						case "3":
							table.setValueAt(rno1, 2, 1);
							break;
						case "4":
							table.setValueAt(rno1, 3, 1);
							break;
						case "5":
							table.setValueAt(rno1, 4, 1);
							break;
						case "6":
							table.setValueAt(rno1, 0, 2);
							break;
						case "7":
							table.setValueAt(rno1, 1, 2);
							break;
						case "8":
							table.setValueAt(rno1, 2, 2);
							break;
						case "9":
							table.setValueAt(rno1, 3, 2);
							break;
						case "10":
							table.setValueAt(rno1, 4, 2);
							break;
						case "11":
							table.setValueAt(rno1, 0, 3);
							break;
						case "12":
							table.setValueAt(rno1, 1, 3);
							break;
						case "13":
							table.setValueAt(rno1, 2, 3);
							break;
						case "14":
							table.setValueAt(rno1, 3, 3);
							break;
						case "15":
							table.setValueAt(rno1, 4, 3);
							break;
						case "16":
							table.setValueAt(rno1, 0, 4);
							break;
						case "17":
							table.setValueAt(rno1, 1, 4);
							break;
						case "18":
							table.setValueAt(rno1, 2, 4);
							break;
						case "19":
							table.setValueAt(rno1, 3, 4);
							break;
						case "20":
							table.setValueAt(rno1, 4, 4);
							break;
						default: break;
					}
		
			   }
		       
		        
		        rs1.close();
		        stmt.close();
		        con.close();
		    }
			catch(SQLException e1)
		    {
				
				System.out.println(e1);
		     }
			
		
        
			table.setIntercellSpacing(new Dimension(15,5));
       
			ListSelectionModel lsm=table.getSelectionModel();
		
			lsm.addListSelectionListener(new ListSelectionListener()
			{
				public void valueChanged(ListSelectionEvent e) 
				{
					table.setCellSelectionEnabled(true);
					int r=table.getSelectedRow();
					int c=table.getSelectedColumn();
					String seat;
					if(c==1) seat = "0"+(r+c);
					else if(c==2){
						if((r+4+c)<10) seat = "0"+(r+4+c);
						else seat = ""+(r+4+c);
					}
					else if(c==3) seat = ""+(r+8+c);
					else seat =""+(r+12+c);
					
					if(table.getValueAt(r,c) == "-")
						new addseat1(sblock,sroom,seat);
					}
			});
            f.setResizable(false);
			f.setSize(500,500);
			f.setVisible(true);
			f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		}
	}

	public static class display {
		
		JFrame f=new JFrame("Display");
		JLabel l,l1,l2,l3;
		JComboBox cb1,cb2,cb3;
		JButton b1;
		display(){  
		
		
			//l = new JLabel("Select Seat");l.setBounds(50,60,90,20);f.add(l);
		
			l1= new JLabel("Select Block");l1.setBounds(100,100,90,20);f.add(l1);
			String block[] = {"IT BLOCK","CSE BLOCK"};
			cb1=new JComboBox(block); cb1.setBounds(200, 100,90,20);  f.add(cb1);
			cb1.setBackground(Color.white);
		
			l2 = new JLabel("Select Room");l2.setBounds(100,140,90,20);f.add(l2);
			cb2=new JComboBox(); cb2.setBounds(200, 140,90,20);  f.add(cb2);
			cb2.setBackground(Color.white);
			DefaultComboBoxModel model = (DefaultComboBoxModel) cb2.getModel();
			model.removeAllElements();
			for (int i=1;i<=9;i++)  model.addElement("00"+i);
			for (int i=10;i<=20;i++)  model.addElement("0"+i);
			for (int i=1;i<=9;i++)  model.addElement("10"+i);
			for (int i=10;i<=20;i++)  model.addElement("1"+i);
			for (int i=1;i<=9;i++)  model.addElement("20"+i);
			for (int i=10;i<=20;i++)  model.addElement("2"+i);
			
			b1 = new JButton("Display");b1.setBounds(140,180,90,20);f.add(b1);
			b1.setBackground(green);
			b1.setForeground(Color.white);
		
			b1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					String sroll,block,room,seat;
					block = (String) cb1.getSelectedItem();
					room = (String) cb2.getSelectedItem();
					new table(block,room);
				}
			});
		f.getContentPane().setBackground(Color.white);
		f.setResizable(false);	
		f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		f.setLayout(null);    
		f.setSize(500,500);    
		f.setVisible(true);
		
		}
	}
	
	public static class studentlist extends JFrame { 
	
		studentlist(){     
			DefaultMutableTreeNode student=new DefaultMutableTreeNode("Student List"); 
			
			DefaultMutableTreeNode cse=new DefaultMutableTreeNode("CSE");  
			DefaultMutableTreeNode it=new DefaultMutableTreeNode("IT");  
			student.add(cse);  
			student.add(it);  
			
			DefaultMutableTreeNode s1=new DefaultMutableTreeNode("Section-A");  
			DefaultMutableTreeNode s2=new DefaultMutableTreeNode("Section-B"); 
			DefaultMutableTreeNode s3=new DefaultMutableTreeNode("Section-C");  
			DefaultMutableTreeNode s4=new DefaultMutableTreeNode("Section-D");  
			cse.add(s1); cse.add(s2); cse.add(s3); cse.add(s4);      
			
			DefaultMutableTreeNode r;
			int i;
			for(i=1;i<=9;i++)
			{
				r = new DefaultMutableTreeNode("18CSR00"+i);s1.add(r);
			}
			for(i=10;i<=60;i++)
			{
				r = new DefaultMutableTreeNode("18CSR0"+i);s1.add(r);
			}
			for(i=61;i<=99;i++)
			{
				r = new DefaultMutableTreeNode("18CSR0"+i);s2.add(r);
			}
			for(i=100;i<=120;i++)
			{
				r = new DefaultMutableTreeNode("18CSR"+i);s2.add(r);
			}
			for(i=121;i<=180;i++)
			{
				r = new DefaultMutableTreeNode("18CSR"+i);s3.add(r);
			}
			for(i=181;i<=240;i++)
			{
				r = new DefaultMutableTreeNode("18CSR"+i);s4.add(r);
			}
			
			DefaultMutableTreeNode s5=new DefaultMutableTreeNode("Section-A");  
			DefaultMutableTreeNode s6=new DefaultMutableTreeNode("Section-B"); 
			it.add(s5);it.add(s6);
			
			for(i=1;i<=9;i++)
			{
				r = new DefaultMutableTreeNode("18ITR00"+i);s5.add(r);
			}
			for(i=10;i<=60;i++)
			{
				r = new DefaultMutableTreeNode("18ITR0"+i);s5.add(r);
			}
			for(i=61;i<=99;i++)
			{
				r = new DefaultMutableTreeNode("18ITR0"+i);s6.add(r);
			}
			for(i=100;i<=120;i++)
			{
				r = new DefaultMutableTreeNode("18ITR"+i);s6.add(r);
			}
			
			JTree jt=new JTree(student);
			JScrollPane sp = new JScrollPane(jt);
			add(sp);
			
			
			setResizable(false);
			setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			setSize(500,500);  
			setVisible(true);  
			getContentPane().setBackground(Color.white);
		} 
	}
	
	public static class adminfirst extends JFrame{
		
		JButton b1,b2,b3,b4;
		
		adminfirst(){
			b1=new JButton("ADD SEAT");b1.setBounds(100,80,300,40);add(b1);
			b2=new JButton("REMOVE SEAT");b2.setBounds(100,150,300,40);add(b2);
			b3=new JButton("DISPLAY");b3.setBounds(100,220,300,40);add(b3);
			b4=new JButton("STUDENT LIST");b4.setBounds(100,290,300,40);add(b4);
			b1.setBackground(green);
			b1.setForeground(Color.white);
			b2.setBackground(green);
			b2.setForeground(Color.white);
			b3.setBackground(green);
			b3.setForeground(Color.white);
			b4.setBackground(green);
			b4.setForeground(Color.white);
			
			b1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					new addseat();
				}
			});
			
			b2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					new removeseat();
				}
			});
			
			b3.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					new display();
				}
			});
			
			b4.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					new studentlist();
				}
			});
			
			getContentPane().setBackground(Color.white);
			setResizable(false);
			setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			setSize(500, 500); 
			setTitle("ADMIN PAGE");
			setLayout(null);
			setVisible(true);
		}
	}
	public static class studentfirst extends JFrame{
		JLabel l1,l2;
		JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18,b19,b20;
		JTextArea ta=new JTextArea();
		studentfirst(String roll)  throws ClassNotFoundException
		{
			l1=new JLabel();add(l1);
			l2=new JLabel();add(l2);
			
	        
			JButton[] b=new JButton[20];
			for(int i=0;i<20;i++)
			{
				b[i]=new JButton(""+(i+1));
				add(b[i]);
				b[i].setBackground(lb);
				b[i].setForeground(Color.white);
			}
			try 
			{
		        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");     
		        Statement stmt = con.createStatement( );
		        ResultSet rs=stmt.executeQuery("select block,room,seat from place where rollno='"+roll+"'");
		        if(rs.next())
		        {
			        	String block1 = rs.getString("block");
						String room1 = rs.getString("room");
						int seat1 = rs.getInt("seat");
						ta.setText("\tSEATING ARRANGEMENT");
						ta.setEditable(false);
						ta.setFont(new Font(Font.SERIF,Font.BOLD,16));
				        ta.setForeground(Color.white);
				        ta.setBackground(Color.gray);
						ta.setBounds(0,0,500,50);add(ta);
						l1.setText("Block  : "+block1);l1.setBounds(200,370,100,20);
						l2.setText("Room no: "+room1);l2.setBounds(200,400,130,20);
						b[seat1-1].setBackground(Color.blue);
						b[seat1-1].setForeground(Color.white);
						b[seat1-1].setToolTipText("This is your seat");
						b[0].setBounds(10,100,100,30);
						b[1].setBounds(10,150,100,30);
						b[2].setBounds(10,200,100,30);
						b[3].setBounds(10,250,100,30);
						b[4].setBounds(10,300,100,30);
						b[5].setBounds(130,100,100,30);
						b[6].setBounds(130,150,100,30);
						b[7].setBounds(130,200,100,30);
						b[8].setBounds(130,250,100,30);
						b[9].setBounds(130,300,100,30);
						b[10].setBounds(250,100,100,30);
						b[11].setBounds(250,150,100,30);
						b[12].setBounds(250,200,100,30);
						b[13].setBounds(250,250,100,30);
						b[14].setBounds(250,300,100,30);
						b[15].setBounds(370,100,100,30);
						b[16].setBounds(370,150,100,30);
						b[17].setBounds(370,200,100,30);
						b[18].setBounds(370,250,100,30);
						b[19].setBounds(370,300,100,30);
						
		        }
		        else
		        {
		        	l1.setText("OOPS.......!");l1.setBounds(150,10,100,20);
		        	l2.setText("Seat not allocated for you");l2.setBounds(100,30,200,20);
		        }
		       
		        
		        rs.close();
		        stmt.close();
		        con.close();
		    }
			catch(SQLException e1)
		    {
				
				System.out.println(e1);
		     }
			getContentPane().setBackground(Color.white);
			setResizable(false);
			setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			setTitle("Exam hall");
			setSize(500, 500); 
			setLayout(null);
			setVisible(true);
		}
		
	}
	
	public static class adminlog extends JFrame{
		JLabel l1,l2;
		JTextField t1;
		JPasswordField p1;
		JButton b1,b2;
		JTextArea ta=new JTextArea();
		adminlog()  throws ClassNotFoundException
		{
			ta.setText("\n\t      Admin  Login  Form");
			ta.setEditable(false);
			ta.setFont(new Font(Font.SERIF,Font.BOLD,16));
	        ta.setForeground(Color.white);
	        ta.setBackground(Color.gray);
	        ta.setBounds(0,0,500,60);add(ta);
			l1=new JLabel("Enter Your id");l1.setBounds(100,100,100,20);add(l1);
			l2=new JLabel("Enter Password");l2.setBounds(100,140,130,20);add(l2);
			t1=new JTextField();t1.setBounds(220,100,100,20);add(t1);
			p1=new JPasswordField();p1.setBounds(220,140,100,20);add(p1);
			b1=new JButton("Reset");b1.setBounds(110,180,80,20);add(b1);
			b2=new JButton("Submit");b2.setBounds(200,180,80,20);add(b2);
			b1.setBackground(green);
			b1.setForeground(Color.white);
			b2.setBackground(green);
			b2.setForeground(Color.white);
            b1.addMouseListener(new MouseAdapter(){
            	
            	public void mouseClicked(MouseEvent m)
            	{
            		b1.setBackground(Color.gray);
            	}
            	public void mouseExited(MouseEvent m)
            	{
            		b1.setBackground(green);
            	}
            });
            b2.addMouseListener(new MouseAdapter(){
            	
            	public void mouseClicked(MouseEvent m)
            	{
            		b1.setBackground(Color.gray);
            	}
            	public void mouseExited(MouseEvent m)
            	{
            		b1.setBackground(green);
            	}
            });

			b1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					t1.setText("");
					p1.setText("");
				}
			});

			b2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					String id = t1.getText();
					String pass  = p1.getText();
					
					try 
					{
				        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");     
				        Statement stmt = con.createStatement( );
				        if(con!=null)
				        	System.out.println("Connection Success");
				        int s=1;
				        ResultSet rs=stmt.executeQuery("select Id,password from adminreg where Id='"+id+"'");
				        while(rs.next())
				        {
				        	String id1 = rs.getString("Id");
							String pass1 = rs.getString("password");
							if(id1.contentEquals(id) && pass1.contentEquals(pass))
					        {
					        	new adminfirst();
					        }
					        else if(!(pass1.contentEquals(pass)))
					        {
					        	JOptionPane.showMessageDialog(null,"Inorrect password");
					        }
							s++;
				        }
				        rs.close();
				        
				        if(s==1)
				        	JOptionPane.showMessageDialog(null,"Please register before logging in");
				        	 
				        stmt.close();
				        con.close();
				    }
					catch(SQLException e1)
				    {
						System.out.println("Error"+e1);
			        }
					
				}
			});
			getContentPane().setBackground(Color.white);
			setResizable(false);
			setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			setSize(500, 500); 
			setLayout(null);
			setVisible(true);
		}
    }

	public static class studentlog extends JFrame{
		JLabel l1,l2;
		JTextField t1;
		JPasswordField p1;
		JButton b1,b2;
		JTextArea ta=new JTextArea();
		studentlog() throws ClassNotFoundException
		{
			ta.setText("\n\t    Student Login Form");
			ta.setEditable(false);
			ta.setFont(new Font(Font.SERIF,Font.BOLD,16));
	        ta.setForeground(Color.white);
	        ta.setBackground(Color.gray);
	        ta.setBounds(0,0,500,60);add(ta);
			l1=new JLabel("Enter Register No");l1.setBounds(100,100,100,20);add(l1);
			l2=new JLabel("Enter Password");l2.setBounds(100,140,130,20);add(l2);
			t1=new JTextField();t1.setBounds(220,100,100,20);add(t1);
			p1=new JPasswordField();p1.setBounds(220,140,100,20);add(p1);
			b1=new JButton("Reset");b1.setBounds(110,180,80,20);add(b1);
			b2=new JButton("Submit");b2.setBounds(200,180,80,20);add(b2);
			b1.setBackground(green);
			b1.setForeground(Color.white);
			b2.setBackground(green);
			b2.setForeground(Color.white);
            b1.addMouseListener(new MouseAdapter(){
            	
            	public void mouseClicked(MouseEvent m)
            	{
            		b1.setBackground(Color.gray);
            	}
            	public void mouseExited(MouseEvent m)
            	{
            		b1.setBackground(green);
            	}
            });
            b2.addMouseListener(new MouseAdapter(){
            	
            	public void mouseClicked(MouseEvent m)
            	{
            		b1.setBackground(Color.gray);
            	}
            	public void mouseExited(MouseEvent m)
            	{
            		b1.setBackground(green);
            	}
            });

			b1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					t1.setText("");
					p1.setText("");
				}
			});

			b2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					String rno = t1.getText();
					String pass  = p1.getText();
					try 
					{
				        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");     
				        Statement stmt = con.createStatement( );
				        if(con!=null)
				        	System.out.println("Connection Success");
				        int s=1;
				        ResultSet rs=stmt.executeQuery("select rollno,password from studentreg where rollno='"+rno+"'");//and password='"+pass+"'");
				        while(rs.next())
				        {
				        	String rno1 = rs.getString("rollno");
							String pass1 = rs.getString("password");
							if(rno1.contentEquals(rno) && pass1.contentEquals(pass))
					        {
								JOptionPane.showMessageDialog(null,"Logged in.....");
								new studentfirst(rno1);
					        }
					        else if(!(pass1.contentEquals(pass)))
					        {
					        	JOptionPane.showMessageDialog(null,"Inorrect password");
					        }
							s++;
				        }
				        rs.close();
				        
				        if(s==1)
				        	JOptionPane.showMessageDialog(null,"Please register before logging in");
				        	 
				        stmt.close();
				        con.close();
				    }
					catch(SQLException e1)
				    {
						System.out.println("Error"+e1);
						
			        } catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					}
					
				}
			});
			getContentPane().setBackground(Color.white);
			setResizable(false);
			setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			setSize(500, 500); 
			setLayout(null);
			setVisible(true);
		}
    }
	
    public static class menu{ 
    	JFrame f=new JFrame();
		JMenuBar mb; 
		JMenu x, y, z, a; 
		JMenuItem m1, m2, m3, m4; 
		JTextArea ta=new JTextArea();
        JTextArea ta1=new JTextArea(2,2);
        JTextArea ta2=new JTextArea();
        
        JPopupMenu pm;
        JMenuItem mi1, mi2;
        
        JToolBar tb;
        JButton b1,b2;
        
         
		menu() 
		{  
			
        	mb = new JMenuBar(); 
 
        	x = new JMenu("Home"); 
			y = new JMenu("Register");
			z = new JMenu("Login");
			a = new JMenu("Contact");
   
			Action act = new act();
			m1 = new JMenuItem(act);
	    	m2 = new JMenuItem(act);
	    	m1.setText("Admin");
			m2.setText("Student");
        	//m1 = new JMenuItem("Admin"); 
        	//m2 = new JMenuItem("Student"); 
			m3 = new JMenuItem("Admin"); 
        	m4 = new JMenuItem("Student");  
  
        	y.add(m1); 
        	y.add(m2);
			z.add(m3); 
        	z.add(m4);

			x.addMenuListener(new MenuListener() {

				public void menuSelected(MenuEvent e) {
					f.setLayout(new BorderLayout());
					ta.setText("\t KONGU ENGINEERING COLLEGE\n"+"\t                  (Autonomous)\n"+"\tAFFILIATED TO ANNA UNIVERSITY");
					ta.setFont(new Font(Font.SERIF,Font.BOLD,16));
					ta.setEditable(false);
			        ta.setForeground(Color.white);
			        ta.setBackground(Color.gray);
			        
			         
			        ta2.setText("\n\n\n\n\tExam Hall Seating Arrangement ");
			        ta2.setFont(new Font(Font.SERIF,Font.BOLD,16));
			        ta2.setBackground(Color.white);
			      
			        ta1.setText("\n\t\tDesigned by Ananya\n");
			        ta1.setFont(new Font(Font.SERIF,Font.PLAIN,12));
			        ta1.setForeground(Color.white);
			        ta1.setBackground(Color.black);
			        
			        f.add(ta,BorderLayout.NORTH);
			        f.add(ta1,BorderLayout.SOUTH);
		        	f.add(ta2);
      			}

     			public void menuDeselected(MenuEvent e) {
     				ta.setText("");
					ta.setBackground(null);
					ta.setForeground(null);
					ta1.setText("");
					ta1.setBackground(null);
					ta1.setForeground(null);
					ta2.setText("");
					ta2.setBackground(null);
					f.setLayout(null);
					f.remove(tb);
				
				}

      			public void menuCanceled(MenuEvent e) {}

    		});
			
        	
			y.addMenuListener(new MenuListener() {

				public void menuSelected(MenuEvent e) {
		
                    /*tb=new JToolBar();f.add(tb);
                    b1=new JButton(act);tb.add(b1);
            		b2=new JButton(act);tb.add(b2);
            		b1.setText("Admin");
            		b2.setText("Student");*/
                    
                    
                    
                    f.setLayout(new FlowLayout());
					pm=new JPopupMenu("login");f.add(pm);
					mi1 = new JMenuItem(act);pm.add(mi1); 
			    	mi2 = new JMenuItem(act);pm.add(mi2);
			    	mi1.setText("Admin");
            		mi2.setText("Student");
					
		        	
					f.addMouseListener(new MouseAdapter()
		            {
		            	public void mouseClicked(MouseEvent m)
		            	{
		            		pm.show(f,m.getX(),m.getY());
		            	}
		            });
					
					//pm.setPopupSize(100,50);
      			}

     			public void menuDeselected(MenuEvent e) {
     				f.setLayout(null);
     				f.getContentPane().setBackground(Color.white);
				
				}

      			public void menuCanceled(MenuEvent e) {
      				
      			}

    		});

			/*m1.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					try {
						new adminreg();
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					} 
				}
			});

			m2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					try {
					   new studentreg();
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					} 
				}
			});*/
			
			m3.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					try {
						new adminlog();
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					}
				}
			});

			m4.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					try {
						new studentlog();
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					}
				}
			});
			
			a.addMenuListener(new MenuListener() {

				public void menuSelected(MenuEvent e)
				{
					f.setLayout(new BorderLayout());
					ta.setText("\t KONGU ENGINEERING COLLEGE\n"+"\t                  (Autonomous)\n"+"\tAFFILIATED TO ANNA UNIVERSITY");
					ta.setFont(new Font(Font.SERIF,Font.BOLD,16));
					ta.setEditable(false);
			        ta.setForeground(Color.white);
			        ta.setBackground(Color.gray);
			         
			        ta2.setText("\n\n\n\n\tIf any Problem With using this Application.\n\tContact : 6369238009");
			        ta2.setFont(new Font(Font.SERIF,Font.BOLD,16));
			        ta2.setBackground(Color.white);
			      
			        ta1.setText("\n\t\tDesigned by Ananya\n");
			        ta1.setFont(new Font(Font.SERIF,Font.PLAIN,12));
			        ta1.setForeground(Color.white);
			        ta1.setBackground(Color.black);
			        
			        f.add(ta,BorderLayout.NORTH);
			        f.add(ta1,BorderLayout.SOUTH);
			        f.add(ta2);
			        f.remove(tb);
      			}

     			public void menuDeselected(MenuEvent e) {
     				ta.setText("");
					ta.setBackground(null);
					ta.setForeground(null);
					ta1.setText("");
					ta1.setBackground(null);
					ta1.setForeground(null);
					ta2.setText("");
					ta2.setBackground(null);
					f.setLayout(null);
				}

      			public void menuCanceled(MenuEvent e) {}

    		});
			m1.setBackground(Color.white);
			m2.setBackground(Color.white);
			m3.setBackground(Color.white);
			m4.setBackground(Color.white);
			mb.setBackground(g);
			
 
        	mb.add(x); mb.add(y);mb.add(z);mb.add(a);
 
        	f.setJMenuBar(mb); 

			f.add(ta);
        	
        	
			f.setResizable(false);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setTitle("Exam Hall Seating Arrangement");
        	f.setSize(500, 500); 
        	f.setVisible(true); 
    	} 
		class act extends AbstractAction
		{

			public void actionPerformed(ActionEvent e) {
				
				if(e.getActionCommand()=="Admin")
				{
					//f.getContentPane().setBackground(Color.blue);
					try {
						new adminreg();
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					} 
				}
				else if(e.getActionCommand()=="Student")
				{
					
					//f.getContentPane().setBackground(Color.green);
					try {
						   new studentreg();
						} catch (ClassNotFoundException e1) {
							e1.printStackTrace();
						} 
				}
			}
			
		}
    } 
    

    public static void main(String s[])
    {
		new menu();
    }
}