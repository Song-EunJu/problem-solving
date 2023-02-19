package corona.app;

import corona.virus.*;

public class MainTest {
	public static void main(String[] args) {
	

		// 10.질병관리 문제 //
		//
		//	아래 11~13번 주석을 해제하여
		//	"정상 출력 예" 와 같이 출력될 수 있도록
		System.out.println("10.질병관리(코로나,메르스) =================================");
		VirusMgr vmgr=new VirusMgrImpl();
		System.out.println();		
		
		System.out.println("11.코로나19 등록");
		// 정상 출력 예: 
		// 11.코로나19 등록
		// 코로나19: 등록된 바이러스입니다.
		try {
			vmgr.add(new Mers(  "메르스15", 2, 1.5));
			vmgr.add(new Corona("코로나19", 3, 2));
			vmgr.add(new Corona("코로나19", 2, 2));
		} catch (DuplicatedException e) {
			System.out.println(e.getMessage());
		}
		System.out.println();

		System.out.println("12.바이러스 전체검색");
		// 정상 출력 예: 
		// 12.바이러스 전체검색
		// 메르스15	2	1.5
		// 코로나19	3	2
		Virus[] virus=vmgr.search();
		for(Virus v:virus) {
			System.out.println(v);
		}
		System.out.println();
	}
}
