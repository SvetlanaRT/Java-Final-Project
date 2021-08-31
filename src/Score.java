import java.util.*;

public class Score {
//var
    public String courseIndex;
    public String courseName;
    public int scoreValue;
//constructor
    public Score() {
        courseIndex = null;
        courseName = null;
        scoreValue = 0;
    }
//methods
    public void input() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter index of  Course");
        courseIndex = sc.next();

        System.out.println("Enter name of Course");
        courseName = sc.next();

        System.out.println("Enter score:");
        scoreValue = sc.nextInt();
    }
    @Override
    public String toString() {
        return String.format("Index: %4s, Course:  %4s, Score: %4d,",courseIndex, courseName, scoreValue);
    }

    public static String getCourseIndex (Score s) {
        return s.courseIndex;
    }
    public static String getCourseName (Score s) {
        return s.courseName;
    }
    public static int getScoreValue(Score s){
        return s.scoreValue;
    }
}
