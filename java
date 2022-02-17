package lesson4;

public class Climber {
    private String fullName;
    private int age;
    private String email;
    
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        if (fullName.isEmpty() || fullName.trim().length() < 3) {
            throw new IllegalArgumentException("Значение full < 3");
        }
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Значение age 18 или больше");
        }
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email.isEmpty() || !email.trim().contains("@")) {
            throw new IllegalArgumentException("Это не email");
        }
        this.email = email;
    }
}
