/*
User class
⁃	integer Id
⁃	String username
⁃	String password
⁃	String name
⁃	Integer age
⁃	BankCard bankCard
Переопределить toString
 */

public class User extends BankCard{
    private Integer id;
    private String login;
    private String password;
    private String username;
    private Integer age;
    private BankCard bankCard;
    public User(){}
    public User(String data, String nameBank, String cvc, Double balance, BankType bankType, Integer id, String login,
                String password, String username, Integer age, BankCard bankCard){
        super(data, nameBank, cvc, balance, bankType);
        this.id = id;
        this.login = login;
        this.password = password;
        this.username = username;
        this.age = age;
        this.bankCard = bankCard;
    }
    public Integer getId(){
        return id;
    }
    public String getLogin(){
        return login;
    }
    public String getPassword(){
        return password;
    }
    public String getUsername(){
        return username;
    }
    public Integer getAge(){
        return age;
    }
    public BankCard getBankCard(){
        return bankCard;
    }
    public void setId(Integer id){
        this.id = id;
    }
    public void setLogin(String login){
        this.login = login;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public void setAge(Integer age){
        this.age = age;
    }
    public void setBankCard(BankCard bankCard){
        this.bankCard = bankCard;
    }
    @Override
    public String toString (){
        return getData()+" "+getNameBank()+" "+getCvc()+" "+getBalance()+" "+getBankType()+" "+id+" "+login+" "+password+" "+username+" "+age+" "+bankCard;
    }
}
