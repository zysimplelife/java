package charlie.zha.jaxbutils;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

/**
 * Created by ezhayog on 4/16/2016.
 */
public class JaxbElementFactory {
    /**
     * Create JaxbElement for given object
     * It used when we want to create some element without object factory
     * @param name the tag name
     * @param clz  the class which want to marshall to xml
     * @param obj the object of the instance
     * @return
     */
    public static <T> JAXBElement<T> JAXBElement(String name, Class<T> clz, T obj){
        return new JAXBElement<>(new QName(name),clz,obj);
    }

    /**
     * Create JaxbElement for given object
     * It used when we want to create some element without object factory
     * @param tagName the tag name
     * @return
     */
    public static JAXBElement<String> nillString(String tagName){
        return new JAXBElement<>(new QName(tagName),String.class,null);
    }

}
