import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] edges = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++)
            edges[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            edges[S].add(E);
            edges[E].add(S);
        }

        for (int i = 0; i <= N; i++)
            Collections.sort(edges[i]);

        int order = 1;

        int[] ans = new int[N + 1];

        boolean[] visited = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(R);
        visited[R] = true;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            ans[cur] = order++;

            for (int next : edges[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (ans[i] == 0)
                sb.append(0 + "\n");
            else
                sb.append(ans[i] + "\n");
        }
        System.out.println(sb);
    }
}