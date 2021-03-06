package mainPackage.dbQuerys;

import mainPackage.CheckValidData;
import mainPackage.Connections;
import mainPackage.Doctor;
import mainPackage.SwithMenu;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DBQueryDoctors {
    public static final String tableName = "Doctors";

    public static List<Doctor> getAllDoctors(Connection connectTo) throws SQLException {
        ArrayList<Doctor> doctors = new ArrayList<>();
        try (Statement statement = connectTo.createStatement()) {
            ResultSet rs = statement.executeQuery("select doctorId, firstName, lastName, profession from Doctors");
            while (rs.next()) {
                int d = rs.getInt(1);
                String fName = rs.getString(2);
                String lName = rs.getString(3);
                String prof = rs.getString(4);
                System.out.println("Номер: " + d + " фамилия: " + fName + " имя: " + lName + " специлиализация: " + prof);
                Doctor doc = new Doctor(d, fName, lName, prof);
                doctors.add(doc);
            }
        }
        return doctors;
    }

    public static void printDoctors(List<Doctor> connectTo) {
        for (Doctor doc : connectTo) {
            System.out.println(doc);
        }
    }

    public static void addDoctorYourself(Connection connectTo, Doctor doc) {  //добавление доктора с параметрами вручную
        try {
            PreparedStatement preparedStatement = connectTo.prepareStatement("insert into Doctor(firstName, lastName, profession)" +
                    "values(?,?,?)");
            preparedStatement.setString(1, doc.getFirstName());
            preparedStatement.setString(2, doc.getLastName());
            preparedStatement.setString(3, doc.getProfession());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addNewDoctor(Connection connectTo) {
        try (Statement statement = connectTo.createStatement()) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("\nВведите фамилию нового доктора : ");
            System.out.println("Для отмены Введите - Отмена");
            String str2;
            do {
                str2 = bufferedReader.readLine();
                if (str2.equals("Отмена")) {
                    SwithMenu.sW_Menu_2();
                }
                if (!CheckValidData.isName(str2)) {
                    System.out.println("Неверный формат повторите");
                }
            }while (!CheckValidData.isName(str2));

            System.out.println("Введите имя нового доктора : ");
            String str3;
            do {
                str3 = bufferedReader.readLine();
                if (str3.equals("Отмена")) {
                    SwithMenu.sW_Menu_2();
                }
                if (!CheckValidData.isName(str3)) {
                    System.out.println("Неверный формат повторите");
                }
            }while (!CheckValidData.isName(str3));

            System.out.println("Введите специализацию нового доктора : ");
            String str4 = bufferedReader.readLine();
            if (str4.equals("Отмена")) {
                SwithMenu.sW_Menu_2();
            }
            statement.executeUpdate("insert into Doctors (firstName, lastName, profession)" +
                    " values ('" + str2 + "','" + str3 + "', '" + str4 + "')");
//            System.out.println("DBQueryDoctors.addNewDoctor(); -- " + str2 + " " + str3 + " " + str4);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void editOneDoctor(Connection connectTo) {
        try {
            Statement statement = connectTo.createStatement();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            DBQueryDoctors.printDoctors(DBQueryDoctors.getAllDoctors(Connections.connectTo()));
            System.out.println("\nВведите фамилию доктора на изменение данных");
            System.out.println("Для отмены Введите - Отмена");
            String fNameForEdit;
            do {
                fNameForEdit = bufferedReader.readLine();
                if (fNameForEdit.equals("Отмена")) {
                    SwithMenu.sW_Menu_4();
                }
                if (!CheckValidData.isName(fNameForEdit)) {
                    System.out.println("Неверный формат повторите");
                }
            }while (!CheckValidData.isName(fNameForEdit));

            System.out.println("Редактирование фамилии ");
            String newFirstName;
            do {
                newFirstName = bufferedReader.readLine();
                if (newFirstName.equals("Отмена")) {
                    SwithMenu.sW_Menu_4();
                }
                if (!CheckValidData.isName(newFirstName)) {
                    System.out.println("Неверный формат повторите");
                }
            }while (!CheckValidData.isName(newFirstName));

            System.out.println("Редактирование имени ");
            String newLastName;
            do {
                newLastName = bufferedReader.readLine();
                if (newLastName.equals("Отмена")) {
                    SwithMenu.sW_Menu_4();
                }
                if (!CheckValidData.isName(newLastName)) {
                    System.out.println("Неверный формат повторите");
                }
            }while (!CheckValidData.isName(newLastName));
            System.out.println("Редактирование специализации ");
            String newSpecilization = bufferedReader.readLine();
            if (newSpecilization.equals("Отмена")) {
                SwithMenu.sW_Menu_4();
            }
            statement.executeUpdate("update Doctors set firstName = '" + newFirstName + "',lastName = '" + newLastName + "',profession  = '" + newSpecilization + "' where firstName = '" + fNameForEdit + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void deleteOneDoctor(Connection connectTo) throws IOException {
        try (Statement statement = connectTo.createStatement()) {
            Scanner scanner = new Scanner(System.in);
            DBQueryDoctors.printDoctors(DBQueryDoctors.getAllDoctors(Connections.connectTo()));
            System.out.println("\nВведите фамилию доктора которого удалить из базы: ");
            System.out.println("для отмены введите - Отмена");
            String str;
            do {
                str = scanner.nextLine();
                if (str.equals("Отмена")) {
                    SwithMenu.sW_Menu_3();
                }
                if (!CheckValidData.isName(str)) {
                    System.out.println("Неверный формат");
                }
            }while (!CheckValidData.isName(str));

            statement.executeUpdate("delete from Doctors where firstName='" + str + "'");
//            System.out.println("DBQueryDoctors::deleteOneDoctor(); -- " + str);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

