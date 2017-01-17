package km_Views;

public class TextView {
	//text
	private int TextID;
	private String heading;
	private String text;

	public TextView(){}
	
	public TextView(km_Entities.Text text){
		this.TextID = text.getTextID();
		this.heading = text.getHeading();
		this.text = text.getText();
	}
	
	public TextView(int textID, String heading, String text) {
		super();
		TextID = textID;
		this.heading = heading;
		this.text = text;
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
