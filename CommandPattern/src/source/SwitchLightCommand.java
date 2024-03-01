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
public class SwitchLightCommand implements Command{
    private Light light;
    
    public SwitchLightCommand(Light light){
        this.light = light;
    }
    
    @Override
    public void execute() {
        light.execute();
    }
    
}
