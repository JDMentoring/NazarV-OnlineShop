package domain;

import dao.Identeficator;

import java.time.LocalDate;

public class Customer extends User implements Identeficator<Integer> {
    private int id;
    private String address;
    private String phone;
    private UserState status;

    public Customer() {
        this.id = 0;
        this.address = "noaddress";
        this.phone = "380680363051";
        this.status = UserState.New;
    }

    public Customer(String name, String surname, String login, String password, int id, UserState status) {
        super(name, surname, login, password);
        this.id = id;
        this.status = status;
    }

    public Customer(String name, String surname, LocalDate birthDay,
                    String login, String password, UserState state, String email,
                    int id, String address, String phone, UserState status) {
        super(name, surname, birthDay, login, password, state, email);
        this.id = id;
        this.address = address;
        this.phone = phone;
        this.status = status;
    }


    public Integer getId() {
        return id;
    }

    protected void setId(int id) {
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

    public UserState getStatus() {
        return status;
    }

    public void setStatus(UserState status) {
        this.status = status;
    }

    public void setStatus(String user_status) {
        switch (user_status) {
            case "New":
                this.status = UserState.New;
                break;
            case "Active":
                this.status = UserState.Active;
                break;
            case "Blocked":
                this.status = UserState.Blocked;
                break;
            case "Banned":
                this.status = UserState.Banned;
                break;
        }

    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", status=" + status +
                "} " + super.toString();
    }
}

