package java8.lambdas;

import java.util.Random;

class JoneApprove {
    private Joke joke;
    private int points;

    private JoneApprove(Joke joke, int points) {
        this.joke = joke;
        this.points = points;
    }

    public static JoneApprove withRandomPoints(Joke joke) {
        return new JoneApprove(joke, (new Random().nextInt(10) + 1));
    }

    public int getPoints() {
        return points;
    }

    public Joke getJoke() {
        return joke;
    }

    @Override
    public String toString() {
        return "Joke: " + joke.getJoke() + " with points: " + points;
    }
}
