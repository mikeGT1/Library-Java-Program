import java.util.ArrayList;

public class Library {
    private ArrayList<Item> items;
    private ArrayList<Member> members;

    public Library() {
        items = new ArrayList<>();
        members = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public void displayItems() {
        for (Item item : items) {
            System.out.println(item.displayInfo());
        }
    }

    public void displayMembers() {
        for (Member member : members) {
            System.out.println(member.displayInfo());
        }
    }

    public Item findItem(String title) {
        for (Item item : items) {
            if (item.getTitle().equalsIgnoreCase(title)) {
                return item;
            }
        }
        return null;
    }
}
