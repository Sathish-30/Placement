import java.util.ArrayList;
import java.util.Scanner;

public class Implementation{
   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      System.out.print("Enter the array size :");
      int n = in.nextInt();
      int[] arr = new int[n];
      for(int i = 0  ; i < n ; i++){
         arr[i] = in.nextInt();
      }
      int k = in.nextInt();
      Operation op = new Operation();
      ArrayList<Integer> res = op.howSum(arr , k);
      System.out.println(res);
   }
}