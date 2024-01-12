package maze;
import java.util.*;

public class Level1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] maze = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                maze[i][j] = in.nextInt();
            }
        }
        if(maze[0][0] != 0 ){
            System.out.println("No path exists");
        }else {
            int[][] res = new int[n][n];
            res[0][0] = 1;
            checkMaxe(maze, res, 0, 0, n);
        }
    }

    private static void checkMaxe(int[][] maze, int[][] res, int i, int j, int n) {
        if(i == n - 1 &&  j == n - 1){
            for(int[] e : res){
                System.out.println(Arrays.toString(e));
            }
        }
        if(i + 1 < n && maze[i + 1][j] == 0 && res[i + 1][j] == 0){
            res[i + 1][j] = 1;
            checkMaxe(maze , res , i + 1 , j , n);
            res[i + 1][j] = 0;
        }
        if(j + 1 < n && maze[i][j + 1] == 0 && res[i][j + 1] == 0){
            res[i][j + 1] = 1;
            checkMaxe(maze , res , i + 1 , j , n);
            res[i][j + 1] = 0;
        }
    }
}
