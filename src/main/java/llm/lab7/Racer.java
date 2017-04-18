package llm.lab7;


public class Racer implements Comparable<Object>{
	
	public String bib;
	public String lastName;
	public String firstInitial;
	public String time;
	
	public Racer(String bib, String lastName, String firstInitial, String time) {
		this.bib = bib;
		this.lastName = lastName;
		this.firstInitial = firstInitial;
		this.time = time;
	}
	
	@Override
	public String toString() {
		return String.format("#%s: %s. %s  [%s]", bib, firstInitial, lastName, time);
	}

	public int compareTo(Object o) {
		if (o instanceof Racer) {
			Racer other = (Racer) o;
			return lastName.compareTo(other.lastName);
		}
		return 0;
	}

}
