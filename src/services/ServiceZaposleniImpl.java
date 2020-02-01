package services;

import java.util.List;
import java.util.Scanner;

import dao.DAOZaposleni;
import dao.Dao;
import domen.Zaposleni;
import exception.MyInputMismatchException;
import exception.MyNoSuchElementException;
import helper.Helper;
import helper.MyTimeOut;
import main.Main;

public class ServiceZaposleniImpl implements ServiceZaposleni {

    private DAOZaposleni daoZaposleni = new DAOZaposleni();
    private Helper helper = new Helper();

    @Override
    public void saveZaposleni() {
        Scanner sc;
        Zaposleni zaposleni = null;
        int numberOfTrys = 3;
        while (numberOfTrys > 0) {
            System.out.println("Unesite sifru zaposlenog.");
            sc = new Scanner(System.in);
            try {
                int sifra = helper.validateInput(sc);
                zaposleni = daoZaposleni.findBySifra(sifra);
                if (zaposleni == null) {
                    Zaposleni newZaposleni = new Zaposleni();
                    sc = new Scanner(System.in);
                    System.out.println("Unesite ime zaposlenog.");
                    String ime = sc.next();
                    System.out.println("Unesite prezime zaposlenog.");
                    String prezime = sc.next();
                    newZaposleni.setDeleted(false);
                    newZaposleni.setIme(ime);
                    newZaposleni.setPrezime(prezime);
                    newZaposleni.setSifra(sifra);
                    daoZaposleni.save(newZaposleni);
                } else {
                    System.err.println("Vec postoji zaposleni pod tom sifrom.");
                    saveZaposleni();
                }
            } catch (MyInputMismatchException e) {
                numberOfTrys--;
                System.err.println(e.getMessage());
                if (numberOfTrys == 0) new MyTimeOut(3);
            }
        }

    }

    @Override
    public void updateZaposleni() {
        Scanner sc;
        Zaposleni zaposleni = new Zaposleni();
        int numberOfTrys = 3;
        while (numberOfTrys > 0) {
            try {
                sc = new Scanner(System.in);
                System.out.println("Unesite sifru zaposlenog.");
                int sifra = helper.validateInput(sc);
                zaposleni = daoZaposleni.findBySifra(sifra);
                if (zaposleni == null) {
                    System.out.println("Ne postoji zaposleni pod tom sifrom");
                } else {
                    daoZaposleni.updat(zaposleni);
                }
            } catch (MyInputMismatchException e) {
                numberOfTrys--;
                System.err.println(e.getMessage());
                if (numberOfTrys == 0) {
                    new MyTimeOut(3);
                    Main.zaposleniOptions();
                }

            }

        }
    }

    @Override
    public void deleteZaposleni() {
        Scanner sc;
        System.out.println("Unesite sifru zaposlenog.");
        sc = new Scanner(System.in);
        int sifra = sc.nextInt();
        Zaposleni zaposleni = daoZaposleni.findBySifra(sifra);
        if (zaposleni == null) {
            System.out.println("Ne postoji zaposleni pod tom sifrom");
        } else {
            daoZaposleni.softDelete(zaposleni);
        }
    }

    @Override
    public List<Zaposleni> getAllZaposleni() {
        List<Zaposleni> list = daoZaposleni.getAll();
        return list;
    }

}
