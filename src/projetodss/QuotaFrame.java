/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetodss;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class QuotaFrame extends javax.swing.JFrame implements Observer {

    /**
     * Creates new form NewJFrame
     */
    public QuotaFrame(ProjetoDSS p, ArrayList<Integer> quotasAPagar,ArrayList<Integer> quotasPagas, Integer numeroAluno,int permissao) {
        this.permissao = permissao;
        initComponents();
        this.p = p;
        this.numeroAluno = numeroAluno;
        
        DefaultTableModel dm = new DefaultTableModel(){
            @Override
    public boolean isCellEditable(int row, int column) {
       if( column == 4)return true; return false;
                }};
        this.dm = dm;
        if(permissao == 1){
            dm.setColumnIdentifiers(new String [] {"Id", "Data", "Valor", "Estado","Pagamento"});
            refreshTable(dm,quotasAPagar,quotasPagas,permissao);
        
            jTable1.setModel(dm);
            jTable1.getColumn("Pagamento").setCellRenderer(new ButtonRenderer());
            jTable1.getColumn("Pagamento").setCellEditor(
            new ButtonPagar(new JCheckBox(),this.p,jTable1,dm));
        } else{
            dm.setColumnIdentifiers(new String [] {"Id", "Data", "Valor", "Estado"});
            refreshTable(dm,quotasAPagar,quotasPagas,permissao);
            jTable1.setModel(dm);
        }
        
    }
    
    public void refreshTable(DefaultTableModel dm ,ArrayList<Integer> quotasAPagar, ArrayList<Integer> quotasPagas,int permissao){
        if(permissao == 1){
           for(Integer idAPagar : quotasAPagar){
               dm.addRow(new Object[]{idAPagar.toString(),p.getQuotas().getQuotas().get(idAPagar).getData(),p.getQuotas().getQuotas().get(idAPagar).getValor(),"Nao Pago","Pagar"});//,new JButton});
            }
        
           for(Integer idPagas : quotasPagas){
               dm.addRow(new Object[]{idPagas.toString(),p.getQuotas().getQuotas().get(idPagas).getData(),p.getQuotas().getQuotas().get(idPagas).getValor(),"Pago","Pagar"});//,new JButton});
           }
        } else{
            for(Integer idAPagar : quotasAPagar){
               dm.addRow(new Object[]{idAPagar.toString(),p.getQuotas().getQuotas().get(idAPagar).getData(),p.getQuotas().getQuotas().get(idAPagar).getValor(),"Nao Pago"});//,new JButton});
            }
        
           for(Integer idPagas : quotasPagas){
               dm.addRow(new Object[]{idPagas.toString(),p.getQuotas().getQuotas().get(idPagas).getData(),p.getQuotas().getQuotas().get(idPagas).getValor(),"Pago"});//,new JButton});
           }
        }
    }
    
    @Override
    public void update(Observable o, Object arg) {
        if(arg instanceof Quota){
            Quota q = (Quota) arg;
            dm.addRow(new Object[]{Integer.toString(q.getId()),p.getQuotas().getQuotas().get(q.getId()).getData(),p.getQuotas().getQuotas().get(q.getId()).getValor(),"Nao Pago","Pagar"});
        }
        else{
            dm.setValueAt("Pago",jTable1.getSelectedRow(),3);
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
        jButton1 = new javax.swing.JButton();
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

        jButton1.setText("back");
        if(permissao == 0){
            jButton1.setText("Logout");
        }
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        if(permissao == 0) jMenuBar1.setVisible(false);

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
            .addGroup(layout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new AddQuotaFrame(p,numeroAluno,this).setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(permissao == 1){
            this.dispose();
        }
        else{
            JOptionPane.showMessageDialog(null,"Logout efetuado com sucesso!", "Message" , JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            new MenuLogin().setVisible(true);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
*/
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
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

    private Integer numeroAluno; 
    private Map <Integer,Aluno> membros = new HashMap<Integer,Aluno>();
    private DefaultTableModel dm;
    private ProjetoDSS p;
    private int permissao;

}
