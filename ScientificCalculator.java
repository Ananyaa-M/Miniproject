import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import java.lang.Math;
public class ScientificCalculator implements ActionListener
{
	JFrame f;
	double n1,n2,ans;
	int i;
	JTextField t;
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18,b19,b20,b21,b22,b23;
	Color LIGHTGREEN=new Color(0,255,51);
	ScientificCalculator()
	{
		f=new JFrame();
		f.setLayout(null);
		f.getContentPane().setBackground(Color.PINK);
		f.setResizable(false);
		f.setSize(350,550);
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
		b1=new JButton("0");
		b1.setBackground(Color.WHITE);
		b1.setForeground(Color.GRAY);
		b2=new JButton("1");
		b2.setBackground(Color.GRAY);
		b2.setForeground(Color.WHITE);
		b3=new JButton("2");
		b3.setBackground(Color.GRAY);
		b3.setForeground(Color.WHITE);
		b4=new JButton("3");
		b4.setBackground(Color.GRAY);
		b4.setForeground(Color.WHITE);
		b5=new JButton("4");
		b5.setBackground(Color.WHITE);
		b5.setForeground(Color.GRAY);
		b6=new JButton("5");
		b6.setBackground(Color.WHITE);
		b6.setForeground(Color.GRAY);
		b7=new JButton("6");
		b7.setBackground(Color.WHITE);
		b7.setForeground(Color.GRAY);
		b8=new JButton("7");
		b8.setBackground(Color.GRAY);
		b8.setForeground(Color.WHITE);
		b9=new JButton("8");
		b9.setBackground(Color.GRAY);
		b9.setForeground(Color.WHITE);
		b10=new JButton("9");
		b10.setBackground(Color.GRAY);
		b10.setForeground(Color.WHITE);
		b11=new JButton("+");
		b11.setBackground(Color.WHITE);
		b11.setForeground(Color.GRAY);
		b12=new JButton("-");
		b12.setBackground(Color.GRAY);
		b12.setForeground(Color.WHITE);
		b13=new JButton("*");
		b13.setBackground(Color.WHITE);
		b13.setForeground(Color.GRAY);
		b14=new JButton("/");
		b14.setBackground(Color.GRAY);
		b14.setForeground(Color.WHITE);
		b15=new JButton("=");
		b15.setBackground(Color.WHITE);
		b15.setForeground(Color.GRAY);
		b16=new JButton("sqr");
		b17=new JButton("log");
		b17.setBackground(Color.WHITE);
		b17.setForeground(Color.GRAY);
		b18=new JButton("sin");
		b18.setBackground(Color.WHITE);
		b18.setForeground(Color.GRAY);
		b19=new JButton("cos");
		b19.setBackground(Color.WHITE);
		b19.setForeground(Color.GRAY);
		b20=new JButton("tan");
		b20.setBackground(Color.WHITE);
		b20.setForeground(Color.GRAY);
		b21=new JButton("clear");
		b21.setBackground(Color.GRAY);
		b21.setForeground(Color.WHITE);
		b22=new JButton("Delete");
		b22.setBackground(Color.GRAY);
		b22.setForeground(Color.WHITE);
		b23=new JButton(".");
		b23.setBackground(Color.WHITE);
		b23.setForeground(Color.GRAY);
		t=new JTextField(40);
		
		t.setBounds(30,40,300,30);
	
		b17.setBounds(40,100,60,40);
		b18.setBounds(110,100,60,40);
		b19.setBounds(180,100,60,40);
		b20.setBounds(250,100,60,40);
		
		b8.setBounds(40,170,60,40);
		b9.setBounds(110,170,60,40);
	    b10.setBounds(180,170,60,40);
	    b14.setBounds(250,170,60,40);
	    
		b5.setBounds(40,240,60,40);
		b6.setBounds(110,240,60,40);
	    b7.setBounds(180,240,60,40);
	    b13.setBounds(250,240,60,40);
	    
	    b2.setBounds(40,310,60,40);
		b3.setBounds(110,310,60,40);
		b4.setBounds(180,310,60,40);
		b12.setBounds(250,310,60,40);
		
		b23.setBounds(40,380,60,40);
		b1.setBounds(110,380,60,40);
		b15.setBounds(180,380,60,40);
		b11.setBounds(250,380,60,40);
		
		b22.setBounds(60,450,100,40);
		b21.setBounds(180,450,100,40);
		
		f.add(b1);
	    b1.addActionListener(this);
	    f.add(b2);
	    b2.addActionListener(this);
	    f.add(b3);
	    b3.addActionListener(this);
	    f.add(b4);
	    b4.addActionListener(this);
	    f.add(b5);
	    b5.addActionListener(this);
	    f.add(b6);
	    b6.addActionListener(this);
	    f.add(b7);
	    b7.addActionListener(this);
	    f.add(b8);
	    b8.addActionListener(this);
	    f.add(b9);
	    b9.addActionListener(this);
	    f.add(b10);
	    b10.addActionListener(this);
	    f.add(b11);
	    b11.addActionListener(this);
	    f.add(b12);
	    b12.addActionListener(this);
	    f.add(b13);
	    b13.addActionListener(this);
	    f.add(b14);
	    b14.addActionListener(this);
	    f.add(b15);
	    b15.addActionListener(this);
	    f.add(b16);
	    b16.addActionListener(this);
	    f.add(b17);
	    b17.addActionListener(this);
	    f.add(b18);
	    b18.addActionListener(this);
	    f.add(b19);
	    b19.addActionListener(this);
	    f.add(b20);
	    b20.addActionListener(this);
	    f.add(b21);
	    b21.addActionListener(this);
	    f.add(b22);
	    b22.addActionListener(this);
	    f.add(b23);
	    b23.addActionListener(this);
	    f.add(t);
	    t.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b11)
		{
			n1=Double.parseDouble(t.getText());
			i=1;
			t.setText("");
		}
		if(e.getSource()==b12)
		{
			n1=Double.parseDouble(t.getText());
			i=2;
			t.setText("");	
		}
		if(e.getSource()==b13)
		{
			n1=Double.parseDouble(t.getText());
			i=3;
			t.setText("");
		}
		if(e.getSource()==b14)
		{
			n1=Double.parseDouble(t.getText());
			i=4;
			t.setText("");
		}
		if(e.getSource()==b16)
		{
			n1=Double.parseDouble(t.getText());
			i=6;
			t.setText("");
		}
		if(e.getSource()==b17)
		{
			n1=Double.parseDouble(t.getText());
			i=7;
			t.setText("");
		}
		if(e.getSource()==b18)
		{
			n1=Double.parseDouble(t.getText());
			i=8;
			t.setText("0");
		}
		if(e.getSource()==b19)
		{
			n1=Double.parseDouble(t.getText());
			i=9;
			t.setText("");
		}
		if(e.getSource()==b20)
		{
			n1=Double.parseDouble(t.getText());
			i=10;
			t.setText("");
		}
		if(e.getSource()==b21)
		{
			t.setText("");
		}
		if(e.getSource()==b22)
		{
		   String s=t.getText();
		   t.setText("");
		   for(int i=0;i<s.length()-1;i++)
		     t.setText(t.getText()+s.charAt(i));
		} 
		if(e.getSource()==b23)
			 t.setText(t.getText().concat("."));
		
