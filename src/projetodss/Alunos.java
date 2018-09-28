/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetodss;

import java.util.HashMap;
import java.util.Map;

public class Alunos {
    
    private Map<Integer, Aluno> alunos; //organizado por numero
    
    public Alunos() {
       alunos = new HashMap<>();
    }
    
    public Alunos(HashMap<Integer, Aluno> alunos) {
       this.alunos = new HashMap<>(alunos);
    }
    
    public void addAluno(Aluno a){
        alunos.put(a.getNumero(), a.clone());
    }
    
    public Aluno getAluno(int n){
        return alunos.get(n).clone();
    }
    
    public Map<Integer, Aluno> getAlunos(){
       return this.alunos; 
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
