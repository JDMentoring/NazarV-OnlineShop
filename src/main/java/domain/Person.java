package domain;

import java.time.LocalDate;

public class Person {
    private String name;
    private String surname;
    private LocalDate birthDay;

    public Person() {
        this.name = "noname";
        this.surname = "nosurname";
        this.birthDay = LocalDate.now();
    }

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.birthDay = LocalDate.now();
    }

    public Person(String name, String surname, LocalDate birthDay) {
        this.name = name;
        this.surname = surname;
        this.birthDay = birthDay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDay=" + birthDay +
                '}';
    }
}

