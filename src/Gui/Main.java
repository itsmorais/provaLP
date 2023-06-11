/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Gui;
import Dao.AlunoDAO;
import Model.Aluno;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author michael
 */
public class Main extends javax.swing.JFrame {
    private DefaultTableModel model;


    public Main() {
    initComponents();
    updateTableData();
    progress.setStringPainted(true);
    progress.setBorderPainted(true);
    progress.setBackground(Color.GREEN);
  

    
    }
    
    public void updateTableData() {
        AlunoDAO alunoDAO = new AlunoDAO();
        List<Aluno> alunos = alunoDAO.buscarAlunos();
        DecimalFormat df = new DecimalFormat("#.00");

        model = new DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Nome", "Data Nascimento", "CPF", "Altura", "Peso", "IMC"
                }
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column != 5 && column != 2;
            }
        };

        jTable1.setModel(model);

        for (Aluno aluno : alunos) {
            model.addRow(new Object[]{
                aluno.getNome(),
                aluno.getDataNascimento(),
                aluno.getCpf(),
                aluno.getAltura(),
                aluno.getPeso(),
                df.format((aluno.getPeso() / aluno.getAltura()) / 2)
            });
        }
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinner1 = new javax.swing.JSpinner();
        titulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        progress = new javax.swing.JProgressBar();
        status = new javax.swing.JLabel();
        deletarButton = new javax.swing.JButton();
        imcButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titulo.setFont(new java.awt.Font("Liberation Sans", 1, 33)); // NOI18N
        titulo.setText("Alunos - IMC");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Data Nascimento", "CPF", "Altura", "Peso", "IMC"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Long.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, true, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setToolTipText("Clique sobre um campo para editar\n");
        jTable1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTable1FocusLost(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton2.setText("Cadastrar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        progress.setBackground(new java.awt.Color(153, 204, 0));
        progress.setForeground(new java.awt.Color(102, 204, 0));
        progress.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        status.setText("Status");

        deletarButton.setText("Deletar");
        deletarButton.setToolTipText("Deletar Aluno Selecionado");
        deletarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletarButtonActionPerformed(evt);
            }
        });

        imcButton.setText("Gerar IMC");
        imcButton.setToolTipText("Gera arquivo txt com IMC");
        imcButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imcButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(titulo)
                .addGap(305, 305, 305))
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 826, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 16, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(status, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(progress, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE))
                        .addGap(127, 127, 127)
                        .addComponent(deletarButton)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(imcButton)
                        .addGap(29, 29, 29))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(status)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(progress, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(deletarButton)
                        .addComponent(jButton2)
                        .addComponent(imcButton)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
   
        // TELA CADASTRO
        Cadastro cadastro = new Cadastro(this);
        cadastro.setLocationRelativeTo(null);
        cadastro.setVisible(true);
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTable1FocusLost
     int linha = jTable1.getSelectedRow();

                 if (linha == -1) {
        return;
    }
                 else{
        
    String nome = jTable1.getModel().getValueAt(linha,0).toString();
    
    status.setText("Editando aluno(a) "+nome+ "...");
    progress.setValue(15);
                 }
        
    }//GEN-LAST:event_jTable1FocusLost

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
                // UPDATE 
                    int linha = jTable1.getSelectedRow();

                 if (linha == -1) {
        return;
    }
                 else{
    progress.setValue(25);

    
    
    String nome = jTable1.getModel().getValueAt(linha,0).toString();

    long cpf = (long) jTable1.getModel().getValueAt(linha,2);
    float altura = Float.parseFloat(jTable1.getModel().getValueAt(linha, 3).toString());
    float peso = Float.parseFloat(jTable1.getModel().getValueAt(linha, 4).toString());
    progress.setValue(35);
  


    Aluno alunoAtualizado = new Aluno(cpf, nome, peso, altura, "2000-01-01");
    AlunoDAO atualizarAluno = new AlunoDAO();
    progress.setValue(50);

    atualizarAluno.updateAluno(alunoAtualizado);
    updateTableData();

    progress.setValue(100);

    JOptionPane.showMessageDialog(null,"Aluno "+nome+ " Atualizado com sucesso!");
    status.setText("Status");
    progress.setValue(0);

                 }

    }//GEN-LAST:event_jTable1KeyPressed

    private void deletarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletarButtonActionPerformed
        // DELETAR ALUNO SELECIONADO
        int linha = jTable1.getSelectedRow();
    if (linha == -1) {
        return;
    }
    else{
    
        String nome = jTable1.getModel().getValueAt(linha,0).toString();
        long cpf = (long) jTable1.getModel().getValueAt(linha,2);
        AlunoDAO deletarAluno = new AlunoDAO();
         
        deletarAluno.deleteAluno(cpf);
        updateTableData();

        progress.setValue(100);

        JOptionPane.showMessageDialog(null,"Aluno "+nome+ " Deletado com sucesso!");
        progress.setValue(0);
    

    }
    }//GEN-LAST:event_deletarButtonActionPerformed

    private void imcButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imcButtonActionPerformed
        // Buscando Aluno selecionado!
           int linha = jTable1.getSelectedRow();
        if (linha == -1) {
            JOptionPane.showMessageDialog(null,"Nenhum(a) aluno(a) selecionado(a)");
        
        }
        
        else{
    
        String nome = jTable1.getModel().getValueAt(linha,0).toString();
        long cpf = (long) jTable1.getModel().getValueAt(linha,2);
        String imc = jTable1.getModel().getValueAt(linha, 5).toString();
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = currentDate.format(formatter);
        AlunoDAO alunoIMC = new AlunoDAO();
        String mensagemIMC = alunoIMC.interpretadorDeIMC(imc);
        

        // IMC Button
        JFileChooser fc = new JFileChooser();
        fc.setCurrentDirectory(new File("/home/michael/Documentos"));
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fc.setDialogType(JFileChooser.SAVE_DIALOG); 
        progress.setValue(70);


        int resp = fc.showSaveDialog(null);
            if(resp == JFileChooser.APPROVE_OPTION){
                File selectedDirectory = fc.getSelectedFile();
                String fileName = nome+"_imc.txt";
                String filePath = selectedDirectory.getAbsolutePath() + File.separator + fileName;
                
               
        String alunoData = "IMC do aluno(a):"+ nome+"\n";
        alunoData += "CPF: "+cpf+"\n";
        alunoData += "Data do levantamento: "+ formattedDate+"\n\n\n";
        alunoData += "Índice IMC: "+imc+"\n";
        alunoData += mensagemIMC.toString();
        try (PrintWriter writer = new PrintWriter(filePath)) {
            writer.println(alunoData);
            writer.flush();
            progress.setValue(100);
            JOptionPane.showMessageDialog(null,"IMC do aluno(a) "+nome+ " Salvo com sucesso!");
            progress.setValue(0);

           
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        
        }
            
            }
            
            }


    }//GEN-LAST:event_imcButtonActionPerformed

    public static void main(String args[]) {
   
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            Main mainFrame = new Main();
            mainFrame.setLocationRelativeTo(null); // Add this line
            mainFrame.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deletarButton;
    private javax.swing.JButton imcButton;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    public javax.swing.JTable jTable1;
    private javax.swing.JProgressBar progress;
    private javax.swing.JLabel status;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
