import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
public class Inventoryapp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List <Product> products = new ArrayList<>();
        InventoryManagement inventory = new InventoryManagement();
        boolean isRun = true;
        while(isRun){
            System.out.println("1.Add electrnic product");
            System.out.println("2. Add grocery product");
            System.out.println("3. Display all products");
            System.out.println("4.Search product");
            System.out.println("5.Sort product");
            System.out.println("6.Low Stock Alert");
            System.out.println("7.Total inventory value");
            System.out.print("enter your chooice");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice){
                case 1 -> {
                    System.out.print("Enter ID:");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("enter name:");
                    String name = scanner.nextLine();
                    System.out.print("Enter price:");
                    double price = scanner.nextDouble(); 
                    System.out.print("Enter quantity:");
                    int quantity = scanner.nextInt();
                    System.out.print("Enter warranty period in years:");
                    int warranty = scanner.nextInt();
                    inventory.addProduct(name,id,price,quantity,warranty);
                    System.out.println("Electronic product added successfully!");
                }
                case 2 -> {
                    System.out.print("Enter ID:");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("enter name:");
                    String name = scanner.nextLine();
                    System.out.print("Enter price:");
                    double price = scanner.nextDouble(); 
                    System.out.print("Enter quantity:");
                    int quantity = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter expiry date (DD/MM/YYYY):");
                    String expirydate = scanner.nextLine();
                    inventory.addProduct(name,id,price,quantity,expirydate);
                    System.out.println("Grocery product added successfully!");
                }
                case 3 -> inventory.display();
                case 4 -> inventory.search(scanner);
                case 5 -> inventory.sort();
                case 6 -> inventory.lowStock();
                case 7 -> inventory.totalValue();
                case 8 ->{
                    isRun = false;
                }
            }
        }
    }
}

class Product {
    String name;
    int id;
    double price;
    int quantity;

    Product(String name , int id,double price,int quantity){
        this.name = name;
        this.id = id;
        this.price = price;
        this.quantity = quantity;
        
    }
    void show(){
        System.out.println(id + "  Product Name: " + name + " Price: " + price + " Qty : " + quantity);
}
}
   
        class Electronic extends Product {
        int warranty;
        Electronic(String name,int id ,double price , int quantity,int warranty){
            super(name,id,price,quantity);
            this.warranty = warranty;
        }
        void show(){
            System.out.println("electronic Name: " + name + " Price: " + price + " Warranty: " + warranty + " years");

        }
    }
    class Grocery extends Product{
        String expirydate;
        Grocery(String name ,int id, double price , int quantity, String expirydate)
        {
            super(name,id,price,quantity);
            this.expirydate = expirydate;
        }
    
        void show(){
            System.out.println("Grocery Name: " + name + " Price: " + price + " Expiry Date: " + expirydate);
        }

    }
    class InventoryManagement{
        ArrayList<Product> products = new ArrayList<>();
         void addProduct(String name, int id, double price, int quantity, int warranty){
            products.add(new Electronic(name,id,price,quantity,warranty));
     }
      void addProduct(String name, int id,double price,int quantity,String expirydate){
        products.add(new Grocery(name , id , price,quantity,expirydate));
      }
      void display(){
        if(products.isEmpty()){
            System.out.println("no products");
            return;
        }
        System.out.println("Product List:");
        for(Product p : products){
            p.show();
        }
            
        }
        void search(Scanner scanner){
            scanner.nextLine();
            System.out.print("Enter product name to search:");
            String search = scanner.nextLine();
            boolean found = false;
            for(Product p : products){
                if(p.name.equalsIgnoreCase(search)){
                    p.show();
                    found = true;
                }
            }
        }
         void sort(){
            products.sort((a,b) -> Double.compare(a.price , b.price));
            System.out.println("sorted by price succesfully");
            display();
         }

         void lowStock(){
            System.out.println("products with low stock:");
            boolean found = false;
            for(Product p : products){
                if(p.quantity < 5){
                    p.show();
                    found = true;
                }
            }
        }
                
                void totalValue(){
                    double total = 0;
                    for(Product p : products){
                        total +=p.price*p.quantity;
                    }
                    System.out.println("Total inventory value: " + total);
                            
                }
            }

         

    
      
        
    
