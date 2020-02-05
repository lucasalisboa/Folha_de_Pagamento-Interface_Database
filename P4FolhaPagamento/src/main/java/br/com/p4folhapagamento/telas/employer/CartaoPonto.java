package br.com.p4folhapagamento.telas.employer;

import br.com.p4folhapagamento.dal.MysqlManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.inject.Inject;
import javax.swing.JOptionPane;

public class CartaoPonto extends javax.swing.JInternalFrame {

    @Inject
    private MysqlManager mysqlManager;
    private Connection connection = null;
    private PreparedStatement pst = null;
    private PreparedStatement pst2 = null;
    private ResultSet rs = null;
    private ResultSet rs2 = null;

    public CartaoPonto() {
        initComponents();
        this.connection = new MysqlManager().getConnection();
    }

    private void cartaoPonto() {
        String sql = "update horista set hora=? where id_empregado=?";
        String sql2 = "select * from horista where id_empregado = ?";

        try {
            // aqui para tabela horistas
            this.pst2 = this.connection.prepareStatement(sql2);
            this.pst2.setString(1, txtId.getText());
            this.rs2 = pst2.executeQuery();

            if (this.rs2.next()) {
                String valor_hora = this.txtHora.getText();
                String horas = this.rs2.getString(3);

                if (!valor_hora.equals("")) {
                    int total = Integer.parseInt(horas);
                    int hora = Integer.parseInt(valor_hora);
                    total += hora;

                    this.pst = this.connection.prepareStatement(sql);
                    this.pst.setString(1,Integer.toString(total));
                    this.pst.setString(2, this.txtId.getText());
                    this.pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Horas Adicionada com sucesso");
                }else{
                    JOptionPane.showMessageDialog(null, "Falta preencher o campo das horas adicionadas");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Empregado nao encontrado");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void busca() {
        String sql = "select * from empregados where id_empregado = ?";
        String sql2 = "select * from horista where id_empregado = ?";

        try {
            // aqui para tabela empregados
            this.pst = this.connection.prepareStatement(sql);
            this.pst.setString(1, txtId.getText());
            this.rs = pst.executeQuery();

            // aqui para tabela horistas
            this.pst2 = this.connection.prepareStatement(sql2);
            this.pst2.setString(1, txtId.getText());
            this.rs2 = pst2.executeQuery();

            //caso exista esse usuario tem que setar os campos
            if (this.rs.next() && this.rs2.next()) {
                this.txtNome.setText(rs.getString(2));
                this.txtIdHorista.setText(rs2.getString(1));
            } else {
                JOptionPane.showMessageDialog(null, "Empregado nao encontrado");
                this.txtNome.setText(null);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtHora = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtIdHorista = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Cartao de Ponto");

        jLabel1.setText("*ID Empregado:");

        jLabel2.setText("*Quantidade de Horas Trabalhadas:");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/iconfinder_sign-add_299068.png"))); // NOI18N
        jButton1.setToolTipText("Adicionar");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setPreferredSize(new java.awt.Dimension(80, 80));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("*Campos Obrigatorios");

        jLabel4.setText("Nome do Empregado:");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/iconfinder_.svg_2093656.png"))); // NOI18N
        jButton2.setToolTipText("Buscar");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel5.setText("Id Horista:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4)
                    .addComponent(txtNome)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtIdHorista, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))
                .addGap(37, 37, 37))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdHorista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        busca();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        cartaoPonto();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtIdHorista;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
