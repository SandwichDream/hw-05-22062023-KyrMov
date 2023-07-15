package sample;

public class Human {
    private String name;
    private String lastName;
    private Gender gender;
    private int age;

    public Human(String name, String lastName, Gender gender, int age) {
        this.name = name;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
    }

    public Human() {

    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Human [name=" + name + ", lastName=" + lastName + ", gender=" + gender + "]";
    }
}