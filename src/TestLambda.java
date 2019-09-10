import Iris.Object.Sorter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TestLambda {
    static BigDecimal five = new BigDecimal(5);
    static BigDecimal six = new BigDecimal(6);
    static BigDecimal seven = new BigDecimal(7);

    public static void main(String[] args) {
        List<Sorter> list = new ArrayList<>();


        list.add(new Sorter(BigDecimal.ONE,BigDecimal.TEN));//0.1
        list.add(new Sorter(six,BigDecimal.TEN));           //0.6
        list.add(new Sorter(seven,BigDecimal.TEN));         //0.7
        list.add(new Sorter(five,five));          //0.5

        List<Sorter> result = sort(list);
        result.stream().forEach(sorter -> System.out.println(sorter.getFirst()+"-----"+sorter.getSecond()));

        System.out.println(new BigDecimal(1).divide(new BigDecimal(1000000),10,BigDecimal.ROUND_HALF_DOWN));
    }

    public static List<Sorter> sort(List<Sorter> list){
        Predicate<Sorter> gtFive = sorter -> sorter.getFirst().compareTo(five)>=0;
        Comparator<Sorter> first = Comparator.comparing(sorter -> sorter.getFirst().divide(sorter.getSecond(),2,BigDecimal.ROUND_HALF_DOWN));
        Comparator<Sorter> second = Comparator.comparing(sorter -> sorter.getSecond());
        return list.stream().filter(gtFive).sorted(first).collect(Collectors.toList());
    }
}
