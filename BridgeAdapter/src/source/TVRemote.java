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
public class TVRemote implements Remote{
    private final Device device;

    public TVRemote(Device device) {
        this.device = device;
    }

    @Override
    public void power() {
        device.turnOn();
    }
}
