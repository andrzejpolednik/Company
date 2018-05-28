package company;

import java.util.Map;
import java.util.HashMap;

public class Departments {
    private static HashMap departments;
    
    public static void init() {
        Departments.departments = new HashMap<>();
        Departments.departments.put(1, "Quality");
        Departments.departments.put(2, "Production");
        Departments.departments.put(3, "Logistics");
        Departments.departments.put(4, "Maintenance");
        Departments.departments.put(5, "Planning");
        Departments.departments.put(6, "Complaints");
        
    }
    
    public static HashMap getAll() {
        return Departments.departments;
    }
    
    public static String get(int id) {
        return (String) Departments.departments.get(id);
    }
}
