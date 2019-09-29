package main.List;

public interface Iterator {
     void first()  throws Exception;
     void next() throws Exception;
     boolean isDone();
     Object currentItem();
}
