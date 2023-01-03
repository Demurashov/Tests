package accounts;

public class SavingAccount extends Account{
    long minBalanse;
    public SavingAccount(String name,int minBalanse){
        super(name);
        this.minBalanse=minBalanse;
        balanse=minBalanse;
    }
    @Override
    public boolean pay(long expenses) {
        super.pay(expenses);//используем метод предка
        if (balanse<minBalanse) {
            balanse += expenses;
            return false;
        }
            else {
        return true;}

    }
    public String toString(){
        return "--------Накопительный счет---------";
    }

    @Override
    public boolean transfer(Account accountTo, long amount) {
        return super.transfer(accountTo, amount);
    }
}
