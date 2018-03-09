package top.zzh.csv;

import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import top.zzh.bean.Contract;
import top.zzh.bean.Contract1;
import java.util.*;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by 曾志湖 on 2018/3/9.
 */
public class ReaderTest {

    public static void main(String[] args) throws IOException{
        //读取数据到字符串数组中
        CSVReader reader = new CSVReader(new FileReader("src/main/rescources/contract.csv"));
        String [] contract;
        while ((contract = reader.readNext()) != null) {
            System.out.println(contract[0] + ", " + contract[1] + ", etc...");
        }

        // 读取到字符串数组组成的集合中
        CSVReader reader1 = new CSVReader(new FileReader("src/main/rescources/contract.csv"));
        List<String[]> contractList = reader1.readAll();
        for (String[] contract1 : contractList) {
            System.out.println(contract1[0] + ", " + contract1[1] + ", etc...");
        }

        // 读取到JavaBean， @CsvBindByName
        List<Contract> contractList1 = new CsvToBeanBuilder(new FileReader("src/main/rescources/contract.csv"))
                .withType(Contract.class).build().parse();
        if (contractList1 != null && contractList1.size() > 0) {
            for (Contract contract1 : contractList1) {
                System.out.println(contract1);
            }
        }

        // 读取到JavaBean， @CsvBindByPosition
        List<Contract1> contractList2 = new CsvToBeanBuilder(new FileReader("src/main/rescources/contract1.csv"))
                .withType(Contract1.class).build().parse();
        if (contractList2 != null && contractList2.size() > 0) {
            for (Contract1 contract1 : contractList2) {
                System.out.println(contract1);
            }
        }

        // 非注解读取到JavaBean中
        ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
        strategy.setType(Contract.class);
        // 配置与JavaBean中一致的列名
        String[] columns = new String[] {"id", "contract_name", "phone", "company", "address"};
        strategy.setColumnMapping(columns);
        CsvToBean csv = new CsvToBean();
        List<Contract> list = csv.parse(strategy, new FileReader("src/main/rescources/contract.csv"));
        for (Contract contract1 : list) {
            System.out.println(contract1);
        }
    }
}
