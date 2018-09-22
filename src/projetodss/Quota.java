/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetodss;

public class Quota {
    
    private int id;
    private String data; //talvez mudar para outro formato?
    private float valor;
    
    public Quota() {
       id = 0;
       data = "";
       valor = 0;
    }

    public Quota(int id, String data, float valor) {
        this.id = id;
        this.data = data;
        this.valor = valor;
    }
    
    public int getId() {
        return this.id;
    }

    public String getData() {
        return this.data;
    }

    public float getValor() {
        return this.valor;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public void setData(String data) {
        this.data = data;
    }
    
    public void setValor(float valor) {
        this.valor = valor;
    }
    
    public boolean equals(Object o) {
        boolean b=false;

        if (o!= null && o instanceof Quota) {
            Quota a = (Quota)o;
            b = this.id == a.getId() &&
                this.data.equals(a.getData()) &&
                this.valor == a.getValor();
        }
        return b;
    }
    
    public Object clone() {
        return new Quota(this.id, this.data, this.valor);
    }
    
    public String toString() {
        StringBuffer sb = new StringBuffer("Quota(");
        sb.append(this.id);
        sb.append(",");
        sb.append(this.data);
        sb.append(",");
        sb.append(this.valor);
        sb.append(",");
        return sb.toString();
    }
}
