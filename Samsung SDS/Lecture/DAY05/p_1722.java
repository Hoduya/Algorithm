package Lecture.DAY05;

public class p_1722 {
    public static void main(String[] args){
        A a = new A();
        B b = new B();
        A ab = new B();




    }
}

class A{
    int a;

    public void Afunc(){
        System.out.println("Hello");
    }
}

class B extends A{
    int b;

    public void Afunc(){
        System.out.println("im B");
    }

    public void Bfunc(){
        System.out.println("BFunc");
    }
}
