package lab8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SortedLinkedListClient {

	public static void main(String[] args) throws IOException {
		int entry = -100; //store input integer
        int lines = 0; //holds number of lines in the file
        Employee [] employeesArray = new Employee[lines]; //array of Employees

        SortedLinkedList<Employee> sortedLL = new SortedLinkedList<>();//initiated sorted linked list
      
        System.out.print("Please enter File Name you'd like to read: ");
    	Scanner input2 = new Scanner(System.in);
    	String file = input2.nextLine();
    	
        FileReader FileName = new FileReader(file);
        
        //Count lines in file using BufferReader
        BufferedReader reader = new BufferedReader(FileName);
      
        while (reader.readLine() != null) lines++;
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        //Create array of employees with size of lines
        employeesArray = new Employee[lines]; 
        int counter = 0; //employee counter

       //Now read the file again using a while loop and insert it into array
        File inputFile = new File(file);
        Scanner inpScanner = new Scanner(inputFile);

        while (inpScanner.hasNextLine()) {

            String nextLine = inpScanner.nextLine();

            //splitting line into parts and writing to array
            String [] emp = nextLine.split(" ");

            //instantiating new Employee
            Employee employee = new Employee(emp[0], Integer.parseInt(emp[1]));
            sortedLL.add(employee);
            counter++;
            }
        sortedLL.printList();
        System.out.println("Elements added in a sorted way based on ID");
       
	}

}
//src/lab8/emp.txt
