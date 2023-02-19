package corona2.virus;


public class VirusMgrImpl implements VirusMgr {
	private Virus[] virus;
	private int index;
	
	public VirusMgrImpl() {
		virus=new Virus[100];		
	}
	
	@Override
	public void add(Virus v) {
		search(v.getName());
	}
	@Override
	public Virus[] search() {
		return virus;
	}
	@Override
	public Virus search(String name) {
		try{
			for(int i=0; i<virus.length; i++) {
				if(virus[i] == null)
					break;

				if(virus[i].getName().equals(name))
					throw new DuplicatedException(name+": 이미 등록된 놈이다.");
			}
			throw new NotFoundException(name+": 미등록 바이러스입니다.");
		}
		catch (NotFoundException e) {
			System.out.println(e.getMessage());
//			virus[index++] = v;
		} catch (DuplicatedException e){
			System.out.println(e.getMessage());
		}
		return null;
	}
}
