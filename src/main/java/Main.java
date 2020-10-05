public class Main {

    public static void main(String[] args) {
        Phone phone = new Iphone10();

        phone.addContact("1", "12", "a", "c");
        phone.addContact("2", "13", "b", "d");
        phone.listContacts();

        phone.sendMessage("12", "gg34tgtgwrfg3eh45yhy5gr");
        phone.listMessages("12");

        // send a message to the second contact from the previous listed
        phone.call("13");
        phone.viewHistory();


    }
}
