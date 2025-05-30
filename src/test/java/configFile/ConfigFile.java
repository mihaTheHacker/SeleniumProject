package configFile;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class ConfigFile {
    //facem o metoda generica care sa deserializeze xml file si sa returneze o bucata pe care mi-o doresc
    //metoda generica

    public static <T> T createConfigNode(Class<T> klass) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(klass);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return klass.cast(unmarshaller.unmarshal(new File("src/test/resources/configFile/sharedDataConfig.xml")));

        } catch (JAXBException e) {
            System.out.println(e.getMessage());
        }
        return null;

    }

}
