package Study;// compare 메소드는 양의 정수, 0, 음의 정수 중 하나를 반환하며
// 양의 정수일 경우만 두 객체의 위치를 바꿔주는 역할
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class p10814_나이순정렬 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Customer[] cList = new Customer[N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            int order = i;

            cList[i] = new Customer(age, name, order);
        }

        Arrays.sort(cList, new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) {
                if(o1.age == o2.age){
                    return o1.order - o2.order;
                }else{
                    return o1.age - o2.age;
                }
            }
        });

        for(int i = 0; i < N; i++){
            sb.append(cList[i].age + " " + cList[i].name).append("\n");
        }
        System.out.println(sb);
    }
}

class Customer{
    public int age;
    public String name;
    public int order;

    public Customer(int age, String name, int order){
        this.age = age;
        this.name = name;
        this.order = order;
    }
}