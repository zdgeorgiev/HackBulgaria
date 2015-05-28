package com.hackbulgaria.corejava2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
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
        Function<List<Student>, Double> getAverageFunction = x -> {
            return x.stream().collect(Collectors.averagingDouble(s -> s.getGrade()));
        };

        return getAverageFunction.apply(this.students);
    }

    @Override
    public List<Student> getAllPassing() {
        Function<List<Student>, List<Student>> getAverageFunction = x -> x.stream().filter(s -> s.getGrade() >= 3.0f)
                .collect(Collectors.toList());

        return getAverageFunction.apply(this.students);
    }

    @Override
    public List<Student> getAllFailing() {
        Function<List<Student>, List<Student>> getFallingFunction = x -> x.stream().filter(s -> s.getGrade() < 3.0f)
                .collect(Collectors.toList());

        return getFallingFunction.apply(this.students);
    }

    @Override
    public Map<Boolean, List<Student>> splitStudentsByMarks(float splitMark) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @author zdgeorgiev
     * @param descending
     *            true if want to compare in descending order or false to
     *            compare in ascending order
     */
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
        List<Student> sortedAsc = this.orderByMarkAscending();
        double maxGrade = sortedAsc.get(0).getGrade();

        Function<List<Student>, List<Student>> getLowestMarkFunction = x -> x.stream()
                .filter(s -> Double.compare(s.getGrade(), maxGrade) == 0).collect(Collectors.toList());

        return getLowestMarkFunction.apply(sortedAsc);
    }

    @Override
    public List<Student> getStudentsWithHighestMarks() {
        List<Student> sortedDesc = this.orderByMarkDescending();
        double maxGrade = sortedDesc.get(0).getGrade();

        Function<List<Student>, List<Student>> getHighestMarkFunction = x -> x.stream()
                .filter(s -> Double.compare(s.getGrade(), maxGrade) == 0).collect(Collectors.toList());

        return getHighestMarkFunction.apply(sortedDesc);
    }

    @Override
    public Map<Integer, List<Double>> getMarksDistributionByAge() {
        Map<Integer, List<Double>> map = new HashMap<>();

        BiFunction<List<Student>, Integer, List<Double>> getAllMarksFromAge = (students, age) -> students.stream()
                .filter(s -> Integer.compare(s.getAge(), age) == 0).mapToDouble(s1 -> s1.getGrade()).boxed()
                .collect(Collectors.toList());

        Consumer<List<Student>> distributionByAgeFunction = x -> x.stream().forEach(
                s1 -> map.put(s1.getAge(), getAllMarksFromAge.apply(this.students, s1.getAge())));

        distributionByAgeFunction.accept(this.students);

        return map;
    }

    @Override
    public Map<Gender, Double> getAverageMarkByGender() {
        Map<Gender, Double> map = new HashMap<>();

        Map<Gender, List<Student>> allStudentsWithGrade = this.students.stream().collect(
                Collectors.groupingBy(Student::getGender));

        map.put(Gender.MALE,
                allStudentsWithGrade.get(Gender.MALE).stream().collect(Collectors.averagingDouble(Student::getGrade)));

        map.put(Gender.FEMALE,
                allStudentsWithGrade.get(Gender.FEMALE).stream().collect(Collectors.averagingDouble(Student::getGrade)));

        return map;
    }

    @Override
    public Map<Double, Integer> getMarksDistribution() {
        Map<Double, Integer> map = new HashMap<>();

        Map<Double, List<Student>> uniqueGrades = this.students.stream().collect(
                Collectors.groupingBy(Student::getGrade));

        return map;
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