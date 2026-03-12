package models;

public abstract class Person {
    protected String name;
    protected int age;
    protected String id;
    
    public Person(String name, int age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }
    
    // Getters and Setters
    public String getName() { 
        return name; 
    }
    
    public void setName(String name) { 
        this.name = name; 
    }
    
    public int getAge() { 
        return age; 
    }
    
    public void setAge(int age) { 
        this.age = age; 
    }
    
    public String getId() { 
        return id; 
    }
    
    // Abstract method
    public abstract String getRole();
    
    @Override
    public String toString() {
        return String.format("Name: %s | Age: %d | ID: %s", name, age, id);
    }
}
