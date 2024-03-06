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
    private static final Object lock = new Object();
    private static boolean resourceInUse = false;
    
    public static void main(String[] args) {
        Thread thread1 = new Thread( ()-> {
            synchronized(lock){
                try{
                    Thread.sleep(100);
                    resourceInUse = true;
                    System.out.println("Thread 1 report: resources in use ...");
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                } finally {
                    resourceInUse = false;
                    System.out.println("Thread 1: Resource released");
                }
            }
        });
        
        Thread thread2 = new Thread( ()-> {
            synchronized(lock){
                try{
                    Thread.sleep(100);
                    resourceInUse = true;
                    System.out.println("Thread 2 report: resources in use ...");
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                } finally {
                    resourceInUse = false;
                    System.out.println("Thread 2: Resource released");
                }
            }
        });
        thread1.start();
        thread2.start();
    }
    
}
