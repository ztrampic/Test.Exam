package services;

import dao.DAOAngazovanja;
import dao.DAOZaposleni;
import domen.AngazovanjeNaProjektu;
import domen.Projekat;
import domen.Zaposleni;
import exception.MyInputMismatchException;
import helper.Helper;
import helper.MyTimeOut;
import main.Main;
import menutext.MenuText;

import java.text.ParseException;
import java.util.Scanner;

public class ServiceAngazovanjaImpl implements ServiceAngazovanja{
    private Helper helper = new Helper();
    private DAOZaposleni daoZaposleni = new DAOZaposleni();
    private DAOAngazovanja daoAngazovanja = new DAOAngazovanja();

    @Override
    public void createNewAngazovanje(Projekat projekat) {
        int numberOfTrys = 3;
        Scanner sc;
        while (numberOfTrys > 0) {
            try {
                sc = new Scanner(System.in);
                System.out.println("Unesite sifru zaposlenog");
                int sifra = helper.validateInput(sc);
                Zaposleni zaposleni = daoZaposleni.findBySifra(sifra);
                if(zaposleni != null){
                    AngazovanjeNaProjektu angazovanjeNaProjektu = createNewAngazovanja(projekat,zaposleni);
                    daoAngazovanja.save(angazovanjeNaProjektu);
                    chooseNextStep(projekat);

                }else {
                    numberOfTrys--;
                    System.err.println("Ne postoji zaposleni pod tom sifrom.");
                }
            }catch (MyInputMismatchException | ParseException e){
                numberOfTrys--;
                System.err.println(e.getMessage());
            }
        }
    }

    private void chooseNextStep(Projekat projekat) {
        int numberOfTrys = 3;
        Scanner sc;
        while (numberOfTrys > 0){
          try {
              sc = new Scanner(System.in);
              MenuText.choseNextStep();
              int choise = helper.validateInput(sc);
              switch (choise){
                  case 1:
                      createNewAngazovanje(projekat);
                      break;
                  case 2:
                      new MyTimeOut(3);
                      Main.showMenu();
                      break;
                  default:
                      System.out.println("Niste nista odabrali od ponudjenog.");
                      numberOfTrys--;
                      return;
              }
          }catch (MyInputMismatchException e){
              System.err.println(e.getMessage());
              if (numberOfTrys == 0) new MyTimeOut(3); Main.showMenu();
          }
        }
    }

    private AngazovanjeNaProjektu createNewAngazovanja(Projekat projekat, Zaposleni zaposleni) throws ParseException {
        AngazovanjeNaProjektu angazovanjeNaProjektu = new AngazovanjeNaProjektu();
        angazovanjeNaProjektu.setSifraZaposlenog(zaposleni.getSifra());
        angazovanjeNaProjektu.setSifraProjekat(projekat.getSifra());
        Scanner sc =new Scanner(System.in);
        System.out.println("Unesite broj radnih sati zaposlenog na projektu.");
        int numberOfTrys = 3;
        while(numberOfTrys > 0){
            try {
                sc = new Scanner(System.in);
                int brRadnihSati = helper.validateInput(sc);
                angazovanjeNaProjektu.setBrojRadnihSati(Double.parseDouble(String.valueOf(brRadnihSati)));
                numberOfTrys = 0;
            }catch (MyInputMismatchException e){
                numberOfTrys--;
                System.out.println(e.getMessage());
                if (numberOfTrys == 0) createNewAngazovanje(projekat);
            }
        }
        System.out.println("Unesite pocetak rada zaposlenog na projektu. Format datuma je [ dd.MM.yyyy ].");
        String dateFrom = sc.next();
        angazovanjeNaProjektu.setDatumOd(helper.convertAndFormatStringToDate(dateFrom));
        System.out.println("Unesite kraj rada zaposlenog na projektu. Format datuma je [ dd.MM.yyyy ].");
        String dateTo = sc.next();
        angazovanjeNaProjektu.setDatumDo(helper.convertAndFormatStringToDate(dateTo));
        angazovanjeNaProjektu.setUloga(helper.setUlogaOnProject(sc));
        return angazovanjeNaProjektu;
    }
}
