package OnlyOneUseAcc.third;

public class U0901WorkArray<T extends Number> {
    private T[] arrNums;


    public U0901WorkArray(T[] numP) {
        this.arrNums = numP;
    }

    public double sum() {
        if (this.arrNums == null) {
            return 0;
        }
        double doubleWork = 0;
        for (T tempNumber : arrNums) {
            String tempStr = tempNumber.toString();
            doubleWork += Double.parseDouble(tempStr);
        }
        return doubleWork;
    }
}
