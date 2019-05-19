package org.hillel.demo;

import java.io.Serializable;

public class UserParent implements Serializable {

    protected String parentVar = "111";

    public UserParent() {
        System.out.println("Parent default constructor");
    }

    public String getParentVar() {
        return parentVar;
    }

    public void setParentVar(String parentVar) {
        this.parentVar = parentVar;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("UserParent{");
        sb.append("parentVar='").append(parentVar).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
