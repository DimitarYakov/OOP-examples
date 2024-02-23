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
public class MyRunnable implements Runnable {

    private int countdown;

    public MyRunnable(int countdown) {
        this.countdown = countdown;
    }

    @Override
    public void run() {
        System.out.println("Нишката стартира.");

        while (countdown > 0) {
            System.out.println("Остават " + countdown + " секунди.");
            try {
                Thread.sleep(2000); // Изчакване за 2 секунди
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countdown--;
        }

        System.out.println("Нишката завършва.");
    }
    
}
