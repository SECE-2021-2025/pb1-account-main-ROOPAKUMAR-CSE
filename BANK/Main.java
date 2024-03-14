package PROJECT.BANK;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n;
        System.out.println("Enter the Number Of Accounts you Need to Create!");
        n = Integer.parseInt(br.readLine());
        String id;
        String name;
        Integer balance;
        
        Account []accArr = new Account[n];
        Account acc, accFrom, accTo;

        int choice, accId, amount, accIdFrom, accIdTo;

        for(int i=0; i<n; i++){
            System.out.println("ENTER ACCOUNT ID : ");
            id = br.readLine();
            System.out.println("ENTER ACCOUNT NAME : ");
            name = br.readLine();
            System.out.println("ENTER THE BALANCE : ");
            balance = Integer.parseInt(br.readLine());

            acc = new Account(id, name, balance);
            
            accArr[i] = acc;
        }

        display(accArr , n);
        
        do{
            System.out.println("1 : CREDIT");
            System.out.println("2 : DEBIT");
            System.out.println("3 : TRANSFER");
            System.out.println("ENTER YOUR CHOICE!");
            
            choice = Integer.parseInt(br.readLine());

            switch (choice) {
                case 1:
                    System.out.println("SELECT THE ACCOUNT");
                    display(accArr, n);
                    accId = Integer.parseInt(br.readLine());
                    acc = accArr[accId-1];
                    System.out.println("ENTER THE AMOUNT NEED TO BE CREDITED");
                    amount = Integer.parseInt(br.readLine());
                    balance = acc.credit(amount);
                    System.out.println("AMOUNT CREDITTED SUCCESSFULLY! \n CURRENT BALANCE : "+balance);
                    break;
                case 2:
                    System.out.println("SELECT THE ACCOUNT");
                    display(accArr, n);
                    accId = Integer.parseInt(br.readLine());
                    acc = accArr[accId-1];
                    System.out.println("ENTER THE AMOUNT NEED TO BE DEBITTED");
                    amount = Integer.parseInt(br.readLine());
                    balance = acc.debit(amount);
                    System.out.println("AMOUNT DEBITTED SUCCESSFULLY! \n CURRENT BALANCE : "+balance);
                    break;
                case 3:
                    System.out.println("SELECT THE FROM ACCOUNT");
                    display(accArr, n);

                    accIdFrom = Integer.parseInt(br.readLine());
                    accFrom = accArr[accIdFrom-1];
    
                    accIdTo = Integer.parseInt(br.readLine());
                    accTo = accArr[accIdTo-1];

                    System.out.println("ENTER THE AMOUNT NEED TO BE TRANSFERED");
                    amount = Integer.parseInt(br.readLine());

                    balance = accFrom.transfer(accTo , amount);
                
                    System.out.println("SENDER ACCOUNT BALANCE : " +accFrom.getBalance());
                    System.out.println("RECEIVER ACCOUNT BALANCE : "+accTo.getBalance());
                    break;
            }
        }
        while(choice>0 && choice<4);
    }

    public static void display(Account[] accArr, int size) {
        for(int i=0; i<size; i++) {
            System.out.println(accArr[i].toString());
        }
    }
}
