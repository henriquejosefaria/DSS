/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetodss;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Alunos {
    
    private Map<Integer, Aluno> alunos; //organizado por numero
    
    public Alunos() {
       alunos = new HashMap<>();
       Aluno aluno1 = new Aluno();
       ArrayList<Integer> ola = new ArrayList<Integer>();
       ola.add(88888);
       ola.add(77777);
       ola.add(66666);
       Aluno aluno2 = new Aluno("Filipe",83099,2018,"Vila Verde",new ArrayList<Integer>(),new ArrayList<Integer>());
       Aluno aluno3 = new Aluno("Andre",82260,2018,"Braga",new ArrayList<Integer>(),new ArrayList<Integer>());
       addAluno(aluno1);
       addAluno(aluno2);
       addAluno(aluno3);
    }
    
    public Alunos(HashMap<Integer, Aluno> alunos) {
       this.alunos = new HashMap<>(alunos);
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
