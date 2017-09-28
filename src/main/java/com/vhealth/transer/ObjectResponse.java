package com.vhealth.transer;


import com.fasterxml.jackson.annotation.JsonInclude;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
//@XmlSeeAlso(PersonDTO.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ObjectResponse<T>  extends BaseResponse{

    //@XmlAnyElement
    @XmlAnyElement(lax=true)
    T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
