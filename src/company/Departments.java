package company;

import java.util.Map;
import java.util.TreeMap;

public class Departments {
    private static Map<Integer, String> departments;
    
    public static void Department() {
        departments = new TreeMap<>();
        departments.put(1, "Quality");
        departments.put(2, "Production");
        departments.put(3, "Logistics");
        departments.put(4, "Maintenance");
        departments.put(5, "Planning");
        departments.put(6, "Complaints");
    }
    
    public static Map<Integer, String> getAll() {
        return departments;
    }
    
    public static String get(Integer id) {
        return "fake";//departments.get(id);
    }
}
