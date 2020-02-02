package helper;

import domen.AngazovanjeNaProjektu;
import domen.Projekat;
import domen.Zaposleni;
import enums.Uloga;
import exception.MyInputMismatchException;
import menutext.MenuText;

import java.io.File;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Helper {


    public int validateInput(Scanner sc) {
        try {
            int number = sc.nextInt();
            return number;
        } catch (Exception e) {
            throw new MyInputMismatchException();
        }
    }

    public String validateEmptyString(Scanner sc, String ime) {
        String validate = sc.nextLine();
        if(validate.equals("")){
            return ime;
        }
        return validate;
    }

    public void updateFileZaposleni(List<Zaposleni> list){
        try (PrintWriter writer = new PrintWriter(new File("fileZaposleni.txt"))){
            for (Zaposleni z:list) {
                writer.write(String.valueOf(z.getSifra()));
                writer.write(";");
                writer.write(String.valueOf(z.getIme()));
                writer.write(";");
                writer.write(String.valueOf(z.getPrezime()));
                writer.write(";");
                writer.write(String.valueOf(z.isDeleted()));
                writer.println();
            }
        }catch (Exception e){
            e.getMessage();
        }
    }

    public Date convertAndFormatStringToDate(String s) throws ParseException {
        Date formater = new SimpleDateFormat("dd.MM.yyyy").parse(s);
        return formater;
    }
    public String convertAndFormatDateToString(Date date) throws ParseException {
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        return df.format(date);
    }

    public void updateFileProject(List<Projekat> list) {
        try (PrintWriter writer = new PrintWriter(new File("fileProject.txt"))){
            for (Projekat pro:list) {
                writer.write(String.valueOf(pro.getSifra()));
                writer.write(";");
                writer.write(String.valueOf(pro.getNaziv()));
                writer.write(";");
                writer.write(convertAndFormatDateToString(pro.getDatumOd()));
                writer.write(";");
                writer.write(convertAndFormatDateToString(pro.getDatumDo()));
                writer.println();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void updateFileAngazovanja(List<AngazovanjeNaProjektu> list) {
        try (PrintWriter writer = new PrintWriter(new File("fileAngazovanja.txt"))){
            for (AngazovanjeNaProjektu a:list) {
                writer.write(String.valueOf(a.getBrojRadnihSati()));
                writer.write(";");
                writer.write(convertAndFormatDateToString(a.getDatumOd()));
                writer.write(";");
                writer.write(convertAndFormatDateToString(a.getDatumDo()));
                writer.write(";");
                writer.write(String.valueOf(a.getSifraProjekat()));
                writer.write(";");
                writer.write(String.valueOf(a.getSifraZaposlenog()));
                writer.write(";");
                writer.write(String.valueOf(a.getUloga().ordinal()));
                writer.println();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Uloga checkUloga(int uloga) {
        switch (uloga){
            case 0:
                return Uloga.RUKOVODILAC;
            default:
                return Uloga.RUKOVODILAC;
        }
    }

    public Uloga setUlogaOnProject(Scanner sc) {
        int numberOfTrys = 3;
        while (numberOfTrys > 0) {
            try {
                MenuText.showUlogaMenu();
                int number = validateInput(sc);
                switch (number) {
                    case 1:
                        return Uloga.RUKOVODILAC;
                    case 2:
                        return Uloga.DEVELOPER;
                    default:
                        return Uloga.DEVELOPER;
                }
            } catch (MyInputMismatchException e) {
                numberOfTrys--;
                System.err.println(e.getMessage());
                if (numberOfTrys == 0) return null;
            }
        }
        return null;
    }

    public List<Projekat> doRelations(List<AngazovanjeNaProjektu> angazovanja, List<Projekat> projects) {
        for (AngazovanjeNaProjektu angaz:angazovanja){
            for (Projekat p : projects) {
                if(p.getSifra() == angaz.getSifraProjekat()){
                    p.addAngazovanje(angaz);
                }
            }
        }
        return projects;
    }
}
