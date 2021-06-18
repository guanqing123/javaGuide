package liaoxuefeng.collection;

import java.io.*;
import java.util.Properties;

/**
 * @description: TODO 类描述
 * @Author guanqing
 * @Date 2021/6/17 14:24
 **/
public class PropertiesTest {

    public static void main(String[] args) throws IOException {
//        loadProperties();
        readMemory();
    }

    public static void loadProperties() throws IOException {
        Properties props = new Properties();
        props.load(PropertiesTest.class.getResourceAsStream("/setting.properties"));

        String filePath = props.getProperty("last_open_file");
        String interval = props.getProperty("auto_save_interval", "120");

        System.out.println("filePath:" + filePath +"\t"+"interval:" + interval);

        props.setProperty("name", "guanqing");
        props.setProperty("email", "guanqinghz@163.com");
        props.store(new FileOutputStream("src/main/resources/setting.properties"), "这是写入的properties注释");
    }

    public static void readFile() throws IOException {
        String f = "setting.properties";
        Properties props = new Properties();
        props.load(new FileInputStream(f));

        String filePath = props.getProperty("last_open_file");
        String interval = props.getProperty("auto_save_interval", "120");

        System.out.println("filePath:" + filePath +"\t"+"interval:"+interval);
    }

    public static void readMemory() throws IOException {
        String str = "#这是字符串测试\n"+"name=guanqing\n"+"email=guanqinghz@163.com\n";
        ByteArrayInputStream bais = new ByteArrayInputStream(str.getBytes("UTF-8"));
        Properties pros = new Properties();
        pros.load(bais);

        System.out.println(pros.getProperty("name") +"\t"+ pros.getProperty("email"));
    }
}
