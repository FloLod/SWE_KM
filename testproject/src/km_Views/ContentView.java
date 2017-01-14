package km_Views;

import java.util.Date;
import java.util.List;

public class ContentView {

		private StudentView creator;
		private Date created;
		private Date changed;
		private int contentID;
			
		//contenttype
		private int contentTypeID;
		private String contentTypeName;
		private int KarmaReward;
		private ClassView owner;

		public ContentView(){}
		
		public ContentView(km_Entities.Content cont, km_Entities.ContentType conttype){
			
		}
		
		public ContentView(StudentView creator, Date created, Date changed, int contentID, int contentTypeID,
				String contentTypeName, int karmaReward, ClassView owner) {
			super();
			this.creator = creator;
			this.created = created;
			this.changed = changed;
			this.contentID = contentID;
			this.contentTypeID = contentTypeID;
			this.contentTypeName = contentTypeName;
			KarmaReward = karmaReward;
			this.owner = owner;
		}
		
		public int getLikes(){return 0;}
		
		public km_Entities.ContentType parseContenttype(){
			return null;
		}
		
		public km_Entities.Content parseContent(){
			return null;
		}
		
		
		public StudentView getCreator() {
			return creator;
		}
		public void setCreator(StudentView creator) {
			this.creator = creator;
		}
		public Date getCreated() {
			return created;
		}
		public void setCreated(Date created) {
			this.created = created;
		}
		public Date getChanged() {
			return changed;
		}
		public void setChanged(Date changed) {
			this.changed = changed;
		}
		public int getContentID() {
			return contentID;
		}
		public void setContentID(int contentID) {
			this.contentID = contentID;
		}
		public int getContentTypeID() {
			return contentTypeID;
		}
		public void setContentTypeID(int contentTypeID) {
			this.contentTypeID = contentTypeID;
		}
		public String getContentTypeName() {
			return contentTypeName;
		}
		public void setContentTypeName(String contentTypeName) {
			this.contentTypeName = contentTypeName;
		}
		public int getKarmaReward() {
			return KarmaReward;
		}
		public void setKarmaReward(int karmaReward) {
			KarmaReward = karmaReward;
		}
		public ClassView getOwner() {
			return owner;
		}
		public void setOwner(ClassView owner) {
			this.owner = owner;
		}

}
