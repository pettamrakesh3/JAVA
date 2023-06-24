import java.util.*;

//creating a Class for user datails;
class User{
    String UserId;
    String UserPin;
    int balance;
    List<String> TransactionHistory;
    public User(String UserId,String UserPin){
        this.UserId=UserId;
        this.UserPin=UserPin;
        this.balance=0;
        TransactionHistory=new ArrayList<String>();
    }
}
//interface of ATM functions
public interface ATM{
    User CheckCreadentials(String UserId,String UserPin);
    void GetTransactions(User user);
    void Withdraw(User user,int amount);
    void Debit(User user,int amount);
    void Transfer(User Owner,String UserId,int amount);
    void CheckBalance(User user);
}
//implementing ATM Functions
class myATM implements ATM{
    ArrayList<User> Data=new ArrayList<>();
    public void CreateUser() {
        //default user by manual input

        Data.add(new User("David", "1899"));
        Data.add(new User("Philp", "1900"));
        Data.add(new User("Roman", "1333"));
        Data.add(new User("venu", "1699"));
    }
    //checking user Details
    public User CheckCreadentials(String UserId, String UserPin) {
        for(User user: Data){
            if(user.UserId.equals(UserId) && user.UserPin.equals(UserPin))
            {
                return user;
            }
        }
        return null;
    }

    //checking user balance

    public void CheckBalance(User user){
        System.out.println("\nBalance: "+user.balance+"\n");
        return;
    }

    //history of transactions

    public void GetTransactions(User user) {
        System.out.println("******History*******");
        for(String history: user.TransactionHistory){
            System.out.println(history);
        }
        System.out.println("-----------------------");
    }
    //function for withdraw money

    public void Withdraw(User user,int amount) {
       if(user.balance<amount)
       {
            System.out.println("\n*** Transaction Failed!. Check Your Balance ");
            return;
       }
       user.balance-=amount;
       System.out.println("\n"+amount+" has been Credited from your account");
       user.TransactionHistory.add("Withdraw: "+amount);
    }

    //function deposite money

    public void Debit(User user,int amount) {
        user.balance+=amount;
        System.out.println("\n"+amount+" has been Debited into your account");
        user.TransactionHistory.add("Debited: "+amount);
    }

    //Function for Transfer money to other account
    
    public void Transfer(User Owner,String UserId, int amount) {
        int user;
        for(user=0;user<Data.size();user++)
        {
            if(Data.get(user).UserId.equals(UserId)){
                break;
            }
        }
        if(user==Data.size())
        {
            System.out.println("\n*** Transaction Failed\n");
            return;
        }
        if(Owner.balance<amount)
        {
            System.out.println("\n*** Insufficient Funds!. Check Your Balance\n");
            return;
        }
        Owner.balance-=amount;
        Data.get(user).balance+=amount;
        System.out.println("\n"+amount+" has been Transformed from your account to "+UserId);
        Owner.TransactionHistory.add("Transfered "+amount+"to"+UserId);
    }
}

class Main{
    static Scanner sc=new Scanner(System.in);
    static myATM m=new myATM();
    public static void Banking()
    {        
        String UserId;
        String UserPin;
        int amount;
        System.out.println("UserId: ");
        UserId=sc.next();
        System.out.println("UserPin: ");
        UserPin=sc.next();
        while(true)
        {
            User user=m.CheckCreadentials(UserId, UserPin);

            if(user==null)
            {
                System.out.println("\n*** Invalid User\n");
                break;
            }
            System.out.println("\nChoose Services: \n");
            System.out.println("\n1.Check Balance\n2.Transaction History\n3.DEBIT\n4.WITHDRAW\n5.TRANSFER\n6.QUIT\n");

            int option=sc.nextInt();
            switch(option)
            {
                case 1:
                    m.CheckBalance(user);
                    break;
                case 2:
                    m.GetTransactions(user);
                    break;
                case 3:
                    System.out.println("Enter amount to Debit: ");
                    amount=sc.nextInt();
                    m.Debit(user, amount);
                    break;
                case 4:
                    System.out.println("Enter amount to Withdraw: ");
                    amount=sc.nextInt();
                    m.Withdraw(user, amount);
                    break;
                case 5:
                    System.out.println("Enter reciever UserId: ");
                    String reciever=sc.next();
                    System.out.println("Enter amout to transfer: ");
                    amount=sc.nextInt();
                    m.Transfer(user, reciever, amount);
                    break;
                case 6:
                    return;
                default:
                    System.out.println("\n*** Invalid Services\n");
                    break;
            }
        }
        // System.out.println("------------------------------------------------------------------------------------");
    }
    public static void main(String[] args) {
        m.CreateUser();
        while(true)
        {
            System.out.println("1.Banking\n2.Quit\n\n");
            int option=sc.nextInt();
            if(option!=1)
            {
                break;
            }
            System.out.println("--------------------------------------  ATM  ---------------------------------------\n");
            Banking();
            System.out.println("------------------------------------------------------------------------------------\n");
        }
        System.out.println("\n\nClosing.........\n\n");

    }
}
