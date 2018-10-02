import java.util.Objects;


public class Human {
    private String
                    surname,
                    name,
                    patronymic;//отчество
    private int
                    age;

    public Human(String surname, String name, String patronymic, int age) throws NotCorrectAge {
        if (age <= 0) {
            throw new NotCorrectAge();
        }
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.age = age;
    }

    public Human(Human people) {
        this.name = people.name;
        this.surname = people.surname;
        this.patronymic = people.patronymic;
        this.age = people.age;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getName() {
        return this.name;
    }

    public String getPatronymic() {
        return this.patronymic;
    }

    public int getAge() {
        return this.age;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setAge(int age) throws NotCorrectAge {
        if (age <= 0) {
            throw new NotCorrectAge("Not Correct Age");
        }
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Human)) return false;
        Human human = (Human) o;
        return getAge() == human.getAge() &&
                Objects.equals(getSurname(), human.getSurname()) &&
                Objects.equals(getName(), human.getName()) &&
                Objects.equals(getPatronymic(), human.getPatronymic());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSurname(), getName(), getPatronymic(), getAge());
    }

    public static void main(String[] args) throws NotCorrectAge {
        Human human = new Human("aa","bb","ff",5);
        human.setAge(-2);
    }



}

