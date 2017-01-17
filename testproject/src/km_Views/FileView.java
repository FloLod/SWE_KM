package km_Views;

public class FileView{
	private int fileID;
	private String fileName;
	private ContentView content;
	private TextView text;

	
	public FileView(){}
	public FileView(km_Entities.File file){
		this.fileID = file.getFileID();
		this.fileName = file.getFileName();
		this.content = new ContentView(file.getContent(), file.getContent().getContentType());
		this.text = new TextView(file.getText());
		
	}
	
	public FileView(int fileID, String fileName, ContentView content, TextView text) {
		super();
		this.fileID = fileID;
		this.fileName = fileName;
		this.content = content;
		this.text = text;
	}
	
	public int getFileID() {
		return fileID;
	}
	public void setFileID(int fileID) {
		this.fileID = fileID;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
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