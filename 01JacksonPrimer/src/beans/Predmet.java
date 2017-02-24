package beans;

public class Predmet {
	String naziv;
	String [] profesor;
	int brojIzlazaka;
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String[] getProfesor() {
		return profesor;
	}
	public void setProfesor(String[] profesor) {
		this.profesor = profesor;
	}
	public int getBrojIzlazaka() {
		return brojIzlazaka;
	}
	public void setBrojIzlazaka(int brojIzlazaka) {
		this.brojIzlazaka = brojIzlazaka;
	}

}
