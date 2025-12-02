package net.alkeity.homework3.task3;

public class Product {
    private String name;
    private Money price;

    public Product(String name, Money price) {
        setName(name);
        setPrice(price);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Money getPrice() {
        return price;
    }

    public void setPrice(Money price) {
        this.price = price;
    }

    public void printPrice() {
        price.printAmount();
    }

    public void changePrice(int integer, int fraction)
    {
        // you can make it cheaper by using negative values
        int newInt = price.getInteger() + integer;
        int newFraction = price.getFraction() + fraction;
        price.setAmount(newInt, newFraction);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;
        return name.equals(product.name) && price.equals(product.price);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + price.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
