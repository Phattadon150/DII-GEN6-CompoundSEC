import java.util.ArrayList;
import java.util.List;

public class Patient {
    private String id;
    private String name;
    private List<String> history;

    public Patient(String id, String name) {
        this.id = id;
        this.name = name;
        this.history = new ArrayList<>();
    }

    public void addHistory(String record) {
        history.add(record);
    }

    public List<String> getHistory() {
        return history;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}
