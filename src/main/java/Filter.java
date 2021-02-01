import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Filter {
    public static List<Integer> Filter(List<Integer> listInt) {
        Stream<Integer> stream = listInt.stream();
        List<Integer> resultCollect = stream.filter(x -> x > 0)
                .filter(x -> x % 2 == 0)
                .collect(Collectors.toList());
        return resultCollect;
    }

}
