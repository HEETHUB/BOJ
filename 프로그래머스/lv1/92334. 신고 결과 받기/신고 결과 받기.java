import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int size = id_list.length;
        int[] answer = new int[size];
        int[] arr = new int[size];
        HashMap<String, Integer> map = new HashMap<>();
        // System.out.println(1);
        for (int i = 0; i < size; i++){
            map.put(id_list[i], i);
        }
        // System.out.println(map.toString());
        HashSet<Integer>[] list = new HashSet[size];
        HashSet<Integer>[] list2 = new HashSet[size];
        for (int i = 0; i < size; i++){
            list[i] = new HashSet<>();
            list2[i] = new HashSet<>();
        }
        for (String re : report) {
            StringTokenizer st = new StringTokenizer(re, " ");
            String s = st.nextToken();
            String e = st.nextToken();
            if (!list[map.get(s)].contains(map.get(e)))
                arr[map.get(e)]++;
            list[map.get(s)].add(map.get(e));
            list2[map.get(e)].add(map.get(s));
        }
        for (int i = 0; i < size; i++){
            if (arr[i] >= k){
                for (int l : list2[i])
                    answer[l]++;
            }
        }
        return answer;
    }
}