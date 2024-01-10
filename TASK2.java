import java.util.Scanner;

public class TASK2 {

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      System.out.print("Enter Your Name: ");
      String str = sc.nextLine();

      double sum = 0, avgperc;
      Character grade = 'C';

      System.out.print("\nEnter no of subjects: ");
      int n = sc.nextInt();
      for (int i = 1; i <= n; i++) {

         System.out.print("\nEnter marks out of 100 in subject " + i+": ");
         Double m = sc.nextDouble();
         if (m >= 0 && m <= 100) {
            sum = sum + m;
         } else {
            System.out.println("\nMarks should be in range 0 to 100");
            --i;
            continue;
         }

      }
      avgperc = (sum / (n * 100)) * 100;

      if (avgperc >= 50) {
         grade = 'B';
      }
      if (avgperc >= 70) {
         grade = 'A';
      }
      if (avgperc >= 90) {
         grade = 'O';
      }
      sum = Math.round(sum * 100.0) / 100.0; 
      avgperc = Math.round(avgperc * 100.0) / 100.0;
      System.out.print("\nStudent details are :- ");
      System.out.print("\nStudent's name is " + str);
      System.out.print("\nTotal marks obtained by the Student is "+ sum+" out of "+ n * 100);
      System.out.print("\nTotal percentage obtained by the Student is "+ avgperc + "%");
      System.out.print("\nStudent's grade is " + grade);

      sc.close();

   }
}
