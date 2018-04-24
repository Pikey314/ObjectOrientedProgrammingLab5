import prGrading.*;

public class CourseTest {


    public static void main(String args[]) {

        System.out.println("\n*********Starting test for task 1*********\n");
        String[] students1 = new String[3];
        students1[0] = "Lopez Perez, Pedro;12455666F;6.7";
        students1[1] = "Merlo Gomez, Isabel;33678999D;5.8";
        students1[2] = "Martinez Herrera, Lucia;23555875G;9.1";


        Course c = new Course("OOP", students1);

        System.out.println(c);

            System.out.println(c.getStudents()[1].getGrade());

        System.out.println("*********Ending test for task 1*********\n");
        System.out.println("*********Starting test for means of task 2*********\n");
        String [] students = {
                "25653443S;Garcia Gomez, Juan;8.1",
                "23322443K;Lopez Turo, Manuel;4.3",
                "24433522M;Merlo Martinez, Juana;5.3",
                "53553421D;Santana Medina, Petra;-7.1",
                "55343442L,Godoy Molina, Marina;6.3",
                "34242432J;Fernandez Vara, Pedro;2.k",
                "42424312G;Lopez Gama, Luisa;7.1" };
        ImprovedCourse algebra = new ImprovedCourse("Algebra", students);

        try {
            Student st1 = new Student("23322443k","Lopez Turo, Manuel");
            Student st2 = new Student("34242432J","Fernandez Vara, Pedro");
            System.out.println(st1 + "'s grade : " + algebra.getGrade(st1));
            System.out.println(st2 + "'s grade : " + algebra.getGrade(st2));
        } catch(StudentException e) {
            System.err.println(e.getMessage());
        }

        try {
            MeanCalculation m1 = new Average();
            MeanCalculation m2 = new HarmonicMean();
            double min = 5.0;
            double max = 9.0;
            MeanCalculation m3 = new TrimMean(min,max);

            System.out.println("Average " + algebra.getAverage(m1));
            System.out.println("Harmonic Mean " + algebra.getAverage(m2));
            System.out.println("Trim Mean ["+min+","+max+"] " + algebra.getAverage(m3));
        } catch (StudentException e) {
            System.out.println("Error "+ e.getMessage());
        }
        System.out.println("\n*********Ending test for means of task 2*********\n");
    }
}
