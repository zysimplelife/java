package charlie.zha;

import charlie.zha.noFactory.Customer;
import org.junit.Test;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.bind.*;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;

/**
 * Created by ezhayog on 4/16/2016.
 */
public class TestNillableString {

    @Test
    public void testNillableString() throws Exception {
        Customer customer = new Customer();
        customer.setNillableString(null);

        JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
        Marshaller marshaller = jaxbContext.createMarshaller();

        /**
         * Create own jaxb Element
         */
        JAXBElement<Customer> jaxbElement = new JAXBElement<>(new QName(Customer.class.getSimpleName()), Customer.class, customer);
        marshaller.marshal(jaxbElement,System.out);
    }



    @Test
    public void testNillableUnMarshall() throws Exception {
        String xml = "<customer><nillableString>1232</nillableString></customer>";

        Customer obj = unmarshall(xml);
        System.out.println(obj.getNillableString().getValue());


    }


    @Test
    public void testNillableUnMarshallWithNill() throws Exception {
        String xml = "<customer><nillableString nil=\"true\" /></customer>";

        Customer obj = unmarshall(xml);
        System.out.println(obj.getNillableString().getValue());


    }



    private Customer unmarshall(String xml) throws JAXBException, ParserConfigurationException, SAXException, IOException {
        Document doc = getDoc(xml);
        JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        return (Customer) unmarshaller.unmarshal(doc);
    }

    private Document getDoc(String str) throws IOException, SAXException, ParserConfigurationException {
        DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        InputSource is = new InputSource();
        is.setCharacterStream(new StringReader(str));

        return db.parse(is);
    }


}
