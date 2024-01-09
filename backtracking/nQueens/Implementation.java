package nQueens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.List;
public class Implementation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // Board size n * n
        int n = in.nextInt();
        char[][] board = new char[n][n];
        for(int i = 0 ; i < n ; i++){
            Arrays.fill(board[i] , 'X');
        }
        List<List<String>> res = new ArrayList<>();
        solve(0 , board , res , n);
        for(List<String> e : res){
            for(String x : e){
                System.out.println(x+" ");
            }
            System.out.println();
        }
        // To get number of queens in the problem we need to return the result length
    }

    private static void solve(int col, char[][] board, List<List<String>> res, int n) {
        if(col == n){
            ArrayList<String> s = new ArrayList<>();
            for(char[] e : board){
                StringBuilder sb = new StringBuilder();
                sb.append(e);
                s.add(sb.toString());
            }
            res.add(s);
            return;
        }
        for(int row = 0 ; row < n ; row++){
            if(check(board, row , col , n)){
                board[row][col] = 'Q';
                solve(col + 1 , board , res , n);
                board[row][col] = 'X';
            }
        }
    }
    private static boolean check(char[][] board , int row , int col , int n){
        int dupRow = row;
        int dupCol = col;
        while(row >= 0 && col >= 0){
            if(board[row][col] == 'Q') return false;
            row--;
            col--;
        }
        row = dupRow;
        col = dupCol;
        while(col >= 0){
            if(board[row][col] == 'Q') return false;
            col--;
        }
        col = dupCol;
        while(row < n && col >= 0){
            if(board[row][col] == 'Q') return false;
            row++;
            col--;
        }
        return true;
    }
}
