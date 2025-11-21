package hrms.service;

import hrms.model.Employee;
import hrms.model.Person;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

import static hrms.util.JsonStorage.loadPersons;
import static hrms.util.SafeInput.safeInt;

/**
 *  操作数据的行为
 */
public class PersonService {

    // 创建列表
    public static ArrayList<Person> creatTeam() {
        ArrayList<Person> personList = loadPersons(); // 从 JSON 文件加载团队

        return personList;
    }

    // 更新列表
    public static void updateTeam(ArrayList<Person> personList) {
    }

    // 查看当前人员数据
    public static void GetTeam (ArrayList<Person> personList) {
        System.out.println("\n===========================\n");

        System.out.println("当前团队人数: " + personList.size());
        for (int i = 0; i < personList.size(); i++) {
            System.out.println(i+1 + ". " + personList.get(i));
        }

        System.out.println("\n===========================\n");
    }

    // 增加人员
    public static void personAdd(ArrayList<Person> personList, Scanner sc) {


        while (true) {
            System.out.println("当前选择的是: 增加员工\n请输入 员工姓名 年龄 工作 (空格分割)："); // 获取职员信息
            String name = sc.next();
            if (Objects.equals(name, "q")) {
                break;
            }
            int age = safeInt(sc);
            String work = sc.next();

            // 创建职员
            Employee newPeople = new Employee(name, age, work);
            System.out.println("成功增加新员工: ");
            newPeople.showInfo();

            // 加入团队
            System.out.println("成功添加新员工( " + name + " )至团队");
            personList.add(newPeople);

        }

    }



    // 减少人员
    public static void personDel(ArrayList<Person> personList, Scanner sc) {

        while (true) {
            GetTeam(personList);    // 输出全体列表

            System.out.println("当前选择的是: 删除员工\n请输入 员工序号：(输入字母返回菜单)");
            try {   // 检查是否退出 1.输入的数不在团队内 重新输入 2.输入的是String 返回菜单
                int number = sc.nextInt();
                personList.remove(personList.get(number - 1));


            } catch (IndexOutOfBoundsException e) {
                GetTeam(personList); // 输出全体列表
                System.out.println("找不到该员工 请重试-> 最大员工数量:" + personList.size());

            } catch (InputMismatchException f) {
                System.out.println("返回菜单");
                sc.next();
                return;
            }

        }

    }

}
