package rx;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;

import java.util.ArrayList;
import java.util.List;

public class MainRx {

    public static void main(String[] args) {

        Observable.just(
                new Venta(new Quesero("Puigdemont", "Catalonia"), 2014, 2000),
                new Venta(new Quesero("Jone", "Alcalá"), 2015, 10000),
                new Venta(new Quesero("O'behan", "Marte"), 2016, 100)
        )
        .filter(venta -> venta.getValue() > 1000)
        .subscribe(venta -> {
            System.out.println(venta.getQuesero().getName() + ": " + venta.getValue());
        });


        MyObservable myObservable = new MyObservable();
        Observable<Venta> ventaObservable = Observable.create(myObservable);

        Disposable disposable = ventaObservable.subscribe(
                v -> System.out.println(v.getQuesero().getName() + ": " + v.getValue()));

        disposable.dispose();
    }
}

class MyObservable implements ObservableOnSubscribe<Venta> {

    List<Venta> ventas;

    public MyObservable() {
        ventas = new ArrayList<Venta>(){{
            add(new Venta(new Quesero("Puigdemont", "Catalonia"), 2014, 2000));
            add(new Venta(new Quesero("Jone", "Alcalá"), 2015, 10000));
            add(new Venta(new Quesero("O'behan", "Marte"), 2016, 100));
        }};
    }

    @Override
    public void subscribe(ObservableEmitter<Venta> emitter) throws Exception {
        try {

            for (Venta venta : ventas) {
                emitter.onNext(venta);
            }

            emitter.onComplete();

        } catch (Exception exception) {
            emitter.onError(exception);
        }
    }

    public void addVenta(Venta venta) {
        ventas.add(venta);
    }
}