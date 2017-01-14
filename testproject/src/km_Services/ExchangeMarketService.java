package km_Services;

import java.io.File;

import km_Views.FileView;

public interface ExchangeMarketService {

	public void unlockfile(int userid, int fileid);

	public File filedownload(FileView file);
	
	public void uploadfile();
	
	public void deleteFile(FileView file);

}
