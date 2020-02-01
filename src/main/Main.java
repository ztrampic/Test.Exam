package main;

import domen.Projekat;
import domen.Zaposleni;
import exception.MyInputMismatchException;
import helper.FileProject;
import helper.FileZaposleni;
import helper.Helper;
import helper.MyTimeOut;
import menutext.MenuText;
import services.ServiceProjekat;
import services.ServiceProjekatImpl;
import services.ServiceZaposleni;
import services.ServiceZaposleniImpl;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static ServiceZaposleni serviceZaposleni;
    private static ServiceProjekat serviceProjekat;
    private static Helper helper;
    public static FileZaposleni fileZaposleni;
    public static FileProject fIleProject;

    public static void main(String[] args) throws IOException {
        initApplication();
        showMenu();
    }

    private static void initApplication() throws IOException {
        helper = new Helper();
        serviceZaposleni = new ServiceZaposleniImpl();
        serviceProjekat = new ServiceProjekatImpl();
        fileZaposleni = new FileZaposleni();
        fIleProject = new FileProject();
    }

    public static void showMenu() {
        int count = 3;
        Scanner sc;
        while (count > 0) {
            try {
                MenuText.showMainMenu();
                sc = new Scanner(System.in);
                int number = helper.validateInput(sc);
                switch (number) {
                    case 1:
                        zaposleniOptions();
                        break;
                    case 2:
                        projekatOptions();
                        break;
                    case 3:
                        count = MenuText.closeApp();;
                        break;
                    default:
                        System.err.println("Niste izabrali nista od ponudjenih opcija");
                        showMenu();
                        break;
                }
            } catch (MyInputMismatchException e) {
                count--;
                System.err.println(e.getMessage());
                if (count == 0) count = MenuText.closeApp();
            }
        }
    }

    private static void projekatOptions() {
        int count = 3;
        while (count > 0) {
            try {
                MenuText.showMenuOptionsProjekat();
                Scanner sc = new Scanner(System.in);
                int number = helper.validateInput(sc);
                switch (number) {
                    case 1:
                        serviceProjekat.saveProjekat();
                        break;
                    case 2:
//                        System.out.println(fIleProject.getProjekatList().toString());
                        break;
                    case 3:
                        List<Projekat> list = serviceProjekat.getAllProjekat();
                        list.stream().forEach(zaposleni -> System.out.println(zaposleni.toString()));
                        break;
                    case 4:
                        new MyTimeOut(3);
                        Main.showMenu();
                        break;
                    default:
                        System.err.println("Niste izabrali nista od ponudjenih opcija");
                        projekatOptions();
                        break;
                }
            } catch (MyInputMismatchException e) {
                count--;
                System.err.println(e.getMessage());
                if (count == 0) {
                    new MyTimeOut(3);
                    showMenu();
                }
            }
        }
    }

    public static void zaposleniOptions() {
        int count = 3;
        while (count > 0) {
            try {
                MenuText.showMenuOptionsZaposleni();
                Scanner sc = new Scanner(System.in);
                int number = helper.validateInput(sc);
                switch (number) {
                    case 1:
                        serviceZaposleni.saveZaposleni();
                        break;
                    case 2:
                        serviceZaposleni.updateZaposleni();
                        break;
                    case 3:
                        serviceZaposleni.deleteZaposleni();
                        break;
                    case 4:
                        List<Zaposleni> list = serviceZaposleni.getAllZaposleni();
                        list.stream().forEach(zaposleni -> System.out.println(zaposleni.toString()));
                        new MyTimeOut(3);
                        showMenu();
                        break;
                    case 5:
                        new MyTimeOut(3);
                        Main.showMenu();
                        break;
                    default:
                        System.err.println("Niste izabrali nista od ponudjenih opcija");
                        zaposleniOptions();
                        break;
                }

            } catch (MyInputMismatchException e) {
                count--;
                System.err.println(e.getMessage());
                if (count == 0) {
                    new MyTimeOut(3);
                    showMenu();
                }
            }
        }
    }

}
