public class WarmUp1 {

    public static void swap(int x, int y){
        System.out.println("inside swap: x is " + x + " y is: " + y);
        int temp = x;
        x = y;
        y = temp;
        System.out.println("inside swap: x is " + x + " y is: " + y);
    }

    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);

        swap(x, y);
    }
}
