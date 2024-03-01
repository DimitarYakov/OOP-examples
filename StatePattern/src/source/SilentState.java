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
public class SilentState implements State{

    @Override
    public void handlePowerButton(MobilePhone phone) {
        System.out.println("Switching to Ringing mode");
        phone.setState(new RingingState());
    }
    
}
