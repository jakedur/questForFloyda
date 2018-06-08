package util;

public class Coordinate {
	
	private int x;
	private int y;
	
	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
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
	
	@Override
	public boolean equals(Object object) {
		boolean isSame = false;
		if (object instanceof Coordinate) {
			isSame = this.x == ((Coordinate) object).x;
			if (isSame)
				isSame = this.y == ((Coordinate) object).y;
		}
		return isSame;
	}
}
