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
public class RadioRemote implements Remote {
    private final Device device;

    public RadioRemote(Device device) {
        this.device = device;
    }

    @Override
    public void power() {
        device.turnOn();
    }
}
