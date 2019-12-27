package MiniFramework;

import org.testng.annotations.Test;

public class TestCases extends UserLibrary {

	public static void TC01_VerifyLeavesStatus()
	{
		driverLaunchApp();
		hrmLogin("user02","TM1234");
		navgateMyLeave();
		searchWithLeaveStatus("Pending Approval");
		verifyPendingApprovedOrNot("Pending Approval");
		closeBrowser();

	}

	public static void TC02_CancelLeavesStatusSpecifiedDate()
	{
		driverLaunchApp();
		hrmLogin("user02","TM1234");
		navgateMyLeave();
		searchWithLeaveStatus("Pending Approval");
		CancelLeavesStatusSpecifiedDate("2019-10-25");
		closeBrowser();

	}


}


