import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ReflectionDemo {

    // Дан список объектов произвольных типов. Найдите количество элементов списка,
// которые являются объектами типа Human или его подтипами
    public static int countHumanTypeElement(List<Object> Generic){
        int count =0;
        if(Generic.isEmpty()) {
            return 0;
        }
        for (Object obj:Generic) {
            if(obj instanceof Human){
                count++;
            }
        }
        return count;
    }

    // Для объекта получить список имен его открытых методов.
    public static List<String> getOpenMethodName(Object obj){
        Class cl = obj.getClass();
        List<String> names = new ArrayList<String>();
        for(Method m : cl.getMethods()){
            names.add(m.getName());
        }
        return names;
    }

    //Для объекта получить в виде списка строк, список  имен всех его суперклассов
// до класса Object включительно
    //http://qaru.site/questions/3997634/why-cant-classgetsuperclass-method-get-exactly-the-super-class-type-instance
    //https://docs.oracle.com/javase/7/docs/api/java/lang/Class.html
    public static List<String> getSuperName(Object obj){
        Class cls = obj.getClass().getSuperclass();
        List<String> superNames = new ArrayList<String>();
        while(cls!=null){
            superNames.add(cls.getName());
            cls=cls.getSuperclass();
        }
        return superNames;
    }
}
