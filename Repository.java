import java.util.ArrayList;
import java.util.List;

public class Repository {
    private List<Hardware> data;

    public Repository() {
        data = new ArrayList<>();
        // Initial Batch from PDF Table [cite: 41]
        data.add(new Laptop(1, "Dell XPS 13", 16));
        data.add(new Phone(2, "Samsung S24", 50));
        data.add(new Laptop(3, "MacBook Pro", 32));
        data.add(new Phone(4, "iPhone 15", 48));
        data.add(new Laptop(5, "ASUS Zenbook", 16));
        data.add(new Phone(6, "Google Pixel 8", 50));
        data.add(new Laptop(7, "Lenovo Legion", 32));
        data.add(new Phone(8, "Huawei P60", 48));
        data.add(new Laptop(9, "HP Spectre", 16));
        data.add(new Phone(10, "Sony Xperia", 16));
    }

    public void addHardware(Hardware item) {
        data.add(item);
    }

    public List<Hardware> getHardwareData() {
        return data;
    }
}