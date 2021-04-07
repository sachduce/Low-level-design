package ATM;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

class ATM {
    int atmId;
    Address address;
    CashDispenser cashDispenser;
    Keypad keypad;
    Screen screen;
    CardReader cardReader;
    CashDeposit cashDeposit;
    ChequeDeposit chequeDeposit;
    BankService bankService;
}

class Address{
    String country;
    String state;
    String city;
    String street;
    String pinCode;
}

class CashDispenser{
    Map<CashType, List<Cash>> cashAvailable;
    public void dispenseCash(int amount){};
}

enum CashType{
    FIFTY, HUNDRED, FIVEHUNDRED;
}

class Cash{
    String serialNumber;
    CashType cashType;
}

class Screen{
    public void display(String message){};
}

class CardReader{
    public CardInfo fetchCardDetails(){
        return new CardInfo();
    };
}

class CardInfo{
    CardType cardType;
    Bank bank;
    String cardNumber;
    int cvv;
    Date expirationDate;
}

enum CardType{
    CREDIT, DEBIT;
}

class Keypad{
    public String getInput(){return "abc";}
}

class Bank{
    String name;
    Address address;
    List<ATM> atmList;
}

interface BankService{
    public Boolean isValidUser(String pin, CardInfo cardInfo);
    public Customer getCustomerDetails(CardInfo cardInfo);
    public TransactionDetail executeTransaction(Transaction transactioInfo, Customer customer);
}

class BankA implements BankService{
    public Boolean isValidUser(String pin, CardInfo cardInfo){ return true;};
    public Customer getCustomerDetails(CardInfo cardInfo){
        return new Customer();
    };
    public TransactionDetail executeTransaction(Transaction transactioInfo, Customer customer){
        return new TransactionDetail();
    };
}

class BankB implements BankService{
    public Boolean isValidUser(String pin, CardInfo cardInfo){ return true;};
    public Customer getCustomerDetails(CardInfo cardInfo){
        return new Customer();
    };
    public TransactionDetail executeTransaction(Transaction transactioInfo, Customer customer){
        return new TransactionDetail();
    };
}

class BankServiceFactory{
    // Runtime polymorphism
    public BankService getBankService(CardInfo cardInfo){
        return new BankA();
    };
}

class Customer{
    String firstNamme;
    String lastName;
    CardInfo cardInfo;
    Account account;
    BankService bankServiceObj;
    CustomerStatus customerStatus;
}

class Account{
    String accountNumber;
    float availableBalance;
}

enum CustomerStatus{
    BLOCKED, ACTIVE, CLOSED
}

class Transaction{
    Integer transactionId;
    String sourceAccount;
    Date transactionDate;
}

class Deposit extends Transaction{
    float amount;
}

class CashDeposit extends Deposit{
    public List<Cash> getCash(){
        return new ArrayList<Cash>();
    };
}

class ChequeDeposit extends Deposit{
    public Cheque getCheque(){
        return new Cheque();
    };
}

class Withdraw extends Transaction{
    float amount;
}

class Transfer extends Transaction{
    String destAccount;
    float amount;
}

class TransactionDetail{
    TransactionStatus transactionStatus;
    int transactionId;
    Date transactionDate;
    String sourceAccountNumber;
    TransactionType transactionType;
}

enum TransactionStatus{
    PENDING, CANCELLED, SUCCESS, ERROR
}

enum TransactionType{
    WITHDRAW, DEPOSIT, TRANSFER
}

class Cheque{
    String chequeNumber;

}