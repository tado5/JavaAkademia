package Field;

public class Kocka {

	public enum State {

		START, FULL, EMPTY,

	}
	
	
	int value;
	
	private State state = State.START;

	public State getState() {
		return state;

	}

	public void setState(State state) {

		this.state = state;

	}

	public int getValue(){
    	return value;
    }
	
	public void setValue(int value){
		this.value = value;
		
	}
	
	
	
	
	

}
