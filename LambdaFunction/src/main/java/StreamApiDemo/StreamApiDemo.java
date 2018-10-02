package StreamApiDemo;
import Humans.Human;
import Lambda.LambdaDemo;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamApiDemo extends LambdaDemo {
// Function<List<?>, List<?>> Представляет функцию, которая принимает один аргумент и создает результат.
    // https://metanit.com/java/tutorial/10.6.php (collect)
    public static Function<List<?>, List<?>> deleteAllNull =
            (list) -> (list.stream().filter(Objects::nonNull)).collect(Collectors.toList());

    //https://habr.com/company/luxoft/blog/270383/ (filter)
    public static Function<Set<Integer>, Long> countPositiveValueInSet =
            (set) -> set.stream().filter(x -> x >= 0).count();

    //https://metanit.com/java/tutorial/10.4.php  (skip)
    public static Function<List<?>, List<?>> getThreeLastElements =
            (list) -> list.stream().skip(list.size() - 3).collect(Collectors.toList());

    //http://qaru.site/questions/182969/difference-between-findany-and-findfirst-in-java-8
    public static Function<List<Integer>, Integer> getFirstEvenValueOrNull =
            (list) -> list.stream().filter(x -> x % 2 == 0).findFirst().orElse(null);

    //Метод distinct возвращает stream без дубликатов, при этом для упорядоченного стрима
    // (например, коллекция на основе list) порядок стабилен
    public static Function<Integer[], List<Integer>> buildListSquaresOfElemsWithoutRepeat =   // int?
            (array) -> Arrays.stream(array).distinct().map(x -> x * x).collect(Collectors.toList());

    //Отсортировать коллекцию строк по алфавиту
    //https://habr.com/company/luxoft/blog/270383/
    public static Function<List<String>, List<String>> upListNonEmptyStrings =
            (list) -> list.stream().filter(Objects::nonNull).filter(x -> !(x.equals(""))).sorted()
                    .collect(Collectors.toList());

    //http://proglang.su/java/strings-compareto
    public static Function<Set<String>, List<String>> setOfStringTurnInList =
            (set) -> set.stream().sorted((x, y) -> -x.compareTo(y)).collect(Collectors.toList());

    //Аналог map, но возвращает числовой стрим (то есть стрим из числовых примитивов)
    //https://habr.com/company/luxoft/blog/270383/
    public static Function<Set<Integer>, Integer> accumulateSquares =
            (set) -> set.stream().mapToInt(x -> x*x).sum(); //(int) Math.pow(x,x)

    //Отсортировать коллекцию строк по алфавиту sorted()
    //Отсортировать коллекцию строк по алфавиту в обратном порядке sorted((o1, o2)
    public static Function<Collection<Human>, Integer> calculateMaxAge =
            (col) -> col.stream().sorted((x, y) -> x.compareToAge(y)).findFirst().get().getAge();

    public static Function<Collection<Human>, Collection<Human>> sortByGenderSortByAge =
            (col) -> col.stream().sorted((x,y) -> x.compareToAge(y)).sorted((x,y)->
                    x.compareToGender(y)).collect(Collectors.toList());
}//↑↓compareToGender