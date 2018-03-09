package top.zzh.csv;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import top.zzh.bean.Contract;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.*;
/**
 * Created by 曾志湖 on 2018/3/9.
 */
public class WriterTest {

    public static void main(String[] args) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
        //从字符中数组写出到CSV文件中
        CSVWriter writer = new CSVWriter(new FileWriter("src/main/rescources/stu.csv"),',');
        String[][] stus = new String[][]{
                {"1","stu1","male"},
                {"2","stu2","female"}
        };
        for(String[] stu:stus){
            writer.writeNext(stu);
        }
        writer.close();
        //从bean的集合中写到CSV文件中
        Writer writer1 = new FileWriter("src/main/rescources/stu1.csv");
        StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer1).build();
        List<Contract> list = new ArrayList <>();
        list.add(new Contract("1","小李","13333333333","**公司","江西赣州"));
        list.add(new Contract("2","小美","18888888888","**公司","江西吉安"));
        beanToCsv.write(list);
        writer1.close();
    }
}
