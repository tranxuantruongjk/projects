/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aimsproject;
//import java.lang.NullPointerException;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author xuantruong
 */
public class AimsProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Calendar c = Calendar.getInstance();
        int day = c.get(Calendar.DAY_OF_MONTH);
        int month = c.get(Calendar.MONTH);
        int year = c.get(Calendar.YEAR);
        
        Order anOrder = new Order(day, month, year);
        
        //System.out.println(anOrder.getNbOrders());
        //anOrder.printDateOrdered();
        //Order anOrder1 = new Order();
        // anOrder2 = new Order();
        //System.out.println(anOrder.getNbOrders());
        DigitalVideoDics dvd1 = new DigitalVideoDics("The Lion King",
                "Animation", "Roger Allers", 87, 19.95f);

        //anOrder.addDigitalVideoDisc(dvd1);
        DigitalVideoDics dvd2 = new DigitalVideoDics("Star Wars",
                "Science Fiction", "George Lucas", 87, 24.95f);
        //anOrder.addDigitalVideoDisc(dvd2);

        DigitalVideoDics dvd3 = new DigitalVideoDics("Aladin", "Animation", 18.99f);
        //anOrder.addDigitalVideoDisc(dvd3);

        //DigitalVideoDics[] dvdList = {dvd2, dvd3};
        //anOrder.addDigitalVideoDisc(dvdList);
        anOrder.addDigitalVideoDisc(dvd1, dvd2);
        System.out.println("Print Bill: ");
        anOrder.orderedBill();
//        System.out.print("Total Cost is ");
//        System.out.println(anOrder.totalCost());
        //anOrder.removeDigitalVideoDisc(dvd1);
        //System.out.print("After removing, total cost is ");
        //System.out.println(anOrder.totalCost());
    }
}
