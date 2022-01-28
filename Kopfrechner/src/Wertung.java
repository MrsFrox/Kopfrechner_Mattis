import java.util.List;

public class Wertung {
	
	
	@DisplayName(name = "Anzahl Fragen")
	protected int anzahlFragen;
	
	@DisplayName(name = "Anzahl Fehler")
	protected int anzahlFehler;
	
	@DisplayName(name = "Name")
	protected String name ;
	
	@DisplayName(name = "Operatoren")
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
