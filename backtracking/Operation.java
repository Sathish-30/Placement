
public class Operation{
   // Where the maze can be go by Right and Down -> lexiographically from down to right
   public int mazeRunner(int i , int j){
      if(i == 1 && j == 1){
         return 1;
      }else if(i == 0 || j == 0){
         return 0;
      }else{
         return mazeRunner(i - 1, j) + mazeRunner(i, j - 1);
      }
   }

   public boolean canSum(int[] arr , int sum){
      if(sum == 0) return true;
      else if (sum < 0) return false;
      else{
         for(int i = 0 ; i < arr.length ; i++){
            sum -= arr[i];
            if(canSum(arr, sum) == true) return true;
         }
         return false;
      }
   }
}