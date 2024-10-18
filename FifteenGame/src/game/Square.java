package game;
public class Square {
	int value;
	public Square(int value)
	{
		this.value=value;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String toString() {
		if(this.value==0)
		{
			return String.format("%-4s", " ");
		}
		return String.format("%-4d", value);
	}

}
