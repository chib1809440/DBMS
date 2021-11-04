
import com.google.zxing.*;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFrame;

public class Qr_test {
    public static void main(String[] args) throws SQLException, FileNotFoundException, IOException, WriterException {
        PreparedStatement st;
        ResultSet rs;
        
        String sql_ketquahoctap = "select mssv from sinhvien;";
        st = Connect_MySQL.openConnection().prepareStatement(sql_ketquahoctap); 
        rs = st.executeQuery();
        ArrayList<String> row = new ArrayList<String>();
        String str = "";
        while(rs.next()){
            str = rs.getString(1);
            row.add(str) ;
        }
        System.out.println(row);
        Connect_MySQL.openConnection().close();
        int number = 0;
        for(int i=0; i<row.size()-1; i++){
            String data = row.get(i);
            for(int j=i+1; j<row.size(); j++){
                String data1 = row.get(j);
                String path1 = "C:\\Users\\HP\\OneDrive\\Máy tính\\QR_code\\"+data+".jpg";
                String path2 = "C:\\Users\\HP\\OneDrive\\Máy tính\\QR_code\\"+data1+".jpg";
                File f1 = new File(path1);
                File f2 = new File(path2);

                FileInputStream fis1 = new FileInputStream(f1);
                FileInputStream fis2= new FileInputStream(f2);

                byte[] b1 = new byte[(int)f1.length()];
                byte[] b2 = new byte[(int)f2.length()];

                fis1.read(b1);
                fis2.read(b2);

                String s1 = new String(b1);
                String s2 = new String(b2);

                if(s1.equals(s2)){
                    System.out.println(data+" Similar "+data1);
                    break;
                }    
                else{
                    number++;
                }
                    
            }
            
//            BitMatrix matrix = new MultiFormatWriter()
//                .encode(data, BarcodeFormat.QR_CODE, 150, 150);
//            MatrixToImageWriter.writeToPath(matrix, "jpg", Paths.get(path));
//            System.out.println(path);
//            MyCanvas m=new MyCanvas(path);  
//            JFrame f=new JFrame();  
//            f.add(m);  
//            f.setSize(300,300);  
//            f.setVisible(true); 
//            f.setTitle(data);
            
        }
        
        if(number==66){
            System.out.println("All are differrent");
        }
        
    }
}
