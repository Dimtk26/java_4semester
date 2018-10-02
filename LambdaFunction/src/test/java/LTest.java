import Humans.BadYearException;
import Humans.Gender;
import Humans.Human;
import Lambda.LambdaDemo;
import Lambda.LambdaRunner;
import org.junit.Assert;
import org.junit.Test;

import java.util.function.BiPredicate;

public class LTest {
    private Human Dima = new Human("Ткаченко", "Дмитрий",
            "Владиславович", 19, Gender.MALE);
    private Human newDima = new Human("Ткаченко", "Dima",
            "Vladislavovich", 21, Gender.MALE);

    public LTest() throws BadYearException {
    }

    @Test
    public void TestGetStringLength(){
        Assert.assertEquals(
                new Integer(18),
                LambdaRunner.run(LambdaDemo.getLengthString,"It's not just Java")
        );
    }
    @Test
    public void TestGetFirstCharacterInStringOrNull(){
        Assert.assertEquals(
                new Character('w'),
                LambdaRunner.run(LambdaDemo.getFirstCharacterInStringOrNull, "warning")
        );
    }

    @Test
    public void TestCheckSpaceInStringTrue(){
        Assert.assertTrue(
                LambdaRunner.check(LambdaDemo.InStringCheckSpace, "name")
        );
    }

    @Test
    public void TestCheckSpaceInStringFalse(){
        Assert.assertFalse(
                LambdaRunner.check(LambdaDemo.InStringCheckSpace, "My name")
        );
    }

    @Test
    public void  getHumanAgeTest(){
        Assert.assertEquals(19, LambdaRunner.getAgeOfHuman(Dima));
    }

    @Test(expected = BadYearException.class)
    public void TestBadYearException() throws BadYearException {
        Human badMan = new Human();
        badMan.setAge(-1);
    }

    @Test
    public void  TestGetHumanOlder(){
        Assert.assertEquals(20, LambdaRunner.plusOne(Dima).getAge());
    }

    @Test
    public void  TestBiPredicateHuman(){
        Assert.assertTrue(
                LambdaRunner.biPredicateHuman((BiPredicate<Human, Human>) LambdaDemo.compareSurname, Dima,newDima));
    }


    @Test
    public void getFullNameTest(){
        Assert.assertEquals("Ткаченко Дмитрий Владиславович", LambdaRunner.getAllName(Dima));
    }
 //getCountOfWordsInString
//checkStringLambda
    @Test
    public void getNumberOfWordsTest(){
        Assert.assertEquals(3, LambdaRunner.getCountOfWordsInString("first,second,third"));
        Assert.assertEquals(1, LambdaRunner.getCountOfWordsInString("onlyOne"));
    }

    @Test
    public void maxAgeTest() throws BadYearException {
        Human hum3 = new Human();
        hum3.setAge(9);
        Assert.assertTrue(
                LambdaRunner.checkAgeChecker(LambdaDemo.checkMaxAge,newDima,Dima,hum3,25)
        );
        Assert.assertFalse(
                LambdaRunner.checkAgeChecker(LambdaDemo.checkMaxAge,newDima,Dima,hum3,20)
        );

    }

}


