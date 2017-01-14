package km_Services;

import java.io.File;

public interface FileService {

	public File downloadFile(String filepath);
	
	public void uploadFile();
	
	public void deleteFile(String filepath);
	
	public void renameFile(String filepath, String newname);
	
}
