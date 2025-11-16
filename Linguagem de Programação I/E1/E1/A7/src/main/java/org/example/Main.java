package org.example;

public class Main {
    public static void main(String[] args) {

        Person she = new Person("She", "skin too hard to leave a puncture", "untouchable");
        Memory misalignment = new Memory("misalignment in tears", 10, 10);
        Emotion longing = new Emotion("longing to forget", 10, 10);

        PersonDAO personDAO = new PersonDAO();
        MemoryDAO memoryDAO = new MemoryDAO();
        EmotionDAO emotionDAO = new EmotionDAO();

        // CREATE
        personDAO.create(she);
        memoryDAO.create(misalignment);
        emotionDAO.create(longing);

        // READ
        System.out.println("\n--- LISTANDO DADOS ---");
        personDAO.read();
        memoryDAO.read();
        emotionDAO.read();

        // UPDATE
        personDAO.update("She", "blurred through my hands", "conflicted");
        memoryDAO.update("misalignment in tears", 20, 3);
        emotionDAO.update("longing to forget", 5, 5);

        // DELETE
        personDAO.delete("She");

        System.out.println("\nLinha narrativa:");
        System.out.println(she.getName() + " carries the " + misalignment.getContent() + " while feeling " + longing.getType() + ".");
    }
}