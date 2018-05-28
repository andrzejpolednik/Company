package company;

import java.util.HashMap;

public class Worker {
    private String id;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private int department;
    private int course;
    private int position;
    
    public void setFirstName(String name) {
        this.firstName = name;
    }
    
    public void setLastName(String name) {
        this.lastName = name;
    }
    
    public void setPosition(int position) {
    	this.position = position;
    }
    
    public void setDepartment(int department) {
        this.department = department;
    }
    
    public void setCourse(int course) {
    	this.course = course;
    }

    public void generateUserCredentials() {
        email = this.generateEmail();
        password = this.generatePassword(10);
        id = this.setID();
    }
    
    public HashMap getFullInfo() {
        HashMap info = new HashMap();
        info.put("id", this.id);
        info.put("firstName", this.firstName);
        info.put("lastName", this.lastName);
        info.put("position", Position.get(this.position));
        info.put("department", Departments.get(this.department));
        info.put("course", Courses.get(this.course));
        info.put("email", this.email);
        
        return info;
    }
    
    // Generate the email
    private String generateEmail() {
        String email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + Departments.get(department).toLowerCase() + "MAN.com";
        return email;
    }

    // Generate random password
    private String generatePassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVXYZ1234567890";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    // Generate worker ID
    private String setID() {
        int randomNumber = (int) (Math.random() * Math.pow(10, 4));
        String id = Departments.get(department).substring(0, 1) + randomNumber;
        return id;
    }
}
