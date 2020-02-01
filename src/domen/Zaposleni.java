package domen;

public class Zaposleni {
	private int sifra;
	private String ime;
	private String prezime;
	private boolean deleted;
	
	public Zaposleni() {
	}
	public Zaposleni(int sifra, String ime, String prezime, boolean deleted) {
		super();
		this.sifra = sifra;
		this.ime = ime;
		this.prezime = prezime;
		this.deleted = deleted;
	}
	public int getSifra() {
		return sifra;
	}
	public void setSifra(int sifra) {
		this.sifra = sifra;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	@Override
	public String toString() {
		return "Zaposleni [sifra=" + sifra + ", ime=" + ime + ", prezime=" + prezime + ", isDeleted=" + deleted + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ime == null) ? 0 : ime.hashCode());
		result = prime * result + (deleted ? 1231 : 1237);
		result = prime * result + ((prezime == null) ? 0 : prezime.hashCode());
		result = prime * result + sifra;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Zaposleni other = (Zaposleni) obj;
		if (ime == null) {
			if (other.ime != null)
				return false;
		} else if (!ime.equals(other.ime))
			return false;
		if (deleted != other.deleted)
			return false;
		if (prezime == null) {
			if (other.prezime != null)
				return false;
		} else if (!prezime.equals(other.prezime))
			return false;
		if (sifra != other.sifra)
			return false;
		return true;
	}
	
	
	
}
