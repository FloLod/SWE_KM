package km_Handler;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import km_Services.*;
@ManagedBean
@SessionScoped
public class ServiceLocatorImpl implements ServiceLocator{
	private ExchangeCenterService exchangeCenterService;
	//Test
	
	private ExchangeMarketService exchangeMarketService;
	
	private FileService fileService;
	
	private CalenderService calenderService;
	
	private KarmaService karmaService;
	
	private ClassService classService;
	
	private KnowledgeCenterService knowledgeCenterService;
	
	private LoginService loginService;
	
	private NotificationService notificationService;
	
	private PDFService pdfservice;
	
	private StudentService studentService;

	
	
	public ServiceLocatorImpl() {
		super();
		this.exchangeCenterService = new ExchangeCenterServiceImpl();
		this.exchangeMarketService = new ExchangeMarketServiceImpl();
		this.fileService = new FileServiceImpl();
		this.calenderService = new CalenderServiceImpl();
		this.karmaService = new KarmaServiceImpl();
		this.classService = new ClassServiceImpl();
		this.knowledgeCenterService = new KnowledgeCenterServiceImpl();
		this.loginService = new LoginServiceImpl();
		this.notificationService = new NotificationServiceImpl();
		this.pdfservice = new PDFServiceImpl();
		this.studentService = new StudentServiceImpl();
	}

	public ExchangeCenterService getExchangeCenterService() {
		return exchangeCenterService;
	}

	public ExchangeMarketService getExchangeMarketService() {
		return exchangeMarketService;
	}

	public FileService getFileService() {
		return fileService;
	}

	public CalenderService getCalenderService() {
		return calenderService;
	}

	public KarmaService getKarmaService() {
		return karmaService;
	}

	public ClassService getClassService() {
		return classService;
	}

	public KnowledgeCenterService getKnowledgeCenterService() {
		return knowledgeCenterService;
	}

	public LoginService getLoginService() {
		return loginService;
	}

	public NotificationService getNotificationService() {
		return notificationService;
	}

	public PDFService getPdfservice() {
		return pdfservice;
	}

	public StudentService getStudentService() {
		return studentService;
	}
	
	
	
}
