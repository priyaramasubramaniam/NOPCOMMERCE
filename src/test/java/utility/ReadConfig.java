package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
    private Properties prop;
    public ReadConfig() throws IOException {
        File f = new File("Configurations/Config.properties");
        FileInputStream fis = new FileInputStream(f);
        prop = new Properties();
        prop.load(fis);
    }

    public String setUrl(){return prop.getProperty("url");}
    public String setEmail(){return prop.getProperty("email");}
    public String setPassword(){return prop.getProperty("password");}
    public String setProductname(){return prop.getProperty("product_name");}
    public String setIncorrectProdName(){return prop.getProperty("incorrect_product_name");}
}
