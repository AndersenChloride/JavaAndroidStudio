import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        List<workingStaff> staffList = new ArrayList<>();
        staffList.add(new clerk(5000, 30000, "Clerk 1", "John"));
        staffList.add(new clerk(5000, 30000, "Clerk 2", "Alice"));
        staffList.add(new viceDirector(20000, 70000, "Vice Director 1", "Mike"));
        staffList.add(new viceDirector(10000, 80000, "Vice Director 2", "Susan"));
        staffList.add(new director(100000, 150000, "Director 1", "Bob"));


        Collections.sort(staffList);

        for (Object staff : staffList) {
            System.out.println(staff);
        }

    }
}