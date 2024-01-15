package chessboard.knight;

import java.util.*;

public class Implementation{
    public static int[] pathRow = {2 , 1 , -1, -2 , -2 , -1, 1 , 2};
    public static int[] pathCol = {1 , 2 , 2 ,1 , -1 , -2 , -2 , -1};
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        char[][] b = new char[8][8];
        int[][] board = new int[8][8];
        for(int i = 0 ; i < 8 ; i++){
            Arrays.fill(board[i] , -1);
        }
        int ind = 0;
        while(in.hasNext()){
            b[ind++] = in.nextLine().replaceAll("[a-z]: ","").replaceAll(",","").toCharArray();
        }
        int sRow = 0 , sCol = 0 , dRow = 0 , dCol = 0;
        for(int i = 0 ; i < 8 ; i++){
            for(int j = 0 ; j < 8 ; j++){
                if(b[i][j] == 'S'){
                    sRow = i;
                    sCol = j;
                }
            }
        }
        board[sRow][sCol] = 0;
        for(int i = 0 ; i < 8 ; i++){
            for(int j = 0 ; j < 8 ; j++){
                if(b[i][j] == 'X'){
                    dRow = i;
                    dCol = j;
                }
            }
        }
        for(int i = 0 ; i < 8 ; i++){
            for(int j = 0 ; j < 8 ; j++){
                if(b[i][j] == '1'){
                    board[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        // for(int[] e : board){
        //     System.out.println(Arrays.toString(e));
        // }
        minToReachDes(board , sRow , sCol , dRow , dCol);
        System.out.print(board[dRow][dCol] == -1 ? "NO" : "YES");
    }
    static void minToReachDes(int[][] board , int row , int col , int dRow , int dCol){
        if(row == dRow && col == dCol){
            return;
        }
        for(int i = 0 ; i < pathRow.length ; i++){
            int nRow = row + pathRow[i];
            int nCol = col + pathCol[i];
            if ((nRow >= 0  && nRow < 8) && (nCol >= 0 && nCol < 8) && board[nRow][nCol] != Integer.MAX_VALUE && (board[nRow][nCol] > board[row][col] + 1 || board[nRow][nCol] == -1)){
                board[nRow][nCol] = board[row][col] + 1;
                minToReachDes(board , nRow , nCol ,  dRow , dCol);
            }
        }
    }
}