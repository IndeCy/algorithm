package ParallelStream;

import java.util.ArrayList;
import java.util.List;

public class Main {


    public List retainList(){

        List<List<Student>> lists = new ArrayList<>();
        List<Student> a = new ArrayList<>();
        Student a1 = new Student("a1",1);
        Student a2 = new Student("a2",2);
        Student a3 = new Student("a3",3);
        Student a4 = new Student("a4",4);
        a.add(a1);
        a.add(a4);
        a.add(a3);
        a.add(a2);
        List<Student> b = new ArrayList<>();
        Student b1 = new Student("a1",1);
        Student b2 = new Student("a2",2);
        Student b3 = new Student("b3",3);
        b.add(b1);
        b.add(b3);
        b.add(b2);
        lists.add(a);
        lists.add(b);
        return a;
    }
}
