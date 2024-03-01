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
public class ProductBuilder implements Builder{
    private Product product;
    
    public ProductBuilder(){
        this.product = new Product("", 0, "");
    }

    @Override
    public void setName(String name) {
        product.setName(name); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setPrice(int price) {
        product.setPrice(price); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setDescription(String description) {
        product.setDescription(description); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Product build() {
        return product; //To change body of generated methods, choose Tools | Templates.
    }
    
}
