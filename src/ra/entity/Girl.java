package ra.entity;

import java.io.Serializable;

public class Girl implements Serializable {
    private double v1,v2,v3,height, weight;
    private String name;
    private int age;

    public Girl() {
    }

    public Girl(double v1, double v2, double v3, double height, double weight, String name, int age) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
        this.height = height;
        this.weight = weight;
        this.name = name;
        this.age = age;
    }

    public double getV1() {
        return v1;
    }

    public void setV1(double v1) {
        this.v1 = v1;
    }

    public double getV2() {
        return v2;
    }

    public void setV2(double v2) {
        this.v2 = v2;
    }

    public double getV3() {
        return v3;
    }

    public void setV3(double v3) {
        this.v3 = v3;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "name='" + name + '\'' +
                ", v3=" + v3 +
                ", v2=" + v2 +
                ", v1=" + v1 +
                '}';
    }
}
