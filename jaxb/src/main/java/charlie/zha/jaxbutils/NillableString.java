package charlie.zha.jaxbutils;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * Created by ezhayog on 4/16/2016.
 */
public class NillableString {
    public static final String XSI = "http://www.w3.org/2001/XMLSchema-instance";

    @XmlAttribute(namespace = XSI)
    protected String nil;
    protected String value;

    public String getNil() {
        return nil;
    }

    public void setNil(String nil) {
        this.nil = nil;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
