package customAnotation;

@ClassInfo(autor = "Zdravko", related = { String.class })
public class MyClass {
    private int age;

    public MyClass(int age) {
        this.setAge(age);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}