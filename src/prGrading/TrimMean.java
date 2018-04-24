package prGrading;

public class TrimMean implements MeanCalculation {

    private double min;
    private double max;

    public TrimMean (double min, double max){
        this.max = max;
        this.min = min;
    }

    @Override
    public double calculate(Student[] st) throws StudentException {
        boolean rangeCounterFlag = false;
        double average = 0;
        int numberOfGrades = 0;
        for (Student s : st) {
            if (s.getGrade() >= min && s.getGrade() <= max) {
                rangeCounterFlag = true;
                average += s.getGrade();
                numberOfGrades++;
            }
        }

        if (!rangeCounterFlag)
            throw new StudentException("Non student has grade in given range");
        else {
            average = average / numberOfGrades;
            return average;
        }
    }


}
