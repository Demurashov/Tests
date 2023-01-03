package accounts;
import accounts.SavingAccount;
import accounts.Account;
import clients.Client;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class AccountTest {

    public SavingAccount sAcc = new SavingAccount("Вася", 100);
    public CreditAccount cAkk=new CreditAccount("Вася",10);
    public Client client=new Client("Вася",3);
    Account Ob1=new SavingAccount(client.getName(),10);
    Account Ob2=new CheckingAccount(client.getName());
    Account Ob3=new CreditAccount(client.getName(),15);
    Account Ob4=null;
    Object[]arrObj={Ob1,Ob2,Ob3,Ob4};

    @ParameterizedTest
    @ValueSource(longs={0,10,100,1000})
    public void paySavingAccountTest(long i) {
       boolean result= sAcc.pay(i+10);//проверяем возврат методом состояния True
        Assertions.assertFalse(result);
        //Assertions.assertTrue(result);
        boolean result1=sAcc.pay(i*-1);//провереяем возврат методом состояния False
        Assertions.assertTrue(result1);
    }
    @Test
    public void setSumPercentCreditAccountTest(){
        cAkk.balanse=-1000;
        long result=cAkk.setSumPercent(365,10);
        Assertions.assertEquals(100,result);//проверка правильности рассчета процентов по кредиту
    }
    @ParameterizedTest
    @ValueSource(ints={0,1,2,3})
    public void getAccClientTest(int i){//проверка методов добавления и вывода аккаунтов
        client.addAcc(Ob1);
        client.addAcc(Ob2);
        client.addAcc(Ob3);
        Assertions.assertEquals(client.getAcc(i),arrObj[i]);

    }

}