package lab8;

public class Employee implements Comparable<Employee> {

    //instantiating variables
    private String name;
    private int Id;

    //default constructor for class Employee
    public Employee() {
    }

    //constructor for class Employee
    public Employee(String name, int Id) {
        this.Id = Id;
        this.name = name;
    }

    //getters and setters for variables
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    //toString method to print array elements 
    @Override
    public String toString() {
        return String.format("(%s, %d)", name, Id);
    }
    
    //compareTo method to use in selection sort
    @Override
    public int compareTo(Employee second){
        int result;
        
        if (this.getId() > second.getId()) {             
                return result = 1; 
        } else if (this.getId()<second.getId()){
                return result = -1; 
        } else {
                return result = 0; 
        }
    }
    
    public int equals(Employee second){
        int result;
        
        if (this.getId() > second.getId()) {             
                return result = 1; 
        } else if (this.getId()<second.getId()){
                return result = -1; 
        } else {
                return result = 0; 
        }
    }
}