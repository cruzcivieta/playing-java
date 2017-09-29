package thread.practice;

import java.util.Random;

public class InvestmentService {

    private static final Integer max = 3000;
    private static final Integer bias = 2000;

    public static Integer getInvestment(){
        return (new Random()).nextInt(max) - bias;
    }
}
