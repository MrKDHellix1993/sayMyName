package excercse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import excercse.Record;
 
@SuppressWarnings("unchecked")
public class Main 
{
  public static void main(String[] args) 
  {
    List<Record> recordsList = getRecords();
 
    List<Record> list = recordsList
                .stream()
                .filter(distinctByKeys(Record::getId))
                .collect(Collectors.toList());
 
    System.out.println(list);
  }
 
  private static <T> Predicate<T> distinctByKeys(Function<? super T, ?>... keyExtractors) 
  {
    final Map<List<?>, Boolean> seen = new ConcurrentHashMap<>();
    return t -> 
    {
      final List<?> keys = Arrays.stream(keyExtractors)
                  .map(ke -> ke.apply(t))
                  .collect(Collectors.toList());
       
      return seen.putIfAbsent(keys, Boolean.TRUE) == null;
    };
  }
 
  private static ArrayList<Record> getRecords() 
  {
    ArrayList<Record> records = new ArrayList<>();
 
    records.add(new Record(1l, 10l, "record1", "record1@email.com", "India"));
    records.add(new Record(1l, 20l, "record1", "record1@email.com", "India"));
    records.add(new Record(2l, 30l, "record2", "record2@email.com", "India"));
    records.add(new Record(2l, 40l, "record2", "record2@email.com", "India"));
    records.add(new Record(3l, 50l, "record3", "record3@email.com", "India"));
 
    return records;
  }
}

