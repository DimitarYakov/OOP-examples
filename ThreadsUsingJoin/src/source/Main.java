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
        Thread thread1 = new Thread( ()->{
            System.out.println("Starting thread 1 ....");
            try{
                Thread.sleep(1000);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("Task in thread 1 finished.");
        });
        
        Thread thread2 = new Thread( ()->{
            System.out.println("Starting thread 2 ....");
            try{
                Thread.sleep(1000);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("Task in thread 2 finished.");
        });
        
        try{
            thread1.start();
            thread1.join();
            thread2.start();
            thread2.join();
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("All task completed!");
    }
    
}
