package SDS_Lecture.DAY03;

import java.io.*;
import java.util.*;

public class p1202_보석도둑 {
    static Jewel[] jewel;
    static int[] bag;
    static PriorityQueue<Integer> pq;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("BOJ_java/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        jewel = new Jewel[N];
        bag = new int[K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            jewel[i] = new Jewel(weight, price);
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            bag[i] = Integer.parseInt(st.nextToken());
        }

        // 가방 허용무게 오름차순 정렬
        Arrays.sort(bag);

        // 보석 무게 기준 오름차순 정렬
        Arrays.sort(jewel, new Comparator<Jewel>() {
            @Override
            public int compare(Jewel o1, Jewel o2) {
                return o1.weight - o2.weight;
            }
        });

        // 최대가격을 찾기 위한 힙
        pq = new PriorityQueue<>(Collections.reverseOrder());

        int total = 0;
        int ptBag = 0;
        int ptJewel = 0;

        for (int i = 0; i < bag.length; i++) {
                while(ptJewel < N && jewel[ptJewel].weight <= bag[i]){
                    pq.add(jewel[ptJewel].price);
                    ptJewel++;
                }
                if(!pq.isEmpty()){
                    total += pq.poll();
                }
        }
//        while(true){
//            // 보석을 가방에 담을 수 있으면
//            //  힙에 넣고 다음 보석
//            if(bag[ptBag] >= jewel[ptJewel].weight){
//                pq.add(jewel[ptJewel].price);
//                ptJewel += 1;
//            }
//            // 가방에 넣을 수 없다면
//            //  힙에서 최대 가격 저장하고 다음 가방
//            else {
//                if(!pq.isEmpty()){
//                    total += pq.remove();
//                }
//                ptBag += 1;
//            }
//
//            // 보석이 끝나면
//            if(ptJewel == N){
//                if(!pq.isEmpty()){
//                    total += pq.remove();
//                }
//                break;
//            }
//
//            // 가방이 더 이상 없으면
//            if(ptBag == K){
//                break;
//            }
//        }
        System.out.println(total);
    }

    static class Jewel{
        int weight;
        int price;

        public Jewel(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }
    }
}
