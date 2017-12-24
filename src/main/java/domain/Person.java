package domain;

import dao.Identeficator;
import supportFiles.ConsoleReader;

import java.time.LocalDate;
import java.time.Period;

public class Person  implements Identeficator<Integer>{
    private int id;
    private String name;
    private String surname;
    private LocalDate birthDay;

    public Person() {
        this.name = name;
        this.surname = surname;
        this.birthDay = birthDay;
    }

    public Person(int id, String name, String surname, LocalDate birthDay) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthDay = birthDay;
    }

    public Person(String name, String surname, LocalDate birthDay) {
        this.name = name;
        this.surname = surname;
        this.birthDay = birthDay;
    }

    public Integer getId() {
        return id;
    }

    protected void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setName() {
        this.name = ConsoleReader.getStringData("Please enter you name");
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;

    }

    public void setSurname() {
        this.surname = ConsoleReader.getStringData("Please enter you surname");
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public void setBirthDay() {
        int year = ConsoleReader.getIntData("Please enter you born year");
        int month = ConsoleReader.getIntData("Please enter you born month");
        int day = ConsoleReader.getIntData("Please enter you born day");
        this.birthDay = LocalDate.of(year,month,day);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDay=" + birthDay +
                '}';
    }
}

