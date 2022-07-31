package TEST;

public class 순열과조합 {
    static boolean[] visited;
    static char[] list;
    static char[] resultList;
    static int R = 2;
    public static void main(String[] args){
        list = new char[]{'A', 'B', 'C', 'D'};
        resultList = new char[R];

        visited = new boolean[list.length];
        //permutation(0);

      combination(0, 0);
    }

    public static void permutation(int idx){
        if(idx == R){
            System.out.println(resultList);
            return;
        }
        for(int i = 0; i < list.length; i++){
            if(!visited[i]) {
                resultList[idx] = list[i];
                visited[i] = true;
                permutation(idx + 1);
                visited[i] = false;
            }
        }
    }

    public static void combination(int idx, int start){
        if(idx == R){
            System.out.println(resultList);
            return;
        }
        for(int i = start; i < list.length; i++){
            resultList[idx] = list[i];
            combination(idx + 1, i + 1);
        }
    }
}

