import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class reducingStream {
    public static void main(String[] args) {
        List<Integer> listInt = List.of(1,10,100,1000);
        BinaryOperator<Integer> sum = (a, b) -> a + b;
        int result = listInt.get(0);
        for(int index = 1; index < listInt.size(); index++){
            result = sum.apply(result, listInt.get(index));
        }
        System.out.println(result);

        List<Integer> lista = List.of(20, 25, 300, 1000);
        List<Integer> stream = lista.stream().parallel().toList();
        System.out.println(stream);
    }
}
