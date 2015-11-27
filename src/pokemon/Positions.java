package pokemon;

public class Positions {
	private int id_positions;
	private int x;
	private int y;
	
	public Positions(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Positions() {
	}
	
	public int getId_positions() {
		return id_positions;
	}
	public void setId_positions(int id_positions) {
		this.id_positions = id_positions;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
}
