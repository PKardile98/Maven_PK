package Com.healthcare.Configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Read_configuration_MRS {


	Properties Pro;

	public Read_configuration_MRS() {
		
		String Path="C:\\Users\\Prashant\\git\\Maven_PK\\PK_MavenProject\\src\\test\\resources\\Configuration\\Config.properties";

		File SRC = new File(Path);

		Pro = new Properties();
		try {
			FileInputStream FSI = new FileInputStream(SRC);
			try {

				Pro.load(FSI);

			} catch (IOException e) {

				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public String GetAppURL() {

		String URL = Pro.getProperty("BaseURL");
		return URL;
	}

	public String U_Name() {

		String UN_Name1 = Pro.getProperty("Username");
		return UN_Name1;
	}
	

	public String Pass() {

		String P1 = Pro.getProperty("Password");
		return P1;
	}

	public String GetChormePath() {

		String CP1 = Pro.getProperty("Chromdriver");
		return CP1;
	}
	
	public String Getgeckopath() {

		String CP1 = Pro.getProperty("Firefox");
		return CP1;
	}

}
