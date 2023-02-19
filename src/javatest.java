//public class javatest {
//    public static void main(String[] args) {
//        char c1;
//        char c2 = '1';
//        int count = 0;
//        while(c1 < '9') {
//            c1 = c2 + 2; count += 1;
//        }
//        System.out.println(count);
//    }
//}

//public class javatest {
//    public static void main(String[] args) {
//        run1();
//        run2();
//        new javatest().run1();
//        new javatest().run2();
//    }
//
//    void run1() {
//        System.out.println("Hello 1");
//    }
//
//    void run2() {
//        System.out.println("Hello 2");
//    }
//}


//public class javatest{
//    public static void main(String[] args) {
//        int n1 = -4;
//        int n2 = n1 >> 1;
//        int n3 = n1 >>> 1;
//        System.out.printf("%x -> %d\n", n1, n1);
//        System.out.printf("%x -> %d\n", n2, n2);
//        System.out.printf("%x -> %d\n", n3, n3);
//    }
//}

//public class javatest{
//    public static void main(String[] args) {
//        Integer num1 = (Integer) 100;
//        Integer num2 = (Integer) 100;
//        Integer num3 = (Integer) 100;
//        Integer num4 = (Integer) 100;
//
//        if(num1 == num2)
//            System.out.println("num1==num2");
//        else System.out.println("num1!=num2");
//
//        if(num3 == num4)
//            System.out.println("num3==num4");
//        else System.out.println("num3!=num4");
//
//    }
//}

//class arrClass{
//    private int[] arrTest;
//    private String StringTest;
//    public arrClass(){
//        arrTest=new int[]{2020};
//        StringTest="Class";
//    }
//
//    public int[] getArrTest(){
//        return arrTest;
//    }
//
//    public String getStringTest(){
//        return StringTest;
//    }
//
//    public void printArr(){
//        System.out.println(arrTest[0]+" / "+StringTest);
//    }
//}
//
//public class javatest {
//    public static void main(String[] args)  {
//        arrClass ac = new arrClass();
//
//        int[] arr = ac.getArrTest();
//        String s= ac.getStringTest();
//        arr[0]=2021;
//        s="Main";
//
//        ac.printArr();
//    }
//}

//public class javatest{
//    public static void main(String[] args) {
//        Object[] objs = new Object[2];
//        objs[0] = "Hello";
//        objs[1] = 3; // auto boxing ->
//
//        for(int i=0;i<objs.length;i++) {
//            System.out.println(objs[i].getClass().getName()); // objs[3] 을 찍었을 때 java.lang.Integer
//        }
//    }
//}

//interface Aircon {
//    void makeCool();
//    default void dry(){
//        System.out.println("hi");
//    };
//}
//
//class OldisButGoodies1 implements Aircon {
//    @Override
//    public void makeCool() {
//        System.out.println("전체 냉각");
//    }
//}
//
//class OldisButGoodies2 implements Aircon {
//    @Override
//    public void makeCool() {
//        System.out.println("집중 냉각");
//    }
//}
//
//class NoWindAircon implements Aircon {
//    @Override
//    public void makeCool() {
//        System.out.println("바람 없이 시원하다");
//    }
//
//    @Override // default method 로 선언한 것도 재정의 가능
//    public void dry() {
//        System.out.println("종료시 자동 건조");
//    }
//}
//
//public class javatest {
//    public static void main(String[] args) {
//        Aircon[] aircons = {
//                new OldisButGoodies1(),
//                new OldisButGoodies2(),
//                new NoWindAircon()
//        };
//        for (Aircon aircon : aircons) {
//            aircon.makeCool();
//            aircon.dry();
//						/*
//							이후에 추가된 dry 메소드는 default method로 선언하면
//							바로 접근해서 dry() 도 사용가능
//						*/
//        }
//    }
//}

//interface MyInterface {
//    default void hi() {
//        System.out.println("hi");
//    }
//}
//
//class MySuperClass {
//    public void hi(){
//        System.out.println("super hi");
//    }
//}
//
//class MyClass extends MySuperClass implements MyInterface {
//
//}
//
//public class javatest {
//    public static void main(String[] args) {
//        MyClass my = new MyClass();
//        my.hi();
//        // super hi가 출력됨 -> class 가 가지고 있는 구체적인 메소드가 우선
//    }
// }

//interface MyInterface1 {
//    default void method() {
//        System.out.println("interface1 hi");
//    }
//}
//
//interface MyInterface2 {
//    void method();
//}
//
//// 디폴트 메소드랑 구현안된 메소드가 있으면 구현안된 메소드를 오버라이드 하게 됨
//class MyClass implements MyInterface1, MyInterface2 {
//    @Override
//    public void method() {
//        System.out.println("hhhh");
//    }
//}
//
//public class javatest implements MyInterface2, MyInterface1 {
//    public static void main(String[] args) {
//        MyClass my = new MyClass();
//        my.method();
//        javatest j = new javatest();
//        j.method();
//    }
//
//    @Override
//    public void method() {
//        System.out.println("여기");
//    }
//}

//class Nodes {
//    int x;
//}
//class javatest {
//    public static class Nodes {
//        int x;
//    }
//    public static void main(String[] args) {
//        Nodes node = new Nodes();
//        System.out.println(node.x);
//    }
//}


//import java.util.Arrays;
//
//class Student implements Comparable<Student>{
//    int grade;
//    int age;
//
//    public Student(int grade, int age) {
//        this.grade = grade;
//        this.age = age;
//    }
//
//    @Override
//    public int compareTo(Student st){
//        return st.age - this.age; // 나이 내림차순
//    }
//
//    @Override
//    public String toString() {
//        return "Student{" +
//                "grade=" + grade +
//                ", age=" + age +
//                '}';
//    }
//}
//class javatest {
//    public static void main(String[] args) {
//        Student st1 = new Student(100, 10);
//        Student st2 = new Student(110, 11);
//        Student st3 = new Student(120, 12);
//        Student st4 = new Student(130, 13);
//        Student[] students = new Student[]{st1, st2, st3, st4};
//
//        Arrays.sort(students);
//        System.out.println(Arrays.toString(students));
//    }
//}

//public class javatest {
//    public static void main(String[] args) {
//        try{
//            add();
//        } catch (AException e){
//            System.out.println("여기");
//        }
//    }
//
//    public static void add() throws AException{
//        try {
//            throw new AException();
//        } finally {
//            System.out.println("hi");
//        }
//    }
//}

