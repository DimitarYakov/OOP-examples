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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Пример за използване на Builder и Director шаблоните
        Builder builder = new ProductBuilder();
        Director director = new Director(builder);

        Product product = director.createProduct("Phone", 500, "Smartphone with high-resolution screen");

        System.out.println("Product: " + product.getName() + ", Price: $" + product.getPrice());
    }
    
}
