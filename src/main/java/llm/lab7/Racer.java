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
//Sort racers by race result order (shortest to longest with all DNFs at the end)
	public int compareTo(Object o) {
		if (o instanceof Racer) {
			Racer other = (Racer) o;
			if(other.time.equals("DNF")) return -1;
			//split strings by hours, minutes, and seconds
			String[] times = other.time.split(":");
			int hours = times[0];
			int minutes = times[1];
			int seconds = times[2];
			return time.compareTo(other.time);
		}
		return 0;
	}

}
