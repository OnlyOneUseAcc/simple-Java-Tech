package OnlyOneUseAcc.first;

import java.util.Date;

public class Cycle {
    public static void printAll(){

        for (int i = 97; i <= 122; i++ ){
            System.out.println((char)i);
        }
    }
    public static void printDifference(){
        long begin = new Date().getTime();
        for (int i = 0 ; i <100000000; i++ ){

        }
        long end = new Date().getTime();
        long diff = end - begin;
        System.out.println(diff);
        begin = new Date().getTime();
        for (long i = 0 ; i <100000000; i++ ){

        }
        end = new Date().getTime();
        System.out.println(end - begin);
        System.out.println(end - begin - diff);
    }
    public static void main(String[] args){
        printAll();
        printDifference();
    }
}
