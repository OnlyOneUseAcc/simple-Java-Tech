package OnlyOneUseAcc.first;

/**
 * Class for practice with arrays Part2
 *
 */
public class WorkWithArray2 {

    /**
     * Static method for transponate matrix
     * @param mas matrix
     */
    public static void transponate(int[][] mas) {

        for (int[] underArray : mas) {
            if (mas.length != underArray.length) {
                return;
            }
        }

        for (int i = 0; i < mas.length; i++) {
            for (int j = i + 1; j < mas.length; j++) {
                int temp = mas[i][j];
                mas[i][j] = mas[j][i];
                mas[j][i] = temp;
            }
        }
    }

    /**
     * Method for print array
     * @param array printable array
     */
    public static void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][]mas = new int[5][5];
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length; j++) {
                mas[i][j] = (int) Math.round(Math.random() * 10);
            }
        }
        printArray(mas);
        transponate(mas);
        System.out.println();
        printArray(mas);

    }
}
