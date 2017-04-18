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
			if(other.time.equals("DNF")) return -1; // Less than others
			
			
			String[] ttimes = this.time.split(":");
			int thours = Integer.parseInt(ttimes[0]);
			int tminutes = Integer.parseInt(ttimes[1]);
			double tseconds = Integer.parseInt(ttimes[2]);
			
			String[] otimes = other.time.split(":");
			int ohours = Integer.parseInt(otimes[0]);
			int ominutes = Integer.parseInt(otimes[1]);
			double oseconds = Integer.parseInt(otimes[2]);
			
			
			if (thours > ohours){
				return 1;
			} else if (thours < ohours){
				return -1;
			} else {
				if (tminutes > ominutes){
					return 1;
				} else if (tminutes < tminutes){
					return -1;
				} else {
					if (tseconds > oseconds){
						return 1;
					} else if (tseconds < oseconds){
						return -1;
					} else {
						return 0;
					}
				}
			}
			
			//return time.compareTo(other.time);
		}
		return 0;
	}

}
