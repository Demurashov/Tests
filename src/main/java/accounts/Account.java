package accounts;

public abstract class Account implements MoneyTarget {
    long balanse=0;
    String name;
    public Account(String name){
        this.name=name;
    }
    public boolean add(long income){
        if (income>=0) {
            balanse+=income;
            return true;
        }
        else{
            return false;
        }
    }
    public boolean pay(long expenses){

        if (expenses>=0) {
            balanse-=expenses;
            return true;
        }
        else{
            return false;
        }
    }
    public boolean transfer (Account accountTo, long amount){
        if (pay(amount)){
            if (accountTo.add(amount)){
                return true;
            }
            else{
                add(amount);
                return false;
            }
        }
        else{
            return false;
        }
    }
    public long getBalanse(){
        return balanse;
    }

    @Override
    public boolean accept(long money) {
        add(money);
        return true;
    }
}

