import java.util.ArrayList;
import java.util.List;

class Contact {

    private String id;
    private String phoneNumber;
    private String fistName;
    private String lastName;

    public Contact(String id, String phoneNumber, String firstName, String lastName){
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.fistName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id='" + id + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", fistName='" + fistName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
class Call{
    private String phoneNumber;

    public Call(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Called{" +
                "phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
class Message {

    private String phoneNumber;
    private String message;

    public Message( String phoneNumber, String message) {
        this.phoneNumber = phoneNumber;
        this.message = message;
    }

    @Override
    public String toString() {
        return "Message{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getMessage() {
        return message;
    }
}
abstract class Phone implements Ability{

    private int batteryLife;
    private String color;
    private String material;
    private int imei;
    private List<Contact> contacts;
    private List<Message> messages;
    private List<Call> calls;

    protected Phone(int batteryLife, String color, String material, int imei){
        this.batteryLife = batteryLife;
        this.color = color;
        this.material = material;
        this.imei = imei;
        this.contacts = new ArrayList<>();
        this.messages = new ArrayList<>();
        this.calls = new ArrayList<>();
    }


    public void setColor(String color) {
        this.color = color;
    }

    public void setMaterial(String material) {
        this.material = material;
    }


    @Override
    public void addContact(String id, String phoneNumber, String firstName, String lastName) {
        this.contacts.add(new Contact (id, phoneNumber, firstName, lastName));
    }

    @Override
    public void listContacts() {
        for (int i = 0; i < contacts.size(); i++){
            System.out.println(contacts.get(i));
        }
    }

    @Override
    public void sendMessage(String phoneNumber, String message) {
        if(message.length() > 500){
            System.out.println("Write a shorter message!!!");
        }
        else {
            this.batteryLife = batteryLife - 1;
            this.messages.add(new Message(phoneNumber, message));
        }

    }

    @Override
    public void listMessages(String phoneNumber) {
        for(int i = 0; i < messages.size(); i++){
            if (phoneNumber.contentEquals(messages.get(i).getPhoneNumber())){
                System.out.println(messages.get(i));
        }
        }
    }

    @Override
    public void call(String phoneNumber) {
        this.batteryLife = batteryLife - 2;
        this.calls.add(new Call(phoneNumber));
    }

    @Override
    public void viewHistory() {
        System.out.println("Call history: ");
        for ( int i = 0; i < calls.size(); i++){
            System.out.println(calls.get(i));
        }
    }


}
