package domain;

public class Customer extends User {

    private String address;
    private String phone;
    private UserState status;


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
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", status=" + status +
                "} " + super.toString();
    }
}

