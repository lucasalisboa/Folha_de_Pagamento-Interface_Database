package br.com.p4folhapagamento.telas.employer;

import br.com.p4folhapagamento.dal.MysqlManager;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import java.sql.*;

public class EditarAgenda extends javax.swing.JInternalFrame {

    private String idFound = "-1";
    private boolean found = false;
    private Connection connection = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;

    public EditarAgenda() {
        initComponents();
        blockForms();
        this.connection = new MysqlManager().getConnection();
    }

    private void busca() {
        if (this.id.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha os campos obrigatórios");
        } else {
            try {
                String sql = "select * from empregados where id_empregado = ?";
                this.pst = this.connection.prepareStatement(sql);
                this.pst.setString(1, this.id.getText());
                this.rs = pst.executeQuery();

                if (this.rs.next()) {
                    this.unblockForms();
                    this.found = true;
                    this.idFound = this.id.getText();
                    this.nome.setText(rs.getString(2));
                    this.pagamento.setSelectedItem(this.rs.getString(4));
                    this.dia.setSelectedItem(this.rs.getString(7));
                } else {
                    JOptionPane.showMessageDialog(null, "Empregado inexistente");
                    this.found = false;
                    this.idFound = "-1";
                    this.clearForms();
                    this.blockForms();
                }
            } catch (HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    private void alterar() {
        if (this.found == false || this.id.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Realize uma pesquisa");
        } else {
            try {
                String sql = "update empregados set metodo_pagamento = ?, data_pagamento = ? where id_empregado = ?";
                this.pst = this.connection.prepareStatement(sql);
                this.pst.setString(1, this.pagamento.getSelectedItem().toString());
                this.pst.setString(2, this.dia.getSelectedItem().toString());
                this.pst.setString(3, this.idFound);
                int adicionado = this.pst.executeUpdate();
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Empregado alterado com sucesso");
                    this.found = false;
                    this.idFound = "-1";
                    this.clearForms();
                    this.blockForms();
                }
            } catch (HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    private void blockForms() {
        this.nome.setFocusable(false);
        this.pagamento.setEnabled(false);
        this.dia.setEnabled(false);
    }

    private void unblockForms() {
        this.pagamento.setEnabled(true);
        this.dia.setEnabled(true);
    }

    private void clearForms() {
        this.id.setText(null);
        this.nome.setText(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nomeLabel = new javax.swing.JLabel();
        nome = new javax.swing.JTextField();
        pagamento = new javax.swing.JComboBox<>();
        pagamentoLabel = new javax.swing.JLabel();
        btnBusca = new javax.swing.JButton();
        idLabel = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        btnAlterar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        diaLabel = new javax.swing.JLabel();
        dia = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        setTitle("Editar Agenda");
        setMinimumSize(new java.awt.Dimension(0, 0));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(550, 400));
        setRequestFocusEnabled(false);

        nomeLabel.setText("Nome:");

        nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeActionPerformed(evt);
            }
        });

        pagamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Banco", "Dinheiro" }));
        pagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pagamentoActionPerformed(evt);
            }
        });

        pagamentoLabel.setText("*Forma de Pagamento:");

        btnBusca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/iconfinder_.svg_2093656.png"))); // NOI18N
        btnBusca.setToolTipText("busca");
        btnBusca.setPreferredSize(new java.awt.Dimension(80, 80));
        btnBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscaActionPerformed(evt);
            }
        });

        idLabel.setText("*ID: ");

        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/iconfinder_update_172618.png"))); // NOI18N
        btnAlterar.setToolTipText("alterar");
        btnAlterar.setPreferredSize(new java.awt.Dimension(80, 80));
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        jLabel2.setText("*Campos obrigatórios");

        diaLabel.setText("*Dia de Pagamento:");

        dia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "3", "7" }));
        dia.setToolTipText("");
        dia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(150, 150, 150))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(nome, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(nomeLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(pagamentoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(pagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBusca, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(idLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                .addComponent(id))
                            .addComponent(diaLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idLabel)
                    .addComponent(nomeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pagamentoLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(diaLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        setBounds(0, 0, 538, 326);
    }// </editor-fold>//GEN-END:initComponents

    private void nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeActionPerformed

    private void pagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pagamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pagamentoActionPerformed

    private void btnBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaActionPerformed
        busca();
    }//GEN-LAST:event_btnBuscaActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        alterar();
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void diaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_diaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnBusca;
    private javax.swing.JComboBox<String> dia;
    private javax.swing.JLabel diaLabel;
    private javax.swing.JTextField id;
    private javax.swing.JLabel idLabel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField nome;
    private javax.swing.JLabel nomeLabel;
    private javax.swing.JComboBox<String> pagamento;
    private javax.swing.JLabel pagamentoLabel;
    // End of variables declaration//GEN-END:variables
}
