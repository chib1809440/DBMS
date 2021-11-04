import java.awt.*;  
import javax.swing.JFrame;  
  
public class MyCanvas extends Canvas{  
      
    static String path = "";
    public MyCanvas(String path){
        this.path = path;
    }
    @Override
    public void paint(Graphics g) {  
  
        Toolkit t=Toolkit.getDefaultToolkit();  
        Image i=t.getImage(this.path);  
        g.drawImage(i, 0,0,this);  
          
    }  
    public static void main(String[] args) {  
        
        MyCanvas m=new MyCanvas("C:\\Users\\HP\\OneDrive\\Máy tính\\QR_code\\b1809440.jpg");  
        JFrame f=new JFrame();  
        f.add(m);  
        f.setSize(300,300);  
        f.setVisible(true);  
    }  
  
}  