/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetodss;

import java.io.Serializable;

/**
 *
 * @author henriquefaria
 */
public class Admin implements Serializable {
    private int numero;
    private String password;
    
    
    public  Admin (){
        this.numero = 0 ;
        this.password = "MasterPass";
    }
    
     public  Admin (int numero, String password){
        this.numero = numero ;
        this.password = password;
    }
    
    public Admin(Admin admin){
        this.numero = admin.getNumero();
        this.password = admin.getPassword();
    }
    
    
    public int getNumero() {
        return this.numero;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    public void setNumero(int numero){
        this.numero = numero;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    public boolean equals(Object admin){
        if (admin == this) return true;
        if(this == null || admin == null || admin.getClass() != this.getClass()) return false;
        System.out.println("cheguei aqui");
        Admin a = (Admin) admin;
        return this.numero == a.getNumero() && this.password.equals(a.getPassword());
    }
    
    public String toString(){
        StringBuffer sb = new StringBuffer("{");
        sb.append(this.numero);
        sb.append(", ");
        sb.append(this.password);
        sb.append(";}");
        return sb.toString();
    }
}
