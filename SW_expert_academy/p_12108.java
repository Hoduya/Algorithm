import java.util.Scanner;
import java.io.FileInputStream;

public class p_12108
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        int numStudent, numSet;

        for(int test_case = 1; test_case <= T; test_case++)
        {
            numStudent = sc.nextInt();

            numSet = numStudent / 3;
            System.out.println("#" + test_case + " " + numSet);
        }
    }
}