		if(e.getSource()==b1)
		{
			t.setText(t.getText()+"0");
		}
		if(e.getSource()==b2)
		{
			t.setText(t.getText()+"1");
		}
		if(e.getSource()==b3)
		{
			t.setText(t.getText()+"2");
		}
		if(e.getSource()==b4)
		{
			t.setText(t.getText()+"3");
		}
		if(e.getSource()==b5)
		{
			t.setText(t.getText()+"4");
		}
		if(e.getSource()==b6)
		{
			t.setText(t.getText()+"5");
		}
		if(e.getSource()==b7)
		{
			t.setText(t.getText()+"6");
		}
		if(e.getSource()==b8)
		{
			t.setText(t.getText()+"7");
		}
		if(e.getSource()==b9)
		{
			t.setText(t.getText()+"8");
		}
		if(e.getSource()==b10)
		{
			t.setText(t.getText()+"9");
		}
		if(e.getSource()==b15)
		{
			n2=Double.parseDouble(t.getText());
		switch(i)
		{
		
		case 1:
			     ans=n1+n2;
			     break;
		case 2:
			     ans=n1-n2;
			     break;
		case 3:
			     ans=n1*n2;
			     break;
		case 4:
			     ans=n1/n2;
			     break;
		case 6:
		         ans=Math.sqrt(n2);
		         break;
	    case 7:
		         ans=Math.log(n2);
		         break;					      
		case 8:
			     n2=Math.toRadians(n2);
			     ans=Math.sin(n2);
			     break;
		case 9:
			     n2=Math.toRadians(n2);
			     ans=Math.cos(n2);
			     break;
		case 10:
			     n2=Math.toRadians(n2);
			     ans=Math.tan(n2);
	    		 break;
		 		 
		}
		t.setText(Double.toString(ans));
	 }	
	}
    public static void main(String[] args) {
           new ScientificCalculator();
    }
}