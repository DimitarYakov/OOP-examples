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
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(new Book(20.0));
        cart.addItem(new Movie(15.0));

        PriceCalculatorVisitor visitor = new PriceCalculatorVisitor();
        cart.accept(visitor);
        System.out.println("Total price: " + visitor.getTotalPrice());
    }
    
}
