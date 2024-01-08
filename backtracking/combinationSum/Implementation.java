package combinationSum;

import java.util.ArrayList;

public class Implementation {
    public static void main(String[] args) {
        int target = 7;
        int[] arr = {2 , 3 ,5 ,7};
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        combinationSum(target , arr , 0 , arr.length , new ArrayList<>() , 0 ,list);
        for(ArrayList<Integer> res : list){
            System.out.println(res);
        }
    }
    static void combinationSum(int target, int[] arr , int index , int len , ArrayList<Integer> al , int sum , ArrayList<ArrayList<Integer>> res){
        if(target == sum) {
            res.add(new ArrayList<>(al));
            return;
        }
        if(index >= len || sum > target){
            return;
        }
        sum += arr[index];
        al.add(arr[index]);
        combinationSum(target, arr, index , len, al, sum, res);
        al.removeLast();
        sum -= arr[index];
        combinationSum(target , arr , index + 1 , len , al , sum, res);
    }
}
