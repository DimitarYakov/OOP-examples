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
public class TVDisplay implements Observer {
    @Override
    public void update(int temperature) {
        System.out.println("TV Display: Temperature is now " + temperature + " degrees Celsius");
    }
}
