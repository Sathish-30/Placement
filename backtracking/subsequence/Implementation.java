package subsequence;

import java.util.ArrayList;

public class Implementation {
    public static void main(String[] args) {
        int[] arr = {1 , 2 ,3, 4 , 5};
        int arrLen = arr.length;
        combinationSum(arr , arrLen , 0 , 0, 15 , new ArrayList<>());
    }
    static void subsequence(int[] arr , int len , int index , ArrayList<Integer> al){
        if(index >= len){
            if(al.size() <= 2){
                System.out.println(al);
            }
            return;
        }
        al.add(arr[index]);
        subsequence(arr , len , index+1 , al);
        al.remove(Integer.valueOf(arr[index]));
        subsequence(arr , len , index + 1 , al);
    }
    static void combinationSum(int[] arr , int len , int index , int sum , int target , ArrayList<Integer> al){
        if(sum == target){
            System.out.println(al);
            return;
        }
        if(index >= len){
            return;
        }
        al.add(arr[index]);
        sum += arr[index];
        combinationSum(arr , len , index+1 , sum , target , al);
        al.remove(Integer.valueOf(arr[index]));
        sum -= arr[index];
        combinationSum(arr , len , index + 1 , sum , target , al);
    }
}
