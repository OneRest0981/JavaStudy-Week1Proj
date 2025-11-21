package hrms.app;

import hrms.model.Person;

import java.util.ArrayList;
import java.util.Scanner;

import static hrms.service.PersonService.*;
import static hrms.util.JsonStorage.savePersons;
import static hrms.util.SafeInput.safeInt;
import static hrms.util.SystemSet.reSet;

public class MainApp {
    static Scanner sc = new Scanner(System.in);


    public static void menuControl(ArrayList<Person> personList) {
        while (true) {
            System.out.println("输入指令: \n1->增加员工\n2->开除员工\n3.查看团队\n4.保存团队到文件\n7.退出");
            int getButton = safeInt(sc);
            switch (getButton) {
                case 1:
                    reSet();
                    personAdd(personList, sc);
                    break;

                case 2:
                    reSet();
                    personDel(personList, sc);
                    break;

                case 3:
                    reSet();
                    GetTeam(personList);
                    break;

                case 4:
                    savePersons(personList);
                    break;

                case 7:
                    savePersons(personList);
                    System.out.println("系统已退出，再见！");
                    break;

            }
            if(getButton == 7) {
                break;
            }
        }
    }





    public static void main(String[] args) {
        ArrayList<Person> personList = creatTeam(); // 人员列表

        menuControl(personList);






    }




}
