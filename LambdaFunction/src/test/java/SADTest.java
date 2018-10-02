import Humans.BadYearException;
import Humans.Gender;
import Humans.Human;
import Lambda.LambdaDemo;
import Lambda.LambdaRunner;

import StreamApiDemo.StreamApiDemo;
import org.junit.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SADTest {

    @Test
    public void deleteAllNullTest(){
        List list = new ArrayList<>();
        Collections.addAll(list, false, true, null, 0, null, "add", null, 11);

        List ress = new ArrayList<>();
        Collections.addAll(ress, false, true, 0, "add", 11);

        assertEquals(ress, StreamApiDemo.deleteAllNull.apply(list));
    }

    @Test
    public void countPositiveValueInSetTest(){
        Set<Integer> set = new HashSet<>(8);
        Collections.addAll(set, 0, 1, 2, 3, -4, -5, -6, -7);
        assertEquals(4, (long)StreamApiDemo.countPositiveValueInSet.apply(set));
    }

    @Test
    public void returnThreeElemsTest(){
        List list = new ArrayList<>();
        Collections.addAll(list, null, null, true, 10, true, "maybe", false);
        List result = new ArrayList<>();
        Collections.addAll(result, true,"maybe",false);
        assertEquals(result,StreamApiDemo.getThreeLastElements.apply(list));
    }

    @Test
    public void getFirstEvenValueOrNullTestNull(){
        List<Integer> listOfInt = new ArrayList<>();
        Collections.addAll(listOfInt, 1, 3, 5, 7, 9, 11, 13, 15, 17);
        assertEquals(null,StreamApiDemo.getFirstEvenValueOrNull.apply(listOfInt));
    }

      @Test
    public void getFirstEvenValueOrNullTest8() {
          List<Integer> listOfInt1 = new ArrayList<>();
          Collections.addAll(listOfInt1, 1, 3, 5, 7, 9, 8, 9, 9, 1, 4, 18, 61);
          assertEquals(8, (int) StreamApiDemo.getFirstEvenValueOrNull.apply(listOfInt1));
      }

    @Test
    public void buildListSquaresOfElementsWithoutRepeat(){
        Integer[] arr = {1, 2, 3, 4, 5, 6};
        List<Integer> ress = new ArrayList<>();
        Collections.addAll(ress, 1, 4, 9, 16, 25, 36);
        List<Integer> actual = new ArrayList<>();
        actual = StreamApiDemo.buildListSquaresOfElemsWithoutRepeat.apply(arr);
        assertEquals(ress,actual);
    }

    @Test
    public void  upListNonEmptyStrings(){
        List<String> listOfString = new ArrayList<>();
        Collections.addAll(listOfString,
                "My", "", "name",null, "20", "is", "Dima");
        List<String> result = new ArrayList<>();
        Collections.addAll(result,
                "20", "Dima","My","is","name");
        assertEquals(result,StreamApiDemo.upListNonEmptyStrings
                .apply(listOfString));
    }

    @Test
    public void setOfStringTurnInListTest(){
        Set<String> setOfString = new HashSet<>();
        Collections.addAll(setOfString,
                "My", "", "name", "20", "is", "Dima");
        List<String> result = new ArrayList<>();
        Collections.addAll(result,
                "name","is","My","Dima","20","");
        assertEquals(result,StreamApiDemo.setOfStringTurnInList.apply(setOfString));
    }

    @Test
    public void accumulateSquares(){
        Set<Integer> set = new HashSet<>(5);
        Collections.addAll(set, 1, -2, 3, -4, 0); //1+4+9+16
        assertEquals(30,(int)StreamApiDemo.accumulateSquares.apply(set));
        Set<Integer> set1 = new HashSet<>(5);
        Collections.addAll(set1, 0, 0, 0, 0, 0);
        assertEquals(0,(int)StreamApiDemo.accumulateSquares.apply(set1));
    }

    @Test
    public void calculateMaxAgeTest() throws BadYearException {
        Collection<Human> HumanCol = new ArrayList<>();
        Collections.addAll(HumanCol,
                new Human("Иванова", "Леонида", "Ивановна", 26, Gender.FEMALE),
                new Human("Владимиров", "Игроь", "Петрович", 17, Gender.MALE),
                new Human("Петров", "Василий", "Измаилович", 19, Gender.FEMALE),
                new Human("Венедик","Иван","Витальевич", 23, Gender.MALE));
        assertEquals(26,(int)StreamApiDemo.calculateMaxAge.apply(HumanCol));
    }

    @Test
    public void sortByGenderSortByAgeTest() throws BadYearException {
        Collection<Human> HumanCol = new ArrayList<>();
        Collections.addAll(HumanCol,
                new Human("Владимиров", "Петрович", "Иванов", 20, Gender.MALE),
                new Human("Олев", "Петр", "Иванов", 19, Gender.MALE),
                new Human("Валев", "Лена", "Иванова", 17, Gender.FEMALE),
                new Human("Крант","Иван","Владимирович", 20, Gender.MALE),
                new Human("Иванова", "Настя", "Иванова", 23, Gender.FEMALE),
                new Human("Венедик", "Костя", "Иванов", 21, Gender.MALE),
                new Human("Александра", "Виталина", "Петрова", 12, Gender.FEMALE),
                new Human("Левша", "Слава", "Иванов", 26, Gender.MALE),
                new Human("Вант", "Лера", "Иванова", 22, Gender.FEMALE)
        );
        Collection<Human> ress = new ArrayList<>();
        Collections.addAll(ress,
                new Human("Левша", "Слава", "Иванов", 26, Gender.MALE),
                new Human("Венедик", "Костя", "Иванов", 21, Gender.MALE),
                new Human("Владимиров", "Петрович", "Иванов", 20, Gender.MALE),
                new Human("Крант","Иван","Владимирович",  20, Gender.MALE),
                new Human("Олев", "Петр", "Иванов",  19, Gender.MALE),
                new Human("Иванова", "Настя", "Иванова",23, Gender.FEMALE),
                new Human("Вант", "Лера", "Иванова", 22, Gender.FEMALE),
                new Human("Валев", "Лена", "Иванова", 17, Gender.FEMALE),
                new Human("Александра", "Виталина", "Петрова", 12, Gender.FEMALE));
        assertEquals(ress,StreamApiDemo.sortByGenderSortByAge.apply(HumanCol));
    }

    @Test(expected = BadYearException.class)
    public void ExcepptionTest() throws BadYearException {
        Human h = new Human("Левша", "Слава", "Иванов", 26, Gender.MALE);
        h.setAge(-1);
    }
}
