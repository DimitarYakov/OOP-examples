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
    private static final Object resource1 = new Object();
    private static final Object resource2 = new Object();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Thread thread1 = new Thread( ()-> {
            synchronized(resource1){
                System.out.println("Started thread 1: holding resource 1...");
            
                try{
                    Thread.sleep(100);
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
                
                System.out.println("Thread 1: Waiting for resource 2...");
                synchronized (resource2) {
                    System.out.println("Thread 1: Holding resource 1 and resource 2...");
                }
            }
            
            
        });
        
        Thread thread2 = new Thread( ()-> {
            synchronized(resource2){
                System.out.println("Started thread 1: holding resource 1...");
            
                try{
                    Thread.sleep(100);
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
                
                System.out.println("Thread 1: Waiting for resource 2...");
                synchronized (resource1) {
                    System.out.println("Thread 1: Holding resource 1 and resource 2...");
                }
            }
            
            
        });
        
        thread1.start();
        thread2.start();
    }
    
}
