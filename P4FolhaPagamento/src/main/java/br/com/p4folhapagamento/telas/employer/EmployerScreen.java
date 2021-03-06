package br.com.p4folhapagamento.telas.employer;

import javax.swing.JOptionPane;
import java.time.LocalDate;

public class EmployerScreen extends javax.swing.JFrame {

    public static LocalDate localDate;

    public EmployerScreen(LocalDate localDate) {
        this.localDate = localDate;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktop = new javax.swing.JDesktopPane();
        menu = new javax.swing.JMenuBar();
        usuario1 = new javax.swing.JMenu();
        usuarioNovo = new javax.swing.JMenuItem();
        usuarioRemover = new javax.swing.JMenuItem();
        usuarioAlterar = new javax.swing.JMenuItem();
        empregado = new javax.swing.JMenu();
        empregadoNovo = new javax.swing.JMenu();
        empregadoNovoHorista = new javax.swing.JMenuItem();
        empregadoNovoAssalariado = new javax.swing.JMenuItem();
        empregadoNovoComissionado = new javax.swing.JMenuItem();
        empregadoEditar = new javax.swing.JMenu();
        empregadoEditarHorista = new javax.swing.JMenuItem();
        empregadoEditarAssalariado = new javax.swing.JMenuItem();
        empregadoEditarComissionado = new javax.swing.JMenuItem();
        empregadoRemover = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        pagamento = new javax.swing.JMenu();
        pagamentoPagar = new javax.swing.JMenuItem();
        lancamento = new javax.swing.JMenu();
        lancamentoCartaoPonto = new javax.swing.JMenuItem();
        lancamentoResultadoVenda = new javax.swing.JMenuItem();
        agenda = new javax.swing.JMenu();
        agendaAlterar = new javax.swing.JMenuItem();
        ajuda = new javax.swing.JMenu();
        ajudaSobre = new javax.swing.JMenuItem();
        ajudaSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(" Employer Panel");
        setMinimumSize(new java.awt.Dimension(700, 600));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        desktop.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout desktopLayout = new javax.swing.GroupLayout(desktop);
        desktop.setLayout(desktopLayout);
        desktopLayout.setHorizontalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 823, Short.MAX_VALUE)
        );
        desktopLayout.setVerticalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 481, Short.MAX_VALUE)
        );

        menu.setMinimumSize(new java.awt.Dimension(450, 25));
        menu.setPreferredSize(new java.awt.Dimension(450, 25));
        menu.setRequestFocusEnabled(false);

        usuario1.setText("Usuario");
        usuario1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuario1ActionPerformed(evt);
            }
        });

        usuarioNovo.setText("Novo");
        usuarioNovo.setEnabled(false);
        usuarioNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioNovoActionPerformed(evt);
            }
        });
        usuario1.add(usuarioNovo);

        usuarioRemover.setText("Remover");
        usuarioRemover.setEnabled(false);
        usuarioRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioRemoverActionPerformed(evt);
            }
        });
        usuario1.add(usuarioRemover);

        usuarioAlterar.setText("Alterar");
        usuarioAlterar.setEnabled(false);
        usuarioAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioAlterarActionPerformed(evt);
            }
        });
        usuario1.add(usuarioAlterar);

        menu.add(usuario1);

        empregado.setText("Empregado");
        empregado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empregadoActionPerformed(evt);
            }
        });

        empregadoNovo.setText("Novo");
        empregadoNovo.setEnabled(false);

        empregadoNovoHorista.setText("Horista");
        empregadoNovoHorista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empregadoNovoHoristaActionPerformed(evt);
            }
        });
        empregadoNovo.add(empregadoNovoHorista);

        empregadoNovoAssalariado.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        empregadoNovoAssalariado.setText("Assalariado");
        empregadoNovoAssalariado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empregadoNovoAssalariadoActionPerformed(evt);
            }
        });
        empregadoNovo.add(empregadoNovoAssalariado);

        empregadoNovoComissionado.setText("Comissionado");
        empregadoNovoComissionado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empregadoNovoComissionadoActionPerformed(evt);
            }
        });
        empregadoNovo.add(empregadoNovoComissionado);

        empregado.add(empregadoNovo);

        empregadoEditar.setText("Editar");
        empregadoEditar.setEnabled(false);

        empregadoEditarHorista.setText("Horista");
        empregadoEditarHorista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empregadoEditarHoristaActionPerformed(evt);
            }
        });
        empregadoEditar.add(empregadoEditarHorista);

        empregadoEditarAssalariado.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        empregadoEditarAssalariado.setText("Assalariado");
        empregadoEditarAssalariado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empregadoEditarAssalariadoActionPerformed(evt);
            }
        });
        empregadoEditar.add(empregadoEditarAssalariado);

        empregadoEditarComissionado.setText("Comissionado");
        empregadoEditarComissionado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empregadoEditarComissionadoActionPerformed(evt);
            }
        });
        empregadoEditar.add(empregadoEditarComissionado);

        empregado.add(empregadoEditar);

        empregadoRemover.setText("Remover");
        empregadoRemover.setEnabled(false);
        empregadoRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empregadoRemoverActionPerformed(evt);
            }
        });
        empregado.add(empregadoRemover);

        jMenuItem2.setText("Lista Empregados");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        empregado.add(jMenuItem2);

        menu.add(empregado);

        pagamento.setText("Rodar Folha ");

        pagamentoPagar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        pagamentoPagar.setText("Pagar");
        pagamentoPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pagamentoPagarActionPerformed(evt);
            }
        });
        pagamento.add(pagamentoPagar);

        menu.add(pagamento);

        lancamento.setText("Lancamento");
        lancamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lancamentoActionPerformed(evt);
            }
        });

        lancamentoCartaoPonto.setText("Cartao de Ponto");
        lancamentoCartaoPonto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lancamentoCartaoPontoActionPerformed(evt);
            }
        });
        lancamento.add(lancamentoCartaoPonto);

        lancamentoResultadoVenda.setText("Resultado de Venda");
        lancamentoResultadoVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lancamentoResultadoVendaActionPerformed(evt);
            }
        });
        lancamento.add(lancamentoResultadoVenda);

        menu.add(lancamento);

        agenda.setText("Agenda");

        agendaAlterar.setText("Alterar");
        agendaAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agendaAlterarActionPerformed(evt);
            }
        });
        agenda.add(agendaAlterar);

        menu.add(agenda);

        ajuda.setText("Ajuda");

        ajudaSobre.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, java.awt.event.InputEvent.ALT_MASK));
        ajudaSobre.setText("Sobre");
        ajudaSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajudaSobreActionPerformed(evt);
            }
        });
        ajuda.add(ajudaSobre);

        ajudaSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        ajudaSair.setText("Sair");
        ajudaSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajudaSairActionPerformed(evt);
            }
        });
        ajuda.add(ajudaSair);

        menu.add(ajuda);

        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(desktop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(839, 545));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ajudaSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajudaSairActionPerformed
        String warning = "Atenção";
        String message = "Tem certeza que deseja sair?";
        int logout = JOptionPane.showConfirmDialog(null, message, warning, JOptionPane.YES_NO_OPTION);
        if (logout == JOptionPane.YES_OPTION)
            System.exit(0);
    }//GEN-LAST:event_ajudaSairActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

    }//GEN-LAST:event_formWindowActivated

    private void empregadoNovoAssalariadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empregadoNovoAssalariadoActionPerformed
        NewEmployeeSalaried newEmployeeSalaried = new NewEmployeeSalaried();
        newEmployeeSalaried.setVisible(true);
        this.desktop.add(newEmployeeSalaried);
    }//GEN-LAST:event_empregadoNovoAssalariadoActionPerformed

    private void empregadoNovoHoristaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empregadoNovoHoristaActionPerformed
        NewEmployeeHourly newEmployeeHourly = new NewEmployeeHourly();
        newEmployeeHourly.setVisible(true);
        this.desktop.add(newEmployeeHourly);
    }//GEN-LAST:event_empregadoNovoHoristaActionPerformed

    private void empregadoRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empregadoRemoverActionPerformed
        RemoveEmployee removeEmployee = new RemoveEmployee();
        removeEmployee.setVisible(true);
        this.desktop.add(removeEmployee);
    }//GEN-LAST:event_empregadoRemoverActionPerformed

    private void empregadoEditarHoristaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empregadoEditarHoristaActionPerformed
        EditEmployeeHourly editEmployeeHourly = new EditEmployeeHourly();
        editEmployeeHourly.setVisible(true);
        this.desktop.add(editEmployeeHourly);
    }//GEN-LAST:event_empregadoEditarHoristaActionPerformed

    private void empregadoEditarAssalariadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empregadoEditarAssalariadoActionPerformed
        EditEmployeeSalaried editEmployeeSalaried = new EditEmployeeSalaried();
        editEmployeeSalaried.setVisible(true);
        this.desktop.add(editEmployeeSalaried);    }//GEN-LAST:event_empregadoEditarAssalariadoActionPerformed

    private void ajudaSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajudaSobreActionPerformed
        TelaSobre sobre = new TelaSobre();
        sobre.setVisible(true);

    }//GEN-LAST:event_ajudaSobreActionPerformed

    private void lancamentoCartaoPontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lancamentoCartaoPontoActionPerformed
        CartaoPonto cartaoPonto = new CartaoPonto();
        cartaoPonto.setVisible(true);
        desktop.add(cartaoPonto);
    }//GEN-LAST:event_lancamentoCartaoPontoActionPerformed

    private void empregadoEditarComissionadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empregadoEditarComissionadoActionPerformed
        EditEmployeeComissionado editEmployeeComissionado = new EditEmployeeComissionado();
        editEmployeeComissionado.setVisible(true);
        this.desktop.add(editEmployeeComissionado);
    }//GEN-LAST:event_empregadoEditarComissionadoActionPerformed

    private void agendaAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agendaAlterarActionPerformed
        EditarAgenda editarAgenda = new EditarAgenda();
        editarAgenda.setVisible(true);
        this.desktop.add(editarAgenda);
    }//GEN-LAST:event_agendaAlterarActionPerformed

    private void usuario1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuario1ActionPerformed

    }//GEN-LAST:event_usuario1ActionPerformed

    private void usuarioNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioNovoActionPerformed
        // aqui abre o formulario de usuarios
        TelaUsuario telausuario = new TelaUsuario();
        telausuario.setVisible(true);
        desktop.add(telausuario);
    }//GEN-LAST:event_usuarioNovoActionPerformed

    private void usuarioRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioRemoverActionPerformed
        TelaRemoverUsuario telaRemoverUsuario = new TelaRemoverUsuario();
        telaRemoverUsuario.setVisible(true);
        desktop.add(telaRemoverUsuario);
    }//GEN-LAST:event_usuarioRemoverActionPerformed

    private void empregadoNovoComissionadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empregadoNovoComissionadoActionPerformed
        NewEmployeeComissionado newEmployeeComissionado = new NewEmployeeComissionado();
        newEmployeeComissionado.setVisible(true);
        this.desktop.add(newEmployeeComissionado);
    }//GEN-LAST:event_empregadoNovoComissionadoActionPerformed

    private void lancamentoResultadoVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lancamentoResultadoVendaActionPerformed
        ResultadoVenda resultadoVenda = new ResultadoVenda();
        resultadoVenda.setVisible(true);
        this.desktop.add(resultadoVenda);
    }//GEN-LAST:event_lancamentoResultadoVendaActionPerformed

    private void lancamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lancamentoActionPerformed

    }//GEN-LAST:event_lancamentoActionPerformed

    private void pagamentoPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pagamentoPagarActionPerformed
        Pagamento pagamento = new Pagamento();
        pagamento.setVisible(true);
        this.desktop.add(pagamento);
    }//GEN-LAST:event_pagamentoPagarActionPerformed

    private void empregadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empregadoActionPerformed

    }//GEN-LAST:event_empregadoActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        TelaRelatorio telaRelatorio = new TelaRelatorio();
        telaRelatorio.setVisible(true);
        this.desktop.add(telaRelatorio);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void usuarioAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioAlterarActionPerformed
        TelaAlterarUsuario telaAlterarUsuario = new TelaAlterarUsuario();
        telaAlterarUsuario.setVisible(true);
        this.desktop.add(telaAlterarUsuario);
    }//GEN-LAST:event_usuarioAlterarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EmployerScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployerScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployerScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployerScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployerScreen(LocalDate.now()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu agenda;
    private javax.swing.JMenuItem agendaAlterar;
    private javax.swing.JMenu ajuda;
    private javax.swing.JMenuItem ajudaSair;
    private javax.swing.JMenuItem ajudaSobre;
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JMenu empregado;
    public static javax.swing.JMenu empregadoEditar;
    private javax.swing.JMenuItem empregadoEditarAssalariado;
    private javax.swing.JMenuItem empregadoEditarComissionado;
    private javax.swing.JMenuItem empregadoEditarHorista;
    public static javax.swing.JMenu empregadoNovo;
    private javax.swing.JMenuItem empregadoNovoAssalariado;
    private javax.swing.JMenuItem empregadoNovoComissionado;
    private javax.swing.JMenuItem empregadoNovoHorista;
    public static javax.swing.JMenuItem empregadoRemover;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenu lancamento;
    private javax.swing.JMenuItem lancamentoCartaoPonto;
    private javax.swing.JMenuItem lancamentoResultadoVenda;
    private javax.swing.JMenuBar menu;
    private javax.swing.JMenu pagamento;
    private javax.swing.JMenuItem pagamentoPagar;
    private javax.swing.JMenu usuario1;
    public static javax.swing.JMenuItem usuarioAlterar;
    public static javax.swing.JMenuItem usuarioNovo;
    public static javax.swing.JMenuItem usuarioRemover;
    // End of variables declaration//GEN-END:variables
}
