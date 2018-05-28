package company;

import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.ListIterator;

public class WorkersDatabaseApp {

    public static final int OPTION_LIST = 1;
    public static final int OPTION_ADD = 2;
    public static final int OPTION_REMOVE = 3;
    public static final int OPTION_EXIT = 4;

    private static ArrayList<Worker> workers;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int option = 0;

        Departments.init();
        Courses.init();
        Position.init();
        workers = new ArrayList<Worker>();

        while (option != OPTION_LIST) {
            System.out.println("\r\n");
            System.out.println("1. List workers");
            System.out.println("2. Add a new worker");
            System.out.println("3. Remove a worker");
            System.out.println("4. Exit \n");

            // read a user's choice
            System.out.print("Choose an option: ");
            option = in.nextInt();

            switch (option) {
                case WorkersDatabaseApp.OPTION_LIST:
                    printWorkers(WorkersDatabaseApp.workers);
                    break;

                case WorkersDatabaseApp.OPTION_ADD:
                    Worker employee = new Worker();
                    employee = readWorkerData(employee);
                    WorkersDatabaseApp.workers.add(employee);
                    break;

                case WorkersDatabaseApp.OPTION_REMOVE:
                	
                	removeWorkers();
                	break;

                case WorkersDatabaseApp.OPTION_EXIT:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Hold on, Cowboy! \n");
                    break;

            }
        }

    }

    private static Worker readWorkerData(Worker worker) {
        Scanner in = new Scanner(System.in);

        System.out.println("Please fill new worker data. ID, password and email will be assigned automatically.");

        System.out.print("First name: ");
        worker.setFirstName(in.nextLine());

        System.out.print("Last name: ");
        worker.setLastName(in.nextLine());

        System.out.println("Choose the position");
        HashMap position = Position.getAll();
        for (Object key : position.keySet()) {
            Object value = position.get(key);
            System.out.println(key + ". " + value);
        }
        
        System.out.print("Position: ");
        worker.setPosition(in.nextInt());
        
        System.out.println("Choose the department");
        HashMap departments = Departments.getAll();
        for (Object key : departments.keySet()) {
            Object value = departments.get(key);
            System.out.println(key + ". " + value);
        }
        
        System.out.print("Department: ");
        worker.setDepartment(in.nextInt());
        
        System.out.println("Choose the course");
        HashMap courses = Courses.getAll();
        for (Object key : courses.keySet()) {
        	Object value = courses.get(key);
        	System.out.println(key + ". "+ value);
        }	
        
        System.out.println("Course: ");
        worker.setCourse(in.nextInt());
        
        
        worker.generateUserCredentials();

        return worker;
    }  
    
    private static void removeWorkers() {
    	Scanner in = new Scanner(System.in);
    	System.out.println("Choose which worker would you like to remove \nFirst worker starts with 0 ");
    	int removeWorker = in.nextInt();
    	WorkersDatabaseApp.workers.remove(removeWorker);
    }
    
    
    
    private static void printWorkers(ArrayList workers) {
        ListIterator<Worker> litr = workers.listIterator();
        while (litr.hasNext()) {
            Worker worker = litr.next();
            HashMap workerDetails = worker.getFullInfo();
            System.out.println("Worker no " + workerDetails.get("id"));
            System.out.println(workerDetails.get("firstName") + " " + workerDetails.get("lastName"));
            System.out.println("Contact: " + workerDetails.get("email"));
            System.out.println("Position: " + workerDetails.get("position"));
            System.out.println("Department: " + workerDetails.get("department"));
            System.out.println("Course: " + workerDetails.get("course"));
            System.out.println();
            //litr.set(element + "+");
        }
    }
}
