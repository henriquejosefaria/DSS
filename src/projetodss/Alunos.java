/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetodss;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Alunos implements Serializable {
    
    private Map<Integer, Aluno> alunos; //organizado por numero
    
    public Alunos() {
       alunos = new HashMap<>();
    }
    
    public Alunos(HashMap<Integer, Aluno> alunos) {
       this.alunos = new HashMap<>(alunos);
    }
    
    public Alunos(Alunos alunos){
        this.alunos = new HashMap<Integer,Aluno>();
        this.setAlunos(alunos.getAlunos());
    }
    
    public void addAluno(Aluno a){
        alunos.put(a.getNumero(), a);
    }
    
    public Aluno getAluno(int n){
        return alunos.get(n);
    }
    
    public Map<Integer, Aluno> getAlunos(){
       return this.alunos; 
    }
    
    public void setAlunos(Map<Integer, Aluno> alunos){
        for(Map.Entry<Integer,Aluno> a : alunos.entrySet()){
            this.alunos.put(a.getKey(),a.getValue());
        }
    }
    public boolean existeAluno(int id){
       return alunos.containsKey(id);
    }
    
    
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("{");
        for(Aluno a : alunos.values()){
            sb.append(a.toString());
        }
        sb.append("}, ");
        return sb.toString();
    }
}
