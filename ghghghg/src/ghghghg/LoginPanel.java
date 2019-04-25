package ghghghg;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.sql.*;
//import java.sql.DriverManager;
//import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class LoginPanel extends JPanel {
	private JTextField textfield,textfield1;
	private JLabel label,label1;
	private JButton but;
	private Font font;
        public LoginPanel(){
        	init();
        	
        }
       
		public void init(){
        	
        	//init
        	font=new Font("Arial",Font.BOLD,20);
        	label=new JLabel();
        	label1=new JLabel();
        	textfield=new JTextField();
        	textfield1=new JTextField();
        	but=new JButton("LOGIN");
        	//init
        	label.setFont(font);
            label.setText("Name:");
            label.setBounds(200,200,200,25);
        	textfield.setBounds(300,200,200,25);
        	label1.setFont(font);
            label1.setText("Password:");
            label1.setBounds(200,250,200,25);
        	textfield1.setBounds(300,250,200,25);
        	but.setBounds(300,300,200,25);
        	but.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    
                	
                	String s1= textfield.getText().trim();
                    String s2 = textfield1.getText().trim();
                    String s3=new String();
          
           
           try{ 
                                     
       Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
       Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=austproject;integratedSecurity=true");  
      
        Statement statement = connection.createStatement();  
                  
    ResultSet resultSet = statement.executeQuery(" select name, pass from InventoryManager where name='"+s1+"' and pass='"+s2+"' ");  
               
   
     if(resultSet.next()){
                   
    	     s3=resultSet.getString(1);
    	     
              JOptionPane.showMessageDialog(null, s3);
              but.setEnabled(false);
              textfield.setEnabled(false);
              textfield1.setEnabled(false);
              Constants.log=1;
               }
     else{
    	 JOptionPane.showMessageDialog(null, "Invalid");
    	 Constants.log=0;
     }
             
            } catch (Exception ex) {  
            	ex.printStackTrace();  
            }  
                	
                	
                	
                 textfield.setText("");
                 textfield1.setText("");
                
                }    	
           });
        
        	this.add(but);
        	this.add(label);
        	this.add(label1);
        	this.add(textfield);
        	this.add(textfield1);
        	this.setBounds(10, 0, 920, 720);
            this.setBackground(new Color(130,168,180));
          this.setVisible(true);
            this.setLayout(null);
        }
		 public JButton getBut() {
				return but;
			}
			public void setBut(JButton but) {
				this.but = but;
			}

			public JTextField getTextfield() {
				return textfield;
			}

			public void setTextfield(JTextField textfield) {
				this.textfield = textfield;
			}

			public JTextField getTextfield1() {
				return textfield1;
			}

			public void setTextfield1(JTextField textfield1) {
				this.textfield1 = textfield1;
			}
}

