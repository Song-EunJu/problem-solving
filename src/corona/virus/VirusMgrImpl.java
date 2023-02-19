package corona.virus;


import java.util.Arrays;

public class VirusMgrImpl implements VirusMgr {
	private Virus[] virus;
	private int index;
	
	public VirusMgrImpl() {
		virus=new Virus[100];		
	}
	
	@Override
	public void add(Virus v) throws DuplicatedException{
		try {
			search(v.getName());
		} catch (NotFoundException e) {
			virus[index++]=v;
		}
	}
	@Override
	public Virus[] search() {
		return Arrays.copyOfRange(virus, 0, index);
	}
	@Override
	public Virus search(String name) throws NotFoundException, DuplicatedException {
		for(int i=0; i<virus.length; i++) {
			if(virus[i] == null)
				break;
			if(virus[i].getName().equals(name))
				throw new DuplicatedException(name+": 등록된 바이러스입니다.");
		}
		throw new NotFoundException(name+": 미등록 바이러스입니다.");
	}
}
