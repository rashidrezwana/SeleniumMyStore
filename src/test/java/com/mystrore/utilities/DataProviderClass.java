package com.mystrore.utilities;
import org.testng.annotations.DataProvider;

public class DataProviderClass {

    @DataProvider(name = "RegestrationDataProvider")
    public static Object[][] registrationDataProvider() {
        return getDataFromSheet("UserRegistrationData");
    }

    @DataProvider(name = "LoginDataProvider")
    public static Object[][] loginDataProvider() {
        return getDataFromSheet("LoginTestData");
    }
    
    @DataProvider(name = "PurchaseDataProvider")
    public static Object[][] PurchaseDataProvider() {
        return getDataFromSheet("PurchaseData");
    }
    

    private static Object[][] getDataFromSheet(String sheetName) {
        String fileName = System.getProperty("user.dir") + "\\TestData\\MyStoreTestData.xlsx";
        int ttlRows = ReadExcelFile.getRowCount(fileName, sheetName);
        int ttlColumns = ReadExcelFile.getColCount(fileName, sheetName);
        Object[][] data = new Object[ttlRows - 1][ttlColumns];
        for (int i = 1; i < ttlRows; i++) {
            for (int j = 0; j < ttlColumns; j++) {
                data[i - 1][j] = ReadExcelFile.getCellValue(fileName, sheetName, i, j);
            }
        }
        return data;
    }

		
	}
	
	
	
	
	
	
	
	
	
	
	
	
