package chessboard;
import java.util.*;

public class Implementation{
    public static int[] pathRow = {2 , 1 , -1, -2 , -2 , -1, 1 , 2};
    public static int[] pathCol = {1 , 2 , 2 ,1 , -1 , -2 , -2 , -1};
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[][] board = new int[8][8];
        for(int i = 0 ; i < 8 ; i++){
            Arrays.fill(board[i] , -1);
        }
        int sRow = in.nextInt() - 1;
        int eCol = in.nextInt() - 1;
        int dsRow = in.nextInt() - 1;
        int deCol = in.nextInt() - 1;
        board[sRow][eCol] = 0;
        minToReachDes(board , sRow , eCol , dsRow , deCol);
        System.out.println(board[dsRow][deCol]);
    }
    static void minToReachDes(int[][] board , int row , int col , int dRow , int dCol){
        if(row == dRow && col == dCol){
            return;
        }
        for(int i = 0 ; i < pathRow.length ; i++){
            int nRow = row + pathRow[i];
            int nCol = col + pathCol[i];
            if ((nRow >= 0  && nRow < 8) && (nCol >= 0 && nCol < 8) && (board[nRow][nCol] > board[row][col] + 1 || board[nRow][nCol] == -1)){
                board[nRow][nCol] = board[row][col] + 1;
                minToReachDes(board , nRow , nCol ,  dRow , dCol);
            }
        }
    }
}