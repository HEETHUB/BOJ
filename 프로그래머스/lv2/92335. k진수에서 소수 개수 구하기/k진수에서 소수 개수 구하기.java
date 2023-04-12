import java.util.*;
import java.io.*;

class Solution {
    static int max = 0;
    static boolean[] arr;
    public int solution(int n, int k) {
        int answer = 0;
        String Kary = toKary(n, k);
        ArrayList<Long> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(Kary, "0");
        while (st.hasMoreTokens()){
            if (checkPrime(Long.parseLong(st.nextToken())))
                answer++;
            }
        return answer;
    }
    
    public static String toKary(int n, int k){
        String ans = "";
        int div = k;
        while (n >= 1){
            ans += String.valueOf(n%k);
            n /= k;
        }
        String res = "";
        for (int i = ans.length()-1; i >= 0; i--)
            res += ans.charAt(i);
        return res;
    }
    
    public static boolean checkPrime(long num){
        if (num == 1) return false;
        if (num == 2) return true;
        for (int i = 2; i <= Math.sqrt(num); i++){
            if (num % i == 0) return false;
        }
        return true;
    }
}