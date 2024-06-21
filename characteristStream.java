import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class characteristStream {
    public static void main(String[] args) {
        List<Integer> lista = List.of(10, 55, 3, 30);
        Stream<Integer> stream = lista.stream();
        System.out.println(stream.max(Comparator.comparing(Integer::intValue)).orElseThrow());;
    }
}
