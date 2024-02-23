/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author thanos
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyRunnable runnable = new MyRunnable(5); // Отброяване за 5 секунди
        
        // Създаване на пул от нишки и планиране на изпълнението на задачата след изтичане на 0 секунди
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.schedule(runnable, 0, TimeUnit.SECONDS);
        
        // Затваряне на пула от нишки след изпълнението на всички задачи
        executor.shutdown();
    }
    
}
