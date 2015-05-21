package com.hackbulgaria.corejava2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.hackbulgaria.corejava2.data.Gender;
import com.hackbulgaria.corejava2.data.Student;

public class StudentOperationsImpl implements StudentOperations {

    private List<Student> students = new ArrayList<Student>();

    public StudentOperationsImpl(List<Student> students) {
        this.students = students;
    }

    @Override
    public double getAverageMark() {
        Function<List<Student>, Double> getAverageFunction = (x) -> {
            return x.stream().collect(Collectors.averagingDouble(s -> s.getGrade()));
        };

        return getAverageFunction.apply(this.students);
    }

    @Override
    public List<Student> getAllPassing() {
        Function<List<Student>, List<Student>> getAverageFunction = (x) -> x.stream().filter(s -> s.getGrade() >= 3.0f)
                .collect(Collectors.toList());

        return getAverageFunction.apply(this.students);
    }

    @Override
    public List<Student> getAllFailing() {

        Function<List<Student>, List<Student>> getFallingFunction = (x) -> x.stream().filter(s -> s.getGrade() < 3.0f)
                .collect(Collectors.toList());

        return getFallingFunction.apply(this.students);
    }

    @Override
    public Map<Boolean, List<Student>> splitStudentsByMarks(float splitMark) {
        // TODO Auto-generated method stub
        return null;
    }

    private Comparator<Student> getStudentGradeComparator(boolean descending) {
        Comparator<Student> comparator;

        if (descending) {
            comparator = (s2, s1) -> Double.compare(s1.getGrade(), s2.getGrade());
        } else {
            comparator = (s1, s2) -> Double.compare(s1.getGrade(), s2.getGrade());
        }

        return comparator;
    }

    @Override
    public List<Student> orderByMarkDescending() {

        Function<List<Student>, List<Student>> orderFunction = x -> x.stream().sorted(getStudentGradeComparator(true))
                .collect(Collectors.toList());

        return orderFunction.apply(this.students);
    }

    @Override
    public List<Student> orderByMarkAscending() {

        Function<List<Student>, List<Student>> orderFunction = x -> x.stream().sorted(getStudentGradeComparator(false))
                .collect(Collectors.toList());

        return orderFunction.apply(this.students);
    }

    @Override
    public List<Student> getStudentsWithLowestMarks() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Student> getStudentsWithHighestMarks() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Map<Integer, List<Double>> getMarksDistributionByAge() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Map<Gender, Double> getAverageMarkByGender() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Map<Double, Integer> getMarksDistribution() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getEmailToHeader() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Map<Gender, Map<Integer, List<Student>>> splitStudentMarksByGenderAndThenByAge() {
        // TODO Auto-generated method stub
        return null;
    }
}