package company;

import java.util.Scanner;
import java.util.Map;
import java.util.TreeMap;
import java.util.List;

public class WorkersDatabaseApp {

    public static final int OPTION_LIST = 1;
    public static final int OPTION_ADD = 2;
    public static final int OPTION_REMOVE = 3;
    public static final int OPTION_EXIT = 4;

    private static List<Worker> workers;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int option = 0;

        while (option != OPTION_LIST) {
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
                    readWorkerData(employee);

                    //workers.add(employee);
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

    private static void readWorkerData(Worker worker) {
        Scanner in = new Scanner(System.in);

        System.out.println("Please fill new worker data. ID, password and email will be assigned automatically.");

        System.out.print("First name: ");
        worker.setFirstName(in.nextLine());

        System.out.print("Last name: ");
        worker.setLastName(in.nextLine());

//        Map departments = Departments.getAll();
//        System.out.print("Department ");
        //worker.setFirstName(in.nextLine())
        //worker.generateUserCredentials();
    }
}
