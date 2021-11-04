
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class check {
    String IDname;
    String Fname ;
    String gender ;
    String dob;
    String pob ;
    String address;
    String faculty;
    
    public check(String IDname){
        this.IDname=IDname;

    }
    
    public static boolean checK(String IDname){
        PreparedStatement st;
        ResultSet rs;
        
        try{
                String query_insert = "select username from users where username = '"+IDname+"';";
                st = Connect_MySQL.openConnection().prepareStatement(query_insert); 

                rs = st.executeQuery();  
                Connect_MySQL.openConnection().close();
                
                while(rs.next()){
                    if(rs.getString(1).equals(IDname)){
                        return true;
                    }
                    return false;
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        return false;
    }

}
