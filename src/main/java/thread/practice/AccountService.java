package thread.practice;

public class AccountService {

    AccountRepository accountRepository;
    boolean busy = false;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    synchronized public void process() {

        Integer investmentResult = InvestmentService.getInvestment();
        message("- Investment: " + investmentResult);

        while (busy) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        busy = true;
        try {
            Account account = accountRepository.getAccount();
            message( " - Get account:" + account.getAmount());
            if (investmentResult > 0){
                Account newAccount = account.add(investmentResult);
                message( " - New account > 0:" + newAccount);
                accountRepository.persist(newAccount);
            } else {
                if (account.isAffordable(investmentResult)) {
                    Account newAccount = account.sub(investmentResult);
                    message( " - New account affordable:" + newAccount);
                    accountRepository.persist(newAccount);
                } else {
                    message("- We don't have money!!");
                }
            }
        } catch (ResourceNotAvailableException e) {
            message(e.getMessage());
        }

        busy = false;
        notify();
    }

    private void message(String message) {
        System.out.println(Thread.currentThread().getName() + ":" + message);
    }

}