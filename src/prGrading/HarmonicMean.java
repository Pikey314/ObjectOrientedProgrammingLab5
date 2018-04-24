package prGrading;

public class HarmonicMean implements MeanCalculation {

    @Override
    public double calculate(Student[] st) throws StudentException {

        double mean = 0;
        int numberOfGradesAbove0 = 0;
        for (Student s : st)
            if (s.getGrade() > 0)
                numberOfGradesAbove0++;

         if (numberOfGradesAbove0 == 0)
             throw new StudentException("No grades above 0");
         else {
            for (Student s : st)
            mean += 1/s.getGrade();
            mean = numberOfGradesAbove0/mean;
            return mean;
        }
    }

}
