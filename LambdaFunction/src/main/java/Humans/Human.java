package Humans;

import java.util.Objects;

public class Human {
    private Gender gender;
    private String surname;
    private String name;
    private String patronymic;
    private int age;

    public Human(String surname, String name, String patronymic, int age, Gender gender) throws BadYearException {
        if(age < 0 ){
            throw new BadYearException();
        }
        this.gender = gender;
        this.name = name;
        this.patronymic = patronymic;
        this.surname = surname;
        this.age = age;
    }

    public Human(Human people){
        this.age = people.age;
        this.surname = people.surname;
        this.patronymic = people.patronymic;
        this.name = people.name;
        this.gender = people.gender;
    }

    public Human() {
        }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getSurname(){
        return surname;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }

    public String getPatronymic(){
        return patronymic;
    }

    public void setPatronymic(String patronymic){
        this.patronymic = patronymic;
    }


    public int getAge(){
        return age;
    }

    public void setAge(int age) throws BadYearException {
        if(age < 0 ){
            throw new BadYearException();
        }
        this.age = age;
    }

    public Gender getGender(){
        return gender;
    }

    public void setGender(Gender gender){
        this.gender = gender;
    }

    public int compareToAge(Human second){
        if(this.getAge() == second.getAge()) return 0;
        if (this.getAge() > second.getAge())
        {
            return -1;
        }
        else
            return 1;
    }

    public int compareToGender(Human second){
        return this.getGender().compareTo(second.getGender());
        //if (this.getGender().compareTo(second.getGender()))
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return age == human.age &&
                Objects.equals(surname, human.surname) &&
                Objects.equals(name, human.name) &&
                Objects.equals(patronymic, human.patronymic) &&
                gender == human.gender;
    }

    @Override
    public int hashCode() {

        return Objects.hash(surname, name, patronymic, age, gender);
    }

}
