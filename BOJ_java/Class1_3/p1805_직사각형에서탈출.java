package Class1_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1805_직사각형에서탈출 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int distX = 0;
        int distY = 0;

        if(x <= (w / 2)) distX = x;
        else distX = (w - x);

        if(y <= (h / 2)) distY = y;
        else distY = (h - y);

        System.out.println(Math.min(distX, distY));
    }
}