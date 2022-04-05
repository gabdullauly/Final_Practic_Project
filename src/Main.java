/*
В Main class реализовать menu
1.	Login ( введите логин и пароль чтобы зайти в юзер)
2.	Создать user
3.	Список всех user ов (выводит весь список с его банковской карточкой)
4.	Exit
Хранить всех users в list
При успешном логине:
    1) Transfer money - создать метод который переводит деньги с юзера который залогинился к другому юзеру по его Id и сумма перевода. Если у вашего юзера не хватает баланса вывести сообщение- недостаточно баланса и вывести баланс
    2) edit user data (password, name, age) (Id, username неизменяемы)
    3) logout (возвращает на главное меню)
При create User
Через сканер ввести данные вручную через консоль  - user, bank
При создании объекта bank-    Вы вправе выбирать тип банка - только из вашего enum class
 */

public class Main {
    public static void main(String[] args) {
        System.out.println("Mobil Bank Application's menu: ");
        System.out.println("1 - Авторизация");
        System.out.println("2 - Создать пользователя");
        System.out.println("3 - Авторизация");
    }
}
