/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetodss;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class QuotaFrame extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public QuotaFrame(ProjetoDSS p, Alunos alunos, ArrayList<Integer> quotasAPagar,ArrayList<Integer> quotasPagas,Quotas quotas,Integer numeroAluno) {
        initComponents();
        this.p = p;
        this.numeroAluno = numeroAluno;
        this.alunos = alunos;
        this.quotas = quotas;
        this.dm = dm;
        
        DefaultTableModel dm = new DefaultTableModel();
        this.dm = dm;
        
        dm.setColumnIdentifiers(new String [] {"Id", "Data", "Valor", "Estado","Pagamento"});
        refreshTable(dm,quotasAPagar,quotasPagas);
        
        jTable1.setModel(dm);
        jTable1.getColumn("Pagamento").setCellRenderer(new ButtonRenderer());
        jTable1.getColumn("Pagamento").setCellEditor(
        new ButtonPagar(new JCheckBox(),this.p,jTable1,dm));
        
    }
    
    public void refreshTable(DefaultTableModel dm ,ArrayList<Integer> quotasAPagar, ArrayList<Integer> quotasPagas){
        for(Integer idAPagar : quotasAPagar){
            dm.addRow(new Object[]{idAPagar.toString(),quotas.getQuotas().get(idAPagar).getData(),quotas.getQuotas().get(idAPagar).getValor(),"Nao Pago","Pagar"});//,new JButton});
        }
        
        for(Integer idPagas : quotasPagas){
            dm.addRow(new Object[]{idPagas.toString(),quotas.getQuotas().get(idPagas).getData(),quotas.getQuotas().get(idPagas).getValor(),"Pago","Pagar"});//,new JButton});
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        jMenuItem2.setText("jMenuItem2");

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Quotas");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jMenu1.setText("File");

        jMenuItem1.setActionCommand("Adicionar Quota");
        jMenuItem1.setLabel("adicionaQuota");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);
        jMenuItem1.getAccessibleContext().setAccessibleName("Add Quota");

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new AddQuotaFrame(quotas,alunos,numeroAluno,this,dm).setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    /**
     * @param args the command line arguments
*/
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
    private Alunos alunos = new Alunos();
    private Quotas quotas = new Quotas();
    private Integer numeroAluno; 
    private Map <Integer,Aluno> membros = new HashMap<Integer,Aluno>();
    private DefaultTableModel dm;
    private ProjetoDSS p;
}
