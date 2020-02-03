package br.com.p4folhapagamento.telas.employer;

import br.com.p4folhapagamento.dal.MysqlManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.inject.Inject;
import javax.swing.JOptionPane;
import java.sql.Statement;

public class RemoveEmployee extends javax.swing.JInternalFrame {

    @Inject
    private MysqlManager mysqlManager;
    private Connection connection = null;
    private PreparedStatement pst = null;
    private PreparedStatement pst2 = null;
    private PreparedStatement pst3 = null;
    private ResultSet rs = null;

    public RemoveEmployee() {
        initComponents();
        this.connection = new MysqlManager().getConnection();
    }

    private void busca() {
        String sql = "select * from empregados where id_empregado = ?";

        try {
            // aqui para tabela empregados
            this.pst = this.connection.prepareStatement(sql);
            this.pst.setString(1, txtId.getText());
            this.rs = pst.executeQuery();

            //caso exista esse usuario tem que setar os campos
            if (this.rs.next()) {
                this.txtNome.setText(rs.getString(2));
                this.txtEndereco.setText(rs.getString(3));
                this.txtPagamento.setText(rs.getString(4));
                this.txtTipo.setText(rs.getString(5));
                this.txtSindicato.setText(rs.getString(6));
            } else {
                JOptionPane.showMessageDialog(null, "Empregado nao encontrado");
                this.txtNome.setText(null);
                this.txtEndereco.setText(null);
                this.txtPagamento.setText(null);
                this.txtTipo.setText(null);
                this.txtSindicato.setText(null);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void remover() {
        String sql = "select * from empregados where id_empregado = ?";
        String sql2 = "delete from empregados where id_empregado = ?";
        String sql3 = "delete from assalariado where id_empregado = ?";
        String sql4 = "delete from horista where id_empregado = ?";
        String sql5 = "delete from comissionado where id_empregado = ?";

        try {
            this.pst = this.connection.prepareStatement(sql);
            this.pst.setString(1, txtId.getText());
            String tipo = txtTipo.getText();
            this.rs = this.pst.executeQuery();

            if (tipo.equals("assalariado")) {
                this.pst2 = this.connection.prepareStatement(sql3);
                this.pst2.setString(1, txtId.getText());
                this.pst2.executeUpdate();
            } else if (tipo.equals("horista")) {
                this.pst2 = this.connection.prepareStatement(sql4);
                this.pst2.setString(1, txtId.getText());
                this.pst2.executeUpdate();
            } else {
                this.pst2 = this.connection.prepareStatement(sql5);
                this.pst2.setString(1, txtId.getText());
                this.pst2.executeUpdate();
            }

            this.pst3 = this.connection.prepareStatement(sql2);
            this.pst3.setString(1, txtId.getText());
            int apagado2 = this.pst3.executeUpdate();

            if (this.rs.next() && (apagado2 > 0)) {
                JOptionPane.showMessageDialog(null, "empregado removido com sucesso");
                this.txtNome.setText(null);
                this.txtEndereco.setText(null);
                this.txtPagamento.setText(null);
                this.txtTipo.setText(null);
                this.txtSindicato.setText(null);
            } else {
                JOptionPane.showMessageDialog(null, "Empregado nao encontrado");
                this.txtNome.setText(null);
                this.txtEndereco.setText(null);
                this.txtPagamento.setText(null);
                this.txtTipo.setText(null);
                this.txtSindicato.setText(null);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nomeLabel = new javax.swing.JLabel();
        enderecoLabel = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        tipoLabel = new javax.swing.JLabel();
        txtTipo = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        txtEndereco = new javax.swing.JTextField();
        txtSindicato = new javax.swing.JTextField();
        sindicatoLabel = new javax.swing.JLabel();
        pagamentoLabel = new javax.swing.JLabel();
        txtPagamento = new javax.swing.JTextField();
        btnEnviar = new javax.swing.JButton();
        idLabel = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("Remover Empregado");
        setMinimumSize(new java.awt.Dimension(0, 0));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(550, 400));
        setRequestFocusEnabled(false);

        nomeLabel.setText("Nome");

        enderecoLabel.setText("Endereço");

        txtNome.setFocusable(false);
        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        tipoLabel.setText("Tipo de Empregado");

        txtTipo.setFocusable(false);
        txtTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTipoActionPerformed(evt);
            }
        });

        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/iconfinder_.svg_2093656.png"))); // NOI18N
        btnPesquisar.setToolTipText("buscar");
        btnPesquisar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        txtEndereco.setFocusable(false);

        txtSindicato.setFocusable(false);
        txtSindicato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSindicatoActionPerformed(evt);
            }
        });

        sindicatoLabel.setText("Sindicalizado");

        pagamentoLabel.setText("Forma de Pagamento");

        txtPagamento.setFocusable(false);
        txtPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPagamentoActionPerformed(evt);
            }
        });

        btnEnviar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/iconfinder_sign-error_299045.png"))); // NOI18N
        btnEnviar.setToolTipText("enviar");
        btnEnviar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEnviar.setPreferredSize(new java.awt.Dimension(80, 80));
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        idLabel.setText("*Id:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtNome)
                                .addComponent(nomeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pagamentoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtPagamento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tipoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(70, 70, 70))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnPesquisar)
                        .addGap(133, 133, 133)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtEndereco)
                    .addComponent(enderecoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSindicato, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(sindicatoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(idLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtId)
                    .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idLabel)
                    .addComponent(nomeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(enderecoLabel)
                    .addComponent(tipoLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pagamentoLabel)
                    .addComponent(sindicatoLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSindicato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPesquisar)
                    .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(142, 142, 142))
        );

        setBounds(0, 0, 538, 391);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void txtTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipoActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        busca();
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void txtSindicatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSindicatoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSindicatoActionPerformed

    private void txtPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPagamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPagamentoActionPerformed

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        remover();
    }//GEN-LAST:event_btnEnviarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JLabel enderecoLabel;
    private javax.swing.JLabel idLabel;
    private javax.swing.JLabel nomeLabel;
    private javax.swing.JLabel pagamentoLabel;
    private javax.swing.JLabel sindicatoLabel;
    private javax.swing.JLabel tipoLabel;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPagamento;
    private javax.swing.JTextField txtSindicato;
    private javax.swing.JTextField txtTipo;
    // End of variables declaration//GEN-END:variables
}
