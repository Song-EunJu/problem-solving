package corona2.virus;

public class NotFoundException extends Exception{
	public NotFoundException(String msg) {
		super(msg);
	}
	public NotFoundException() {
		this("NotFound예외");
	}
}
