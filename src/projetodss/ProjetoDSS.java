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
import java.util.Observable;
/**
 *
 * @author André
 */
public class ProjetoDSS extends Observable implements Serializable {

    private Quotas quotas;
    private Alunos alunos;
    private Admin admin;
    
    public ProjetoDSS(){
        this.quotas = new Quotas();
        this.alunos = new Alunos();
        this.admin = new Admin();
    }
    
    public ProjetoDSS(Alunos alunos,Quotas quotas, Admin admin){
        this.alunos = new Alunos(alunos);
        this.quotas = new Quotas(quotas);
        this.admin = new Admin(admin);
    }
    
    public ProjetoDSS(ProjetoDSS p){
        this.alunos = new Alunos(p.getAlunos());
        this.quotas = new Quotas(p.getQuotas());
         this.admin = new Admin(p.getAdmin());
    }
    
    public Quotas getQuotas(){
        return this.quotas;
    }
    
    public Admin getAdmin(){
        return this.admin;
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
            setChanged();
            notifyObservers(q);
    }
    public void pagarQuota(int quotaID){
        Quota quota = getQuotas().getQuota(quotaID);
        quota.setEstado(true);
        getAluno(quota.getOwner()).addQuotaPaga(quotaID);
        setChanged();
        notifyObservers();
    }
    
    public void addAluno(Aluno a){
        this.alunos.addAluno(a);
        setChanged();
        notifyObservers(a);
    }
    
    public void addAdmin(Admin admin){
        this.admin = admin;
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
