import java.util.Scanner;

public class Teacher extends Person {
    Scanner sc = new Scanner(System.in);
//var
    public double wage;
//constructor
    public Teacher(){
        super();
        this.wage = 0.0;
    }
//methods
    @Override
    public void input() {
        super.input();
        System.out.println("Enter wage :");
        wage =  sc.nextDouble();
    }
    @Override
    public String toString() {
        return super.toString() + String.format(" Wage: %s \n",wage);
    }
}
