import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedHashSet;
public class Main{
   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      System.out.print("Enter the String : ");
      String str = in.next();
      String[] arr = str.split("");
      ArrayList<String> al = new ArrayList<>();
      for(String e : arr){
         al.add(e);
      }
      LinkedHashSet<ArrayList<String>> set = new LinkedHashSet<>();
      permuteForDuplicateArray(0, al, set, al.size());
      for(ArrayList<String> e : set){
         System.out.println(e);
      }
      // System.out.println(Arrays.toString(arr));
      // ArrayList<String> al = new ArrayList<>();
      // ArrayList<String> list = new ArrayList<>();
      // int n = arr.length;
      // boolean[] freq = new boolean[n];
      // permuteApproachOne(arr , n , al , list , freq);
      // for(String e : list){
      //    System.out.println(e);
      // }
   }

   // The below approach require a additional data structure to store the answer and a freq array to check if it is taken or not
   static void permuteApproachOne(String[] arr , int len , ArrayList<String> al , ArrayList<String> list , boolean[] freq){
      if(al.size() == len){
         StringBuilder sb = new StringBuilder();
         for(String e : al){
            sb.append(e);
         }
         list.add(sb.toString());
         return;
      }
      for(int i = 0 ; i < len ; i++){
         if(!freq[i]){
            freq[i] = true;
            al.add(arr[i]);
            permuteApproachOne(arr, len, al, list, freq);
            al.remove(al.size() - 1);
            freq[i] = false;
         }
      }
   }

   static void permuteApproachTwo(int start , String[] arr){
      if(start == arr.length){
         for(String e : arr){
            System.out.print(e);
         }
         System.out.println();
         return;
      }
      for(int i = start ; i < arr.length ; i++){
         swap(i , start , arr);
         permuteApproachTwo( start + 1 , arr);
         swap(i , start , arr);
      }
   }
   static void swap(int i , int j , String[] arr){
      String temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
   }

   static void permuteForDuplicateArray(int start , ArrayList<String> arr , LinkedHashSet<ArrayList<String>> list , int len){
      if(start == len){
         //System.out.println(arr);
         list.add(new ArrayList<>(arr));
         return;
      }
      for(int i = start ; i < len ; i++){
         swap(i , start , arr);
         permuteForDuplicateArray(start + 1, arr, list, len);
         swap(i , start , arr);
      }
   }

   static void swap(int i , int j , ArrayList<String> arr){
      String temp = arr.get(i);
      arr.set(i, arr.get(j));
      arr.set(j , temp);
   }
}