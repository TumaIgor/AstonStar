package aston.exceptions;

public class RuntimeExceptionExample {
    public static void main(String[] args) {
        try {
            // NullPointerException 
            String text = null;
            System.out.println(text.length());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            // ArrayIndexOutOfBoundsException
            int[] array = new int[5];
            System.out.println(array[5]);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            // ArithmeticException
            int result = 10 / 0;
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            // ClassCastException
            Object x = new Integer(0);
            System.out.println((String)x);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            // IllegalArgumentException
            Integer.parseInt("notANumber");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
