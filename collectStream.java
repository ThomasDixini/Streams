import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class collectStream {
    public static void main(String[] args) {
        String any = IntStream.range(0, 20)
            .boxed()
            .map(Object::toString)
            .collect(Collectors.joining(" ,")
        );

        Collection<String> strings = List.of("one", "two", "Threee", "thre");
        Map<Boolean, List<String>> stream = strings.stream().collect(Collectors.partitioningBy(s -> s.length() > 3));

        Collection<String> stringsGroup = List.of("one", "two", "Threee", "thre");
        Map<Integer, List<String>> streamGroup = stringsGroup.stream().collect(Collectors.groupingBy(String::length));


        Map<String, Integer> mapStream = stringsGroup.stream().collect(Collectors.toMap(s -> s.toString(), t -> t.length()));

        System.out.println(any);
        System.out.println(stream);
        System.out.println(streamGroup);
        System.out.println(mapStream);

    }
}
