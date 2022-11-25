package com.facebook.com.facebook;

import java.io.File;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class TestListner implements ITestListener {
	ExtentReports reports;
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		 test = reports.startTest(result.getMethod().getMethodName());
			System.out.println("*******Starting the test*******"+result.getMethod().getMethodName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("*******Test case is passed*******"+result.getMethod().getMethodName());
		test.log(LogStatus.FAIL,result.getThrowable());
		reports.endTest(test); 
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("*******Test case is failed*******"+result.getMethod().getMethodName());
		test.log(LogStatus.FAIL,result.getThrowable());
		reports.endTest(test); 
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		reports = new ExtentReports("C:\\Users\\LENOVO\\eclipse-workspace\\com.facebook\\reports"+"\\ExtentReportResults.html");
		reports.loadConfig(new File("C:\\Users\\LENOVO\\eclipse-workspace\\end2end\\config-report.xml"));
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("*******Test case suite is completed******");

		reports.flush(); 

	}

}
