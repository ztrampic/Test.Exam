package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import domen.Zaposleni;
import helper.Helper;
import helper.MyTimeOut;
import main.Main;

public class DAOZaposleni implements Dao<Zaposleni> {
    private final Helper helper;

    public DAOZaposleni() {
        helper = new Helper();
    }

    @Override
    public void save(Zaposleni entity) {
        Main.fileZaposleni.getList().add(entity);
        System.out.println("Usepesno sacuvan zaposleni");
        helper.updateFileZaposleni(Main.fileZaposleni.getList());
        Main.showMenu();
    }

    @Override
    public void softDelete(Zaposleni zaposleni) {
        List<Zaposleni> list = Main.fileZaposleni.getList();
        for (Zaposleni zaposleni2 : list) {
            if (zaposleni.getSifra() == zaposleni2.getSifra()) {
                zaposleni2.setDeleted(true);
                System.out.println("Uspesan Soft delete zaposlenog:" + " " + zaposleni2.toString());
            }
        }
        helper.updateFileZaposleni(list);
    }

    @Override
    public Zaposleni findBySifra(int sifra) {
        List<Zaposleni> list = Main.fileZaposleni.getList();
        Zaposleni zaposleni = list.stream().filter(zaposleni1 -> zaposleni1.getSifra() == sifra).findFirst()
                .orElse(null);
        return zaposleni;
    }


    @Override
    public void updat(Zaposleni zaposleni) {
        System.out.println("Zaposleni za uopdate :" + " " + zaposleni.toString());
        Scanner sc = new Scanner(System.in);
        System.out.println("Novo ime zaposlenog :");
        String ime = helper.validateEmptyString(sc, zaposleni.getIme());
        System.out.println("Unesite prezime zaposlenog.");
        String prezime = helper.validateEmptyString(sc, zaposleni.getPrezime());

        List<Zaposleni> list = Main.fileZaposleni.getList();
        for (Zaposleni z :
                list) {
            if (zaposleni.getSifra() == z.getSifra()) {
                z.setDeleted(false);
                z.setIme(ime);
                z.setPrezime(prezime);
            }
        }
        helper.updateFileZaposleni(list);
        System.out.println("Uspesno izmenjen zaposleni.");
        System.out.println("Novi podaci zaposlenog :" + " " + zaposleni.toString());
        new MyTimeOut(3);
        Main.showMenu();
    }

    @Override
    public List<Zaposleni> getAll() {
        List<Zaposleni> list = Main.fileZaposleni.getList();
        return list;
    }

}
