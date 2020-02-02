package services;


import domen.Zaposleni;

import java.util.List;

public interface ServiceZaposleni {
	void saveZaposleni();

	void updateZaposleni();

	void deleteZaposleni();

	List<Zaposleni> getAllZaposleni();

    Zaposleni findBySifra();
}
