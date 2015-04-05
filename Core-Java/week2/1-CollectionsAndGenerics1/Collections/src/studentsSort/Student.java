package studentsSort;

public class Student implements Comparable<Student> {

    private String name;
    private Integer grade;

    public Student(String name, Integer grade) {
        this.setName(name);
        this.setGrade(grade);
    }

    public int compareTo(Student o) {
        if (this.getGrade() < o.getGrade()) {
            return 1;
        } else if (this.getGrade() > o.getGrade()) {
            return -1;
        } else {
            if (this.getName().compareTo(o.getName()) > 1) {
                return 1;
            } else if (this.getName().compareTo(o.getName()) < 0) {
                return -1;
            }

            return 0;
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(this.getName() + " : " + this.getGrade());
        return output.toString();
    }
}
