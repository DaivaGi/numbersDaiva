import lt.itakademija.exam.IntegerGenerator;

import java.util.Iterator;
import java.util.List;

public class MyIntegerGenerator implements IntegerGenerator {

    Iterator<Integer> iterator;

    MyIntegerGenerator(List<Integer> list){
        iterator = list.iterator();

    }


    @Override
    public Integer getNext() {
        if(iterator.hasNext()) {
            return iterator.next();
        }
        return null;
    }
}
