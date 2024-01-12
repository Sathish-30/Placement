package maze;
import java.util.*;

public class Level2{
    public static boolean status = false;
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] maze = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                maze[i][j] = in.nextInt();
            }
        }
        int[][] res = new int[n][n];
        res[0][0] = 1;
        checkMaze(maze , res , 0 , 0 , n);
        if(!status){
            System.out.println("No solution exists");
        }
    }
    static void checkMaze(int[][] maze , int[][] res , int i , int j , int n){
        if(i == n - 1 && j == n - 1){
            status = true;
            for(int[] ar : res){
                for(int e : ar){
                    System.out.print(e+" ");
                }
                System.out.println();
            }
        }
        if(i + 1 < n && maze[i + 1][j] == 0 && res[i + 1][j] == 0){
            res[i + 1][j] = 1;
            checkMaze(maze , res , i + 1 , j , n);
            res[i + 1][j] = 0;
        }
        if(j + 1 < n && maze[i][j + 1] == 0 && res[i][j + 1] == 0){
            res[i][j + 1] = 1;
            checkMaze(maze , res , i , j + 1 , n);
            res[i][j + 1] = 0;
        }
        if(i - 1 >= 0 && maze[i - 1][j] == 0 && res[i - 1][j] == 0 ){
            res[i - 1][j] = 1;
            checkMaze(maze , res , i - 1, j , n);
            res[i - 1][j] = 0;
        }
        if(j - 1 >= 0 && maze[i][j - 1] == 0 && res[i][j - 1] == 0){
            res[i][j - 1] = 1;
            checkMaze(maze , res , i ,  j - 1 , n);
            res[i][j - 1] = 0;
        }
    }
}