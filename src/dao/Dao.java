package dao;

import domen.Zaposleni;

import java.util.List;

public interface Dao<T> {
	void save(T entity);
	void softDelete(T entity);
	void updat(T entity);
    List<T> getAll();
    T findBySifra(int sifra);
}
