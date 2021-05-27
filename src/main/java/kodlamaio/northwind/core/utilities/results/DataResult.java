package kodlamaio.northwind.core.utilities.results;

public class DataResult<T> extends Result {
    //Generic
    private T data;
    public DataResult(T data, boolean success, String message) { //mesajlı olan
        super(success, message); // base sınıfa yollamış oluyoruz
        this.data = data;
    }
    public DataResult(T data, boolean success) { // mesajsız olan
        super(success); // base sınıfa yollamış oluyoruz
        this.data = data;
    }

    public T getData() {
        return this.data;
    }
}
