package dao;

import domen.Projekat;
import domen.Zaposleni;
import helper.Helper;
import main.Main;

import java.util.List;

public class DAOProject implements Dao<Projekat> {
    private Helper helper = new Helper();

    @Override
    public void save(Projekat project) {
        System.err.println("PRE DODAVANJA"+" "+Main.fIleProject.getProjekatList().size());
        Main.fIleProject.getProjekatList().add(project);
        System.err.println("POSLE DODAVANJA"+" "+Main.fIleProject.getProjekatList().size());
        System.out.println("Usepesno sacuvan projekat.");
        List<Projekat> list = Main.fIleProject.getProjekatList();
        helper.updateFileProject(list);
        Main.showMenu();

    }

    @Override
    public void softDelete(Projekat entity) {
        // TODO Auto-generated method stub

    }

    @Override
    public void updat(Projekat entity) {


    }

    @Override
    public List<Projekat> getAll() {
        return Main.fIleProject.getProjekatList();
    }

    public Projekat findBySifra(int sifra) {
        List<Projekat> list = Main.fIleProject.getProjekatList();
		Projekat projekat = list.stream().filter(projekat1 -> projekat1.getSifra() == sifra).findFirst()
                .orElse(null);
        return projekat;
    }

}
