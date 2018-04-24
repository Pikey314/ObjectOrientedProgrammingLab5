package prGrading;

public class Average implements MeanCalculation {

    @Override
    public double calculate(Student[] st) throws StudentException {
        if (st.length == 0)
            throw new StudentException("No students enrolled for the course");
        else {
            double average = 0;
            int numberOfGrades = 0;
            for (Student s : st) {
                average += s.getGrade();
                numberOfGrades++;
            }
            average = average / numberOfGrades;
            return average;
        }
    }
}
