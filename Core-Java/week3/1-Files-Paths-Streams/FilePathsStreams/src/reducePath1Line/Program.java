package reducePath1Line;

import java.io.File;

public class Program {
    public static void main(String[] args) {
        String path = "/home//radorado/code/./hackbulgaria/week0/../";

        System.out.println(new File(path).toPath().normalize());
    }
}