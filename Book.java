/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book;

/**
 *
 * @author user
 */
public class Book {
    public  String title;
    public  String author;
    public  int price;
    
    Book(String title,String author,int price){
        this.title=title;
        this.author=author;
        this.price=price;
    }
    
    void displaydetails(){
        System.out.println("Title : "+title+"\nAuthor: "+author+"\nPrice : "+price+"\n ");
        System.out.println("\nDiscounted price\n"+"\nTitle : "+title+"\nAuthor: "+author+"\nPrice : "+discount(price));
    }
    double discount(int price){
        return 0.85*price;
    }
    public static void main(String[] args) {
        Book a = new Book("The Secret","Banu",350);
        Book b = new Book("Atomic Habits","James",300);
        a.displaydetails();
        b.displaydetails();
    }
    
}
