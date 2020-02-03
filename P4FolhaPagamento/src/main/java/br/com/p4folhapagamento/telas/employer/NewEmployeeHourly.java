package br.com.p4folhapagamento.telas.employer;

import br.com.p4folhapagamento.dal.MysqlManager;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import java.sql.*;

public class NewEmployeeHourly extends javax.swing.JInternalFrame {

    private Connection connection = null;
    private PreparedStatement pst = null;
    private PreparedStatement pst2 = null;

    public NewEmployeeHourly() {
        initComponents();
        this.connection = new MysqlManager().getConnection();
    }

    private void adicionar() {
        String sql = "insert into empregados(nome,endereco,metodo_pagamento,tipo_funcionario,pertence_sindicato,data_pagamento) values(?,?,?,?,?,?)";
        String sql2 = "insert into horista(hora_salario,id_empregado) values(?,?)";

        try {
            this.pst = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            this.pst2 = this.connection.prepareStatement(sql2);

            this.pst.setString(1, this.txtHoristaNome.getText());
            this.pst.setString(2, this.endereco.getText());
            this.pst.setString(3, this.cboPagamento.getSelectedItem().toString());
            this.pst.setString(4, "horista");
            this.pst.setString(5, this.cboSindicato.getSelectedItem().toString());
            this.pst.setString(6, "1");

            if (this.txtHoristaNome.getText().isEmpty() || (this.endereco.getText().isEmpty()) || (this.salario.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha os campos obrigatórios");
            } else {

                int adicionado = this.pst.executeUpdate();
                ResultSet rs = pst.getGeneratedKeys();
                int id = 0;
                if (rs.next()) {
                    id = rs.getInt(1);
                }
                this.pst2.setString(1, this.salario.getText());
                this.pst2.setInt(2, id);
                int adicionado2 = this.pst2.executeUpdate();

                if (adicionado > 0 && adicionado2 > 0) {
                    JOptionPane.showMessageDialog(null, "Usuário adicionado com sucesso");
                    this.txtHoristaNome.setText(null);
                    this.endereco.setText(null);
                    this.salario.setText(null);
                }
            }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nomeLabel = new javax.swing.JLabel();
        enderecoLabel = new javax.swing.JLabel();
        txtHoristaNome = new javax.swing.JTextField();
        endereco = new javax.swing.JTextField();
        cboPagamento = new javax.swing.JComboBox<>();
        pagamentoLabel = new javax.swing.JLabel();
        salarioLabel = new javax.swing.JLabel();
        salario = new javax.swing.JTextField();
        btnEnviar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cboSindicato = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Novo Empregado Horista");
        setMinimumSize(new java.awt.Dimension(0, 0));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(550, 400));
        setRequestFocusEnabled(false);

        nomeLabel.setText("*Nome:");

        enderecoLabel.setText("*Endereço:");

        txtHoristaNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHoristaNomeActionPerformed(evt);
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

        salario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salarioActionPerformed(evt);
            }
        });

        btnEnviar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/iconfinder_sign-add_299068.png"))); // NOI18N
        btnEnviar.setPreferredSize(new java.awt.Dimension(80, 80));
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        jLabel2.setText("* Campos obrigatorios");

        cboSindicato.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sindicato", "Nao Sindicato" }));

        jLabel1.setText("*Sindicato:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtHoristaNome)
                            .addComponent(nomeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboPagamento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pagamentoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(salarioLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(salario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(99, 99, 99)
                                .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(endereco, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(enderecoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cboSindicato, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(enderecoLabel)
                    .addComponent(nomeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(endereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHoristaNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salarioLabel)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboSindicato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addComponent(pagamentoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        setBounds(0, 0, 538, 338);
    }// </editor-fold>//GEN-END:initComponents

    private void txtHoristaNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHoristaNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHoristaNomeActionPerformed

    private void cboPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboPagamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboPagamentoActionPerformed

    private void salarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_salarioActionPerformed

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        adicionar();
    }//GEN-LAST:event_btnEnviarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviar;
    private javax.swing.JComboBox<String> cboPagamento;
    private javax.swing.JComboBox<String> cboSindicato;
    private javax.swing.JTextField endereco;
    private javax.swing.JLabel enderecoLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel nomeLabel;
    private javax.swing.JLabel pagamentoLabel;
    private javax.swing.JTextField salario;
    private javax.swing.JLabel salarioLabel;
    private javax.swing.JTextField txtHoristaNome;
    // End of variables declaration//GEN-END:variables
}
