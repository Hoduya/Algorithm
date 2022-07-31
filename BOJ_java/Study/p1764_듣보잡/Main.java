package Study.p1764_듣보잡;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] Ns = new String[N];
        String[] Ms = new String[M];
        for(int i = 0; i < N; i++) Ns[i] = br.readLine();
        for(int i = 0; i < M; i++) Ms[i] = br.readLine();

        HashSet<String> nameSet = new HashSet<>();
        ArrayList<String> Unknowns = new ArrayList<>();
        // 듣도 못한 사람이 더많으면
        if(N >= M){
            for(String name : Ms){
                nameSet.add(name);
            }
            for(String findName : Ns){
                if(nameSet.contains(findName)){
                    Unknowns.add(findName);
                }
            }
        }
        // 보도 못한 사람이 더많으면
        else {
            for(String name : Ns){
                nameSet.add(name);
            }
            for(String findName : Ms){
                if(nameSet.contains(findName)){
                    Unknowns.add(findName);
                }
            }
        }
        Collections.sort(Unknowns);

        StringBuilder sb = new StringBuilder();
        sb.append(Unknowns.size() + "\n");
        for(String name : Unknowns){
            sb.append(name + "\n");
        }
        System.out.println(sb);
    }
}
