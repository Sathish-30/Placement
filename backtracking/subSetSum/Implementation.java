package subSetSum;

import java.util.ArrayList;
import java.util.Collections;

public class Implementation {
    public static void main(String[] args) {
        int[] arr = {5 , 2 , 1};
        ArrayList<Integer> res = new ArrayList<>();
        subSetSum(arr , arr.length , 0 , new ArrayList<>() , res);
        Collections.sort(res);
        System.out.println(res);
    }
    static void subSetSum(int[] arr , int len , int ind , ArrayList<Integer> al , ArrayList<Integer> res){
        if(len == ind){
            int sum = 0;
            for(int e : al){
                sum += e;
            }
            res.add(sum);
            return;
        }
        al.add(arr[ind]);
        subSetSum(arr , len , ind + 1 , al , res);
        al.removeLast();
        subSetSum(arr , len , ind + 1 , al , res);
    }
}
