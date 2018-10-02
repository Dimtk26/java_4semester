package Lambda;

import Humans.BadYearException;
import Humans.Human;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaDemo {
    public static final Function<String, Integer> getLengthString = string -> {
        if (string == null) {
            return null;
        }
        return string.length();
    };

    public static final Function<String, Character> getFirstCharacterInStringOrNull = string -> {
        if (string == null || "".equals(string)) {
            return null;
        }
        return string.charAt(0);
    };

    public static final Predicate<String> InStringCheckSpace = string -> {
        if (string == null) {
            return true;
        }
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == ' ') {
                return false;
            }
        }
        return true;
    };

    public static final Function<String , Integer> getCountOfWordsInString = string -> {
        if (string == null || "".equals(string)) {
            return 0;
        }
        String[] buf = string.split(",");
        int res = 0;
        for (int i = 0; i < buf.length; i++) {
            if (!"".equals(buf[i])) {
                res++;
            }
        }
        return res;
    };

    public static final Function<Human, Integer> getAgeOfHuman = human -> {
        if (human == null) {
            return null;
        }
        return human.getAge();
    };

    public static final BiPredicate<? extends Human, ? extends Human> compareSurname = (human1, human2) ->
            human1 != null && human2 != null && human1.getSurname().equals(human2.getSurname());


    public static final Function<Human, Object> getSurnameNamePatronymic = human -> {
        if (human == null) {
            return null;
        }
        return human.getSurname() + " " + human.getName() + " " + human.getPatronymic();
    };

    public static final Function<Human, Human> makeOlder = human -> {
        if (human == null) {
            return null;
        }
        Human older = new Human(human);
        try {
            older.setAge(human.getAge()+1);
        } catch (BadYearException e) {
            e.printStackTrace();
        }
        return older;
    };

    public static final AgeChecker checkMaxAge = (human1, human2, human3, maxAge) -> {
        if (human1 == null || human2 == null || human3 == null || maxAge == null) {
            return false;
        }
        return (maxAge > (human1.getAge())
                && maxAge > (human2.getAge())
                && maxAge > (human3.getAge()));
    };

}
