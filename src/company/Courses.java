package company;

import java.util.HashMap;
import java.util.Map;

public class Courses {
	
	private static HashMap courses;
	
	public static void init() {
		Courses.courses = new HashMap<>();
		Courses.courses.put(1, "Programowanie");
		Courses.courses.put(2, "MSOffice");
		Courses.courses.put(3, "AutoCad");
		Courses.courses.put(4, "BHP");
		Courses.courses.put(5, "Prawo jazdy kat. B");
		Courses.courses.put(6, "Lean Management");
	}
	public static HashMap getAll() {
	    return Courses.courses;
	}
	public static String get(int id) {
        return (String) Courses.courses.get(id);
    }  
	
	
	
	
	
	
	
	
	
	

}
