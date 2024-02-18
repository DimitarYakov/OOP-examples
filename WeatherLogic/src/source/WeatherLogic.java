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
public class WeatherLogic {
    private boolean isRaining; 
    private boolean isSunny;
    private boolean isWindy;
    
    public WeatherLogic(boolean isRaining, boolean isSunny, boolean isWindy){
        this.isRaining = isRaining;
        this.isSunny = isSunny;
        this.isWindy = isWindy;
    }
    
    public void BringUmbrellaIfNeeded(){
        if(isRaining){
            System.out.println("It's raining. Bring an umbrella!");
        }
        else if(isSunny && !isWindy){
            System.out.println("It's sunny and calm. No need for an umbrella.");
        }
        else{
            System.out.println("The weather is unpredictable. Bring an umbrella just in case.");
        }
    }
}
