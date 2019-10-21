package Final_Orange_HRM;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;


    public class LoadProperties {
        static Properties props;
        static FileInputStream input;

        public String getProperty(String key) {
            props = new Properties();
            try {
                input = new FileInputStream("src\\test\\java\\Resources\\testdataConfig.properties");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                props.load(input);
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
            return props.getProperty(key);
        }


    }



