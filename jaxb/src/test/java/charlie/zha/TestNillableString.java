package charlie.zha;

import charlie.zha.jaxbutils.JaxbElementFactory;
import org.example.customer.Customer;
import org.junit.Before;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;

/**
 * Created by ezhayog on 4/16/2016.
 */
public class TestNillableString {

    @Test
    public void testNillableString() throws Exception {
        Customer customer = new Customer();
        customer.setNillableString(JaxbElementFactory.nillString("nillString"));

        JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
        Marshaller marshaller = jaxbContext.createMarshaller();

        /**
         * Create own jaxb Element
         */
        JAXBElement<Customer> jaxbElement = new JAXBElement<>(new QName(Customer.class.getSimpleName()), Customer.class, customer);

        marshaller.marshal(jaxbElement,System.out);

    }
}
