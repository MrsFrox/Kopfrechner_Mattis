import java.util.List;

public class Wertung {
	
	protected int anzahlFragen;
	protected int anzahlFehler;
	protected String name ;
	protected List<String> operatoren ;
	
	
	public int getAnzahlFragen() {
		return anzahlFragen;
	}
	
	public void setAnzahlFragen(int anzahlFragen) {
		this.anzahlFragen = anzahlFragen;
	}
	
	public int getAnzahlFehler() {
		return anzahlFehler;
	}
	
	public void setAnzahlFehler(int anzahlFehler) {
		this.anzahlFehler = anzahlFehler;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<String> getOperatoren() {
		return operatoren;
	}
	
	public void setOperatoren(List<String> operatoren) {
		this.operatoren = operatoren;
	}

}
