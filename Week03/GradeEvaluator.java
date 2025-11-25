
public class GradeEvaluator {
    public static void main(String[] args) {

        int grade = 25;
        String result = (grade >= 40) ? "Pass" : "Fail";
        
        System.out.println("----- Grade Evaluation -----\n");
        System.out.println("Your Grade: " + grade + "\n");
        System.out.println("Result:\t" + result + "\n");
        System.out.println("-----------------------------");
    }
}

