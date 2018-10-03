/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetodss;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;

class ButtonQuota extends DefaultCellEditor {
  protected JButton button;

  private String label;

  private boolean isPushed;

  public ButtonQuota(JCheckBox checkBox,ProjetoDSS p,JTable table) {
    super(checkBox);
    button = new JButton();
    button.setOpaque(true);
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
          System.out.println("WOWOWOWOOW");
        String numero = (String) table.getValueAt(table.getSelectedRow(),0);
        System.out.println(numero);
        
        numeroAluno = Integer.parseInt(numero);
        System.out.println(numeroAluno);
       quotasPagas = p.getAlunos().getAluno(numeroAluno).getQuotasPagas();
       quotasAPagar = p.getAlunos().getAluno(numeroAluno).getQuotasAPagar();
        
        QuotaFrame q = new  QuotaFrame(p,quotasAPagar,quotasPagas,numeroAluno);
        p.addObserver(q);
        q.setVisible(true);
        

      }
    });
  }

  public Component getTableCellEditorComponent(JTable table, Object value,
      boolean isSelected, int row, int column) {
    if (isSelected) {
      button.setForeground(table.getSelectionForeground());
      button.setBackground(table.getSelectionBackground());
    } else {
      button.setForeground(table.getForeground());
      button.setBackground(table.getBackground());
    }
    label = (value == null) ? "" : value.toString();
    button.setText(label);
    isPushed = true;
    return button;
  }

  public Object getCellEditorValue() {
    if (isPushed) {
      JOptionPane.showMessageDialog(button, label + ": Ouch!");

    }
    isPushed = false;
    return new String(label);
  }

  public boolean stopCellEditing() {
    isPushed = false;
    return super.stopCellEditing();
  }

  protected void fireEditingStopped() {
    super.fireEditingStopped();
  }
  
  private Integer numeroAluno;
  private ArrayList<Integer> quotasPagas = new ArrayList<Integer>();
  private ArrayList<Integer> quotasAPagar = new ArrayList<Integer>();
}