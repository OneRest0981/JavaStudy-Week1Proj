package hrms.model;

/**
 *  员工父类
 *
 */

public abstract class Person {
    protected String name;
    protected int age;
    protected String work;

    public Person(String n, int a, String w) {
        this.name = n;
        this.age = a;
        this.work = w;
    }


    public void showInfo (){
        System.out.println("姓名:" + name + " 年龄: " + age + " 工作: " + work);
    }

    @Override
    public String toString() {
        return "姓名:" + name + " 年龄: " + age + " 工作: " + work;
    }
}
