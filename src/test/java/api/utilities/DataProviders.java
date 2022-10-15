package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
/*
 *if we have one data driven test we have one data provider and if we have multiple data
  driven test then we have multiple data provider methods
 * data provider will get data from excel sheet
 * the method with dataprovider will get all data from excel sheet and store it in 2d array
 * this dataprovider will send data to test method and test method will execute 
 * n no of times in loop witout for loop.
 * 
*/
	@DataProvider(name="Data") // this will get all data from excel
	public String[][] getAllData() throws IOException
	{
		String path=System.getProperty("user.dir")+"//externalfiles//restassured.xlsx";
		XLUtility xl=new XLUtility(path);
	
		int rownum=xl.getRowCount("Sheet1");	
		int colcount=xl.getCellCount("Sheet1",1);
		
		String apidata[][]=new String[rownum][colcount];
		// 2d array can store any number of row and colum sice we secified it in above
		for(int i=1;i<=rownum;i++) // this loop will put data in 2d array. first row is heading so i=1 not 0
		{		
			for(int j=0;j<colcount;j++)
			{
				apidata[i-1][j]= xl.getCellData("Sheet1",i, j);  
			}
		}
	
		return apidata;
	}
	
	@DataProvider(name="UserNames") // this method will get only usernames
	public String[] getUserNames() throws IOException
	{
		String path=System.getProperty("user.dir")+"//externalfiles//restassured.xlsx";
		XLUtility xl=new XLUtility(path);
	
		int rownum=xl.getRowCount("Sheet1");	
			
		String apidata[]=new String[rownum];
		
		for(int i=1;i<=rownum;i++)
		{		
			apidata[i-1]= xl.getCellData("Sheet1",i, 1);  
			
		}
	
		return apidata;
	}
	
}
