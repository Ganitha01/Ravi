import java.util.Scanner;
class Account
{
long acno;
int pin;
double balance;

public Account(long acno,int pin,double balance)
{
this.acno=acno;
this.pin=pin;
this.balance=balance;
}
public void withdraw()
{
Scanner sc=new Scanner(System.in);

System.out.println("enter the pin");
int pin=sc.nextInt();
if(this.pin==pin)
   {
    System.out.println("enter the amount");
     double amount=sc.nextDouble();
     if(amount>balance)
         {
  throw new InsafficientBalanceException("your balance is less");
              }
  else
      {
        balance=balance-amount;
    System.out.println("collect your cash");
           }
               }
else
      {
     throw new IncorrectPinException("u entered pin was Incorrect");
          }
}
public static void main(String[] args)
{
   Account a=new Account(457896123l,1122,50000d);
   try{
    a.withdraw();
         }
catch(InsafficientBalanceException e)
        {
      //System.out.println(e);
        e.printStackTrace();
       System.out.println("hello it will execute only when insafficientbalanceException happens");
     }
catch(IncorrectPinException e)
      {
    //System.out.println(e);
      e.printStackTrace();
 System.out.println("hello it will execute only when incorrectPinException happen");
       }
finally
        {//garentee of executing the code,if exception happens or not happens.
        System.out.println("thankyou for using our banking services,visit again");
                     }
 a.wellcome();
}
public void wellcome()
{
  System.out.println("wellcome to our bank hdfc");
}
}