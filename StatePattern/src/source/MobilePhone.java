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
public class MobilePhone {
    private State state;

    public MobilePhone() {
        this.state = new SilentState();
    }

    public void setState(State state) {
        this.state = state;
    }

    public void pressPowerButton() {
        state.handlePowerButton(this);
    }
}
