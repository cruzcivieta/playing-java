package thread.practice;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AccountRepository {

    public void persist(Account account) throws ResourceNotAvailableException {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try (FileWriter fileWriter = new FileWriter("/tmp/account.txt")) {
            fileWriter.write(account.getAmount());
        } catch (IOException e) {
            throw ResourceNotAvailableException.forWriting();
        }
    }

    public Account getAccount() throws ResourceNotAvailableException {

        try (FileReader fileReader = new FileReader("/tmp/account.txt")) {
            Integer amount = fileReader.read();
            return new Account(amount);
        } catch (IOException e) {
            throw ResourceNotAvailableException.forReading();
        }
    }
}
