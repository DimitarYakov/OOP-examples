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
public class Car {
    private String brand;
    private String model;
    private int year;
    
    public Car(){}
    
    public Car(String brand, String model, int year){
        this.brand = brand;
        this.model = model;
        this.year = year;
    }
    
    public void show(){
        System.out.println("Car: " + brand + "" + model + "" + year);
    }
}
