/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aimsproject;

/**
 *
 * @author xuantruong
 */
public class Test {
    public static void main(String[] args) {
        MyDate myDate = new MyDate("eighteenth", "March", "twenty twenty-one");
//        System.out.println(myDate.getDay() + "-" + myDate.getMonth() + "-" +
//                myDate.getYear());
        myDate.print();
    }
    
}
