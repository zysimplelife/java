package charlie.zha.jaxbutils;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

/**
 * Created by ezhayog on 4/16/2016.
 */

public class NillableString  extends JAXBElement{

    public NillableString(QName name, Class declaredType, Class scope, Object value) {
        super(name, declaredType, scope, value);
    }

    public NillableString(QName name, Class declaredType, Object value) {
        super(name, declaredType, value);
    }

    public NillableString(){
        super(new QName("test"),String.class,null);
    }

    public NillableString(String tagName){
        super(new QName(tagName),String.class,null);
    }

}
