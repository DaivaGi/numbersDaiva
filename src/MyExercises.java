import lt.itakademija.exam.Exercises;
import lt.itakademija.exam.IntegerGenerator;
import lt.itakademija.exam.NumberFilter;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MyExercises implements Exercises {


    @Override
    public Integer findSmallest(List<Integer> list) {
        return list.stream().mapToInt(v -> v).min().orElseThrow();
    }

    @Override
    public Integer findLargest(List<Integer> list) {
        return  list.stream().mapToInt(v -> v).max().orElseThrow();
    }

    @Override
    public boolean isEqual(Object o, Object o1) {
        return o.equals(o1);
    }

    @Override
    public boolean isSameObject(Object o, Object o1) {
        return o == o1;
    }

    @Override
    public List<Integer> consume(Iterator<Integer> iterator) {
        List<Integer> numbers = new ArrayList<>();
        while (iterator.hasNext()){
            numbers.add(iterator.next());
        }
        return numbers;
    }

    @Override
    public int computeSumOfNumbers(int number) {
        return IntStream.rangeClosed(1, number).sum();
    }

    @Override
    public int computeSumOfNumbers(int number, NumberFilter numberFilter) {
        return IntStream.rangeClosed(1, number).filter(numberFilter::accept).sum();
    }

    @Override
    public List<Integer> computeNumbersUpTo(int number) {

        return IntStream.range(1, number).boxed().collect(Collectors.toList());
    }

    @Override
    public Map<Integer, Integer> countOccurrences(List<Integer> list) {
        Map<Integer, Integer> occurrences = new HashMap<>();
        for (Integer number : list) {
            if (!occurrences.containsKey(number)){
                occurrences.put(number, 1);
            }else {
                occurrences.put(number, occurrences.get(number) + 1);
            }
        }
                return occurrences;
    }

    @Override
    public IntegerGenerator createIntegerGenerator(int number, int number1) {
        return new IntegerGenerator() {
            Iterator<Integer> iterator = IntStream.rangeClosed(number, number1).boxed()
                    .collect(Collectors.toList())
                    .iterator()   ;
            @Override
            public Integer getNext() {
                while(iterator.hasNext()) {
                    return iterator.next();
                }
                return null;
            }
        };
    }

    @Override
    public IntegerGenerator createFilteredIntegerGenerator(IntegerGenerator integerGenerator, NumberFilter numberFilter) {
        List<Integer> numbers = new ArrayList<>();
        Integer newNumber = integerGenerator.getNext();
        while(newNumber != null){
            if(numberFilter.accept(newNumber)) {
                numbers.add(newNumber);
            }
            newNumber = integerGenerator.getNext();
        }
        return new MyIntegerGenerator(numbers);

    }
}
