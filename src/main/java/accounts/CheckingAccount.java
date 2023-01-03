package accounts;

public class CheckingAccount extends Account{
    long minBalanse=0;

    public CheckingAccount(String name){
        super(name);
        balanse=0;
    }

    @Override
    public boolean pay(long expenses) {
        super.pay(expenses);//используем метод предка
        if (balanse < minBalanse) {
            balanse += expenses;
            return false;
        } else {
            return true;
        }
    }
    public String toString(){
        return "---------Рассчетный счет---------";
    }

    @Override
    public boolean transfer(Account accountTo, long amount) {
        return super.transfer(accountTo, amount);
    }
}
