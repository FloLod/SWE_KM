package km_Handler;

import km_Services.*;


public interface ServiceLocator {
	public ExchangeCenterService getExchangeCenterService();

	public ExchangeMarketService getExchangeMarketService();
	public FileService getFileService() ;
	public CalenderService getCalenderService() ;
	public KarmaService getKarmaService();
	public ClassService getClassService() ;
	public KnowledgeCenterService getKnowledgeCenterService() ;
	public LoginService getLoginService() ;
	public NotificationService getNotificationService();
	public PDFService getPdfservice() ;
	public StudentService getStudentService();
}
