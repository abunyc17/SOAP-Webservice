
package com.application.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 2.6.13
 * Tue Sep 03 08:50:30 WAT 2019
 * Generated source version: 2.6.13
 */

@XmlRootElement(name = "fetchUser", namespace = "http://application.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "fetchUser", namespace = "http://application.com/")

public class FetchUser {

    @XmlElement(name = "REQUEST")
    private com.application.fetchUser.FetchUserRequest REQUEST;

    public com.application.fetchUser.FetchUserRequest getREQUEST() {
        return this.REQUEST;
    }

    public void setREQUEST(com.application.fetchUser.FetchUserRequest newREQUEST)  {
        this.REQUEST = newREQUEST;
    }

}
