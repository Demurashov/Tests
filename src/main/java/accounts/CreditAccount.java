package accounts;

public class CreditAccount extends Account {
    long maxBalanse=0;
    long sumPersent;//сумма выплаты за использование кредита
    public CreditAccount(String name,int persent){
        super(name);
    }
    @Override
    public boolean add(long income){
        super.add(income);
        if (balanse>maxBalanse){
            balanse-=income;
            return false;
        }
        else {
            return true;
        }
    }
    //установить сумму выплат за использование кредита, days-дни использования
    public long setSumPercent(int days,long percent){
        if (balanse<0){
            sumPersent=(Math.abs(balanse)*percent/100)*days/365;
        }
        return sumPersent;
    }
    public long getSumPersent() {
        return sumPersent;
    }
    public String toString(){
        return "----------Кредитный счет----------";
    }

    @Override
    public boolean transfer(Account accountTo, long amount) {
        return super.transfer(accountTo, amount);
    }
}


