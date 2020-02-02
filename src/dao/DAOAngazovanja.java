package dao;

import domen.AngazovanjeNaProjektu;
import domen.Projekat;
import helper.Helper;
import main.Main;

import java.util.List;

public class DAOAngazovanja implements Dao<AngazovanjeNaProjektu>{
    private Helper helper = new Helper();
    @Override
    public void save(AngazovanjeNaProjektu entity) {
        Main.fileAngazovanja.getList().add(entity);
        List<Projekat> updatedList = helper.doRelationsSingle(entity, Main.fIleProject.getProjekatList());
        Main.fIleProject.setProjekatList(updatedList);
        System.out.println("Usepesno sacuvano angazovanje na projektu.");
        List<AngazovanjeNaProjektu> list = Main.fileAngazovanja.getList();
        helper.updateFileAngazovanja(list);
    }

    @Override
    public void softDelete(AngazovanjeNaProjektu entity) {

    }

    @Override
    public void updat(AngazovanjeNaProjektu entity) {

    }

    @Override
    public List<AngazovanjeNaProjektu> getAll() {
        return null;
    }
}
