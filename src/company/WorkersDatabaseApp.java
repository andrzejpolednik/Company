package company;

import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;

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

                    break;

                case WorkersDatabaseApp.OPTION_ADD:
                    Worker employee = new Worker();
                    employee = readWorkerData(employee);
                    WorkersDatabaseApp.workers.add(employee);
                    break;

                case WorkersDatabaseApp.OPTION_REMOVE:

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

        HashMap departments = Departments.getAll();
        for (Object key : departments.keySet()) {
            Object value = departments.get(key);
            System.out.println(key + ". "+ value);
        }
        
        System.out.print("Department: ");
        worker.setDepartment(in.nextInt());
        
        worker.generateUserCredentials();
        
        return worker;
    }
}
