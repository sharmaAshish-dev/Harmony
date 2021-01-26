package mps.project.harmony.Models;

public class User {

    private String Name;
    private String Email;
    private String Password;
    private String age;
    private String weight;
    private String height;
    private String bloodGroup;

    public User() {
    }

    public User(String name, String email, String password, String age, String weight, String height, String bloodGroup) {
        Name = name;
        Email = email;
        Password = password;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.bloodGroup = bloodGroup;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }
}
