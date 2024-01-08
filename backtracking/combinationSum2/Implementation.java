package combinationSum2;
//Given a collection of candidate numbers (candidates) and a target number (target)
//find all unique combinations in candidates where the candidate numbers sum to target.
//Each number in candidates may only be used once in the combination.
import java.util.*;
public class Implementation {
    public static void main(String[] args) {
        int[] candidates = {10 , 1 , 2 , 7 , 6 , 1 ,5};
        int target = 8;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        // System.out.print(Arrays.toString(candidates));
        combinationSum(0 , candidates , new ArrayList<>() , res , target);
        for(List<Integer> e : res){
            System.out.println(e);
        }
    }
    static void combinationSum(int ind , int[] arr , List<Integer> ds , List<List<Integer>> res , int target){
        if(target == 0){
            res.add(new ArrayList<>(ds));
            return;
        }
        for(int i = ind ; i < arr.length ; i++){
            if(i != ind && arr[i] == arr[i - 1]) continue;
            if(arr[i] > target) break;
            ds.add(arr[i]);
            combinationSum(i + 1 , arr , ds , res , target - arr[i]);
            ds.removeLast();
        }
    }
}
