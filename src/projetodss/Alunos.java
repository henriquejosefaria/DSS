/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetodss;

import java.util.HashMap;
import java.util.Map;

public class Alunos {
    
    private Map<Integer, Aluno> alunos;
    
    /**
     * 
       public void pagarQuota(Integer numero, Double valor)
       public Aluno getAluno(int num)
       public void addAluno(Aluno a)
     */
    
    public Alunos() {
       alunos = new HashMap<>();
    }
    
    public Alunos(HashMap<Integer, Aluno> alunos) {
       this.alunos = new HashMap<>(alunos);
    }
    
    /*public Map<Integer, Aluno> getAlunos(){
        
    }*/
    
}
