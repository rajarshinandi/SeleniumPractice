package com.crm.qa.base;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener extends TestBase implements ITestListener{
	
	@Override
	public void onTestStart(ITestResult result) {
	    System.out.println("Testcase "+result.getName()+" Execution started");
	  }

	@Override
	public void onTestSuccess(ITestResult result) {
	    System.out.println("Testcase "+result.getName()+" Execution completed successfully");

	  }
	
	
	@Override
	public void onTestFailure(ITestResult result) {
	    System.out.println("Testcase "+result.getName()+" Execution Failed with error!"+result.getStatus());
	   
	  }
	
	
	@Override
	public void onTestSkipped(ITestResult result) {
	    // not implemented
	  }
	
	
	@Override
	  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	    // not implemented
	  }
	
	
	@Override
	  public void onTestFailedWithTimeout(ITestResult result) {
	    onTestFailure(result);
	  }
	
	
	@Override
	  public void onStart(ITestContext context) {
	    // not implemented
	  }
	
	
	@Override
	  public void onFinish(ITestContext context) {
	    System.out.println("Testcase "+context.getName()+" Execution Finished");

	  }
	
}
