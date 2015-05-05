package junitImpl;

public class JUnit {

    @Before
    public void init() {
        System.out.println("-----Before Test-----");
    }

    @Execute
    public void testAdd() {
        System.out.println("testAdd-Executed");
    }

    @Execute
    public void testDevide() {
        System.out.println("testDevide-Executed");
    }

    @Execute
    public void testSqrt() {
        System.out.println("testSqrt-Executed");
    }

    @After
    public void afterTest() {
        System.out.println("-----After Test-----");
    }
}