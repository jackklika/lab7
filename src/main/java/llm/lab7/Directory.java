package llm.lab7;
import java.util.Collection;

// common interface for Server/MainDirectory and Client/DirectoryProxy

public interface Directory {
	
	public void add(Collection<Racer> e);
	
	public void print();
	
	public void clear();
	
}
