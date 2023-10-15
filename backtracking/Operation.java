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
}