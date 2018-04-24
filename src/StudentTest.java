import prGrading.*;

public class StudentTest {

    public static void main(String args[]) {

        try {
            Student student1 = new Student("Gonzalez Perez, Juan","22456784F",5.5);
            Student student2 = new Student("Gonzalez Perez, Juan","33456777S ",3.4);


            System.out.println(student1.toString() + " " + student1.getGrade());
            System.out.println(student2.toString() + " " + student1.getGrade());

        } catch (StudentException e) {
            e.printStackTrace();
        }


    }
}
