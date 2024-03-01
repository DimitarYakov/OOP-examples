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

        // Pay with credit card
        cart.setPaymentStrategy(new CreditCardPayment("1234 5678 9012 3456", "12/23", "123"));
        cart.checkout(100);

        // Pay with PayPal
        cart.setPaymentStrategy(new PayPalPayment("example@example.com", "password"));
        cart.checkout(200);
    }
    
}
