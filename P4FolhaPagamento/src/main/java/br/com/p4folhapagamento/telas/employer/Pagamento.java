package br.com.p4folhapagamento.telas.employer;

import br.com.p4folhapagamento.dal.MysqlManager;
import java.awt.HeadlessException;
import net.proteanit.sql.DbUtils;
import javax.swing.JOptionPane;
import java.sql.*;

public class Pagamento extends javax.swing.JInternalFrame {

    private Connection connection = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;

    public Pagamento() {
        initComponents();
        this.data.setText(EmployerScreen.localDate.toString());
        this.connection = new MysqlManager().getConnection();
        busca();
    }

    private void busca() {
        try {
            String sql = "select e.nome as 'Nome', e.tipo_funcionario as 'Empregado', a.salario as 'Pagamento' from empregados e, assalariado a where e.id_empregado = a.id_empregado and e.data_pagamento = ? union select e.nome as 'Nome', e.tipo_funcionario as 'Empregado', (c.salario + c.total_vendas) as 'Pagamento' from empregados e, comissionado c where e.id_empregado = c.id_empregado and e.data_pagamento = ? union select e.nome as 'Nome', e.tipo_funcionario as 'Empregado', h.salario as 'Pagamento' from empregados e, horista h where e.id_empregado = h.id_empregado and e.data_pagamento = ?";
            String dayOfMonth = "" + EmployerScreen.localDate.getDayOfMonth();
            this.pst = this.connection.prepareStatement(sql);
            this.pst.setString(1, dayOfMonth);
            this.pst.setString(2, dayOfMonth);
            this.pst.setString(3, dayOfMonth);
            this.rs = pst.executeQuery();
            this.tabela.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void pagar() {
        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja realizar os pagamentos?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            if (this.tabela.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Nenhum pagamento realizado!\nOBS: Data atualizada");
            } else {
                try {
                    String sql1 = "update horista h, empregados e set h.salario = ? where e.id_empregado = h.id_empregado and e.data_pagamento = ?";
                    String sql2 = "update comissionado c, empregados e set c.total_vendas = ? where e.id_empregado = c.id_empregado and e.data_pagamento = ?";
                    this.pst = this.connection.prepareStatement(sql1);
                    this.pst.setString(1, "0");
                    this.pst.setString(2, "" + EmployerScreen.localDate.getDayOfMonth());
                    int atualizadoHorista = pst.executeUpdate();
                    
                    this.pst = this.connection.prepareStatement(sql2);
                    this.pst.setString(1, "0");
                    this.pst.setString(2, "" + EmployerScreen.localDate.getDayOfMonth());
                    
                    int atualizadoComissionado = pst.executeUpdate();
                    if (atualizadoHorista > 0 && atualizadoComissionado > 0) {
                        JOptionPane.showMessageDialog(null, "Pagamentos realizados!\nOBS: Data atualizada");
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
            EmployerScreen.localDate = EmployerScreen.localDate.plusDays(1);
            this.data.setText(EmployerScreen.localDate.toString());
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
        jScrollPane2 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();

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

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nome", "Empregado", "Pagamento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela.setEditingColumn(0);
        tabela.setEditingRow(0);
        tabela.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tabela);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 332, Short.MAX_VALUE)
                                .addComponent(btnBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btnPagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(50, 50, 50))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(dataLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(data, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dataLabel)
                    .addComponent(data))
                .addGap(25, 25, 25)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        setBounds(0, 0, 600, 400);
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
