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
public class MyDate {
    private int day;
    private int month;
    private int year;

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    
    String[][] days = { {"first","1"}, {"second","2"}, {"third","3"},
    {"fourth","4"}, {"fifth","5"}, {"sixth","6"}, {"seventh","7"}, {"eighth","8"},
    {"nineth","9"}, {"tenth","10"}, {"eleventh","11"}, {"twelfth","12"}, 
    {"thirteenth","13"}, {"fourteenth","14"}, {"fifteen","15"}, {"sixteen","16"},
    {"seventeenth","17"}, {"eighteenth","18"}, {"nineteenth","19"},
    {"twentieth","20"}, {"twenty-first","21"}, {"twenty-second","22"},
    {"twenty-third","23"}, {"twenty-fouth","24"}, {"twenty-fifth","25"},
    {"twenty-sixth","26"}, {"twenty-seventh","27"}, {"twenty-eighth","28"},
    {"twenty-nineth","29"}, {"thirtieth","30"}, {"thirty-first","31"}};
    
    String[][] months = { {"January","1"}, {"February","2"}, {"March","3"},
    {"April","4"}, {"May","5"}, {"June","6"}, {"July","7"}, {"August","8"},    
    {"September","9"}, {"October","10"}, {"November","11"}, {"December","12"}};
    
    String[][] years = { {"twenty fifteen","2015"}, {"twenty sixteen","2016"},
    {"twenty seventeen","2017"}, {"twenty eighteen","18"}, {"twenty nineteen","2019"},
    {"twenty twenty","2020"}, {"twenty twenty-one","2021"}, {"twenty twenty-two","2021"},
    {"twenty twenty-two","2022"}, {"twenty twenty-three","2023"},
    {"twenty twenty-four","2024"}, {"twenty twenty-five","2025"}};
    
    public MyDate() {
    }
 
    public MyDate(String day, String month, String year) {
        for (int i = 0; i < days.length; i++) {
            if (day == days[i][0]){
                this.day = Integer.parseInt(days[i][1]);
            }   
        }
        for (int i = 0; i < months.length; i++) {
            if (month == months[i][0]){
                this.month = Integer.parseInt(months[i][1]);
            }
        }
        for (int i = 0; i < years.length; i++) {
            if (year == years[i][0]){
                this.year = Integer.parseInt(years[i][1]);
            }
        }
    }
    public String dayFormat(int day) {
        if (day == 1 || day == 21 || day == 31) {
            return day + "st";
        }
        if (day == 2 || day == 22) {
            return day + "nd";
        }
        if (day == 3 || day == 23) {
            return day + "rd";
        }
        return day + "th";
    }
    
    public void print() {
        // format February 23th 2020
        String monthString = null;
        String dayString;
        for (int i = 0; i < months.length; i++) {
            if (Integer.parseInt(months[i][1]) == this.month) {
                monthString = months[i][0];
            }
        }
        dayString = dayFormat(this.day);
        System.out.println(monthString + " " + dayString + " " + this.year);
    }
}
