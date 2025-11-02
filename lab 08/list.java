import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        StudentManagement sm = new StudentManagement();
        boolean run = true;
        while (run){
            System.out.println("1. Add Student");
            System.out.println("2.Display all Students");
            System.out.println("3. Search Student by name");
            System.out.println("4.Sort by Marks");
            System.out.println("5. Display Students above 85");
            System.out.println("6. Class Average");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch(choice){
                case 1 -> sm.addStudent(scanner);
                case 2 -> sm.displayAll();
                case 3 -> sm.searchStudent(scanner);
                case 4 -> sm.sortByMarks();
                case 5 -> sm.displayToppers();
                case 6 -> sm.classAverage();
             
            }
        }
            scanner.close();
    }
}
    class Student{
        private int rollno;
        private String name;
        private double marks;
        private String department;

        public Student(int rollno,String name,double marks,String department){
        this.rollno = rollno;
        this.name = name;
        this.marks = marks;
        this.department = department;

    }
    public int getRollno(){
        return rollno;
    }
    public String getName(){
        return name;
    }
    public double getMarks(){
        return marks;
    }
    public String getDepartment(){
        return department;
    }
    public void show(){
        System.out.println(rollno + " " + name + " " + marks + " " + department);
    }
}
    class StudentManagement{
        List<Student> students = new ArrayList<>(); 
        
        void addStudent(Scanner scanner){
            System.out.println("Enter details for student ");
            System.out.print("Roll Number");
            int rollno = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter name");
            String name = scanner.nextLine();
            System.out.print("Marks");
            double marks = scanner.nextDouble();
            scanner.nextLine();
            System.out.println("Department");
            String department = scanner.nextLine();

            students.add(new Student(rollno,name,marks,department));
              System.out.println("STudents added succesfully");


        }

    
     void displayAll(){
        for(Student s : students){
            s.show();
        }
     }

     void searchStudent(Scanner scanner){
        scanner.nextLine();
        System.out.print("enter name to search");
        String searchName = scanner.nextLine();
        boolean found = false;
        for(Student s : students){
            if(s.getName().equals(searchName)){
                s.show();
                found = true;
            }
        }
    }

        void sortByMarks() {
            students.sort((a,b) -> Double.compare(b.getMarks(),a.getMarks()));
            System.out.println("sorted by marks");
            displayAll();
        }

        void displayToppers() {
            boolean found = false;
            for(Student s : students){
                if(s.getMarks() > 85){
                    s.show();
                    found = true;
                }
            }
        }

        void classAverage() {
            double total = 0;
            for(Student s : students){
            total += s.getMarks();
            }
            double avg = total/students.size();
            System.out.println("Class Average Marks :" + avg);
        }
    }
    





