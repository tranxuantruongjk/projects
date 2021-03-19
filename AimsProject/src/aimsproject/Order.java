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
public class Order {
    private int qtyOrdered;
    private static int nbOrders = 0;
    private MyDate dateOrdered = new MyDate();
    public static final int MAX_LIMITTED_ORDERS = 5;
    public static final int MAX_NUMBERS_ORDERED = 2;
    private final DigitalVideoDics itemsOrdered[] = new DigitalVideoDics[MAX_NUMBERS_ORDERED];

    public Order() {
        nbOrders = nbOrders + 1;            
    }
    
    public Order(int day, int month, int year) {
        nbOrders = nbOrders + 1;
        this.dateOrdered = new MyDate(dayString(day), monthString(month), yearString(year));
    }

    public int getNbOrders() {
        return nbOrders;
    }

    public MyDate getDateOrdered() {
        return dateOrdered;
    }

    public void setDateOrdered(MyDate dateOrdered) {
        this.dateOrdered = dateOrdered;
    }
    
    public void setNbOrders(int nbOrders) {
        Order.nbOrders = nbOrders;
    }
       
    public DigitalVideoDics[] getItemsOrdered() {
        return itemsOrdered;
    }
    
    public int getQtyOrdered() {
        return qtyOrdered;
    }

    public void setQtyOrdered(int qtyOrdered) {
        this.qtyOrdered = qtyOrdered;
    }
    
    public void addDigitalVideoDisc(DigitalVideoDics disc){
        if (qtyOrdered < MAX_NUMBERS_ORDERED){
            itemsOrdered[qtyOrdered++] = disc;
            System.out.println("The disc named " + disc.getTitle() + 
                        " has been added.");
        }
        else{
            System.out.println("The disc named " + disc.getTitle() + 
                        " hasn't been added. The order is almost full.");
        }
    }
    
    public void addDigitalVideoDisc(DigitalVideoDics[] dvdList) {
        for (int i = 0; i < dvdList.length ; i++) {
            if(qtyOrdered < MAX_NUMBERS_ORDERED){
                itemsOrdered[qtyOrdered++] = dvdList[i];
                System.out.println("The disc named " + dvdList[i].getTitle() + 
                        " has been added.");
            }
            else {
                System.out.println("The disc named " + dvdList[i].getTitle() + 
                        " hasn't been added. The order is almost full.");
            }
        }
    }
    
    public void addDigitalVideoDisc(DigitalVideoDics dvd1, DigitalVideoDics dvd2) {
        addDigitalVideoDisc(dvd1);
        addDigitalVideoDisc(dvd2);
    }
    
    public void removeDigitalVideoDisc(DigitalVideoDics disc){
        int j = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            if (this.itemsOrdered[i] != disc){
                this.itemsOrdered[j] = this.itemsOrdered[i];
                j++;
            }
        }
        if ( j != qtyOrdered ){
            System.out.println("The order was removed.");
            this.setQtyOrdered(j);
        }
        else{
            System.out.println("The order is not in Order.");
        }
    }
    
    public float totalCost(){
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++){
                total += itemsOrdered[i].getCost();
        }
        return total;       
    }
    
    public void printDateOrdered() {
        dateOrdered.print();
    }
    
    public String dayString(int day) {
        for (int i = 0; i < days.length; i++) {
            if (day == Integer.parseInt(days[i][1])){
                return (days[i][0]);
            }   
        }
        return null;
    }
    public String monthString(int month) {
        for (int i = 0; i < months.length; i++) {
            if (month == Integer.parseInt(months[i][1])){
                return (months[i][0]);
            }   
        }
        return null;
    }
    public String yearString(int year) {
        for (int i = 0; i < years.length; i++) {
            if (year == Integer.parseInt(years[i][1])){
                return (years[i][0]);
            }   
        }
        System.out.println(dateOrdered.months);
        return null;
    }
    
    public void orderedBill() {
        System.out.println("*********************Order*********************");
        System.out.print("Date: ");
        dateOrdered.print();
        System.out.println("Ordered Items: ");
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println("DVD - " + itemsOrdered[i].getTitle() + " - " +
                    itemsOrdered[i].getDirector() + " - " + 
                    itemsOrdered[i].getCategory() + " - " + 
                    itemsOrdered[i].getLength() + ": " + 
                    itemsOrdered[i].getCost() + "$");
        }
        System.out.println("Total cost : " + totalCost());
        System.out.println("***********************************************");
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

}
