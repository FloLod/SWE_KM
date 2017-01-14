package km_Views;

class TextView {
	//text
	private int TextID;
	private String heading;
	private String text;

	public TextView(){}
	
	public TextView(km_Entities.Text text){}
	
	public TextView(int textID, String heading, String text) {
		super();
		TextID = textID;
		this.heading = heading;
		this.text = text;
	}

	public km_Entities.Text parseText(){
		return null;
	}

	public int getTextID() {
		return TextID;
	}

	public void setTextID(int textID) {
		TextID = textID;
	}

	public String getHeading() {
		return heading;
	}

	public void setHeading(String heading) {
		this.heading = heading;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	
}
