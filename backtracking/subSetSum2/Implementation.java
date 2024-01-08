package subSetSum2;

import java.util.ArrayList;
import java.util.List;

public class Implementation {
    public static void main(String[] args) {
        int[] arr = {1 , 2 ,2};
        List<List<Integer>> res = new ArrayList<>();
        findSubSet(arr , 0 , new ArrayList<>() , res);
        for(List<Integer> e : res){
            System.out.println(e);
        }
    }
    static void findSubSet(int[] arr , int index , ArrayList<Integer> al ,List<List<Integer>> res){
        res.add(new ArrayList<>(al));
        for(int i = index ; i < arr.length ; i++){
            if(i > index && arr[i] == arr[i - 1]) continue;
            al.add(arr[i]);
            findSubSet(arr , i + 1 , al , res);
            al.removeLast();
        }
    }
}
