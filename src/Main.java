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
    static double sumAllDepartment=0;
    static int indexCollegueDepartment = 0;
    static int numerDepartment = 0;
    public static void main(String[] args) {
        System.out.println("Курсовая работа 1");
        Employee[] collegue = new Employee[10];
        collegue[0] = new Employee("Иванов ", "Дмитрий ", "Иванович ", 5, 4000);
        collegue[1] = new Employee("Сидоров ", "Сергей ", "Петрович ", 2, 1000);
        collegue[2] = new Employee("Лаврова ", "Любовь ", "Васильевна ", 4, 7000);
        collegue[3] = new Employee("Макеев ", "Александр ", "Андреевич ", 3, 2000);
        collegue[4] = new Employee("Юдина ", "Ольга ", "Борисовна ", 1, 3000);
        collegue[5] = new Employee("Сергеев ", "Юрий ", "Витальевич ", 5, 5000);
        collegue[6] = new Employee("Силантьева ", "Екатерина ", "Анатольевна ", 4, 80000);
        collegue[7] = new Employee("Криулина ", "Евгения ", "Валерьевна ", 4, 15000);
        collegue[8] = new Employee("Саркисьян ", "Лариса ", "Михайловна ", 4, 300.50);
        collegue[9] = new Employee("Гречав ", "Максим ", "Павлович ", 4, 6000);

        printInfo(collegue);                                    //Список всех сотрудников со всеми имеющимися по ним данными
        printData(sumWages(collegue));                          //Сумму затрат на зарплаты в месяц.
        printData(minWages(collegue));                          //Поиск сотрудника с минимальной зарплатой.
        printData(maxWages(collegue));                          //Поиск сотрудника с максимальной зарплатой.
        printData(averageSumWages(collegue));                   //Поиск среднего значения зарплат:
        printCollegue(collegue);                                //Печать списка Ф. И. О. всех сотрудников.
        changesDepartment(collegue,7,1);           //Замена номера отдела по id
        changesWages(collegue,1,50000);               //Изменение заработной платы по id
        searchCollegueDepartment(collegue,5);         //Поиск сотрудников по отделу
        searchCollegueId(collegue,2);                        //Поиск сотрудника по id
        indexWages(collegue,3);                          //Индексация заработной платы в %
        sumWagesMonthDepartment(collegue,4);          //Сумму затрат на зарплаты в месяц по отделу.
        averageSumWagesDepartment(collegue,5);        //Среднюю зарплату по отделу (учесть, что количество людей в отделе отличается от employees.length).
        percentWagesDepartment(collegue,4,2);  //Проиндексировать зарплату всех сотрудников отдела на процент, который приходит в качестве параметра.

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
        }
        System.out.print("Сумма затрат на зарплаты ");
        sumAll=sum;
        return sum;
    }

    //Поиск сотрудника с минимальной зарплатой.
    public static double minWages (Employee[] collegue) {
        int index = 0;
        double min = collegue[0].getWages();
        for (int i = 0; i < collegue.length; i++) {
            if (collegue[i].getWages() < min) {
                min=collegue[i].getWages();
                index=i;
            }
        }
        System.out.print("Минимальная заработная плата у сотрудника : " + collegue[index].getSurname() + "" + collegue[index].getName() + "" + collegue[index].getPatronymic() + " - ");
        return min;
    }

    //Поиск сотрудника с максимальной зарплатой.
    public static double maxWages (Employee[] collegue) {
        int indexMax = 0;
        double max = collegue[0].getWages();
        for (int i = 0; i < collegue.length; i++) {
            if (collegue[i].getWages() > max) {
                max = collegue[i].getWages();
                indexMax=i;
            }
            //System.out.print("Максимальная заработная плата у сотрудника :" + collegue[indexMax].getSurname() + "" + collegue[indexMax].getName() + "" + collegue[indexMax].getPatronymic() + " - ");
        }
        System.out.print("Максимальная заработная плата у сотрудника :" + collegue[indexMax].getSurname() + "" + collegue[indexMax].getName() + "" + collegue[indexMax].getPatronymic() + " - ");
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
    public static void changesDepartment(Employee[] collegue,int id, int department) {
        collegue[id].setDepartment(department);
        System.out.println("Изменили отдел сотруднику: " + collegue[id]);
    }

    //Изменение заработной платы по id
    public static void changesWages(Employee[] collegue,int id, double percent) {
        collegue[id].setWages(percent);
        System.out.println("Изменили заработную плату сотруднику: " + collegue[id]);
    }

    //Поиск сотрудников по отделу
    public static String searchCollegueDepartment(Employee[] collegue, int department) {
        for (int i = 0; i < collegue.length; i++) {
            if (department < 6 && department >0 ) {
                if (collegue[i].getDepartment() == department) {
                    System.out.println("В отделе " + department + " работает сотрудник " + collegue[i].getSurname() + "" + collegue[i].getName() + "" + collegue[i].getPatronymic());
                }
            }else {
                System.out.println("Такого отдела не существует. Введите правильной номер отдела.");
                return "";
            }
        }
        return "";
    }

    //Поиск сотрудника по id
    public static String searchCollegueId(Employee[] collegue, int id) {
        for (int i = 0; i < collegue.length; i++) {
            if (collegue[i].getId() == id) {
                System.out.println("Сотрудник с ID " + id + " - " + collegue[i].getSurname() + "" + collegue[i].getName() + "" + collegue[i].getPatronymic());
            }
        }
        return "";
    }

    //Индексация заработной платы в %
    public static double indexWages(Employee[] collegue, int percent) { //x- процент увеличения зп
        double y = 0d;
        for (int i=0; i < collegue.length; i++) {
            y =collegue[i].getWages()+ collegue[i].getWages() * percent / 100;
            collegue[i].setWages(y);
            System.out.println("Индексация зп на " + percent + " %  сотруднику : "+ collegue[i].getSurname() + "" + collegue[i].getName() + "" + collegue[i].getPatronymic() + " зп = " + collegue[i].getWages());
        }
        return y;
    }

    //Сумму затрат на зарплаты в месяц по отделу.
    public static double sumWagesMonthDepartment(Employee[] collegue,int department) {
        indexCollegueDepartment=0;
        double sum = 0;
            if (department < 6 && department > 0) {
                for (int i = 0; i < collegue.length; i++) {
                    if (collegue[i].getDepartment() == department) {
                        sum += collegue[i].getWages();
                        sumAllDepartment = sum;
                        indexCollegueDepartment++;
                    }
                }
                System.out.println("Сумма затрат на зарплаты в отделе " + department +" = "+ sum);
            }
            else {
                System.out.println("Такого отдела не существует. Введите правильной номер отдела.");
                return sum;
            }
        return sum;
    }

    //Среднюю зарплату по отделу (учесть, что количество людей в отделе отличается от employees.length).
    public static double averageSumWagesDepartment(Employee[] collegue,int department) {
        sumWagesMonthDepartment(collegue,department);
        double averageSumAllDepartment = 0;
        averageSumAllDepartment=sumAllDepartment/indexCollegueDepartment;
        System.out.println("Средняя зарплата по отделу " + department + " = " + + averageSumAllDepartment);
        return averageSumAllDepartment;
    }

    //Проиндексировать зарплату всех сотрудников отдела на процент, который приходит в качестве параметра.
    public static double percentWagesDepartment(Employee[] collegue, int department,int percent){
        double y=0;
            if (department > 0 && department < 6) {
                for (int i = 0; i <collegue.length; i++) {
                    if (collegue[i].getDepartment() == department) {
                        y = collegue[i].getWages() + collegue[i].getWages() * percent / 100;
                        collegue[i].setWages(y);
                        System.out.println("Индексация зп на " + percent + " %  сотруднику : " + collegue[i].getSurname() + "" + collegue[i].getName() + "" + collegue[i].getPatronymic() + " зп = " + collegue[i].getWages());
                    }
                }
            }else {
                System.out.println("Такого отдела не существует. Введите правильной номер отдела.");
                return y;
            }
        return y;
    }


    //Печать данных
    public static double printData(double data) {
        System.out.println(data);
        return data;
    }
}