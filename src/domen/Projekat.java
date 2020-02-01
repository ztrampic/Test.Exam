package domen;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Projekat {
	private int sifra;
	private String naziv;
	private Date datumOd;
	private Date datumDo;
	private boolean isDeleted;
	private List<AngazovanjeNaProjektu> listaAngazovanja;

	public Projekat() {
	}
	public Projekat(int sifra, String naziv, Date datumOd, Date datumDo, List<AngazovanjeNaProjektu> listaAngazovanja) {
		this.sifra = sifra;
		this.naziv = naziv;
		this.datumOd = new Date(new SimpleDateFormat("MM-dd-yyyy").format(datumOd));
		this.datumDo = datumDo;
		this.listaAngazovanja = listaAngazovanja;
	}

    public Projekat(int sifra, String naziv, Date datumOd, Date datumDo) {
    }

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean deleted) {
		isDeleted = deleted;
	}

	public int getSifra() {
		return sifra;
	}

	public void setSifra(int sifra) {
		this.sifra = sifra;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Date getDatumOd() {
		return datumOd;
	}

	public void setDatumOd(Date datumOd) {
		this.datumOd = datumOd;
	}

	public Date getDatumDo() {
		return datumDo;
	}

	public void setDatumDo(Date datumDo) {
		this.datumDo = datumDo;
	}

	public List<AngazovanjeNaProjektu> getListaAngazovanja() {
		return listaAngazovanja;
	}

	public void setListaAngazovanja(List<AngazovanjeNaProjektu> listaAngazovanja) {
		this.listaAngazovanja = listaAngazovanja;
	}

	@Override
	public String toString() {
		return "Projekat{" +
				"sifra=" + sifra +
				", naziv='" + naziv + '\'' +
				", datumOd=" + datumOd +
				", datumDo=" + datumDo +
				", listaAngazovanja=" + listaAngazovanja +
				'}';
	}

}
