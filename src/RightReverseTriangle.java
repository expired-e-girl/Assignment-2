//Marilyn Ruptash
//ID: 261126626

//This program will take an integer input as an argument and prints an inverted triangle
//with the number of rows the input represents.

public class RightReverseTriangle {
    //Method to print the reverse right triangle.
    public static void printReverseRightTriangle(int rows) {
        //Loop to determine the number of rows according to input from user and increment.
        for (int i = 1; i < rows; i++) {
            //Loop to calculate the spaces in the pattern.
            for (int z = 0; z < i; z++) {
                System.out.print(" ");
            }
            //Loop to calculate the * in the pattern.
            for (int j = 1; j <= rows - i; j++) {
                System.out.print("*");
            }
            //Print a new line per iteration.
            System.out.println("");
        }
    }


        public static void main (String[]args){
            //Accept integer argument input.
            int rows = Integer.parseInt(args[0]);

            //Error for input under 0.
            if (rows < 0) System.out.println("Error: input value must be >= 0");

            //If the user inputs zero, nothing is output.
            if (rows == 0) System.out.println(" ");

            //Call method printReverseTriangle and passing it the value input by user.
            printReverseRightTriangle(rows);
        }
    }