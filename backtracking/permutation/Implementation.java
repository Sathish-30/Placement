package permutation;

import java.util.ArrayList;
import java.util.List;


public class Implementation {
    public static void main(String[] args) {
        int[] arr = {1 , 2 , 3};
        List<List<Integer>> res = new ArrayList<>();
        permutation2(arr , 0 , res);
        for(List<Integer> e : res){
            System.out.println(e);
        }
    }

    private static void permutation1(int[] arr, int index, int length, boolean[] freq, ArrayList<Integer> al) {
        if(al.size() == arr.length){
            System.out.println(al);
            return;
        }
        for(int i = 0 ; i < arr.length ; i++){
            if(!freq[i]){
                freq[i] = true;
                al.add(arr[i]);
                permutation1(arr , index , length , freq , al);
                al.removeLast();
                freq[i] = false;
            }
        }
    }

    private static void permutation2(int[] arr , int index , List<List<Integer>> res){
        if(index == arr.length){
            List<Integer> al = new ArrayList<>();
            for(int e : arr){
                al.add(e);
            }
            res.add(new ArrayList<>(al));
        }
        for(int i = index ; i < arr.length ; i++){
            swap(arr , index , i);
            permutation2(arr , index + 1, res);
            swap(arr , index , i);
        }
    }

    private static void swap(int[] arr , int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
