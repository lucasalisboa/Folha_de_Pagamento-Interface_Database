package br.com.p4folhapagamento.telas.employer;

import br.com.p4folhapagamento.dal.MysqlManager;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.sql.*;

public class Pagamento extends javax.swing.JInternalFrame {

    private Connection connection = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    private LocalDate localDate;

    public Pagamento(LocalDate localDate) {
        initComponents();
        this.localDate = localDate;
        this.data.setText(this.localDate.toString());
        this.connection = new MysqlManager().getConnection();
        busca();
    }

    private void busca() {
        try {
            String sql = "select count(data_pagamento) from empregados where data_pagamento = ?";
            this.pst = this.connection.prepareStatement(sql);
            this.pst.setString(1, "" + this.localDate.getDayOfMonth());
            this.rs = pst.executeQuery();
            if (this.rs.next()) {
                this.nPagamentos.setText(rs.getString(1));
            } else {
                this.nPagamentos.setText("0");
            }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void pagar() {
        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja realizar os pagamentos?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            if (this.nPagamentos.getText().equals("0")) {
                JOptionPane.showMessageDialog(null, "Que maravilha, não preciso pagar!\nOBS: Data atualizada");
            } else {
                JOptionPane.showMessageDialog(null, "Pagamentos realizados!\nOBS: Data atualizada");
            }
            this.localDate = this.localDate.plusDays(1);
            this.data.setText(this.localDate.toString());
            busca();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnPagar = new javax.swing.JButton();
        btnBusca = new javax.swing.JButton();
        dataLabel = new javax.swing.JLabel();
        data = new javax.swing.JLabel();
        nPagamentos = new javax.swing.JLabel();
        nPagamentosLabel = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Pagamento");
        setMinimumSize(new java.awt.Dimension(0, 0));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(550, 400));
        setRequestFocusEnabled(false);

        btnPagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/pay2.png"))); // NOI18N
        btnPagar.setToolTipText("busca");
        btnPagar.setPreferredSize(new java.awt.Dimension(80, 80));
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarActionPerformed(evt);
            }
        });

        btnBusca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/refresh.png"))); // NOI18N
        btnBusca.setToolTipText("alterar");
        btnBusca.setPreferredSize(new java.awt.Dimension(80, 80));
        btnBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscaActionPerformed(evt);
            }
        });

        dataLabel.setText("Data:");

        data.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        data.setText("-1");
        data.setToolTipText("");

        nPagamentos.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        nPagamentos.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        nPagamentos.setText("-1");

        nPagamentosLabel.setText("Empregados:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnPagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(nPagamentosLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nPagamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(73, 73, 73))
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(dataLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(data, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dataLabel)
                    .addComponent(data))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nPagamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nPagamentosLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        setBounds(0, 0, 326, 260);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed
        pagar();
    }//GEN-LAST:event_btnPagarActionPerformed

    private void btnBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaActionPerformed
        busca();
    }//GEN-LAST:event_btnBuscaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBusca;
    private javax.swing.JButton btnPagar;
    private javax.swing.JLabel data;
    private javax.swing.JLabel dataLabel;
    private javax.swing.JLabel nPagamentos;
    private javax.swing.JLabel nPagamentosLabel;
    // End of variables declaration//GEN-END:variables
}
