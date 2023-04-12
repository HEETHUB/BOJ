import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        // int[] answer = {};
        int recSize = records.length;
        int max = 0;
        HashMap<Integer, ArrayList<String>> map = new HashMap<>();
        for (int i = 0; i < recSize; i++){
            // System.out.println(records[i]);
            StringTokenizer st = new StringTokenizer(records[i]);
            String time = st.nextToken();
            int carNum = Integer.parseInt(st.nextToken());
            String op = st.nextToken();
            max = Math.max(max, carNum);
            if (map.containsKey(carNum)){
                ArrayList<String> temp = map.get(carNum);
                temp.add(time);
                map.put(carNum, temp);
            } else{
                ArrayList<String> temp = new ArrayList<>();
                temp.add(time);
                map.put(carNum, temp);
            }
        }
        
        int[] arr = new int[max+1];
        Arrays.fill(arr, -1);
        
        for (int key : map.keySet()){
            ArrayList<String> temp = map.get(key);
            if (temp.size()%2 == 1){
                temp.add("23:59");  
            } 
            String start = "";
            String end = "";
            for (int i = 0; i < temp.size(); i++){
                if (i % 2 == 0) start = temp.get(i);
                else {
                    end = temp.get(i);
                    if (arr[key] < 0) arr[key] = 0;
                    arr[key] += getTime(start, end);
                }
            }
        }
        int size = 0;
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i <= max; i++){
            if (arr[i] >= 0) {
                int temp = fees[1] + fees[3]*(Math.max(0, (arr[i]-fees[0]))/fees[2]);
                if ((arr[i]-fees[0])%fees[2] > 0) temp += fees[3];
                res.add(temp);
            }
        }
        int[] answer = new int[res.size()];
        for (int i = 0; i < res.size(); i++)
            answer[i] = res.get(i);
        return answer;
    }
    
    public int getTime(String start, String end){
        StringTokenizer S = new StringTokenizer(start, ":");
        int sH = Integer.parseInt(S.nextToken());
        int sM = Integer.parseInt(S.nextToken());
        StringTokenizer E = new StringTokenizer(end, ":");
        int eH = Integer.parseInt(E.nextToken());
        int eM = Integer.parseInt(E.nextToken());
        int ans = 0;
        ans += (eH-sH)*60 + (eM-sM);
        return ans;
    }
}