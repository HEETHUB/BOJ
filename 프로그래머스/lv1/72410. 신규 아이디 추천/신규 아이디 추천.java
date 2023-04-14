class Solution {
    public String solution(String new_id) {
        String answer = "";
        int size = new_id.length();
        new_id = new_id.toLowerCase();
        for (int i = 0; i < new_id.length(); i++){
            if (Character.isDigit(new_id.charAt(i)) || new_id.charAt(i) == '-' || new_id.charAt(i) == '_' ||
                new_id.charAt(i) == '.' || (new_id.charAt(i) >= 'a' && new_id.charAt(i) <= 'z'))
                answer += new_id.charAt(i);
        }
        String temp = answer;
        answer = "";
        int idx = 0;
        while (idx < temp.length()){
            if (idx > 0 && temp.charAt(idx) == '.' && temp.charAt(idx-1) == '.') idx++;
            else answer += temp.charAt(idx++);
        }
        temp = answer;
        answer = "";
        for (int i = 0; i < temp.length(); i++){
            if (temp.charAt(i) == '.' && (i == 0 || i == temp.length()-1)) continue;
            answer += temp.charAt(i);
        }
        if (answer == "") answer = "a";
        temp = answer;
        answer = "";
        for (int i = 0; i < Math.min(temp.length(), 15); i++){
            if (i == 14 && temp.charAt(i) == '.') continue;
            answer += temp.charAt(i);
        }
        if (answer.length() <= 2) {
            while (answer.length() <= 2) answer += answer.charAt(answer.length()-1);
        }
       
        return answer;
    }
}