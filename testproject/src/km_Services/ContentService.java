package km_Services;

import km_Entities.Content;
import km_Entities.ContentType;
import km_Views.ContentView;

public interface ContentService {

	public Content getContent(int id);
	public Content createContent(ContentView cv);
	
	public ContentType getContentType(int id);
	
}
