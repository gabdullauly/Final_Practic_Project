/*
BankCard class
⁃	String data (04/25)
⁃	String name
⁃	String cv (123)
⁃	Double balance
⁃	BankType banktype
Переопределить toString
 */

public class BankCard {
    private String data;
    private String nameBank;
    private String cvc;
    private Double balance;
    private BankType bankType;
    public BankCard(){}
    public BankCard(String data, String nameBank, String cvc, Double balance, BankType bankType){
        this.data = data;
        this.nameBank = nameBank;
        this.cvc = cvc;
        this.balance = balance;
        this.bankType = bankType;
    }
    public String getData(){
        return data;
    }
    public String getNameBank(){
        return nameBank;
    }
    public String getCvc(){
        return cvc;
    }
    public Double getBalance(){
        return balance;
    }
    public BankType getBankType(){
        return bankType;
    }
    public void setData(String data){
        this.data = data;
    }
    public void setName(String nameBank){
        this.nameBank = nameBank;
    }
    public void setCvc(String cvc){
        this.cvc = cvc;
    }
    public void setBalance(Double balance){
        this.balance = balance;
    }
    public void setBankType(BankType bankType){
        this.bankType = bankType;
    }
    @Override
    public String toString (){
        return data+" "+nameBank+" "+cvc+" "+balance+" "+bankType;
    }
}
