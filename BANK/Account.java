package PROJECT.BANK;


public class Account {
    
    private String id;
    private String name;
    private Integer balance =0;
    
    public Account(String id , String name) {
        this.id = id;
        this.name = name;
    }

    public Account(String id , String name , Integer balance) {
    this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public String getId(){
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBalance(){
        return this.balance;
    }

    public void setBalance( Integer balance) {
        this.balance = balance;
    }

    public Integer credit(Integer amount) {
        this.balance = this.balance + amount;
        return this.balance;
    }

    public Integer debit(Integer amount) {
        if(this.balance >= amount) {
            this.balance -= amount;
        }
        else{
            System.out.println("Amount Exceeded the Balance! \n Current Balance = "+this.balance);   
        }
        return this.balance;
    }

    public Integer transfer(Account accTo, Integer amount) {

        if(amount <= this.balance) {
            accTo.setBalance( accTo.getBalance() + amount);
            this.balance -= amount;
        }
        else{
            System.out.println("LOW BALANCE");
        }
        return this.balance;
    }

    @Override
    public String toString() {
        return "ACCOUNT[Id = "+ this.id +", Name = "+this.name+ ", Balance = "+ this.balance+ "]";
    }
}

