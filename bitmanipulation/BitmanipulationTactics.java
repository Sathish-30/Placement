import java.util.ArrayList;
import java.util.Scanner;

class BitmanipulationTactics{
   // The Below following problem are of solving problem using XOR 


   // Find unique element from multiple occurence
   public void uniqueElement(){
      int[] arr = {2 , 1, 2 , 5, 6 ,5, 7 , 7,6};
      int unique = 0;
      for(int e : arr){
         unique ^= e;
      }
      System.out.println(unique);
   }

   public void swap(int a ,int b){
      System.out.printf("Before Swap , A : %d and B : %d \n" , a, b);
      a = a ^ b;
      // a will become a ^ b
      b = a ^ b;
      // b will be (a ^ b) ^ b , where b and b will get eliminated and result in a
      a = a ^ b;
      // a will be (a ^ b) ^ a , where a and a will get eliminated and result in b
      System.out.printf("After Swap , A : %d and B : %d \n" , a, b);
   }

   public int xorNum(int n){
      if(n % 4 == 0){
         return n;
      }else if(n % 4 == 1){
         return 1;
      }else if(n % 4 == 2){
         return n + 1;
      }else if(n % 4 == 3){
         return 0;
      }else{
         return -1;
      }
   }

   public void xorRange(int l , int r){
      System.out.println((xorNum(r)) ^ (xorNum(l - 1)));
   }

   // The below following codes are solved using & operator

   public void checkOddOrEven(int n){
      if((n & 1) == 1){
         System.out.printf("Given number %d is Odd number\n",n);
      }else{
         System.out.printf("Given number %d is Even number\n",n);
      }
   }

   // Create a mask value and check with n , if it is not zero then it is a set bit else it is not a set bit

   public void checkiThPositionIsSet(int n , int i){
      int mask = 1 << i;
      System.out.println((n & mask) != 0 ? "ith bit is set" : "ith bit is not a set");
   }

   // To check the ith position is set bit or not , by using >> operator to n and applying & 1 to check if it is set bit or not 
   public void checkiThPositionIsSetWithoutMask(int n , int i){

      System.out.println(((n >> i) & 1) == 1 ? "ith bit is set" : "ith bit is not a set");
      System.out.println(n);
   }

   // Create a mask value and check if the resultant is not a zero , if not the value of the ith bit is 1 or 0
   public void printiThPositionElement(int n , int i){
      int mask = 1 << i;
      System.out.println((n & mask) != 0 ? 1 : 0);
   }

   // Do Or operation to add the mask value to the n
   public void makeiThBitAsOne(int n , int i){
      int mask = 1 << i;
      n = n | mask;
      System.out.println(n);
   }
   

   // Create a mask with ith element and create a negation of it and do a & n to clear the ith bit
   public void setTheSetBitAsZero(int n , int i){
      int mask = 1 << i;
      System.out.println("The mask value is : "+mask);
      mask = ~mask;
      System.out.println("The negation value of mask value is : "+mask);
      System.out.println(n & mask);
   }

   public void clearLastSetBit(int n){
      System.out.println(n & (n -1));
   }

   public void checkNisPowerOfTwo(int n){
      System.out.println((n & (n - 1)) == 0 ? "Yes it is a power of 2" : "It is not a power of 2");
   }

   // the TC is O(position of MSB[most significant bit])
   public void countSetBits(int n){
      int count = 0;
      while(n > 0){
         if((n & 1) == 1){
            count++;
         }
         n >>= 1;
      }
      System.out.println(count);
   }

   public void countSetBitsByClearingTheSetBit(int n){
      int count = 0;
      while(n != 0){
         n = (n & (n - 1));
         count++;
      }
      System.out.println(count);
   }

   // O(N)
   public void printTwoUniqueNumber(){
      int[] arr = {1 ,1 , 2 , 5, 3 ,2,3,4,7,4 };
      int xor = 0;
      for(int e : arr){
         xor ^= e;
      }
      int count = 0;
      // TO set the last set bit
      while(xor != 0){
         if((xor & 1) == 1){
            break;
         }
         count++;
         xor >>= 1;
      }
      int mask = 1 << count;
      int xor1 = 0 , xor2 = 0;
      for(int e : arr){
         // check if ith bit is set or not , if set xor with xor1 else xor with xor2 
         if((e & mask) != 0){
            xor1 ^= e;
         }else{
            xor2 ^= e;
         }
      }
      System.out.println(xor1+" "+xor2);
   }

   // Powerset algorithm
   public void subSet(){
      int[] arr = {2,3 ,4};
      int len = arr.length;
      for(int i = 0 ; i < (1 << len); i++){
         ArrayList<Integer> al = new ArrayList<>();
         for(int j = 0 ; j < len ; j++){
            if((i & (1 << j)) !=  0){
               al.add(arr[j]);
            }
         }
         System.out.println(al);
      }
   }

   // Powerset algorithm for petr combination lock
   public void petrCombinationLock(){
      Scanner in = new Scanner(System.in);
      int[] arr  = new int[3];
      int n = arr.length;
      boolean flag = false;
      for(int i = 0 ; i < n ; i++){
         arr[i] = in.nextInt();
      }
      for(int i = 0 ; i < (1 << n) ; i++){
         ArrayList<Integer> al = new ArrayList<>();
         for(int j = 0 ; j < n ; j++){
            if((i & (1 << j)) != 0){
               al.add(arr[j]);
            }else{
               al.add(-1 * arr[j]);
            }
         }
         int sum = 0;
         for(int e : al){
            sum += e;
         }  
         if(sum % 360 == 0 || sum == 0){
            flag = true;
            System.out.println("Yes");
            break;
         }
      }
      if(!flag){
         System.out.println("No");
      }
      in.close();
   }

   // Bit masking (Design a set data structure)
   // store unique elements and store in ascending order
   // add(x)
   // removal(x)
   // print all elements
   // 0 <= x <= 60
   // The bit masking uses long data type and store data in the each single bit
} 