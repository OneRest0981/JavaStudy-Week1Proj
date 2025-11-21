package hrms.util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SafeInput {

    public static String safeString(Scanner sc) {
        return  sc.next();
    }

    public static int safeInt(Scanner sc) {
//        System.out.println("安全卫士已启动：");
        int count;
        while(true){
            try {
                count = sc.nextInt();
                if (count < 0 || count > 70) {
                    throw new IllegalArgumentException();
                }
                break;
            }catch (IllegalArgumentException e){

                System.out.print("数值超出限制 请重试(0-70以内整数) -> ");
                sc.next();


            }catch (InputMismatchException f) {

                System.out.println("请勿输入其它的内容");
                sc.next();

            }
        }
        return count;

    }


}
