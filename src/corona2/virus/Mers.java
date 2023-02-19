package corona2.virus;

public class Mers extends Virus{
	private double infectedRate;

	public Mers(String name, int level, double infectedRate) {
		super(name, level);
		setInfectedRate(infectedRate);
	}
	
	public double getInfectedRate() {
		return infectedRate;
	}
	public void setInfectedRate(double infectedRate) {
		this.infectedRate = infectedRate;
	}	
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append(super.toString()).append("\t")
		  .append(getInfectedRate());
		return sb.toString();
	}
}