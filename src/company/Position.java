package company;

import java.util.HashMap;

public class Position {
private static HashMap position;
    
    public static void init() {
        Position.position = new HashMap<>();
        Position.position.put(1, "CEO");
        Position.position.put(2, "Manager");
        Position.position.put(3, "Specialist");
        Position.position.put(4, "Assistant");
        Position.position.put(5, "Trainee");
        Position.position.put(6, "Manual Worker");
        
    }
    
    public static HashMap getAll() {
        return Position.position;
    }
    
    public static String get(int id) {
        return (String) Position.position.get(id);
    }
	
	
	
}
