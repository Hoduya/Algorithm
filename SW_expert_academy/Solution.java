import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;

class Solution
{
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        int H, W, N;
        H = sc.nextInt();
        W = sc.nextInt();
        N = sc.nextInt();
        sc.nextLine();

        int wordCnt = 0;
        int[] lengthArr = new int[N];
        String s = sc.nextLine();

        StringTokenizer str = new StringTokenizer(s, " ");

        while(str.hasMoreTokens()){
            lengthArr[wordCnt] = str.nextToken().length();
            wordCnt++;
        }


//        for(int t : lengthArr){
//            System.out.println(t);
//        }
    }
}