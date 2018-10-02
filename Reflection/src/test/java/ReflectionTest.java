import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ReflectionTest {

    @Test
    public static void testCountHumanTypeElement() throws NotCorrectAge {
        List<Object> Generic = new ArrayList<Object>();
        Generic.add(2);
        Generic.add(null);
        Generic.add(true);
        Generic.add(new Human("A", "B", "C", 26));
        Generic.add(5);
        Generic.add(new Human("D", "E", "F", 33));
        Generic.add(new Human("G", "H", "I", 26));
        Generic.add(false);
        Generic.add("DimTk");
        Generic.add('a');
        Generic.add(new Human("J", "K", "L", 41));
        assertEquals(ReflectionDemo.countHumanTypeElement(Generic), 4);
    }
    @Test
    public static void testgetOpenMethodName() throws NotCorrectAge {
        List<String> names = new ArrayList<String>();
        names.add("getSurname");
        names.add("getName");
        names.add("getPatronymic");
        names.add("getAge");
        names.add("setSurname");
        names.add("setName");
        names.add("setPatronymic");
        names.add("setAge");
        names.add("equals");
        names.add("hashCode");
        names.add("toString");
        names.add("getClass");
        names.add("notify");         // ↓потоки...↓
        names.add("notifyAll");
        names.add("wait");
        names.add("wait");
        names.add("wait");

        Human people = new Human("Gosling", "Java", "James", 23);
        assertTrue(ReflectionDemo.getOpenMethodName(people).containsAll(names));
    }

    @Test
    public static void testGetSuperName() throws NotCorrectAge {
        List<String> superNames = new ArrayList<String>();
        superNames.add("java.lang.Object");
        Human people = new Human("Gosling", "Java", "James", 23);
        assertEquals(superNames, ReflectionDemo.getSuperName(people));
    }


}
