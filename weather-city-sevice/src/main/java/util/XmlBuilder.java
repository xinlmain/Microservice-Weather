package util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/**
 * @author xin
 * @date 2018/9/1 18:01
 */
public class XmlBuilder {

    /**
     * Convert XML to Object
     * @param clazz
     * @param xmlStr
     * @return
     */
    public static Object xmlStrToObject(Class<?> clazz, String xmlStr) throws JAXBException, IOException {
        Object xmlObject;
        JAXBContext context = JAXBContext.newInstance(clazz);

        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (Reader reader = new StringReader(xmlStr)) {
            xmlObject = unmarshaller.unmarshal(reader);
        }

        return xmlObject;
    }
}
