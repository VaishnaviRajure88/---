import java.util.*;
import java.util.concurrent.*;

public class MCQSystem {
    private static final int TIME_LIMIT = 60; 
    private static final Scanner scanner = new Scanner(System.in);

    public void startQuiz() {
        List<Question> questions = createQuestions();
        int score = 0;

        System.out.println("\nStarting the quiz. You have " + TIME_LIMIT + " seconds to complete the quiz.");
        
        
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        Runnable task = () -> {
            System.out.println("\nTime's up! Auto-submitting your answers.");
            System.exit(0); 
        };

        
        scheduler.schedule(task, TIME_LIMIT, TimeUnit.SECONDS);

        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            System.out.println("\nQ" + (i + 1) + ": " + q.getQuestionText());
            System.out.println("a) " + q.getOptionA());
            System.out.println("b) " + q.getOptionB());
            System.out.println("c) " + q.getOptionC());
            System.out.println("d) " + q.getOptionD());
            System.out.print("Your answer: ");
            String answer = scanner.nextLine().toLowerCase();

            if (answer.equals(q.getCorrectAnswer())) {
                score++;
            }
        }

        
        System.out.println("\nQuiz finished. Your score: " + score + "/" + questions.size());
        scheduler.shutdown(); 
    }

    private List<Question> createQuestions() {
        List<Question> questions = new ArrayList<>();
        
       
        questions.add(new Question("What is the capital of India?", "Delhi", "Rome", "Berlin", "Madrid", "a"));
        questions.add(new Question("What is 2 + 2?", "3", "4", "5", "6", "b"));
        questions.add(new Question("Who developed Java?", "James Gosling", "Dennis Ritchie", "Bjarne Stroustrup", "Guido van Rossum", "a"));
        
        return questions;
    }
}

class Question {
    private String questionText;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String correctAnswer;

    public Question(String questionText, String optionA, String optionB, String optionC, String optionD, String correctAnswer) {
        this.questionText = questionText;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String getOptionA() {
        return optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
}

