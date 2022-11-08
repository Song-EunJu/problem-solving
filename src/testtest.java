public class testtest {
    public static void main(String[] args) {
        int num = 1<<21;
        int num2 = num<<1;
        int num3 = num>>1;
        System.out.println(Integer.toBinaryString(num));
        System.out.println(Integer.toBinaryString(num2));
        System.out.println(Integer.toBinaryString(num3));

        System.out.println(Integer.toBinaryString(1<<21));
        System.out.println(Integer.toBinaryString((1<<21)-1));
    }

}
