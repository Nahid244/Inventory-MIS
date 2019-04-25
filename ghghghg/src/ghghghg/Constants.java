package ghghghg;

import java.awt.Point;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Constants {
    public static int log=0;
    public static String[] functions={
    		"Production cost",
    		"Production quantity",
    		
    		"Rawmaterials expiring today",
    		"Production count",
    		"Profits from each",
    		"Top 3 Profits",
    		"unused rawmaterials",
    		"Average production quantity",
    		"Average production cost",
    		"profits > Average profit",
    		"profits < Average profit(supervisors)"
    };
    public static void tableloader(String s,JTable table,JScrollPane scrollpane,DefaultTableModel dtm){
   	 
    	
  	  try {  
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=austproject;integratedSecurity=true");  
  
              Statement statement = connection.createStatement();  
              
            ResultSet rs = statement.executeQuery("SELECT  * FROM "+s+"");  
            ResultSetMetaData  rsmetadata = rs.getMetaData(); 
             int  columns = rsmetadata.getColumnCount();   
              dtm = new DefaultTableModel(); 
             Vector columns_name=new Vector();
             Vector data_rows=new Vector();
             for(int  i= 1; i < columns+1; i++)  
               {             
                       columns_name.addElement (rsmetadata.getColumnLabel(i));  
               }                 
             
             dtm.setColumnIdentifiers(columns_name);
                  while (rs.next())  
          {  
              data_rows = new Vector(); 
              for (int j = 1; j <columns+1; j++)  
              {  
                  data_rows.addElement(rs.getString(j)) ;
              }  
              dtm.addRow(data_rows);  
              
      }   
         table.setModel(dtm); 
            
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
  	  
  	  
  	
  	  scrollpane.setBounds(10,10,500,200);
  	  scrollpane.setViewportView(table);
  	  scrollpane.getViewport().setViewPosition(new Point(20,20));
    }
    public static void tableloader1(String s,JTable table,JScrollPane scrollpane,DefaultTableModel dtm){
      	 
    	
    	  try {  
              Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
              Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=austproject;integratedSecurity=true");  
    
                Statement statement = connection.createStatement();  
                
              ResultSet rs = statement.executeQuery(s);  
              ResultSetMetaData  rsmetadata = rs.getMetaData(); 
               int  columns = rsmetadata.getColumnCount();   
                dtm = new DefaultTableModel(); 
               Vector columns_name=new Vector();
               Vector data_rows=new Vector();
               for(int  i= 1; i < columns+1; i++)  
                 {             
                         columns_name.addElement (rsmetadata.getColumnLabel(i));  
                 }                 
               
               dtm.setColumnIdentifiers(columns_name);
                    while (rs.next())  
            {  
                data_rows = new Vector(); 
                for (int j = 1; j <columns+1; j++)  
                {  
                    data_rows.addElement(rs.getString(j)) ;
                }  
                dtm.addRow(data_rows);  
                
        }   
           table.setModel(dtm); 
              
          } catch (Exception e) {  
              e.printStackTrace();  
          }  
    	  
    	  
    	
    	  scrollpane.setBounds(10,10,500,200);
    	  scrollpane.setViewportView(table);
    	  scrollpane.getViewport().setViewPosition(new Point(20,20));
      }
    public static void tableloader2(String s,JTable table,JScrollPane scrollpane,DefaultTableModel dtm){
     	 
    	
  	  try {  
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=austproject;integratedSecurity=true");  
  
              Statement statement = connection.createStatement();  
              
            ResultSet rs = statement.executeQuery(s);  
            ResultSetMetaData  rsmetadata = rs.getMetaData(); 
             int  columns = rsmetadata.getColumnCount();   
              dtm = new DefaultTableModel(); 
             Vector columns_name=new Vector();
             Vector data_rows=new Vector();
             for(int  i= 1; i < columns+1; i++)  
               {             
                       columns_name.addElement (rsmetadata.getColumnLabel(i));  
               }                 
             
             dtm.setColumnIdentifiers(columns_name);
                  while (rs.next())  
          {  
              data_rows = new Vector(); 
              for (int j = 1; j <columns+1; j++)  
              {  
                  data_rows.addElement(rs.getString(j)) ;
              }  
              dtm.addRow(data_rows);  
              
      }   
         table.setModel(dtm); 
            
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
  	  
  	  
  	
  	  scrollpane.setBounds(540,10,300,55);
  	  scrollpane.setViewportView(table);
  	  scrollpane.getViewport().setViewPosition(new Point(20,20));
    }
}
