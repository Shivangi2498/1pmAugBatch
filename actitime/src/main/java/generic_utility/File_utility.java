package generic_utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class File_utility {
	public String fetchDataFromPropertyFile(String key) throws IOException
	{
		FileInputStream fis= new FileInputStream("./src/test/resources/PropertyData.properties"); //common data is stored in property file
		Properties property = new Properties();
		property.load(fis);
		return property.getProperty(key);
	}
		
}
