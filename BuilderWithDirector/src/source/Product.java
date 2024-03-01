/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source;

/**
 *
 * @author thanos
 */
public class Product {
    
    private String name;
    private int price;
    private String description;
    
    
    public Product(String name, int price, String description){
        this.name = name;
        this.price = price;
        this.description = description;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setPrice(int price){
        this.price = price;
    }
    public void setDescription(String description){
        this.description = description;
    }
    
    public String getName(){
        return name;
    }
    
    public int getPrice(){
        return price;
    }
    
    public String getDescription(){
        return description;
    }
}
