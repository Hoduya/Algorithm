package SDS_Lecture.DAY03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class p1927_최소힙 {
    static List<Integer> heap;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("BOJ_java/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        heap = new ArrayList<Integer>();
        heap.add(0);
        heap.add(heap.size(), 1);
        insert(2);
        insert(1);
        System.out.println(heap);

//        for(int i = 0; i < N; i++){
//            int num = Integer.parseInt(br.readLine());
//
//            // 최소값 삭제 후 출력
//            if(num == 0){
//                // 힙 비어있는 경우
//                if(heap.size() == 1){
//                    System.out.println(0);
//                } else {
//
//                }
//            }
//            // 삽입
//            else{
//
//            }
//        }
    }

    static void insert(int num){
        // leaf 에 삽입
        heap.add(num);
        int childIdx = heap.size() - 1;
        int parentIdx = childIdx / 2;
        while(childIdx != 1){
            if(heap.get(childIdx) < heap.get(parentIdx)){
                swap(childIdx, parentIdx);
                childIdx = parentIdx;
                parentIdx = childIdx / 2;
            } else{
                break;
            }
        }
    }

    static int delete(){
        if(heap.size() == 1){
            return 0;
        }

        int top = heap.get(1);
        heap.set(1, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);

        int currentPos = 1; //root 부터
        while(true){
            int leftChild = currentPos * 2;
            int rightChild = currentPos * 2 + 1;
            // 왼쪽 자식 먼저 확인
            if(leftChild >= heap.size()){ // 왼쪽 자식 없음
                break;
            }

            int minValue = heap.get(leftChild);
            int minPos = leftChild;

            if(rightChild < heap.size() && minValue > heap.get(rightChild)){
                minValue = heap.get(rightChild);
                minPos = rightChild;
            }

            if(heap.get(currentPos) > minValue){
                swap(currentPos, minPos);
                currentPos = minPos;
            }
        }

        return top;
    }

    static void swap(int idx1, int idx2){
        int temp = heap.get(idx1);
        heap.set(idx1, heap.get(idx2));
        heap.set(idx2, temp);
    }
}
