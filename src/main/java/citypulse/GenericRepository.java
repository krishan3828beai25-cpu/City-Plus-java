package citypulse;

import java.util.ArrayList;
import java.util.List;

// A simple generic in-memory repository. T can be any object type.
public class GenericRepository<T> {
    private final List<T> items = new ArrayList<>();

    public void add(T item) { items.add(item); }
    public List<T> getAll() { return new ArrayList<>(items); }
    public int size() { return items.size(); }
    public void clear() { items.clear(); }
}
