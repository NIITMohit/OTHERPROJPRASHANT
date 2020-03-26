package Test;

import java.text.SimpleDateFormat;

import org.testng.annotations.Test;
import Utilities.Mail;
import Utilities.WindowsCapabilitie;

public class SendMail extends WindowsCapabilitie{
	
	@Test(alwaysRun = true)
	public void sendMail(){
		String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
		Mail.sendMail("vijay.j@mindtree.com", "Sanity report", "PFA", Mail.getTheNewestFile(System.getProperty("user.dir") + "/Reports/",
				".html"), "Sanity"+timeStamp+".html");
	}

}
