package thread.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProcessTransaction implements Runnable {

    AccountService accountService;

    public ProcessTransaction(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Run thread");
        this.accountService.process();
        System.out.println(Thread.currentThread().getName() + " Finish thread");
    }
}

class Application {
    public static void main(String[] args) {

        AccountRepository accountRepository = new AccountRepository();
        AccountService accountService = new AccountService(accountRepository);

        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Integer priority = (new Random()).nextInt(Thread.MAX_PRIORITY) + 1;
            Thread thread = new Thread(new ProcessTransaction(accountService),
                    "Thread " + i + " with priority " + priority);
            thread.setPriority(priority);
            threadList.add(thread);
        }

        threadList.forEach(Thread::start);

    }
}