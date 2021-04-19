import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException {
            Path path = Paths.get(Main.class.getClassLoader().getResource("numbers.txt").toURI());
            //Path path = Paths.get(args[0]);
            try (Stream<String> lines = Files.lines(path)) {
                double sum = lines
                        .map(d -> {
                            try {
                                return Double.parseDouble(d);
                            } catch (NumberFormatException e) {
                                return 0d;
                            }
                        })
                        .reduce(0d, Double::sum);
                System.out.println(sum);
            }
    }
}
