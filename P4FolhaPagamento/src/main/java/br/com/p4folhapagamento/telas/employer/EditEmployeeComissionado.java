package br.com.p4folhapagamento.telas.employer;

import br.com.p4folhapagamento.dal.MysqlManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.inject.Inject;
import javax.swing.JOptionPane;

public class EditEmployeeComissionado extends javax.swing.JInternalFrame {

    @Inject
    private MysqlManager mysqlManager;
    private Connection connection = null;
    private PreparedStatement pst = null;
    private PreparedStatement pst2 = null;
    private ResultSet rs = null;
    private ResultSet rs2 = null;

    public EditEmployeeComissionado() {
        initComponents();
        this.connection = new MysqlManager().getConnection();
    }

    private void busca() {
        String sql = "select * from empregados where id_empregado = ?";
        String sql2 = "select * from comissionado where id_empregado = ?";

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
                this.txtEndereco.setText(rs.getString(3));
                this.cboPagamento.setSelectedItem(rs.getString(4));
                this.cboSindicato.setSelectedItem(rs.getString(6));
                this.txtSalario.setText(rs2.getString(2));
                this.txtTaxa.setText(rs2.getString(3));
            } else {
                JOptionPane.showMessageDialog(null, "Empregado nao encontrado");
                this.txtNome.setText(null);
                this.txtEndereco.setText(null);
                this.txtSalario.setText(null);
                this.txtTaxa.setText(null);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void alterar() {
        String sql = "update empregados set nome = ?, endereco = ?, metodo_pagamento = ?, pertence_sindicato = ? where id_empregado = ?";
        String sql2 = "update comissionado set salario=?, taxa_venda = ? where id_empregado = ?";

        try {
            // arrumando Empregado
            this.pst = this.connection.prepareStatement(sql);

            this.pst.setString(1, this.txtNome.getText());
            this.pst.setString(2, this.txtEndereco.getText());
            this.pst.setString(3, this.cboPagamento.getSelectedItem().toString());
            this.pst.setString(4, this.cboSindicato.getSelectedItem().toString());
            this.pst.setString(5, this.txtId.getText());

            //arrumando horista
            this.pst2 = this.connection.prepareStatement(sql2);
            this.pst2.setString(1, this.txtSalario.getText());
            this.pst2.setString(2, this.txtTaxa.getText());
            this.pst2.setString(3, this.txtId.getText());

            if (this.txtNome.getText().isEmpty() || (this.txtEndereco.getText().isEmpty()) || (this.txtSalario.getText().isEmpty()) || (this.txtId.getText().isEmpty()) || (this.txtTaxa.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha os campos obrigatorios");
            } else {
                int adicionado = this.pst.executeUpdate();
                int adicionado2 = this.pst2.executeUpdate();

                if (adicionado > 0 && adicionado2 > 0) {
                    JOptionPane.showMessageDialog(null, "Empregado alterado com sucesso");
                    this.txtNome.setText(null);
                    this.txtEndereco.setText(null);
                    this.txtSalario.setText(null);
                    this.txtTaxa.setText(null);
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtSalario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTaxa = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cboSindicato = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cboPagamento = new javax.swing.JComboBox<>();
        btnBusca = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Editar Empregado Comissionado");
        setToolTipText("");

        jLabel1.setText("*Nome:");

        jLabel2.setText("*Salario:");

        jLabel3.setText("*Id:");

        jLabel4.setText("*Taxa (0-100):");

        jLabel5.setText("*Sindicato:");

        cboSindicato.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sindicato", "Nao Sindicato" }));

        jLabel6.setText("*Forma de Pagamento:");

        cboPagamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Banco", "Dinheiro" }));

        btnBusca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/iconfinder_.svg_2093656.png"))); // NOI18N
        btnBusca.setToolTipText("busca");
        btnBusca.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBusca.setPreferredSize(new java.awt.Dimension(80, 80));
        btnBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscaActionPerformed(evt);
            }
        });

        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/iconfinder_update_172618.png"))); // NOI18N
        btnAlterar.setToolTipText("");
        btnAlterar.setPreferredSize(new java.awt.Dimension(80, 80));
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        jLabel7.setText("*Endereco:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtEndereco, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtTaxa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNome, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSalario, javax.swing.GroupLayout.Alignment.LEADING))
                                .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel6)
                                .addComponent(jLabel3)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5)
                                .addComponent(cboSindicato, 0, 140, Short.MAX_VALUE)
                                .addComponent(cboPagamento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(btnBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(38, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboSindicato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTaxa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaActionPerformed
        busca();
    }//GEN-LAST:event_btnBuscaActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        alterar();
    }//GEN-LAST:event_btnAlterarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnBusca;
    private javax.swing.JComboBox<String> cboPagamento;
    private javax.swing.JComboBox<String> cboSindicato;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtSalario;
    private javax.swing.JTextField txtTaxa;
    // End of variables declaration//GEN-END:variables
}
