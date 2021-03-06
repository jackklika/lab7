package llm.lab7;


public class Racer implements Comparable<Object>{
	
	public String bib;
	public String name;
	public String place;
	public String time;
	
	public Racer(String place, String bib, String name, String time) {
		this.bib = bib;
		this.name = name;
		this.place = place;
		this.time = time;
	}
	
	@Override
	public String toString() {
		return String.format("#%s \tBib: %s  | %s  [%s]", place, bib, name, time);
	}

	//Sort racers by race result order (shortest to longest with all DNFs at the end)
	public int compareTo(Object o) {
		if (o instanceof Racer) {
			Racer other = (Racer) o;
			if(this.time.equals("DNF")) return 1; // Less than others
			
			try {
				String[] ttimes = this.time.split(":");
				int thours = Integer.parseInt(ttimes[0]);
				int tminutes = Integer.parseInt(ttimes[1]);
				double tseconds = Double.parseDouble(ttimes[2]);
				
				String[] otimes = other.time.split(":");
				int ohours = Integer.parseInt(otimes[0]);
				int ominutes = Integer.parseInt(otimes[1]);
				double oseconds = Double.parseDouble(otimes[2]);
				
				
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
			} catch(NumberFormatException e) {
				e.printStackTrace();
			}
			
			
			//return time.compareTo(other.time);
		}
		return 0;
	}

}
