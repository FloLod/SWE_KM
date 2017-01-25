package km_Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Text {
	@Id
	@GeneratedValue
	private int textID;
	private String heading;
	private String text;

	public Text() {
	}

	public Text(String heading, String text) {
		super();
		this.heading = heading;
		this.text = text;
	}

	public int getTextID() {
		return textID;
	}

	public void setTextID(int textID) {
		this.textID = textID;
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
