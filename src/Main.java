import accounts.Account;
import accounts.CheckingAccount;
import accounts.CreditAccount;
import accounts.SavingAccount;
import clients.Client;

import java.util.Scanner;

public class Main {
    static Client client;
    static Scanner sc = new Scanner(System.in);
    static boolean flag=true;
    public static void main(String[] args) {
        //диалог ввода имени клиента и макс. кол-ва доступных счетов
        while (true) {
            String name=input("Введите имя клиента с большой буквы");
            if (name.equals("Q")){
                break;
            }
            int maxAcc=Integer.parseInt(input("Введите кол-во счетов доступное данному клиенту"));

            client= new Client(name,maxAcc);
            createMenu(name);

        }
    }
    //метод ввода данных
    public static String input(String message) {
        System.out.println(message);
        String inputStr = sc.nextLine();
        return inputStr;
    }
    //метод отображения меню выбора счета или платежа
    public static void createMenu(String name){
        boolean flag=true;
        while (flag){

            System.out.println("-------------Создание счета:------------");
            System.out.println("Накопительный счет - 1");
            System.out.println("Рассчетный счет -2");
            System.out.println("Кредитный счет-3");
            System.out.println("Перейти к оплате - 4");
            System.out.printf("Перевод межу своими счетами-5");
            System.out.println("Возврат в предыдущее меню-Q");
            String inp=input("Введите номер для выбора операции:");
            if (name.equals("Q")){
                break;
            }
            int namber=Integer.parseInt(inp);
            switch(namber) {
                case 1: {
                    client.addAcc(new SavingAccount(client.getName(),10));
                    break;
                }
                case 2: {
                    client.addAcc(new CheckingAccount(client.getName()));
                    break;
                }
                case 3:{
                    client.addAcc(new CreditAccount(client.getName(),15));
                    break;
                }
                case 4: {
                    flag=false;
                        pay();
                        break;
                }
                case 5:{

                }
            }

        }
    }
    //диалог платежа
    public static void pay(){
        int sumPay=Integer.parseInt(input("Введите сумму платежа"));
        if (client.pay(sumPay)) {
            System.out.println("Оплата прошла успешно");
        }
        else{
            System.out.println("Недостаточно средств");
        }
    }
    //диалог перевода
    public static void transferer(){
        System.out.println("Список доступных счетов:");
        client.showAccounts();
        int namber1=Integer.parseInt(input("Номер счета,откуда переводить"));
        int namber2=Integer.parseInt(input("Номер счета,куда переводить"));
        int sumPay=Integer.parseInt(input("Введите сумму перевода"));
        client.getAcc(namber1).transfer(client.getAcc(namber2),sumPay);

        if (client.pay(sumPay)) {
            System.out.println("Оплата прошла успешно");
        }
        else{
            System.out.println("Недостаточно средств");
        }
    }
}