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

    private final DAOZaposleni daoZaposleni;
    private final Helper helper;

    public ServiceZaposleniImpl() {
        daoZaposleni = new DAOZaposleni();;
        helper = new Helper();
    }
    @Override
    public void saveZaposleni() {
        Scanner sc;
        int numberOfTrys = 3;
        while (numberOfTrys > 0) {
            try {
                System.out.println("Unesite sifru zaposlenog.");
                sc = new Scanner(System.in);
                int sifra = helper.validateInput(sc);
                Zaposleni zaposleni = daoZaposleni.findBySifra(sifra);
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
        int numberOfTrys = 3;
        while (numberOfTrys > 0){
            try {
                System.out.println("Unesite sifru zaposlenog.");
                sc = new Scanner(System.in);
                int sifra = helper.validateInput(sc);
                Zaposleni zaposleni = daoZaposleni.findBySifra(sifra);
                if (zaposleni == null) {
                    numberOfTrys--;
                    System.out.println("Ne postoji zaposleni pod tom sifrom");
                } else {
                    daoZaposleni.softDelete(zaposleni);
                }
            }catch (MyInputMismatchException e){
                numberOfTrys--;
                System.err.println(e.getMessage());
                if (numberOfTrys == 0) new MyTimeOut(3);
            }
        }
    }

    @Override
    public List<Zaposleni> getAllZaposleni() {
        List<Zaposleni> list = daoZaposleni.getAll();
        return list;
    }

    @Override
    public Zaposleni findBySifra() {
        Scanner sc;
        int numberOfTrys = 3;
        while (numberOfTrys > 0){
            try {
                sc = new Scanner(System.in);
                System.out.println("Unesite sifru zaposlenog.");
                int sifra = helper.validateInput(sc);
                Zaposleni zaposleni = daoZaposleni.findBySifra(sifra);
                return zaposleni;
            } catch (MyInputMismatchException e) {
                numberOfTrys--;
                System.err.println(e.getMessage());
                if (numberOfTrys == 0) {
                    new MyTimeOut(3);
                    Main.zaposleniOptions();
                }
            }
        }
        return null;
    }

}
