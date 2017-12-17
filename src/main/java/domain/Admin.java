package domain;

import dao.Identeficator;

import java.time.LocalDate;

public class Admin extends User implements Identeficator<Integer> {
    private int id;
    private AdminType status;



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
        //this.status = status;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", status=" + status +
                '}';
    }
}
