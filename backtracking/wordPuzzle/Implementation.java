package wordPuzzle;

public class Implementation {
    public static boolean status = false;
    public static void main(String[] args) {
        char[][] board = {
                {'C','A','A'},
                {'A','A','A'},
                {'B','C','D'}};
        String word = "AAB";
        int row = board.length , col = board[0].length;
        for(int i = 0 ; i < row ; i++){
            for (int j = 0; j < col; j++) {
                if(board[i][j] == word.charAt(0)){
                    boolean[][] vis = new boolean[row][col];
                    vis[i][j] = true;
                    StringBuilder sb = new StringBuilder();
                    sb.append(word.charAt(0));
                    checkWord(board , word , i , j , row , col , vis , sb , 1);
                }
            }
        }
    }

    private static void checkWord(char[][] board, String word, int i, int j, int row, int col, boolean[][] vis, StringBuilder sb, int ind) {
        if(sb.toString().equals(word)){
            System.out.println(sb.toString());
            status = true;
            return;
        }
        if(sb.toString().length() > word.length()){
            return;
        }
        if(ind >= word.length()){
//            System.out.println(sb.toString());
            return;
        }
        if(i + 1 < row && j < col && !vis[i + 1][j] && word.charAt(ind) == board[i + 1][j]){
            vis[i + 1][j] = true;
            sb.append(word.charAt(ind));
            System.out.println(sb.toString());
            checkWord(board , word , i + 1 , j , row , col , vis ,  sb, ind + 1);
            vis[i + 1][j]=false;
            sb.deleteCharAt(sb.length() - 1);
        }
        if(i < row && j + 1 < col && !vis[i][j + 1] && word.charAt(ind) == board[i][j + 1]){
            vis[i][j + 1] = true;
            sb.append(word.charAt(ind));
            System.out.println(sb.toString());
            checkWord(board , word , i , j + 1, row , col , vis , sb , ind + 1);
            vis[i][j + 1]=false;
            sb.deleteCharAt(sb.length() - 1);
        }
        if(i - 1 >= 0 && j < col && !vis[i - 1][j] && word.charAt(ind) == board[i - 1][j]){
            vis[i - 1][j] = true;
            sb.append(word.charAt(ind));
            System.out.println(sb.toString());
            checkWord(board , word , i - 1 , j , row , col , vis , sb , ind + 1);
            vis[i - 1][j]=false;
            sb.deleteCharAt(sb.length() - 1);
        }

        if(i < row && j - 1 >= 0 && !vis[i][j - 1] && word.charAt(ind) == board[i][j - 1]){
            vis[i][j - 1] = true;
            sb.append(word.charAt(ind));
            System.out.println(sb.toString());
            checkWord(board , word , i , j - 1 , row , col , vis , sb , ind + 1);
            vis[i][j - 1]=false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
