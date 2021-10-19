import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBook {
    private HashMap<String, ArrayList<String>> phones = new HashMap<>();
    public void add(String name,String phone){
        ArrayList<String> phonesList = phones.get(name);
        phonesList.add(phone);
        phones.put(name,phonesList);
    }
    public String get(String name){
        return phones.get(name).toString();
    }
}
