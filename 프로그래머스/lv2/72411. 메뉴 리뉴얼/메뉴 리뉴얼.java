import java.util.*;
import java.io.*;

class Solution {
    static char[] arr;
    static char[] charArr;
    static int maxCnt, sList, eList;
    static ArrayList<String> ans = new ArrayList<>();
    static ArrayList<char[]> subList = new ArrayList<>();
    
    public String[] solution(String[] orders, int[] course) {
        String[] answer;
        TreeSet<Character> set = new TreeSet<>();
        for (String order : orders){
            for (int i = 0; i < order.length(); i++)
                set.add(order.charAt(i));
        }
        // System.out.println(set.toString());
        
        int N = set.size();
        charArr = new char[N];
        int idx = 0;
        ArrayList<String> res = new ArrayList<>();
        for (char s : set) charArr[idx++] = s;
        // Arrays.sort(course);
        sList = 0;
        eList = 0;
        for (int K : course){
            ans.clear();
            arr = new char[K];
            maxCnt = 2;
            if (subList.size() == 0) combination(N, K, 0, 0, orders);
            else {
                eList = subList.size();
                for (int n = sList; n < eList; n++){
                    char[] temp = subList.get(n);
                    for (int i = 0; i < temp.length; i++)
                        arr[i] = temp[i];
                    int k = 0;
                    for (int i = 0; i < charArr.length; i++){
                        if (charArr[i] == arr[temp.length-1]){
                            k = i;
                            break;
                        }
                    }
                    combination(N, K, temp.length, k+1, orders);
                } 
                sList = eList;
            }
            // combination(N, K, 0, 0, orders);
            for (String a : ans) res.add(a);
        }
        answer = new String[res.size()];
        Collections.sort(res);
        for (int i = 0; i < res.size(); i++){
            answer[i] = res.get(i);
        }
        return answer;
    }
    
    private static void combination(int N, int K, int idx, int k, String[] orders){
        if (idx == K){
            int cnt = 0;
            for (int i = 0; i < orders.length; i++){
                int idx2 = 0;
                int flag = 0;
                for (char a : arr){
                    if (orders[i].contains(String.valueOf(a))) flag++;
                }
                if (flag == K) cnt++;
            }
            if (cnt >= 2) subList.add(Arrays.copyOfRange(arr, 0, K));
            if (cnt < maxCnt) return;
            if (cnt > maxCnt) {
                maxCnt = cnt;
                ans.clear();
            } 
            String temp = "";
            for (char a : arr) temp += a;
            ans.add(temp);
            
            return;
        }
        
        for (int i = k; i < N; i++){
            arr[idx] = charArr[i];
            combination(N, K, idx+1, i+1, orders);
            
        }
    }
}