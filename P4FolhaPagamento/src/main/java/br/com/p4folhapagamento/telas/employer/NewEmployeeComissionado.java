package br.com.p4folhapagamento.telas.employer;

import br.com.p4folhapagamento.dal.MysqlManager;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import java.sql.*;

public class NewEmployeeComissionado extends javax.swing.JInternalFrame {

    private Connection connection = null;
    private PreparedStatement pst = null;
    private PreparedStatement pst2 = null;

    public NewEmployeeComissionado() {
        initComponents();
        this.connection = new MysqlManager().getConnection();
    }

    private void adicionar() {
        String sql = "insert into empregados(nome,endereco,metodo_pagamento,tipo_funcionario,pertence_sindicato,data_pagamento) values(?,?,?,?,?,?)";
        String sql2 = "insert into comissionado(salario,taxa_venda,id_empregado) values(?,?,?)";

        try {
            this.pst = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            this.pst2 = this.connection.prepareStatement(sql2);

            this.pst.setString(1, this.nome.getText());
            this.pst.setString(2, this.endereco.getText());
            this.pst.setString(3, this.cboPagamento.getSelectedItem().toString());
            this.pst.setString(4, "comissionado");
            this.pst.setString(5, this.cboSindicato.getSelectedItem().toString());
            this.pst.setString(6, "1");

            if (this.nome.getText().isEmpty() || (this.endereco.getText().isEmpty()) || (this.salario.getText().isEmpty()) || (this.taxa.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha os campos obrigatórios");
            } else {

                int adicionado = this.pst.executeUpdate();
                ResultSet rs = pst.getGeneratedKeys();
                int id = 0;
                if (rs.next()) {
                    id = rs.getInt(1);
                }
                this.pst2.setString(1, this.salario.getText());
                this.pst2.setString(2, this.taxa.getText());
                this.pst2.setInt(3, id);
                int adicionado2 = this.pst2.executeUpdate();

                if (adicionado > 0 && adicionado2 > 0) {
                    JOptionPane.showMessageDialog(null, "Usuário adicionado com sucesso");
                    this.nome.setText(null);
                    this.endereco.setText(null);
                    this.salario.setText(null);
                    this.taxa.setText(null);
                }
            }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        nome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cboPagamento = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        endereco = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        salario = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        taxa = new javax.swing.JTextField();
        btnEnviar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        cboSindicato = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Novo Empregado Comossionado");
        setToolTipText("");
        setPreferredSize(new java.awt.Dimension(550, 400));

        jLabel2.setText("*Nome:");

        jLabel3.setText("*Forma de Pagamento:");

        cboPagamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Banco", "Dinheiro" }));

        jLabel4.setText("*Endereco:");

        jLabel5.setText("*Salario:");

        jLabel6.setText("*Taxa (0-100):");

        btnEnviar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/iconfinder_sign-add_299068.png"))); // NOI18N
        btnEnviar.setPreferredSize(new java.awt.Dimension(80, 80));
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        jLabel7.setText("* Campos obrigatorios");

        cboSindicato.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sindicato", "Nao Sindicato" }));

        jLabel1.setText("*Sindicato:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(taxa, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3)
                        .addComponent(nome)
                        .addComponent(cboPagamento, 0, 140, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel4)
                        .addComponent(endereco, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addComponent(salario)
                        .addComponent(cboSindicato, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel1))
                .addGap(104, 104, 104))
            .addGroup(layout.createSequentialGroup()
                .addGap(192, 192, 192)
                .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(endereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(taxa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboSindicato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        adicionar();
    }//GEN-LAST:event_btnEnviarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviar;
    private javax.swing.JComboBox<String> cboPagamento;
    private javax.swing.JComboBox<String> cboSindicato;
    private javax.swing.JTextField endereco;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField nome;
    private javax.swing.JTextField salario;
    private javax.swing.JTextField taxa;
    // End of variables declaration//GEN-END:variables
}
