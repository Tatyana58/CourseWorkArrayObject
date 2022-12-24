import java.util.Arrays;

/**
 * - **Базовая сложность**
 *     1. Создать класс Employee, который содержит информацию о Ф.И.O., отделе и зарплате сотрудника. Отделы для простоты должны быть названы от 1 до 5.
 *     2. Добавить статическую переменную-счетчик, которая будет отвечать за id.
 *     3. Добавить в класс Employee поле id, которое проставляется из счетчика, а затем счетчик увеличивает свое значение.
 *     4. Добавить возможность получать значения полей из Employee (геттеры) для всех полей.
 *     5. Добавить возможность устанавливать значения полей отдела и зарплаты (сеттеры).
 *     6. По умолчанию все поля должны передавать через конструктор (кроме id) и заполняться в нем (включая id, который нужно получить из счетчика).
 *     7. Создать внутри класса с методом main поле типа Employee[10], которое будет выполнять роль «хранилища» для записей о сотрудниках.
 *     8. Создать статические методы, которые будут взаимодействовать с массивом и предоставлять результат:
 *         1. Получить список всех сотрудников со всеми имеющимися по ним данными (вывести в консоль значения всех полей (toString)).
 *         2. Посчитать сумму затрат на зарплаты в месяц.
 *         3. Найти сотрудника с минимальной зарплатой.
 *         4. Найти сотрудника с максимальной зарплатой.
 *         5. Подсчитать среднее значение зарплат (можно использовать для этого метод из пункта b).
 *         6. Получить Ф. И. О. всех сотрудников (вывести в консоль).
 *
 *         - **Критерии оценки**
 *             – Корректно создан класс Employee.
 *             – Реализованы геттеры для всех полей класса.
 *             – Реализованы сеттеры для всех полей класса.
 *             – Создано поле типа Employee[10] для хранения записей о сотрудниках.
 *             – Созданы методы, которые корректно выводят информацию:
 *             - список всех сотрудников со всеми данными,
 *             - поиск сотрудника с минимальной зарплатой,
 *             - поиск сотрудника с максимальной зарплатой,
 *             - подсчет среднего значения зарплат,
 *             - список Ф. И. О. всех сотрудников.
 *
 *             – Программа работает корректно при изменении любых данных о сотрудниках и выводит верный результат.
 */
public class Main {
    static double sumAll=0;
    public static void main(String[] args) {
        System.out.println("Курсовая работа 1");
        Employee[] collegue = new Employee[10];
        collegue[0] = new Employee("Иванов ", "Дмитрий ", "Иванович ", 1, 4000);
        collegue[1] = new Employee("Сидоров ", "Сергей ", "Петрович ", 2, 1000);
        collegue[2] = new Employee("Лаврова ", "Любовь ", "Васильевна ", 4, 7000);
        collegue[3] = new Employee("Макеев ", "Александр ", "Андреевич ", 3, 2000);
        collegue[4] = new Employee("Юдина ", "Ольга ", "Борисовна ", 1, 3000);
        collegue[5] = new Employee("Сергеев ", "Юрий ", "Витальевич ", 5, 5000);
        collegue[6] = new Employee("Силантьева ", "Екатерина ", "Анатольевна ", 4, 80000);
        collegue[7] = new Employee("Криулина ", "Евгения ", "Валерьевна ", 4, 15000);
        collegue[8] = new Employee("Саркисьян ", "Лариса ", "Михайловна ", 4, 300.50);
        collegue[9] = new Employee("Гречав ", "Максим ", "Павлович ", 4, 6000);

        printInfo(collegue);
        printData(sumWages(collegue));
        printData(minWages(collegue));
        printData(maxWages(collegue));
        printData(averageSumWages(collegue));
        printCollegue(collegue);
        changesDepartment(collegue,7,1);
        changesWages(collegue,1,50000);
        searchCollegueDepartment(collegue,4);
        searchCollegueId(collegue,2);
    }

    // Список всех сотрудников со всеми имеющимися по ним данными (вывести в консоль значения всех полей (toString)).
    public static String printInfo(Employee[] collegue) {
        for (int i=0; i < collegue.length; i++) {
            System.out.println("Сотрудник № " + i + " " + collegue[i]);
        }return ""+collegue;
    }

    //Сумму затрат на зарплаты в месяц.
    public static double sumWages(Employee[] collegue) {
        double sum = 0;
        for (int i = 0; i < collegue.length ; i++) {
            sum += collegue[i].getWages();
        }System.out.print("Сумма затрат на зарплаты ");
        sumAll=sum;
        return sum;
    }

    //Поиск сотрудника с минимальной зарплатой.
    public static double minWages (Employee[] collegue) {
        double min = collegue[0].getWages();
        for (int i = 0; i < collegue.length; i++) {
            if (collegue[i].getWages() < min) {
                min=collegue[i].getWages();
            }
        }
        System.out.print("Минимальная заработная плата: ");
        return min;
    }

    //Поиск сотрудника с максимальной зарплатой.
    public static double maxWages (Employee[] collegue) {
        double max = collegue[0].getWages();
        for (int i = 0; i < collegue.length; i++) {
            if (collegue[i].getWages() > max) {
                max = collegue[i].getWages();
            }
        }
        System.out.print("Максимальная заработная плата: ");
        return max;
    }

    //Поиск среднего значения зарплат:
    public static double averageSumWages(Employee[] collegue) {
        sumAll=sumAll/ collegue.length;
        System.out.print("Среднее значение зарплат: ");
        return sumAll;
    }

    //Печать списка Ф. И. О. всех сотрудников.
    public static String printCollegue(Employee[] collegue){
        System.out.println("Список Ф.И.О сотрудников ");
        for (int i = 0; i < collegue.length; i++) {
            System.out.println("" + collegue[i].getSurname().toUpperCase() + "" + collegue[i].getName().toUpperCase() + "" + collegue[i].getPatronymic().toUpperCase());
        }
        return "";
    }

    //Замена номера отдела по id
    public static void changesDepartment(Employee[] collegue,int id, int x) {
        collegue[id].setDepartment(x);
        System.out.println("Изменили отдел сотруднику: " + collegue[id]);
    }

    //Изменение заработной платы по id
    public static void changesWages(Employee[] collegue,int id, double x) {
        collegue[id].setWages(x);
        System.out.println("Изменили заработную плату сотруднику: " + collegue[id]);
    }

    //Поиск сотрудника по отделу
    public static String searchCollegueDepartment(Employee[] collegue, int x) {
        for (int i = 0; i < collegue.length; i++) {
            if (collegue[i].getDepartment() == x) {
                System.out.println("В отделе " + x + " работает сотрудник " + collegue[i].getSurname() + "" + collegue[i].getName() + "" + collegue[i].getPatronymic());
            }
        }
        return "";
    }

    //Поиск сотрудника по id
    public static String searchCollegueId(Employee[] collegue, int x) {
        for (int i = 0; i < collegue.length; i++) {
            if (collegue[i].getId() == x) {
                System.out.println("Сотрудник с ID " + x + " - " + collegue[i].getSurname() + "" + collegue[i].getName() + "" + collegue[i].getPatronymic());
            }
        }
        return "";
    }

    //Печать данных
    public static double printData(double data) {
        System.out.println(data);
        return data;
    }
}