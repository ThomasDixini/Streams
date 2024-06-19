import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class otherStreams {
    public static void main(String[] args) {
        Stream<String> str = Stream.empty();
        System.out.println("String: " + str.collect(Collectors.toList()));

        Stream<Integer> listInt = Stream.of(1,2,3);
        List<Integer> lista = listInt.collect(Collectors.toList());
        System.out.println("Inteiros: " + lista);

        Stream<String> teste = Stream.generate(() -> "+");
        List<String> listring = teste.limit(1000L).collect(Collectors.toList());
        System.out.println(listring);

        Stream<String> itr = Stream.iterate("+", t -> t.length() <= 10, t -> t + "+");
        itr.forEach(System.out::println);

        Random random = new Random(314L);
        List<String> letter = random.doubles(1_000, 0d, 1d).mapToObj(rand -> rand < 0.5 ? "A" : "B").collect(Collectors.toList());
        System.out.println(letter);
        
        
        try(InputStream in = Files.newInputStream(Paths.get("C:\\Users\\ThomásDixini\\Documents\\Dev\\Streams\\teste.txt"))) {
            InputStreamReader stream_in = new InputStreamReader(in);
            BufferedReader buff = new BufferedReader(stream_in);
            Long strr = buff.lines().filter(t -> t.contains("thomas")).count();
            System.out.println("Numero de vezes encontrado: " + strr);
        } catch(IOException e ){

        }


        Stream.Builder<Integer> builder = Stream.<Integer>builder();
        builder.add(1);
        builder.add(2);
        builder.add(3);
        Stream<Integer> streamBuilder = builder.build();
        System.out.print(streamBuilder.collect(Collectors.toList()));
    }
}
