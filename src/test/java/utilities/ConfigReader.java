package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    public static Properties properties;

    static {
        String dosyaYolu = "configration.properties.properties";
        try {
            FileInputStream fis = new FileInputStream(dosyaYolu);
            // fis dosyayolunu tanimladigimiz configuration.properties dosyasini okudu
            properties = new Properties();
            properties.load(fis); // fisin okudgu bilgileri properties´e yükledi

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        /*
        test methodundan yolladigimiz string key degerini alip
        properties classindan getProperty() methodunu kullanarak
        bu keye ait value bize getirildi
         */
        return properties.getProperty(key);
    }
}
