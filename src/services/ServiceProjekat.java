package services;

import domen.Projekat;

import java.util.List;

public interface ServiceProjekat {

	Projekat saveProjekat();

	void updateProjekat();

	void deleteProjekat();

	List<Projekat> getAllProjekat();
}
