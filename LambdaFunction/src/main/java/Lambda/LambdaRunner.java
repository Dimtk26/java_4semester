package Lambda;

import Humans.Human;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaRunner {
    public static <T,R> R run(Function<T,R> lambda, T arg) {
        return lambda.apply(arg);
    }

    public static int getCountOfWordsInString(String str){
        return LambdaDemo.getCountOfWordsInString.apply(str);
    }

    public static boolean check(Predicate<String> lambda, String string){
        return lambda.test(string);
    }

    public static Object getAllName(Human hum){
        return LambdaDemo.getSurnameNamePatronymic.apply(hum);
    }

    public static <T extends Human> Object checkHumanLambda(Function<T, ?> lambda, T human){
        return lambda.apply(human);
    }

    public static int getAgeOfHuman(Human human){
        return LambdaDemo.getAgeOfHuman.apply(human);
    }

    public static Human plusOne(Human hum){
        return LambdaDemo.makeOlder.apply(hum);
    }

    public static boolean biPredicateHuman(BiPredicate<Human, Human> lambda, Human human1, Human human2){
        return lambda.test(human1, human2);
    }

    public static boolean checkAgeChecker(AgeChecker lambda, Human human1, Human human2, Human human3, Integer maxAge){
        return lambda.checkAge(human1, human2, human3, maxAge);
    }

}
