package org.hillel.demo;

import java.io.*;

public class User extends UserParent implements Externalizable {

    private static final long serialVersionUID = 4L;

    private int intVar;

    private String stringVar;

    private transient String stringVar2 = "111111";

    public User() {
        System.out.println("User default constructor");
    }

    public User(int intVar, String stringVar) {
        System.out.println("User non default constructor");
        this.intVar = intVar;
        this.stringVar = stringVar;
    }

    public int getIntVar() {
        return intVar;
    }

    public void setIntVar(int intVar) {
        this.intVar = intVar;
    }

    public String getStringVar() {
        return stringVar;
    }

    public void setStringVar(String stringVar) {
        this.stringVar = stringVar;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("User{");
        sb.append("intVar=").append(intVar);
        sb.append(", stringVar='").append(stringVar).append('\'');
        sb.append(", stringVar2='").append(stringVar2).append('\'');
        sb.append(", parentProperties ='").append(super.toString()).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(this.intVar);
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        int intVar_ = in.readInt();
        this.intVar = intVar_;
    }
}
