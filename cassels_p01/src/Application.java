public class Application {
    public static void main(String[] args) {
        //create instance
        DuplicateRemover duplicateRemover = new DuplicateRemover();

        //remove duplicates
        duplicateRemover.remove("problem1.txt");

        //store unique
        duplicateRemover.write("unique_words.txt");
    }
}
