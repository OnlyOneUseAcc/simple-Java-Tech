package OnlyOneUseAcc.first;

public class WorkWithArray2 {
    public static void Transponate(int[][] mas){

        for (int[] underArray : mas) {
            if (mas.length != underArray.length) {
                return;
            }
        }

        for (int i = 0; i < mas.length; i++) {
            for (int j = i+1; j < mas.length; j++) {
                int temp = mas[i][j];
                mas[i][j] = mas[j][i];
                mas[j][i] = temp;
            }
        }
    }

    public static void printArray(int[][] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        int[][]mas = new int[5][5];
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length; j++) {
                mas[i][j]=(int)Math.round(Math.random()*10);
            }
        }
        printArray(mas);
        Transponate(mas);
        System.out.println();
        printArray(mas);

    }
}
