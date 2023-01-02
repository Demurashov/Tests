package clients;
import accounts.Account;
import accounts.Account;
import accounts.MoneyTarget;

public class Client implements MoneyTarget {
    //Account newAcc;//экземпляр нового счета
    Account[] arrObj;//массив объектов

    String name;
    //long cash;
    int maxNumAcc;//максимальное количество счетов
    public Client(String name, int maxNumAcc) {
        this.name=name;
        this.maxNumAcc = maxNumAcc;
        arrObj=new Account[maxNumAcc];
        //newAcc=new Account(name);
    }
   //добавление нового счета
    public void addAcc(Account newAcc) {
        int count=0;
        for (int i=0;i<arrObj.length;i++) {
            if (arrObj[i]== null) {
                arrObj[i] = newAcc;
                System.out.println(arrObj[i].toString()+" добавлен");
                break;
            }
            else {
                count++; //счетчик добавленых счетов
            }
            if (count>= arrObj.length) {
                System.out.println("Счет не добавлен. Максимальное количество счетов для клиента " + name + ":" + maxNumAcc);
            }
        }
    }
    //метод платежа
    public boolean pay(long cash){
        boolean flag=false;
        for (Account obj : arrObj) {
            // flag=obj.pay(cash) == true ? true:false;
            if (obj!=null){
                if (obj.pay(cash)) {
                    System.out.println(obj.toString());
                    flag=true;
                    break;
                }
            }
        }
        return flag;
    }
    public String getName(){
        return name;
    }
    public Account getAcc(int namber){
        return arrObj[namber];
    }

    public void showAccounts(){
        System.out.printf("Список доступных счетов");
        for (int i=0;i<arrObj.length;i++){
            System.out.printf(arrObj.toString()+" "+i);
        }
    }

    @Override
    public boolean accept(long money) {
        if (pay(money)) {
            return true;
        }
        else {
            return false;
        }
    }
}
