
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class Search_ten extends javax.swing.JFrame {

    private JTable jtable = new JTable();
    private DefaultTableModel tableModel = new DefaultTableModel();
    String ten;
    
        public Search_ten(String ten) { {
            this.ten = ten;
            String []colsName = {"mssv","hoten","gioiTinh","ngaysinh","noiSinh","diaChi","maKhoa"};
            tableModel.setColumnIdentifiers(colsName);
            jtable.setModel(tableModel);

            this.setSize(400, 200);
            JScrollPane scroll = JTable.createScrollPaneForTable(jtable);
            this.add(scroll);
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            this.setVisible(true);

            PreparedStatement st;
            ResultSet rs;

            String sql_ketquahoctap = "call search_ten(\""+ten+"\");";
            try{
                st = Connect_MySQL.openConnection().prepareStatement(sql_ketquahoctap); 
                rs = st.executeQuery();

                while(rs.next()){
                    String rows[] = new String [9];
                    rows[0] = rs.getString(1);
                    rows[1] = rs.getString(2);
                    rows[2] = rs.getString(3);
                    rows[3] = rs.getString(4);
                    rows[4] = rs.getString(5);
                    rows[5] = rs.getString(6);
                    rows[6] = rs.getString(7);
                    tableModel.addRow(rows);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Ketqua_hoctap.class.getName()).log(Level.SEVERE, null, ex);
            }

    }
    }

    private Search_ten() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Search_ten.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Search_ten.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Search_ten.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Search_ten.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Search_ten().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
