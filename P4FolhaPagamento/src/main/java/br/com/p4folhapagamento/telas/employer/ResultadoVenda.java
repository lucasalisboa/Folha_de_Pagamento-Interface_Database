package br.com.p4folhapagamento.telas.employer;

import br.com.p4folhapagamento.dal.MysqlManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.inject.Inject;
import javax.swing.JOptionPane;

public class ResultadoVenda extends javax.swing.JInternalFrame {

    @Inject
    private MysqlManager mysqlManager;
    private Connection connection = null;
    private PreparedStatement pst = null;
    private PreparedStatement pst2 = null;
    private ResultSet rs = null;
    private ResultSet rs2 = null;

    public ResultadoVenda() {
        initComponents();
        this.connection = new MysqlManager().getConnection();
    }

    private void resultadoVenda() {
        String sql = "update comissionado set total_vendas=? where id_empregado=?";
        String sql2 = "select * from comissionado where id_empregado = ?";

        try {
            // aqui para tabela comissionado
            this.pst2 = this.connection.prepareStatement(sql2);
            this.pst2.setString(1, txtId.getText());
            this.rs2 = pst2.executeQuery();

            if (this.rs2.next()) {
                String venda = this.txtVenda.getText();
                String porcentagem = this.rs2.getString(3);
                String total_vendas = this.rs2.getString(4);
                
                if (!venda.equals("")) {
                    double total_vendas_double = Double.parseDouble(total_vendas);
                    double total = Double.parseDouble(venda);
                    double porcentagem_double = Integer.parseInt(porcentagem);
                    double resultado = total * (porcentagem_double/100);
                    double total_vendas2 = resultado + total_vendas_double;  
                            
                    this.pst = this.connection.prepareStatement(sql);
                    this.pst.setString(1, Double.toString(total_vendas2));
                    this.pst.setString(2, this.txtId.getText());
                    this.pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Resultado de Venda adicionado com sucesso");
                } else {
                    JOptionPane.showMessageDialog(null, "Falta preencher o campo da venda adicionada");
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
                this.txtIdComissionado.setText(rs2.getString(1));
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
        txtVenda = new javax.swing.JTextField();
        btnEnviar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtIdComissionado = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Resultado de Venda");
        setToolTipText("");

        jLabel1.setText("*ID Empregado:");

        jLabel2.setText("*Venda:");

        btnEnviar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/iconfinder_sign-add_299068.png"))); // NOI18N
        btnEnviar.setToolTipText("Enviar");
        btnEnviar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEnviar.setPreferredSize(new java.awt.Dimension(80, 80));
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        jLabel3.setText("* Campos Obrigatorios");

        jLabel4.setText("Id Comissionado:");

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/iconfinder_.svg_2093656.png"))); // NOI18N
        btnBuscar.setToolTipText("Buscar");
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.setPreferredSize(new java.awt.Dimension(80, 80));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel5.setText("Nome:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(txtId, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                    .addComponent(txtVenda)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel4)
                        .addComponent(txtIdComissionado, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addComponent(txtNome)
                        .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdComissionado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        busca();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        resultadoVenda();
    }//GEN-LAST:event_btnEnviarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEnviar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtIdComissionado;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtVenda;
    // End of variables declaration//GEN-END:variables
}
