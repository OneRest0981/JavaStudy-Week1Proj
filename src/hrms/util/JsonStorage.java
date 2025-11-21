package hrms.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import hrms.model.Employee;
import hrms.model.Person;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonStorage {

    private static final Gson gson = new Gson();
    private static final String FILE_NAME = "team.json";

    // 获取项目根目录下的 team.json 路径
    private static File getStorageFile() {
        String baseDir = System.getProperty("user.dir"); // 一般就是 README 所在目录
        return new File(baseDir, FILE_NAME);
    }

    // 保存人员列表到 JSON 文件
    public static void savePersons(List<Person> personList) {
        // 只存 Employee（目前你只有这个子类）
        List<Employee> employees = new ArrayList<>();
        for (Person p : personList) {
            if (p instanceof Employee) {
                employees.add((Employee) p);
            }
            // 以后有 Teacher、Manager，可以扩展，这里先简单处理
        }

        String json = gson.toJson(employees);

        File file = getStorageFile();
        try (Writer writer = new OutputStreamWriter(new FileOutputStream(file), "UTF-8")) {
            writer.write(json);
            System.out.println("已保存到文件: " + file.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("保存文件失败: " + e.getMessage());
        }
    }

    // 从 JSON 文件加载人员列表
    public static ArrayList<Person> loadPersons() {
        File file = getStorageFile();
        ArrayList<Person> result = new ArrayList<>();

        if (!file.exists()) {
            System.out.println("未找到保存文件，返回空团队。");
            return result;
        }

        try (Reader reader = new InputStreamReader(new FileInputStream(file), "UTF-8")) {
            Type listType = new TypeToken<List<Employee>>() {}.getType();
            List<Employee> employees = gson.fromJson(reader, listType);
            if (employees != null) {
                result.addAll(employees);
            }
            System.out.println("已从文件加载团队: " + file.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("读取文件失败: " + e.getMessage());
        }

        return result;
    }
}