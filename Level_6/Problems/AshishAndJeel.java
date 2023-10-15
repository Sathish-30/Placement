import java.util.*;

public class AshishAndJeel{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while((t--) != 0){
            int c = 0;
            int n = in.nextInt();
            int[] arr = new int[n + 1];
            for(int i = 1 ; i <= n ; i++){
                arr[i] = in.nextInt();
            }
            long[] pref = new long[n + 1];
            long[] suf = new long[n + 2];
            for (int i = 1;i <= n;i++){
              pref[i] = Math.max(pref[i - 1], arr[i]);
            }
            suf[(n + 1)] = Integer.MAX_VALUE;
            for (int i = n;i >= 1;i--)
            {
              suf[i] = Math.min(suf[(i + 1)], arr[i]);
            }
            for (int i = 1;i <= n - 1;i++)
            {
              if (pref[i] < suf[(i + 1)])
              {
                c++;
              }
            }
            if ((c % 2) != 0){
              System.out.println("Jeel");
            }else{
              System.out.println("Ashish");
            }
        }
    }
}