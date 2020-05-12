package OnlyOneUseAcc.third;

public class U0901Main {
    public static  void main(String[] args) {
        Integer[] intArr = new Integer[]{10, 20, 15};
        Float[] floatArr = new Float[10];
        for (int i = 0; i < 10; i++) {
            floatArr[i] = (float) Math.round(Math.random() * 10);
        }

        U0901WorkArray<Integer> insWorkArrayInt = new U0901WorkArray<>(intArr);
        U0901WorkArray<Float> insWorkArrayFloat = new U0901WorkArray<>(floatArr);

        System.out.println("Integer: " + insWorkArrayInt.sum());
        System.out.println("Float: " + insWorkArrayFloat.sum());
    }
}
