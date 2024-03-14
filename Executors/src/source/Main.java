/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thanos
 */
public class Main {
    
    static class Result{
        int sum;
        int count;
        
        public Result(int sum, int count){
            this.sum = sum;
            this.count = count;
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        ExecutorService service = null;
        try{
            service = Executors.newSingleThreadExecutor();
            System.out.println("begin:" + Thread.currentThread().getName());
            
            Future<Result> result = service.submit(()->{
                int suma = 1;
                int count = 0;
                for(int i = 2; i < 100; i++) {//for(int i = 2; i <= 100;i++){
                    suma += i;
                    count = i;
                }
                return new Result(suma, count);
                
            });
            Result finalResult = result.get();
            
            
            
            System.out.println("Result: "+ finalResult.sum);
            System.out.println("Result: "+ finalResult.count);
            
        }
        catch (InterruptedException | ExecutionException ex) {
            ex.printStackTrace();
        } finally{
            if(service != null) service.shutdown();
        }
    }
    
}
