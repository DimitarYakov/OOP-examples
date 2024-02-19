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
        
        Car car_info = new Car(brand, model, year);
        
        
        car_info.show();
        int calc_age = car_info.calculateAge();
        System.out.println("Age of the car: " + calc_age + " years.");
     
    }
    
}
