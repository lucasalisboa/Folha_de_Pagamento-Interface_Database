package br.com.p4folhapagamento.telas.employer;

import br.com.p4folhapagamento.dal.MysqlManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.inject.Inject;
import javax.swing.JOptionPane;

public class EditEmployeeHourly extends javax.swing.JInternalFrame {

    @Inject
    private MysqlManager mysqlManager;
    private Connection connection = null;
    private PreparedStatement pst = null;
    private PreparedStatement pst2 = null;
    private ResultSet rs = null;
    private ResultSet rs2 = null;

    public EditEmployeeHourly() {
        initComponents();
        this.connection = new MysqlManager().getConnection();
    }

    private void busca() {
        String sql = "select * from empregados where id_empregado = ?";
        String sql2 = "select * from horista where id_empregado = ?";

        try {
            // aqui para tabela empregados
            this.pst = this.connection.prepareStatement(sql);
            this.pst.setString(1, id.getText());
            this.rs = pst.executeQuery();

            // aqui para tabela horistas
            this.pst2 = this.connection.prepareStatement(sql2);
            this.pst2.setString(1, id.getText());
            this.rs2 = pst2.executeQuery();

            //caso exista esse usuario tem que setar os campos
            if (this.rs.next() && this.rs2.next()) {
                this.txtNome.setText(rs.getString(2));
                this.txtEndereco.setText(rs.getString(3));
                this.cboPagamento.setSelectedItem(rs.getString(4));
                this.cboSindicato.setSelectedItem(rs.getString(6));
                this.txtSalario.setText(rs2.getString(2));
            } else {
                JOptionPane.showMessageDialog(null, "Empregado nao encontrado");
                this.txtNome.setText(null);
                this.txtEndereco.setText(null);
                this.txtSalario.setText(null);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void alterar() {
        String sql = "update empregados set nome = ?, endereco = ?, metodo_pagamento = ?, pertence_sindicato = ? where id_empregado = ?";
        String sql2 = "update horista set hora_salario=? where id_empregado = ?";

        try {
            // arrumando Empregado
            this.pst = this.connection.prepareStatement(sql);

            this.pst.setString(1, this.txtNome.getText());
            this.pst.setString(2, this.txtEndereco.getText());
            this.pst.setString(3, this.cboPagamento.getSelectedItem().toString());
            this.pst.setString(4, this.cboSindicato.getSelectedItem().toString());
            this.pst.setString(5, this.id.getText());

            //arrumando horista
            this.pst2 = this.connection.prepareStatement(sql2);
            this.pst2.setString(1, this.txtSalario.getText());
            this.pst2.setString(2, this.id.getText());

            if (this.txtNome.getText().isEmpty() || (this.txtEndereco.getText().isEmpty()) || (this.txtSalario.getText().isEmpty()) || (this.id.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha os campos obrigatorios");
            } else {
                int adicionado = this.pst.executeUpdate();
                int adicionado2 = this.pst2.executeUpdate();

                if (adicionado > 0 && adicionado2 > 0) {
                    JOptionPane.showMessageDialog(null, "Empregado alterado com sucesso");
                    this.txtNome.setText(null);
                    this.txtEndereco.setText(null);
                    this.txtSalario.setText(null);
                }
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
        txtEndereco = new javax.swing.JTextField();
        cboPagamento = new javax.swing.JComboBox<>();
        pagamentoLabel = new javax.swing.JLabel();
        salarioLabel = new javax.swing.JLabel();
        txtSalario = new javax.swing.JTextField();
        btnEnviar = new javax.swing.JButton();
        idLabel = new javax.swing.JLabel();
        cboSindicato = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        btnBusca = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Editar Empregado Horista");
        setMinimumSize(new java.awt.Dimension(0, 0));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(550, 400));
        setRequestFocusEnabled(false);

        nomeLabel.setText("*Nome:");

        enderecoLabel.setText("*Endereço:");

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        cboPagamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Banco", "Dinheiro" }));
        cboPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboPagamentoActionPerformed(evt);
            }
        });

        pagamentoLabel.setText("*Forma de Pagamento:");

        salarioLabel.setText("*Salário/Hora:");

        txtSalario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSalarioActionPerformed(evt);
            }
        });

        btnEnviar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/iconfinder_update_172618.png"))); // NOI18N
        btnEnviar.setToolTipText("update");
        btnEnviar.setPreferredSize(new java.awt.Dimension(80, 80));
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        idLabel.setText("*ID:");

        cboSindicato.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sindicato", "Nao Sindicato" }));

        jLabel1.setText("*Sindicato:");

        btnBusca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/iconfinder_.svg_2093656.png"))); // NOI18N
        btnBusca.setToolTipText("Busca");
        btnBusca.setPreferredSize(new java.awt.Dimension(80, 80));
        btnBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscaActionPerformed(evt);
            }
        });

        jLabel2.setText("*Campo Obrigatorio");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(nomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pagamentoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cboPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(salarioLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSalario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboSindicato, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(enderecoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(59, 59, 59))
            .addGroup(layout.createSequentialGroup()
                .addGap(227, 227, 227)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idLabel)
                    .addComponent(nomeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pagamentoLabel)
                    .addComponent(enderecoLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salarioLabel)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboSindicato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        setBounds(0, 0, 538, 382);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void cboPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboPagamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboPagamentoActionPerformed

    private void txtSalarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSalarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSalarioActionPerformed

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        alterar();
    }//GEN-LAST:event_btnEnviarActionPerformed

    private void btnBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaActionPerformed
        busca();
    }//GEN-LAST:event_btnBuscaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBusca;
    private javax.swing.JButton btnEnviar;
    private javax.swing.JComboBox<String> cboPagamento;
    private javax.swing.JComboBox<String> cboSindicato;
    private javax.swing.JLabel enderecoLabel;
    private javax.swing.JTextField id;
    private javax.swing.JLabel idLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel nomeLabel;
    private javax.swing.JLabel pagamentoLabel;
    private javax.swing.JLabel salarioLabel;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtSalario;
    // End of variables declaration//GEN-END:variables
}
