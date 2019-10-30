public class Application {
    public static void main(String[] args) {
        //create instance
        DuplicateCounter duplicateCounter = new DuplicateCounter();

        //remove duplicates
        duplicateCounter.count("problem2.txt");

        //store unique
        duplicateCounter.write("unique_word_counts.txt");
    }
}
