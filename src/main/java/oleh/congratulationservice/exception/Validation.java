package oleh.congratulationservice.exception;

import java.util.ArrayList;
import java.util.List;

public class Validation<T, G extends RuntimeException> {
    private T data;
    private List<G> exceptions = new ArrayList<>();

    public void add(G exc){
        exceptions.add(exc);
    }

    public boolean isValid(){
        return exceptions.isEmpty();
    }

    public T getData(){
        if(!isValid())
            throw new RuntimeException("Validation failed");
        return data;
    }

    public void setData(T data){
        this.data = data;
    }

    public List<G> getExceptions(){
        return exceptions;
    }
}
