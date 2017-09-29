package java8.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Application {

    public static void main(String[] args) {

        List<JoneApprove> jonesApprove = new ArrayList<>();
        jonesApprove.add(JoneApprove.withRandomPoints(
                new Joke("Mis tetas")
            ));
        jonesApprove.add(JoneApprove.withRandomPoints(
                new Joke("Guau guau")
            ));
        jonesApprove.add(JoneApprove.withRandomPoints(
                new Joke("Other joke")
            ));

        Comparator<JoneApprove> comparator = Comparator.comparingInt(JoneApprove::getPoints);

        List jones = jonesApprove
                .stream()
                .filter(joneApprove -> joneApprove.getPoints() > 5)
                .sorted(comparator)
                .map(joneApprove -> joneApprove.getJoke().getJoke().split(" "))
                .flatMap(Arrays::stream)
                .map(s -> s.split(""))
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());

        jones.forEach(System.out::println);
    }
}
