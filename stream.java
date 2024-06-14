import java.util.List;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class StreamEstudo {
    public static void main(String[] args) {
        List<Integer> ints = List.of(1,2,3,4,5,6,11,15,17,23);
        List<Integer> stream = ints.stream().map(s -> s.intValue() + 1).collect(Collectors.toList());
        System.out.println("Map: "+stream);

        List<Integer> stream2 = ints.stream().map(s -> s.intValue() + 2).filter(t -> t >= 10).collect(Collectors.toList());
        System.out.println("Filter: " + stream2);

        List<Integer> stream3 = ints.stream().map(s -> s.intValue() + 2).filter(t -> t >= 10).limit(2).sorted((o1, o2) -> o2.compareTo(o1)).toList();
        System.out.println("Limit: " + stream3);
    }
}