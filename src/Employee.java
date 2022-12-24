public class Employee {
    private String name;
    private String surname;
    private String patronymic;
    private int department;
    private double wages;
    private int id;
    static int count=0;

    public Employee(String surname, String name, String patronymic, int department, double wages) {
        this.surname = surname;
        this.name = name;
        this.patronymic=patronymic;
        this.department=department;
        this.wages=wages;
        this.id=count;
        count++;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public int getDepartment() {
        return department;
    }

    public double getWages() {
        return wages;
    }

    public int getId() {
        return id;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setWages(double wages) {
        this.wages = wages;
    }

}
