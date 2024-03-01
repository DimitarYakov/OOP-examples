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
        FlyweightFactory factory = new FlyweightFactory();
        
        Flyweight flyweight1 = factory.getFlyweight("key1");
        flyweight1.operation(); // Операцията на flyweight1
        
        Flyweight flyweight2 = factory.getFlyweight("key2");
        flyweight2.operation(); // Операцията на flyweight2
    }
    
}
