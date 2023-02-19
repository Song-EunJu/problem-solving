package corona2.virus;

public interface VirusMgr {
	void add(Virus v);
	Virus[] search();
	Virus search(String name) throws NotFoundException, DuplicatedException;

}