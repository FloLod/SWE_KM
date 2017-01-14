package km_Views;

public class ReplyView{
	private QuestionView question;
	private int replyID;
	private ContentView content;
	private TextView text;
	
	public ReplyView(){}
	public ReplyView(km_Entities.Reply reply){}
	
	public ReplyView(QuestionView question, int replyID, ContentView content, TextView text) {
		super();
		this.question = question;
		this.replyID = replyID;
		this.content = content;
		this.text = text;
	}
	
	public km_Entities.Text parseText(){
		return null;
	}
	
	public km_Entities.Reply parseReply(){
		return null;
	}
	
	
	public QuestionView getQuestion() {
		return question;
	}
	public void setQuestion(QuestionView question) {
		this.question = question;
	}
	public int getReplyID() {
		return replyID;
	}
	public void setReplyID(int replyID) {
		this.replyID = replyID;
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

	
	
}