package az.edu.turing.algorithm;

public class ClimbingStairs {
    public static int climbStairs(int n) {
        //n=1->1
        //n=2 ->2
        //n=3 ->(1,1,1)(2,1)(1,2)=3
        //n=4  ->(1,1,1,1)(2,2)(1,2,1),(1,1,2)(2,1,1)=5;
        //n=5 -> (1,1,1,1,1)(1,1,1,2),(1,1,2,1),(1,2,1,1),(2,1,1,1),(2,2,1),(2,1,2)(1,2,2)=8;
        int[] arr = new int[n+1];
        arr[0]=1;
        arr[1]=1;
        if(n>=2){
            for(int i=2;i<=n;i++){
                arr[i] = arr[i-1]+arr[i-2];
            }
        }
        return arr[n];

    }


    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }
}
