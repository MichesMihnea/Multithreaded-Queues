
public class Client {
	
	public int arrivalTime;
	public int serviceTime;
	public boolean done;
	public int serviceProgress;
	public int rank;
	
	public Client(int arrivalTime, int serviceTime) {
		this.arrivalTime = arrivalTime;
		this.serviceTime = serviceTime;
		this.serviceProgress = 0;
		this.rank = 0;
		this.done = false;
	}
	
	public boolean isDone() {
		if(this.done)
			return true;
		return false;
	}
	
	public void service() {
		if(!this.isDone())
			this.serviceProgress ++;
		else System.out.println("ERROR: serviced a finished deal");
	}
	
	public void makeProgress() {
		this.serviceProgress ++;
		if(this.serviceProgress == this.serviceTime)
			this.done = true;
	}
	
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	public void decreaseRank() {
		this.rank --;
	}
	
	public int getRank() {
		return this.rank;
	}
}
