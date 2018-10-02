/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetodss;

public class Quota {
    
    private int id;
    private String data; //talvez mudar para outro formato?
    private double valor;
    private boolean estado; //0: não paga / 1: paga
    private int owner;
    
    public Quota() {
       id = 0;
       data = "";
       valor = 0;
       estado = false;
       owner = 0;
    }

    public Quota(int owner, double valor) {
        this.data = "2018";
        this.valor = valor;
        this.estado = false;
        this.owner = owner;
    }
    
    public Quota(Quota c){
        this.id = c.getId();
        this.data = c.getData();
        this.valor = c.getValor();
        this.estado = c.getEstado();
        this.owner = c.getOwner();
   }
    
    public int getId() {
        return this.id;
    }

    public String getData() {
        return this.data;
    }

    public double getValor() {
        return this.valor;
    }
    
    public boolean getEstado(){
        return this.estado;
    }
    
    public int getOwner(){
        return this.owner;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public void setData(String data) {
        this.data = data;
    }
    
    public void setValor(double valor) {
        this.valor = valor;
    }
    
    public void setEstado(boolean estado){
        this.estado = estado;
    }
    
    public void setOwner(int owner){
        this.owner = owner;
    }
    
    public boolean equals(Object o) {
        boolean b=false;

        if (o!= null && o instanceof Quota) {
            Quota a = (Quota)o;
            b = this.id == a.getId() &&
                this.data.equals(a.getData()) &&
                this.valor == a.getValor() &&
                this.estado == a.getEstado();
        }
        return b;
    }
    /*
    public Quota clone() {
        return new Quota(this);
    }*/
    
    public String toString() {
        StringBuffer sb = new StringBuffer("{");
        sb.append(this.id);
        sb.append(", ");
        sb.append(this.data);
        sb.append(", ");
        sb.append(this.valor);
        sb.append(", ");
        sb.append(this.estado);
        sb.append("}");
        return sb.toString();
    }
}
