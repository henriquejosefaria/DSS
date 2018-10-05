/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetodss;

import java.io.Serializable;
import java.util.ArrayList;

public class Aluno implements Serializable {
    
    private String nome;
    private int numero;
    private String email;
    private String password;
    private int anoLectivo;
    private String morada;
    private ArrayList<Integer> quotasPagas; //organizadas por IDs
    private ArrayList<Integer> quotasAPagar; //organizadas por IDs

    public Aluno() {
       nome = "Henrique";
       morada = "Porto";
       numero = 84354;
       password = "passBasica";
       anoLectivo = 2018;
       email = "filipe-Cunha1@hotmail.com";
       quotasPagas = new ArrayList<>();
       quotasAPagar = new ArrayList<>();
    }

    public Aluno(String nome, String email,int numero,String password,int anoLectivo,String morada,ArrayList<Integer> quotasPagas, ArrayList<Integer> quotasAPagar) {
        this.nome = nome;
        this.numero = numero;
        this.password = password;
        this.anoLectivo = anoLectivo;
        this.morada = morada;
        this.email = email;
        this.quotasPagas = new ArrayList<>(quotasPagas);
        this.quotasAPagar = new ArrayList<>(quotasAPagar);
    }

    public Aluno(Aluno c){
        this.numero = c.getNumero();
        this.password = c.getPassword();
        this.nome = c.getNome();
        this.email = c.getEmail();
        this.morada = c.getMorada();
        this.anoLectivo = c.getAnoLectivo();
        this.quotasPagas = c.getQuotasPagas();
        this.quotasAPagar = c.getQuotasAPagar();
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public String getEmail(){
        return this.email;
    }

    public int getNumero() {
        return this.numero;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    public int getAnoLectivo() {
        return this.anoLectivo;
    }
    
    public String getMorada() {
        return this.morada;
    }
    
    public ArrayList getQuotasPagas() {
        return this.quotasPagas;
    }
    
    public ArrayList getQuotasAPagar() {
        return this.quotasAPagar;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    public void setNumero(String password) {
        this.password = password;
    }
    
    public void setAnoLectivo(int anoLectivo) {
        this.anoLectivo = anoLectivo;
    }
    
    public void setMorada(String morada) {
        this.morada = morada;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public void addQuotaPaga(int idQuotaPaga) {
        // tratar exceção
        if (this.quotasAPagar.contains(idQuotaPaga)){
            this.quotasAPagar.remove((Object)idQuotaPaga);
            this.quotasPagas.add(idQuotaPaga);
        }
    }
    
    public void addQuotaAPagar(int idQuotaAPagar) {
        this.quotasAPagar.add(idQuotaAPagar);
    }
    
    public boolean equals(Object o) {
        boolean b=false;

        if (o!= null && o instanceof Aluno) {
            Aluno a = (Aluno)o;
            b = this.nome.equals(a.getNome()) &&
                this.numero == a.getNumero() &&
                this.password == a.getPassword() &&
                this.anoLectivo == a.getAnoLectivo() &&
                this.morada.equals(a.getMorada());
        }
        return b;
    }
   

    public String toString() {
        StringBuffer sb = new StringBuffer("{");
        sb.append(this.nome);
        sb.append(", ");
        sb.append(this.numero);
        sb.append(", ");
        sb.append(this.password);
        sb.append(", ");
        sb.append(this.anoLectivo);
        sb.append(", ");
        sb.append(this.morada);
        sb.append("}");
        return sb.toString();
    }
}
