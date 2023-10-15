package Dynamic_Programming;
import java.util.Scanner;
public class Implementation{
   public void fibo(){
      Scanner in = new Scanner(System.in);
      int n = in.nextInt();
      long[] fib = new long[n + 1];
      fib[0] = 0;
      fib[1] = 1;
      for(int i = 2 ; i <= n ; i++){
         fib[i] = fib[i - 1] + fib[i - 2];
      }
      System.out.println(fib[n]);
   }

   // Maze problem
   public void mazeRunner(){
      Scanner in = new Scanner(System.in);
      int n = in.nextInt();
      int[][] arr = new int[n+1][n+1];
      arr[1][1] = 1;
      for(int i = 1 ; i <= n ; i++){
         for(int j = 1 ; j <= n ; j++){
            if(i == 1 && j == 1) continue;
            arr[i][j] = arr[i][j - 1] + arr[i - 1][j]; 
         }
      }
      System.out.println(arr[n][n]);
   }
}