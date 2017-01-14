package km_Views;

public class QuestionView{
	private int questionID;
	private ContentView content;
	private TextView text;
	
	//category
	private int CategoryID;
	private String CategoryText;
	
	public QuestionView(km_Entities.Question question){}
	public QuestionView(){}
	
	public QuestionView(int questionID, ContentView content, TextView text, int categoryID,
			String categoryText) {
		super();
		this.questionID = questionID;
		this.content = content;
		this.text = text;
		CategoryID = categoryID;
		CategoryText = categoryText;
	}
	
	public km_Entities.Category parseCategory(){
		return null;
	}
	
	public km_Entities.Question parseQuestion(){
		return null;
	}

	public int getQuestionID() {
		return questionID;
	}

	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}

	public ContentView getContent() {
		return content;
	}

	public void setContent(ContentView content) {
		this.content = content;
	}

	public TextView getText() {
		return text;
	}
	public void setText(TextView text) {
		this.text = text;
	}
	public int getCategoryID() {
		return CategoryID;
	}

	public void setCategoryID(int categoryID) {
		CategoryID = categoryID;
	}

	public String getCategoryText() {
		return CategoryText;
	}

	public void setCategoryText(String categoryText) {
		CategoryText = categoryText;
	}
	
	
}