package br.com.p4folhapagamento.telas;

import br.com.p4folhapagamento.telas.employer.EmployerScreen;
import br.com.p4folhapagamento.dal.MysqlManager;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.time.LocalDate;
import java.net.URL;
import java.sql.*;

public class LoginScreen extends javax.swing.JFrame {

    private Connection connection = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;

    public LoginScreen() {
        initComponents();
        initMysqlConnection();
    }

    private void initMysqlConnection() {
        this.connection = new MysqlManager().getConnection();
        if (this.connection != null) {
            URL resource = getClass().getResource("/icones/dbon24.png");
            ImageIcon imageIcon = new ImageIcon(resource);
            statusLabel.setIcon(imageIcon);
            statusLabel.setText("Database ON");
        } else {
            URL resource = getClass().getResource("/icones/dboff24.png");
            ImageIcon imageIcon = new ImageIcon(resource);
            statusLabel.setIcon(imageIcon);
            statusLabel.setText("Database OFF");
        }
    }

    public void login() {
        if (this.connection != null) {
            String sql = "select * from usuarios where usuario=? and senha=?";
            try {
                this.pst = this.connection.prepareStatement(sql);
                this.pst.setString(1, this.usuario.getText());
                this.pst.setString(2, this.senha.getText());
                this.rs = this.pst.executeQuery();

                if (this.rs.next()) {
                    if (this.rs.getString(4).equals("admin")) {
                        new EmployerScreen(LocalDate.now()).setVisible(true);
                        EmployerScreen.empregadoEditar.setEnabled(true);
                        EmployerScreen.empregadoNovo.setEnabled(true);
                        EmployerScreen.empregadoRemover.setEnabled(true);
                        EmployerScreen.usuarioNovo.setEnabled(true);
                        EmployerScreen.usuarioRemover.setEnabled(true);
                        EmployerScreen.usuarioAlterar.setEnabled(true);
                    } else {
                        new EmployerScreen(LocalDate.now()).setVisible(true);
                    }
                    this.dispose();
                    this.connection.close();
                } else {
                    JOptionPane.showMessageDialog(null, "Usuário e/ou senha inválido(s)");
                }
            } catch (HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ops, database offline");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        usuarioLabel = new javax.swing.JLabel();
        senhaLabel = new javax.swing.JLabel();
        usuario = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();
        senha = new javax.swing.JPasswordField();
        jPanel1 = new javax.swing.JPanel();
        statusLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Vapa - Login");
        setBackground(new java.awt.Color(112, 112, 112));
        setResizable(false);

        usuarioLabel.setText("Usuário");

        senhaLabel.setText("Senha");

        usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioActionPerformed(evt);
            }
        });

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        senha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                senhaActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 230, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        statusLabel.setText("Status");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(usuarioLabel)
                    .addComponent(senhaLabel)
                    .addComponent(usuario)
                    .addComponent(senha)
                    .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(statusLabel))
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 110, Short.MAX_VALUE)
                        .addComponent(usuarioLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(senhaLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLogin)
                        .addGap(110, 110, 110)
                        .addComponent(statusLabel))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(460, 430));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usuarioActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        login();
    }//GEN-LAST:event_btnLoginActionPerformed

    private void senhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_senhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_senhaActionPerformed

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
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField senha;
    private javax.swing.JLabel senhaLabel;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JTextField usuario;
    private javax.swing.JLabel usuarioLabel;
    // End of variables declaration//GEN-END:variables
}
