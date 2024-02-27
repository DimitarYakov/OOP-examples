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
    
    public interface Product{
        void operation();
    }
    
    public static class ConcreteProduct implements Product{
        @Override
        public void operation(){
            System.out.println("Concrete product...");
        }
    }
    
    public static class Creator{
        public  Product factoryMethod(){
            System.out.println("WTF From Creator class...");
            return new ConcreteProduct();
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Creator creator = new Creator();
        Product product = creator.factoryMethod();
        product.operation();
    }
    
}
