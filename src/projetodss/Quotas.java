/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetodss;

import java.util.Map;
import java.util.HashMap;

public class Quotas {
    
    private Map<Integer, Quota> quotas; //organizado por Ids das quotas
    
    public Quotas() {
       quotas = new HashMap<>();
    }
    
    public Quotas(HashMap<Integer, Quota> quotas) {
       this.quotas = new HashMap<>(quotas);
    }
    
    /*public void addQuota(Quota quota){
        quotas.put(quota.getId(),quota.clone());
    }*/
    
    public void removeQuota (int id){
        quotas.remove(id);
    }
    
    public boolean existeQuota(int id){
       return quotas.containsKey(id);
    }
    
    /*public Quota getQuota(int id){
        return quotas.get(id).clone();
    }*/
}
