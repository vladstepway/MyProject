package sample;

import java.io.Serializable;

public class Message
        implements Serializable
{
    private String message;
    private Object structure;
    static final long serialVersionUID = 5832063776451490808L;

    public Message() {}

    public Message(String message, Object structure)
    {
        this.message = message;
        this.structure = structure;
    }

    public Message(String message)
    {
        this.message = message;
    }

    public String getMessage()
    {
        return this.message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public Object getStructure()
    {
        return this.structure;
    }

    public void setStructure(Object structure)
    {
        this.structure = structure;
    }
}
