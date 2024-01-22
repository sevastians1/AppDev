






public class Location {
	//TODO Put your instance variables here
	private int row;
	private int col;
	/**
	 * The constructor that will set up the object to store a row and column
	 * 
	 * @param row
	 * @param col
	 */
	public Location(int row, int col) {
		this.row=row;
		this.col=col;
		//TODO: this is the constructor, you'll need to fill this in
	}
	
	public int getRow() {
		//TODO fill in this getter
		return this.row;
	}
	
	public void setRow(int row) {
		this.row = row;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public int getCol() {
		//TODO fill this in
		return this.col;
	}
	

}
