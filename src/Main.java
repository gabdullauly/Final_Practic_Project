/*
В Main class реализовать menu
1. Login ( введите логин и пароль чтобы зайти в юзер)
2. Создать user
3. Список всех user ов (выводит весь список с его банковской карточкой)
4. Exit
Хранить всех users в list
При успешном логине:
    1) Transfer money - создать метод который переводит деньги с юзера который залогинился к другому юзеру по его Id и сумма перевода.
    Если у вашего юзера не хватает баланса вывести сообщение- недостаточно баланса и вывести баланс
    2) edit user data (password, name, age) (Id, username неизменяемы)
    3) logout (возвращает на главное меню)
При create User
Через сканер ввести данные вручную через консоль  - user, bank
При создании объекта bank-    Вы вправе выбирать тип банка - только из вашего enum class
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Scanner scan = new Scanner(System.in);
    public static ArrayList<User> users = new ArrayList<>();
    public static void showUserList(){
        System.out.println("Список пользователей: ");
        for (int i=0; i< users.size(); i++){
            System.out.println("id:"+users.get(i));
        }
    }
    public static User getUserByLoginAndPass (String login, String password){
        for (int i=0; i<users.size(); i++){
            if (login.equals(users.get(i).getLogin()) && password.equals(users.get(i).getPassword())){
                return users.get(i);
            }
        }
        return null;
    }
    public static void createUser(){
        System.out.print("Введите логин: ");
        String login = scan.next();
        System.out.print("Введите пароль: ");
        String password = scan.next();
        System.out.print("Введите Имя: ");
        String username = scan.next();
        System.out.print("Введите возраст: ");
        Integer age = scan.nextInt();
        System.out.print("Введите срок действия карточки: ");
        String data = scan.next();
        System.out.print("Введите ФИО: ");
        String fullName = scan.next();
        System.out.print("Введите CVC карточки: ");
        String cvc = scan.next();
        System.out.print("Введите баланс карточки: ");
        Double balance = scan.nextDouble();
        System.out.println("Банк: ");
        System.out.println("1 - Kaspi");
        System.out.println("2 - Halyk");
        System.out.println("3 - Jusan");
        System.out.println("4 - Alpha");
        System.out.print("Выберите подходящий Вам банк: ");
        int type = scan.nextInt();
        BankType bankType = null;
        if (type==1){
            bankType = BankType.Kaspi;
        }else if (type==2){
            bankType = BankType.Halyk;
        }else if (type==3){
            bankType = BankType.Jusan;
        }else if (type==4){
            bankType = BankType.Alpha;
        }else {
            System.out.println("Введите корректное значение Банка!");
        }
        BankCard bankCard = new BankCard();
        bankCard.setData(data);
        bankCard.setFullName(fullName);
        bankCard.setCvc(cvc);
        bankCard.setBalance(balance);
        bankCard.setBankType(bankType);
        User user = new User();
        user.setId(users.size()+1);
        user.setLogin(login);
        user.setPassword(password);
        user.setUsername(username);
        user.setAge(age);
        user.setBankCard(bankCard);
        users.add(user);
        System.out.println("Пользователь успешно создан!");
    }
    public static User getUserById(Integer id){
        for (int i=0; i< users.size(); i++){
            if (id.equals(users.get(i).getId())){
                return users.get(i);
            }
        }
        return null;
    }
    public static void transferMoney(String login, String password){
        System.out.println("Меню денежных переводов: ");
        showUserList();
        System.out.print("Выберите id пользователя, которому хотите перевести: ");
        Integer id = scan.nextInt();
        System.out.print("Введите сумму перевода: ");
        Double balance = scan.nextDouble();
        User user = getUserById(id);
        if (user!=null){
            System.out.println("Вы собираетесь перевести средства пользователю "+user.getUsername()+" в размере "+balance);
            System.out.println("1 - Подтвердить");
            System.out.println("2 - Отмена");
            System.out.print("Подтверждение: ");
            Integer choice = scan.nextInt();
            if (choice==1){
                if (balance<getUserByLoginAndPass(login, password).getBankCard().getBalance()){
                    Double balance1 = getUserByLoginAndPass(login, password).getBankCard().getBalance()-balance;
                    getUserByLoginAndPass(login, password).getBankCard().setBalance(balance1);
                    Double balance2 = user.getBankCard().getBalance()+balance;
                    user.getBankCard().setBalance(balance2);
                    System.out.println("Перевод успешно завершен!");
                }else {
                    System.out.println("Не достаточно средств на балансе, Ваш баланс:"+getUserByLoginAndPass(login, password).getBankCard().getBalance());
                }
            }
            else if (choice==2){
                System.out.println("Отмена перевода!");
            }else {
                System.out.println("Введите корректную цифру!");
            }
        }
        else {
            System.out.println("Пользователь с id:"+id+" не найден!");
        }
    }
    public static void editUser(String login, String password){
        System.out.println("Меню редактирования данных:");
        System.out.print("Введите новый пароль: ");
        String password1 = scan.next();
        System.out.print("Введите Имя: ");
        String username = scan.next();
        System.out.print("Введите Возраст: ");
        Integer age = scan.nextInt();
        if (!password1.trim().isEmpty() && !username.trim().isEmpty() && age!=null){
            User user = getUserByLoginAndPass(login, password);
            user.setPassword(password1);
            user.setUsername(username);
            user.setAge(age);
            System.out.println("Данные успешно изменены!");
        }
    }
    public static void main(String[] args) {
        while (true){
            System.out.println("Mobil Bank Application's menu: ");
            System.out.println("1 - Авторизация");
            System.out.println("2 - Создать пользователя");
            System.out.println("3 - Показать список пользователей с банковской карточкой");
            System.out.println("4 - Выход");
            System.out.print("Выберите действие: ");
            Integer choice = scan.nextInt();
            if (choice==4){
                System.out.println("Завершение программы!");
                break;
            }else if (choice==1){
                System.out.print("Введите логин: ");
                String login = scan.next();
                System.out.print("Введите пароль: ");
                String password = scan.next();
                if (!login.trim().isEmpty() && !password.trim().isEmpty()){
                    User user = getUserByLoginAndPass(login, password);
                    if (user!=null){
                        while (true){
                            System.out.println("Меню пользователя "+getUserByLoginAndPass(login, password).getUsername());
                            System.out.println("1 - Денежные переводы");
                            System.out.println("2 - Редактирование данных пользователя");
                            System.out.println("3 - Выход с личного кабинета");
                            System.out.print("Выберите действие: ");
                            int choice1 = scan.nextInt();
                            if (choice1==3){
                                System.out.println("Выход!");
                                break;
                            }else if (choice1==1){
                                transferMoney(login, password);
                            }else if (choice1==2){
                                editUser(login, password);
                            }
                        }
                    }else {
                        System.out.println("Ошибка! Неверный логин или пароль.");
                    }
                }
            }else if (choice==2){
                createUser();
            }else if (choice==3){
                showUserList();
            }else{
                System.out.println("Ошибка! Введите корректную цифру из меню.");
            }
        }
    }
}