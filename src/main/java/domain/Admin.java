package domain;

import dao.Identeficator;

import java.time.LocalDate;

public class Admin extends User implements Identeficator<Integer> {
    private int id;
    private AdminType status;

    public Admin() {
        this.id = 0;
        this.status = AdminType.Administrator;
    }

    public Admin(String name, String surname, LocalDate birthDay,
                 String login, String password, UserState state, String email,
                 int id, AdminType status) {
        super(name, surname, birthDay, login, password, state, email);
        this.id = id;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AdminType getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", status=" + status +
                '}';
    }
}
