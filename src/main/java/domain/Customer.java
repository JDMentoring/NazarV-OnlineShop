package domain;

import java.time.LocalDate;

public class Customer extends User{
    private String id;
    private String address;
    private String phone;
    private UserGroup group;

    public Customer() {
        this.id = "1";
        this.address = "noaddress";
        this.phone = "380680363051";
        this.group = UserGroup.New;
    }

    public Customer(String name, String surname, String login, String password, String id, UserGroup group) {
        super(name, surname, login, password);
        this.id = id;
        this.group = group;
    }

    public Customer(String name, String surname, LocalDate birthDay,
                    String login, String password, UserState state, String email,
                    String id, String address, String phone, UserGroup group) {
        super(name, surname, birthDay, login, password, state, email);
        this.id = id;
        this.address = address;
        this.phone = phone;
        this.group = group;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public UserGroup getGroup() {
        return group;
    }

    public void setGroup(UserGroup group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", group=" + group +
                '}';
    }
}

