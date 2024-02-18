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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String brand = "Brand";
        String model = "Model";
        int year = 1999;
        
        Car car = null;
        
        if(car == null){
            System.out.println("Nothing is selected!");
        }
        else{
            car.show();
        }
        
        
        Car car_info = new Car("String","String", 2000);
        
        car_info.show();
        
        
        car = new Car();
        
        car.show();
    }
    
}
