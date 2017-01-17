package km_Views;

public class QuestionView{
	private int questionID;
	private ContentView content;
	private TextView text;
	
	//category
	private int CategoryID;
	private TextView CategoryText;
	
	public QuestionView(km_Entities.Question question){
		this.questionID = question.getQuestionID();
		this.content = new ContentView(question.getContent(), question.getContent().getContentType());
		this.text = new TextView(question.getText());
		
		this.CategoryID = question.getCategory().getCategoryID();
		this.CategoryText = new TextView(question.getCategory().getText());
	}
	public QuestionView(){}
	
	public QuestionView(int questionID, ContentView content, TextView text, int categoryID,
			TextView categoryText) {
		super();
		this.questionID = questionID;
		this.content = content;
		this.text = text;
		CategoryID = categoryID;
		CategoryText = categoryText;
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

	public TextView getCategoryText() {
		return CategoryText;
	}

	public void setCategoryText(TextView categoryText) {
		CategoryText = categoryText;
	}
	
	
}