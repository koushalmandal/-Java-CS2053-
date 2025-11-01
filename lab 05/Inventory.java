import java.util.ArrayList;
import java.util.Scanner;

public class Inventory {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)){
            Inventory inventory = new Inventory();
            System.out.println("Inventory Management");
              Management m = new Management();
            boolean isRun = true;
            while(isRun){
                System.out.println("\n1. Add Product");
                System.out.println("2. Display All Products");
                System.out.println("3. Search Product by Name");
                System.out.println("4. Sort Products by Price");
                System.out.println("5. Low Stock Alert");
                System.out.println("6. Total Inventory Value");
int choice = scanner.nextInt();
switch(choice){

        case 1 -> m.input(scanner);
                    case 2 -> m.display();
                    case 3 -> m.search(scanner);
                    case 4 -> m.sort();
                    case 5 -> m.lowStock();
                    case 6 -> m.totalValue();
                    }
}
        }
    }
}
class Product{
    private String name;
    private int id;
    private double price;
    private int quantity;
    private String category;


 public Product(String name, int id , double price , int quantity,String category){
    this.name = name;
    this.id = id;
    this.price = price;
    this.quantity = quantity;
    this.category = category;
}
public String getName(){
    return name;
}
public int getId(){
    return id;
}
public  double getPrice(){
    return price;
}
public int getQuantity(){
    return quantity;
}
public String  getCategory(){
    return category;
}
public void show(){
    System.out.println(id + " |NAme " + name + " | Price" + price + " | Qty: " + quantity + " |Category " + category);
}
}


class Management{
    ArrayList<Product> products = new ArrayList<>();
    void input(Scanner scanner){
        System.out.println("Enter number of products");
        int choice = scanner.nextInt();
        scanner.nextLine();

        for(int i = 0; i<choice;i++){
            System.out.println("Enter details of Products");
            System.out.print("ID");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.println("name");
            String name = scanner.nextLine();
            System.out.println("Price");
            double price = scanner.nextDouble();
            System.out.println("Quantity");
            int quantity = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Category");
            String category = scanner.nextLine();
            
            products.add(new Product(name,id,price,quantity,category));
        }
    }
    void display(){
        for(Product p : products){
        p.show();
        }
    }
void search(Scanner scanner){
scanner.nextLine();
System.out.print("Enter Products to search:");
String search = scanner.nextLine();
boolean found = false;
for(Product p : products){
    if(p.getName().contains(search)){
        p.show();
        found = true;
    }

}

}
void sort(){
    products.sort((a,b) -> Double.compare(a.getPrice() , b.getPrice()));
    System.out.println("Sorted by price");
    display();
}

void lowStock(){
    System.out.println("Low stock Products");
    boolean found = false;
    for(Product p : products){
    if(p.getQuantity()<5){
        p.show();
        found = true;
    }
}
}
void totalValue(){
    double total = 0;
    for (Product p : products){
    total += p.getPrice() * p.getQuantity();

}
System.out.println("total Inventory value :" + total);
}
}
