interface MyInterface {
    default void hi() {
        System.out.println("hi");
    }
}

class MySuperClass {
    public void hi(){
        System.out.println("super hi");
    }
}

class MyClass extends MySuperClass implements MyInterface {

}

public class poli {
    public static void main(String[] args) {
        MyClass my = new MyClass();
        my.hi();
    }
}

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
//class MyClass implements MyInterface2, MyInterface1 {
//    @Override
//    public void method(){
//        System.out.println("myclass");
//    }
//}
//public class poli implements MyInterface1, MyInterface2 {
//    public static void main(String[] args) {
//        MyClass my = new MyClass();
//        my.method();
//    }
//
//    @Override
//    public void method() {
//        System.out.println("hihihih");
//    }
//}
