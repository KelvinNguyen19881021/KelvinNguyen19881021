package selenium.com.dataprovider.sadlierconnect;

import org.testng.annotations.DataProvider;
import selenium.com.constants.FrameworkConstants;
import selenium.com.helpers.ExcelHelpers;
import selenium.com.helpers.Helpers;
import selenium.com.helpers.PropertiesHelpers;


public class DataProviderSCRegisterProduct {
  public DataProviderSCRegisterProduct() {
    super();
    PropertiesHelpers.loadAllFiles();
  }
  @DataProvider(name = "getRegisterAProducts")
  public static Object[][] getRegisterAProducts() {
    return new Object[][][]{getRegisterAProduct01(), getRegisterAProduct02(), getRegisterAProduct03(), getRegisterAProduct04(), getRegisterAProduct05()};
  }


  @DataProvider(name = "getRegisterAProduct01")
  public static Object[][] getRegisterAProduct01() {
    ExcelHelpers excelHelpers = new ExcelHelpers();
    Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_SC_REGISTER_A_PRODUCT, "SC_REGISTER_A_PRODUCT", 1, 1);
    System.out.println("getClientData: " + data);
    return data;
  }

  @DataProvider(name = "getRegisterAProduct02")
  public static Object[][] getRegisterAProduct02() {
    ExcelHelpers excelHelpers = new ExcelHelpers();
    Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_SC_REGISTER_A_PRODUCT, "SC_REGISTER_A_PRODUCT", 2, 2);
    System.out.println("getClientData: " + data);
    return data;
  }
  @DataProvider(name = "getRegisterAProduct03")
  public static Object[][] getRegisterAProduct03() {
    ExcelHelpers excelHelpers = new ExcelHelpers();
    Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_SC_REGISTER_A_PRODUCT, "SC_REGISTER_A_PRODUCT", 3, 3);
    System.out.println("getClientData: " + data);
    return data;
  }
  @DataProvider(name = "getRegisterAProduct04")
  public static Object[][] getRegisterAProduct04() {
    ExcelHelpers excelHelpers = new ExcelHelpers();
    Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_SC_REGISTER_A_PRODUCT, "SC_REGISTER_A_PRODUCT", 4, 4);
    System.out.println("getClientData: " + data);
    return data;
  }

  @DataProvider(name = "getRegisterAProduct05")
  public static Object[][] getRegisterAProduct05() {
    ExcelHelpers excelHelpers = new ExcelHelpers();
    Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_SC_REGISTER_A_PRODUCT, "SC_REGISTER_A_PRODUCT", 5, 5);
    System.out.println("getClientData: " + data);
    return data;
  }

}
