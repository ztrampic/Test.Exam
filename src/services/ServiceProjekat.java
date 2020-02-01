package services;

import domen.Projekat;
import domen.Zaposleni;

import java.util.List;

public interface ServiceProjekat {

	void saveProjekat();

	void updateProjekat();

	void deleteProjekat();

	List<Projekat> getAllProjekat();
}
