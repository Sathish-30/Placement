import java.util.ArrayList;
import java.util.Scanner;

public class TrailingZero{
   public static void main(String[] args){
      Scanner in = new Scanner(System.in);
      int t = in.nextInt();
      int testCase = 0;
      while(testCase < t){
         // Where n is the no of trailing zeros
         int n = in.nextInt();
         int i = 0 , count = 0;
         ArrayList<Integer> al = new ArrayList<>();
         while(count <= n){
            count = 0;
            int j = 1;
            while(i >= (int)Math.pow(5 , j)){
               count += (i / (int)Math.pow(5, j));
               j++;
            }
            if(count == n){
               al.add(i);
            }
            i++;
         }
         System.out.println(al.size());
         if(al.size() > 0){
            for(int e : al){
               System.out.print(e+" ");
            }
            System.out.println();
         }
         testCase += 1;
      }
   }
}