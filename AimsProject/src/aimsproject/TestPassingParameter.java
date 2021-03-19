/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aimsproject;

import java.util.Collections;

/**
 *
 * @author xuantruong
 */
public class TestPassingParameter {
        public static void main(String[] args) {
        DigitalVideoDics jungleDVD = new DigitalVideoDics("Jungle");
        DigitalVideoDics cinderellaDVD = new DigitalVideoDics("Cinderella");
        
        swap(jungleDVD, cinderellaDVD);
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());
            
        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        }
        public static void swap(Object o1, Object o2) {
            Object tmp = o1;
            o1 = o2;
            o2 = tmp;
        }
        
        public static void changeTitle(DigitalVideoDics dvd, String title) {
            String oldTitle = dvd.getTitle();
            dvd.setTitle(title);
            dvd = new DigitalVideoDics(oldTitle);
        }
    
}
