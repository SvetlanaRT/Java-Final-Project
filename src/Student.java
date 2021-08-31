import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class Student extends Person {

    public static int averageScore;
    public static List<Integer> studentScores = new LinkedList<>();


    //methods
    public Student() {
        super();
        averageScore = 0;
    }
    public static int getAvg(List<Integer> l) {
        int sum = 0;

        for (Integer i : l) {
            sum += i;
            averageScore = sum / l.size();
        }
        return averageScore;
    }
    public static void setScore(List<Score> l) {
        for (Score s : l) {
            studentScores.add(s.scoreValue);
        }
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" Average Score: %d \n", averageScore);
    }
}

