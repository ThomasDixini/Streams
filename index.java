import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class index {
    public static void main(String[] args) throws IOException, InterruptedException {
        Path path = Path.of("./teste.txt");
        InputStream input = Files.newInputStream(path);
        InputStreamReader in = new InputStreamReader(input);
        BufferedReader buff = new BufferedReader(in);
        Stream<String> stream = buff.lines();
        System.out.println(stream.filter(t -> t.contains("thomas")).count());
        buff.close();

        buff.lines();

        Stream<String> st = Stream.empty();
        System.out.println(st.collect(Collectors.toList()));

        Stream<String> itr = Stream.iterate("-", t -> t + "-");
        itr.limit(5L).forEach(System.out::println);


        URI uri = URI.create("https://www.gutenberg.org/files/98/98-0.txt");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(uri).build();

        HttpResponse<Stream<String>> response = client.send(request, HttpResponse.BodyHandlers.ofLines());
        List<String> lines;
        try (Stream<String> stream2 = response.body()) {
            lines = stream2
                .dropWhile(line -> !line.equals("A TALE OF TWO CITIES"))
                .takeWhile(line -> !line.equals("*** END OF THE PROJECT GUTENBERG EBOOK A TALE OF TWO CITIES ***"))
                .collect(Collectors.toList());
        }
            System.out.println("# lines = " + lines.size());
        }   
}
