package ra.entity;

import java.io.Serializable;

public class Laptop implements Serializable {
int id ;
String name;

    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}