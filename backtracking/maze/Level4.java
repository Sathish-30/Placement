package maze;

import java.util.*;

public class Level4{
    public static int[][] re;
    public static int min = Integer.MAX_VALUE;
    public static boolean status = false;
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int start = in.nextInt();
        int end = in.nextInt();
        int[][] maze = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                maze[i][j] = in.nextInt();
            }
        }
        int[][] res = new int[n][n];
        res[start][end] = 1;
        checkMaze(maze , res , start , end , n , 1);
        if(!status){
            System.out.println("No solution exists");
        }else{
            System.out.println("Minimum Steps: "+min);
            for(int[] r : re){
                for(int e : r){
                    System.out.print(e+" ");
                }
                System.out.println();
            }
        }
    }
    static void checkMaze(int[][] maze , int[][] res , int i , int j , int n , int c){
        if((i == n - 1 && j == n - 1) || (i == 0 && j == 0) || (i == 0 && j == n - 1) || (i == n - 1 && j == 0) ){
            status = true;
            if(c < min){
                min = c;
                re = new int[n][n];
                for(int x = 0 ; x < n ; x++){
                    for(int y = 0 ; y < n ; y++){
                        re[x][y] = res[x][y];
                    }
                }
            }
            return;
        }
        if(i + 1 < n && maze[i + 1][j] == 0 && res[i + 1][j] == 0){
            res[i + 1][j] = 1;
            c++;
            checkMaze(maze , res , i + 1 , j , n , c);
            c--;
            res[i + 1][j] = 0;
        }
        if(j + 1 < n && maze[i][j + 1] == 0 && res[i][j + 1] == 0){
            res[i][j + 1] = 1;
            c++;
            checkMaze(maze , res , i , j + 1 , n , c);
            c--;
            res[i][j + 1] = 0;
        }
        if(i - 1 >= 0 && maze[i - 1][j] == 0 && res[i - 1][j] == 0 ){
            res[i - 1][j] = 1;
            c++;
            checkMaze(maze , res , i - 1, j , n , c);
            c--;
            res[i - 1][j] = 0;
        }
        if(j - 1 >= 0 && maze[i][j - 1] == 0 && res[i][j - 1] == 0){
            res[i][j - 1] = 1;
            c++;
            checkMaze(maze , res , i ,  j - 1 , n , c);
            c--;
            res[i][j - 1] = 0;
        }
    }
}