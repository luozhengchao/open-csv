package top.zzh.bean;

import com.opencsv.bean.CsvBindByPosition;

/**
 * Created by 曾志湖 on 2018/3/9.
 */
public class Contract1 {

    @CsvBindByPosition(position = 0)
    private String id;
    @CsvBindByPosition(position = 1)
    private String name;
    @CsvBindByPosition(position = 2)
    private String phone;
    @CsvBindByPosition(position = 3)
    private String company;
    @CsvBindByPosition(position = 4)
    private String address;

    public Contract1() {
    }

    public Contract1(String id, String name, String phone, String company, String address) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.company = company;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", company='" + company + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
