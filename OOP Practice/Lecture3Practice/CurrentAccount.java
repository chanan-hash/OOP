package Lecture3Practice;
import java.util.List;

import java.util.ArrayList;

public class CurrentAccount implements Account{
    private List<Double> currentTransactions;

    public CurrentAccount() {
        currentTransactions = new ArrayList<Double>();
    }

}
