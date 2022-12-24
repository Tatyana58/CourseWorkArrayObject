import java.util.Arrays;

/**Повышенная сложность

 Создать дополнительные статические методы для решения следующих задач.

 1. Проиндексировать зарплату (вызвать изменение зарплат у всех сотрудников на величину аргумента в %).
 2. Получить в качестве параметра номер отдела (1–5) и найти (всего 6 методов):
 1. Сотрудника с минимальной зарплатой.
 2. Сотрудника с максимальной зарплатой.
 3. Сумму затрат на зарплату по отделу.
 4. Среднюю зарплату по отделу (учесть, что количество людей в отделе отличается от employees.length).
 5. Проиндексировать зарплату всех сотрудников отдела на процент, который приходит в качестве параметра.
 6. Напечатать всех сотрудников отдела (все данные, кроме отдела).
 3. Получить в качестве параметра число и найти:
 1. Всех сотрудников с зарплатой меньше числа (вывести id, Ф. И. О. и зарплатой в консоль).
 2. Всех сотрудников с зарплатой больше (или равно) числа (вывести id, Ф. И. О. и зарплатой в консоль).

 - Критерии оценки
 – С помощью **шести** методов можно вывести данные:
 - сотрудник с минимальной зарплатой,
 - сотрудник с максимальной зарплатой,
 - сумма затрат на зарплату по отделу,
 - средняя зарплата по отделу,
 - индексация зарплаты на %,
 - печать всех данных всех сотрудников одного отдела, кроме номера отдела.
 – Реализован параметр поиска всех сотрудников с зарплатой больше определенного числа, которое можно указать.
 – Реализован параметр поиска всех сотрудников с зарплатой меньше определенного числа, которое можно указать.
 – Программа работает корректно при изменении любых данных о сотрудниках и выводит верный результат.
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
        indexWages(collegue,3);
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
        System.out.println("Список Ф.И.О всех сотрудников ");
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

    //Индексация заработной платы в %
    public static double indexWages(Employee[] collegue, int x) { //x- процент увеличения зп
        double y = 0d;
        for (int i=0; i < collegue.length; i++) {
            y =collegue[i].getWages()+ collegue[i].getWages() * x / 100;
            collegue[i].setWages(y);
            System.out.println("Индексация зп на " + x + " %  сотруднику : "+ collegue[i].getSurname() + "" + collegue[i].getName() + "" + collegue[i].getPatronymic() + " зп = " + collegue[i].getWages());
        }
        return y;
    }

    //Печать данных
    public static double printData(double data) {
        System.out.println(data);
        return data;
    }
}