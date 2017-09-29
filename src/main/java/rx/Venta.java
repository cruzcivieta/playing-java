package rx;

public class Venta {

    private Quesero quesero;
    private int year;
    private int value;

    public Venta(Quesero quesero, int year, int value) {
        this.quesero = quesero;
        this.year = year;
        this.value = value;
    }

    public Quesero getQuesero() {
        return quesero;
    }

    public void setQuesero(Quesero quesero) {
        this.quesero = quesero;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "quesero=" + quesero.getName() +
                ", year=" + year +
                ", value=" + value +
                '}';
    }
}
