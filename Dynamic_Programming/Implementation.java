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

   public void canSum(){
      Scanner in = new Scanner(System.in);
      int n = in.nextInt();
      int[] arr = new int[n];
      for(int i = 0 ; i < n ; i++){
         arr[i] = in.nextInt();
      }
      int targetSum = in.nextInt();
      boolean[] res = new boolean[targetSum + 1];
      res[0] = true;
      for(int i = 0 ; i <= targetSum ; i++){
         for(int j = 0 ; j < n ; j++){
            if(res[i] && (i+arr[j]) <= targetSum){
               res[(i+arr[j])] = true;
            }
         }
      }
      System.out.println(res[targetSum]);
   }
   public void antPath(){
      Scanner in = new Scanner(System.in);
      int n = in.nextInt();
      int[][] antpath = new int[n+1][n+1];
      int[][] intermediary = new int[n+1][n+1];
      for(int i = 1 ; i <= n ; i++){
         for(int j = 1 ; j <= n ; j++){
            antpath[i][j] = in.nextInt();
            intermediary[i][j] = 1;
         }
      }
      intermediary[1][1] = 1;
      for(int i = 1 ; i <= n ; i++){
         for(int j = 1 ; j <= n ; j++){
            // For Downward movement
            if(i + 1 <= n){
               if(antpath[i+1][j] - antpath[i][j] == 1){
                  intermediary[i+1][j] = intermediary[i][j] + 1; 
               }
            }
            // For rightward movement
            if(j + 1 <= n){
               if(antpath[i][j + 1] - antpath[i][j] == 1){
                  intermediary[i][j + 1] = intermediary[i][j] + 1; 
               }
            }
         }
      }

      for (int i = 1; i <= n; i++) {
         for (int j = 1; j <= n; j++) {
            System.out.print(findMax(intermediary[i][j] , i , j ,intermediary)+" ");
         }
         System.out.println();
      }
   }

   public static int findMax(int curr , int row , int col ,int[][] mat){
      for(int i = 1 ; i <= row ; i++){
         for (int j = 1; j <= col; j++) {
            if(mat[i][j] > curr){
               curr = mat[i][j];
            }
         }
      }
      return curr;
   }
}