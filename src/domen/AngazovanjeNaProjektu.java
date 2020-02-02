package domen;

import enums.Uloga;

import java.util.Date;

public class AngazovanjeNaProjektu {
	private double brojRadnihSati;
	private Date datumOd;
	private Date datumDo;
	private int sifraProjekat;
	private int sifraZaposlenog;
	private Uloga uloga;

	public int getSifraProjekat() {
		return sifraProjekat;
	}

	public void setSifraProjekat(int sifraProjekat) {
		this.sifraProjekat = sifraProjekat;
	}

	public int getSifraZaposlenog() {
		return sifraZaposlenog;
	}

	public void setSifraZaposlenog(int sifraZaposlenog) {
		this.sifraZaposlenog = sifraZaposlenog;
	}

	public double getBrojRadnihSati() {
		return brojRadnihSati;
	}

	public void setBrojRadnihSati(double brojRadnihSati) {
		this.brojRadnihSati = brojRadnihSati;
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

	public Uloga getUloga() {
		return uloga;
	}

	public void setUloga(Uloga uloga) {
		this.uloga = uloga;
	}

	@Override
	public String toString() {
		return "AngazovanjeNaProjektu{" +
				"brojRadnihSati=" + brojRadnihSati +
				", datumOd=" + datumOd +
				", datumDo=" + datumDo +
				", sifraProjekat=" + sifraProjekat +
				", sifraZaposlenog=" + sifraZaposlenog +
				", uloga=" + uloga +
				'}';
	}
}
