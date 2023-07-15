package sample;

public class Student extends Human {
    private int id;
    private String groupName;

    public Student(String name, String lastName, Gender gender, int age, int id, String groupName) {
        super(name, lastName, gender, age);
        this.id = id;
        this.groupName = groupName;
    }

    public Student() {

    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getId() {
        return id;
    }

    public String getGroupName() {
        return groupName;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", groupName=" + groupName + ", " + super.toString() + "]";
    }
}