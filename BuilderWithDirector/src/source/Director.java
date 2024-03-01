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
public class Director {
    private final Builder builder;
    
    public Director(Builder builder){
        this.builder = builder;
    }
    
    public Product createProduct(String name, int price, String description) {
        builder.setName(name);
        builder.setPrice(price);
        builder.setDescription(description);
        return builder.build();
    }
}
