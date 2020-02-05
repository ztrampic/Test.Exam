package services;

import dao.DAOAngazovanja;
import dao.DAOProject;
import dao.DAOZaposleni;
import domen.Projekat;
import exception.MyInputMismatchException;
import helper.Helper;
import helper.MyTimeOut;

import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

public class ServiceProjekatImpl implements ServiceProjekat{

	private final DAOZaposleni daoZaposleni;
	private final DAOProject daoProject;
	private final DAOAngazovanja daoAngazovanja;
	private final Helper helper;

	public ServiceProjekatImpl() {
		daoZaposleni = new DAOZaposleni();
		daoProject = new DAOProject();
		daoAngazovanja = new DAOAngazovanja();
		helper = new Helper();
	}

	@Override
	public Projekat saveProjekat() {
		Scanner sc;
		Projekat projekat = null;
		int numberOfTrys = 3;
		while (numberOfTrys > 0) {
			System.out.println("Unesite sifru projekta.");
			sc = new Scanner(System.in);
			try {
				int sifra = helper.validateInput(sc);
				projekat = daoProject.findBySifra(sifra);
				if (projekat == null) {
					Projekat newProject = new Projekat();
					sc = new Scanner(System.in);
					System.out.println("Unesite naziv projekta");
					String naziv = sc.next();
					System.out.println("Unesite datum pocetka projekta. Format datuma je [ dd.MM.yyyy ].");
					String datumOd = sc.next();
					System.out.println("Unesite datum zavrsetka projekta. Format datuma je [ dd.MM.yyyy ].");
					String datumDo = sc.next();
					newProject.setDeleted(false);
					newProject.setSifra(sifra);
					newProject.setNaziv(naziv);
					newProject.setDatumOd(helper.convertAndFormatStringToDate(datumOd));
					newProject.setDatumDo(helper.convertAndFormatStringToDate(datumDo));
					daoProject.save(newProject);
					return newProject;
				} else {
					numberOfTrys--;
					System.err.println("Vec postoji projekat pod tom sifrom.");
				}
			} catch (MyInputMismatchException | ParseException e) {
				numberOfTrys--;
				System.err.println(e.getMessage());
				if (numberOfTrys == 0) new MyTimeOut(3);
			}
		}
		return null;
	}

	@Override
	public void updateProjekat() {

	}

	@Override
	public void deleteProjekat() {

	}

	@Override
	public List<Projekat> getAllProjekat() {
		List<Projekat> list = daoProject.getAll();
		return list;
	}
}
