public class Main3 {

    public static void main(String[] args) {
        int[][] array1 = { {1, 2, 3}, {4, 5, 6} };
        int[][] array2 = { {1, 2}, {3}, {4, 5, 6} };

        printArray(array1);
        printArray(array2);
    }

    public static void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}