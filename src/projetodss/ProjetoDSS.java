/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetodss;
import javax.swing.JButton;
import javax.swing.JTable;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.lang.ClassNotFoundException;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author André
 */
public class ProjetoDSS implements Serializable {

    private Quotas quotas;
    private Alunos alunos;
    
    public ProjetoDSS(){
        this.quotas = new Quotas();
        this.alunos = new Alunos();
    }
    
    public ProjetoDSS(Alunos alunos,Quotas quotas){
        this.alunos = new Alunos(alunos);
        this.quotas = new Quotas(quotas);
    }
    
    public ProjetoDSS(ProjetoDSS p){
        this.alunos = new Alunos(p.getAlunos());
        this.quotas = new Quotas(p.getQuotas());
    }
    
    public Quotas getQuotas(){
        return this.quotas;
    }
    
    public Map<Integer,Aluno> getHashAlunos(){
        return this.alunos.getAlunos();
    }
    
    public Alunos getAlunos(){
        return this.alunos;
    }
    public Aluno getAluno(int i){
        return this.alunos.getAluno(i);
    }
    
    public void addQuota(Quota q){
        this.quotas.addQuota(q);
         Aluno owner =  this.alunos.getAluno(q.getOwner());
           owner.addQuotaAPagar(q.getId());
    }
    
    public void addAluno(Aluno a){
        this.alunos.addAluno(a);
    }
    
    public void save() throws IOException{
        FileOutputStream foos = new FileOutputStream("FicheiroProjetoDSS");
        ObjectOutputStream oos = new ObjectOutputStream(foos);
        oos.writeObject(this);
        oos.flush();
        oos.close();
    }
    /**
    * Carrega o estado do objeto representado no ficheiro parao objeto atual.
    * 
    */
    // requesito 13
    public static ProjetoDSS load() throws FileNotFoundException, IOException, ClassNotFoundException{
        FileInputStream fis = new FileInputStream("FicheiroProjetoDSS");
        ObjectInputStream oos = new ObjectInputStream(fis);
        ProjetoDSS p = (ProjetoDSS) oos.readObject();
        oos.close();
        return p;
    }  
}
