package rs.ac.bg.fon.ps.common.communication;

import java.io.Serializable;

public class Request implements Serializable {

    private int operation;
    private Object argument;

    public Request() {
    }

    public Request(int operation, Object argument) {
        this.operation = operation;
        this.argument = argument;
    }

    public int getOperation() {
        return operation;
    }

    public void setOperation(int operation) {
        this.operation = operation;
    }

    public Object getArgument() {
        return argument;
    }

    public void setArgument(Object argument) {
        this.argument = argument;
    }
}