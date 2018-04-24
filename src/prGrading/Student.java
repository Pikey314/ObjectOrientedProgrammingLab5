package prGrading;

public class Student {
    private String name;
    private String ID;
    private double grade;

    public Student (String name, String ID, double grade) throws StudentException {
        if (grade < 0)
            throw new StudentException("Grade is negative");
        this.name = name;
        this.ID = ID;
        this.grade = grade;
    }

    public Student (String name, String ID){

        this.name = name;
        this.ID = ID;
        this.grade = 0;
    }

    public String getName() {
        return this.name;
    }

    public String getID() {
        return this.ID;
    }

    public double getGrade() {
        return this.grade;
    }

    public String toString() {
        return this.name + " " + this.ID;
    }


    public boolean equals(Object o) {
        if (o instanceof Student)
            return this.name == ((Student) o).getName() && this.ID.toLowerCase() == ((Student) o).getID().toLowerCase();
        else
            return false;
    }
}
