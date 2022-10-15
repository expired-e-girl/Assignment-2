//Marilyn Ruptash
//ID: 261126626

//This program will take an integer input as an argument and prints a right triangle
//with the number of rows the input represents.

public class RightTriangle {
    //Method to print a right triangle.
    public static void printRightTriangle(int rows){
        //Loop to determine the number of rows according to input from user and increment.
        for(int i = 1; i <= rows; i++){

            //Nested for loop to calculate the spaces in the pattern.
            for(int z = rows - i; z >= 1; z--){
                System.out.print(" ");
            }
           //Nested for loop to calculate the * in the pattern.
            for (int j = i; j >= 1; j--){
                System.out.print("*");
            }
        //Print a new line per iteration.
        System.out.println("");
        }
    }


    public static void main(String[] args) {
        //Accept integer argument input
        int rows = Integer.parseInt(args[0]);

        //Error for input under 0
        if (rows < 0) System.out.println("Error: input value must be >= 0");

        //Call method printRightTriangle and passing it the value input by user.
        printRightTriangle(rows);
    }
}
