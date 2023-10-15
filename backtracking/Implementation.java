import java.util.Scanner;

public class Implementation{
   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      Operation op = new Operation();
      System.out.println(op.mazeRunner(in.nextInt(), in.nextInt()));
   }
}