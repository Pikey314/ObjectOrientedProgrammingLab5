package prGrading;

import java.util.Scanner;

public class Course {

    private String name;
    private Student[] studentsData;
    private String[] errors;

    public Course(String name, String[] studentsData) {
        this.name = name;
        Scanner sc;
        int i = 0;
        int errorIndex = 0;
        int studentIndex = 0;
        String studentName;
        String studentID;
        String studentGradeString;
        double studentGrade;
        Student student;
        int errorTempSize = studentsData.length;
        String[] errorTemp = new String[errorTempSize];
        int studentsDataTempSize = studentsData.length;
        Student[] studentsDataTemp = new Student[studentsDataTempSize];

        while(i < studentsData.length) {
            String studentString = studentsData[i];
            int countTokens = studentsData[i].length() - studentsData[i].replace(";", "").length();
            if (countTokens != 2) {
                errorTemp[errorIndex] = "ERROR - Missing data :" + studentString;
                errorIndex++;
                System.out.println("ERROR - Missing data : " + studentString);

            }
            else {
                    String[] tokens = studentString.split(";");

                    studentName = tokens[0];
                    studentID = tokens[1];
                    studentGradeString = tokens[2];
                    try {
                        studentGrade = Double.parseDouble(studentGradeString);
                        student = new Student(studentName, studentID, studentGrade);
                        studentsDataTemp[studentIndex] = student;
                        studentIndex++;

                    } catch (StudentException e){
                        e.getMessage();
                    } catch (NumberFormatException e){
                        System.out.println("ERROR. Grade is not a number: " + studentString);
                        errorTemp[errorIndex] = "ERROR. Grade is not a number: " + studentString;
                        errorIndex++;
                    }

                }

            i++;
            }
        this.studentsData = new Student[studentIndex];
        this.errors = new String[errorIndex];
        System.arraycopy(studentsDataTemp,0,this.studentsData, 0, studentIndex);
        System.arraycopy(errorTemp,0,this.errors, 0, errorIndex);

        }

    public double getGrade(Student s) throws StudentException {
        int i = 0;
        while (i<this.studentsData.length){
            if (this.studentsData[i].equals(s))
                return this.studentsData[i].getGrade();
            i++;
        } throw new StudentException("No such student enrolled in the course");
    }

    public double getAverage() {
        double average = 0;
        int numberOfGrades = 0;
        for (Student s : this.studentsData){
            average += s.getGrade();
            numberOfGrades++;
        }
        average = average/numberOfGrades;
        return average;
    }

    public Student[] getStudents() {
        return this.studentsData;
    }

    public String[] getErrors() {
        return errors;
    }

    @Override
    public String toString() {
        StringBuilder stringToReturn = new StringBuilder(this.name + " : { [");
        for (Student s : this.studentsData)
            stringToReturn.append(s.toString() + ", ");
        stringToReturn.append("], [");
        for (String e : this.errors)
            stringToReturn.append(e + ", ");
        stringToReturn.append("] }");
        return stringToReturn.toString();
    }
}
