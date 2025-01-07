public class PrivateTester {

    public static Tester tester = new Tester();
    public static void main(String[] args) {
        boolean ans1 = recommendWhoToFollowTest3();
        System.out.println(ans1);
    }
    
    public static boolean recommendWhoToFollowTest1() {
        Network network = new Network(10);
        network.addUser("Alice");
        network.addUser("Bob");
        network.addUser("Charlie");
        network.addUser("Dave");
        network.addUser("Eve");
    
        network.addFollowee("Alice", "Bob");
        network.addFollowee("Alice", "Dave");
        network.addFollowee("Dave", "Charlie");
        network.addFollowee("Bob", "Charlie");
        network.addFollowee("Charlie", "Dave");
        network.addFollowee("Dave", "Eve");
        
        String expected = "Charlie";
        String actual = "";
        try {
            actual += network.recommendWhoToFollow("Alice");
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return tester.test("Recommend Charlie for Alice in a transitive follow scenario", expected, actual);
    }
    
    public static boolean recommendWhoToFollowTest2() {
        Network network = new Network(10);
        network.addUser("Alice");
        network.addUser("Bob");
        network.addUser("Charlie");
        network.addUser("Dave");
        network.addUser("Eve");
        network.addUser("Frank");
    
        network.addFollowee("Alice", "Bob");
        network.addFollowee("Bob", "Charlie");
        network.addFollowee("Charlie", "Dave");
        network.addFollowee("Eve", "Charlie");
        network.addFollowee("Frank", "Charlie");
        network.addFollowee("Alice", "Frank");
        network.addFollowee("Frank", "Bob");
    
        String expected = "Bob";
        String actual = "";
        try {
            actual += network.recommendWhoToFollow("Eve");
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return tester.test("Recommend Bob to Eve via Charlie", expected, actual);
    }
    
    public static boolean recommendWhoToFollowTest3() {
        Network network = new Network(15);
        network.addUser("Alice");
        network.addUser("Bob");
        network.addUser("Charlie");
        network.addUser("Dave");
        network.addUser("Eve");
        network.addUser("Frank");
        network.addUser("Grace");
        network.addUser("Hank");
    
        network.addFollowee("Alice", "Frank");
        network.addFollowee("Bob", "Charlie");
        network.addFollowee("Charlie", "Dave");
        network.addFollowee("Dave", "Eve");
        network.addFollowee("Eve", "Frank");
        network.addFollowee("Grace", "Eve");
        network.addFollowee("Hank", "Eve");
        network.addFollowee("Bob", "Dave");
        network.addFollowee("Charlie", "Eve");
    
        String expected = "Eve";
        String actual = "";
        try {
            actual += network.recommendWhoToFollow("Alice");
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }

        return tester.test("Recommend Eve to Alice", expected, actual);
    }

}
