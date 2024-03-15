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
    
    public static class Singleton implements Cloneable{
        private static Singleton instance = new Singleton();
        
        public Singleton(){}
        
        public static Singleton getInstance(){
            return instance;
        }
        
        @Override
        protected Object clone() throws CloneNotSupportedException{
            return super.clone();
        }
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();

        try {
            // Attempt to clone the singleton
            Singleton singleton2 = (Singleton) singleton1.clone();

            // If cloning is successful, you'll have a new instance
            System.out.println("Cloned instance hash code: " + singleton2.hashCode());
        } catch (CloneNotSupportedException e) {
            System.out.println("Cloning not supported for this class.");
        }
    }
    
}
