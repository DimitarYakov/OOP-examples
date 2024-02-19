/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source;

import java.util.Calendar;

/**
 *
 * @author thanos
 */
public class Car extends Vehicle  {

    private int year;

    
    public Car(String brand, String model, int year){
        super(brand,model);
        this.year = year;
    }
    
    public int getYear(){
        return year;
    }
    public void setYear(int year){
        this.year = year;
    }
    public void show(){
        System.out.println("Car: " + getBrand() + " " + getModel() + " (" + year + ")");
    }
    
    public int calculateAge() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        return currentYear - year;
    }
}
