import java.util.*;

public class Program {
    public static void main(String[] args) {

        System.out.println();
        System.out.println("This program menages TEACHERS and STUDENTS");
        System.out.println();//

        List<Person> People = new ArrayList<>();
        List<Score> scoreList = new ArrayList<>(2);// "BUFFER"
        scoreList.add(new Score());
        scoreList.add(new Score());


        Scanner scanner = new Scanner(System.in);
        int selection;

        main_loop:
        while (true) {
            System.out.println("THERE IS OPTIONS OF ACTION:");
            System.out.print(
                    " 1) Add Teacher \n" +
                            " 2) Add Student \n" +
                            " 3) Show All People \n" +
                            " 4) Show All Teachers \n" +
                            " 5) Show All Students \n" +
                            " 6) Show Teacher by ID \n" +
                            " 7) Show Student by ID and manage Scores \n" +
                            " 8) Show Student by Average Score range \n" +
                            " 9) QUIT \n"
            );
            System.out.println();//
            System.out.println("PLEASE ENTER THE NUMBER OF ACTION:");

            if (scanner.hasNextInt()) {
                selection = scanner.nextInt();
            } else {
                System.out.println("INVALID OPTION!");
                scanner.nextLine();
                System.out.println();//
                continue;
            }

            switch (selection) {
                case 1:
                    System.out.println("option 1 is selected");
                    Person p1 = new Teacher();
                    p1.input();
                    People.add(p1);

                    System.out.println(); //
                    System.out.println("Teacher created:");
                    System.out.println(p1);

                    break;

                case 2:
                    System.out.println("option 2 is selected");
                    Person p2 = new Student();
                    p2.input();
                    People.add(p2);

                    System.out.println("Student created:");
                    System.out.println(p2);
                    break;

                case 3:
                    System.out.println("option 3 is selected");
                    System.out.println("List of all People:");

                    Collections.sort(People, new Comparator<Person>() {
                        @Override
                        public int compare(Person o1, Person o2) {
                            return String.valueOf(o1.id).compareTo(o2.id);
                        }
                    });
                    System.out.println(People);
                    break;

                case 4:
                    System.out.println("option 4 is selected");
                    System.out.println("List of Teachers:");

                    List<Person> teachers = new ArrayList<>();

                    for (Person p : People)
                        if (p.getClass() == Teacher.class) {
                            teachers.add(p);
                        }
                    System.out.println(teachers);
                    break;

                case 5:
                    System.out.println("option 5 is selected");
                    System.out.println("List of Students:");

                    List<Object> students = new ArrayList<>();

                    for (Person p : People)
                        if (p.getClass() == Student.class) {
                            students.add(p);
                        }
                    System.out.println(students);
                    break;
//PROBLEM -print wrong information together with right information
                case 6:
                    System.out.println("option 6 is selected");

                    Scanner scannerT = new Scanner(System.in);
                    System.out.println("Enter ID:");
                    String inputIDt = scannerT.next();

                    for (Person p : People) {

                        if (!inputIDt.equals(p.getId())) {
                            System.out.println("Does NOT Exist by id: " + inputIDt);
                        }
                        else if (p.getClass().equals((Teacher.class))) {
                            System.out.println("Data of Teacher by id:" + inputIDt);
                            System.out.println(p);

                        } else
                            System.out.println("NOT a Teacher by id: " + inputIDt);
                        System.out.println();
                    }

                  break;

                case 7:
                    System.out.println("option 7 is selected");
                    Scanner scannerS = new Scanner(System.in);
                    System.out.println("Enter ID:");
                    String inputIDs = scannerS.next();
//PROBLEM -print wrong information together with right information
                    for (Person p : People) {
                        if (!inputIDs.equals(p.getId())) {
                            System.out.println("Does NOT Exist by id: " + inputIDs);

                        } else if (p.getClass().equals(Student.class)) {
                            System.out.println("Data of Student by id:" + inputIDs);
                            System.out.println(p);
//---------------------------------------------------------------------------------------------------------------------------
                            sub_menu:
                            while (true) {

                                System.out.println("To manage Scores enter option from MENU:");
                                System.out.println("----------------------------------------");//
                                System.out.println(
                                        "a) Show All Scores \n" +
                                                "b) Insert a New Score \n" +
                                                "c) Show Average Score \n" +
                                                "d) Return to ACTION MENU \n");

                                Scanner scanner_sm = new Scanner(System.in);
                                String selection_sm = scanner_sm.nextLine().toUpperCase();

                                switch (selection_sm) {

                                    case "A":
                                        for (Score s : scoreList) {
                                            String scoreString = "Index: " + Score.getCourseIndex(s) + "," +
                                                    "Course: " + Score.getCourseName(s) + "," +
                                                    "Score: " + Score.getScoreValue(s);
                                            System.out.println(scoreString);
                                        }
                                        System.out.println();//
                                        break;

                                    case "B":
//PROBLEM-overloading of scores
                                        for (Score s : scoreList) {
                                            s.input();
                                        }
                                        Student.setScore(scoreList);
                                        break;

                                    case "C":
                                        int avg = Student.getAvg(Student.studentScores);
                                        System.out.printf("Average score by Id %4s is: %4d", inputIDs, avg);
                                        break;

                                    case "D":
                                        System.out.println("Goodbye! Return to OPTIONS ");
                                        System.out.println();//
                                        break sub_menu;
                                }
//--------------------------------------------------------------------------------------------
                            }
                        }
                     else System.out.println("Not a Student by Id: "+ inputIDs);
                    }
                    break;
                case 8:
                    System.out.println("option 8 is selected");

                    Scanner scannerR = new Scanner(System.in);

                    System.out.println("Enter Maximum value of Score:");
                    int scoreMax = scannerR.nextInt();

                    System.out.println("Enter Minimum value of Score:");
                    int scoreMin = scannerR.nextInt();
//PROBLEM-?
                    for(Person p : People){
                        if  ( p.getClass().equals(Student.class) ){
                            if(Student.getAvg(Student.studentScores)>=scoreMin && (Student.getAvg(Student.studentScores)<=scoreMax)){
                                System.out.println(p);
                            }
                        }
                    }
                    break;
                case 9:
                    System.out.println("option 9 is selected");
                    System.out.println("Goodbye!");
                    break main_loop;

                default:
                   System.out.println("INVALID OPTION !!!" );
            }
        }
    }
}



