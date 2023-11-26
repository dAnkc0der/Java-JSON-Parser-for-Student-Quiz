package org.example;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class jsonParser {
    public static void main(String[] args) {
        String jsonData = """
                [
                    {
                        "student": "Student1",
                        "questions": [
                          {
                            "question": "What is the capital of France?",
                            "options": ["Berlin", "Madrid", "Paris", "Rome"],
                            "correct_answer": "Paris",
                            "user_answer": "Pis"
                          },
                          {
                            "question": "What is the largest planet in our solar system?",
                            "options": ["Earth", "Jupiter", "Mars", "Venus"],
                            "correct_answer": "Jupiter",
                            "user_answer": "Mas"
                          },
                          {
                            "question": "Who wrote the play 'Romeo and Juliet'?",
                            "options": ["Shakespeare", "Hemingway", "Tolkien", "Dickens"],
                            "correct_answer": "Shakespeare",
                            "user_answer": "Shakpeare"
                          }
                        ]
                      },
                      {
                        "student": "Student2",
                        "questions": [
                          {
                            "question": "What is the capital of France?",
                            "options": ["Berlin", "Madrid", "Paris", "Rome"],
                            "correct_answer": "Paris",
                            "user_answer": "Paris"
                          },
                          {
                            "question": "What is the largest planet in our solar system?",
                            "options": ["Earth", "Jupiter", "Mars", "Venus"],
                            "correct_answer": "Jupiter",
                            "user_answer": "Jupit"
                          },
                          {
                            "question": "Who wrote the play 'Romeo and Juliet'?",
                            "options": ["Shakespeare", "Hemingway", "Tolkien", "Dickens"],
                            "correct_answer": "Shakespeare",
                            "user_answer": "Shakespea"
                          }
                        ]
                      },
                      {
                        "student": "Student3",
                        "questions": [
                          {
                            "question": "What is the capital of France?",
                            "options": ["Berlin", "Madrid", "Paris", "Rome"],
                            "correct_answer": "Paris",
                            "user_answer": "Paris"
                          },
                          {
                            "question": "What is the largest planet in our solar system?",
                            "options": ["Earth", "Jupiter", "Mars", "Venus"],
                            "correct_answer": "Jupiter",
                            "user_answer": "Jupiter"
                          },
                          {
                            "question": "Who wrote the play 'Romeo and Juliet'?",
                            "options": ["Shakespeare", "Hemingway", "Tolkien", "Dickens"],
                            "correct_answer": "Shakespeare",
                            "user_answer": "Shakespea"
                          }
                        ]
                      },
                      {
                        "student": "Student4",
                        "questions": [
                          {
                            "question": "What is the capital of France?",
                            "options": ["Berlin", "Madrid", "Paris", "Rome"],
                            "correct_answer": "Paris",
                            "user_answer": "Paris"
                          },
                          {
                            "question": "What is the largest planet in our solar system?",
                            "options": ["Earth", "Jupiter", "Mars", "Venus"],
                            "correct_answer": "Jupiter",
                            "user_answer": "Jupiter"
                          },
                          {
                            "question": "Who wrote the play 'Romeo and Juliet'?",
                            "options": ["Shakespeare", "Hemingway", "Tolkien", "Dickens"],
                            "correct_answer": "Shakespeare",
                            "user_answer": "Shakespeare"
                          }
                        ]
                     }
                ]
                """;

        JSONArray studentData = new JSONArray(jsonData);
        List<StudentScore> studentScores = new ArrayList<>();
        for(int i = 0; i < studentData.length(); i++){
            JSONObject studentObject = studentData.getJSONObject(i);
            String student = studentObject.getString("student");
            JSONArray question = studentObject.getJSONArray("questions");
            int total = 0;
            for(int j = 0; j < question.length(); j++) {
                JSONObject questionData = question.getJSONObject(j);
                String questionValue = questionData.getString("question");
                JSONArray options = questionData.getJSONArray("options");
                String correct_answer = questionData.getString("correct_answer");
                String user_answer = questionData.getString("user_answer");
                int marks = checkCorrect(correct_answer, user_answer);
                total = total + marks;
                System.out.println(student);
                System.out.println(questionValue);
                System.out.println(options.toString());
                System.out.println(correct_answer);
                System.out.println(user_answer);
                System.out.println(marks);
                System.out.println();
            }
            System.out.println("Total Score for " + student + ": " + total);
            System.out.println();
            studentScores.add(new StudentScore(student, total));
        }
        Collections.sort(studentScores, (s1, s2) -> Integer.compare(s2.total, s1.total));
        System.out.println("Students sorted by score (descending order):");
        for (StudentScore student : studentScores) {
            System.out.println(student.student + ": " + student.total);
        }

    }

    public static int checkCorrect(String correct_answer, String user_answer){
        return user_answer.equals(correct_answer)?4:-1;
    }
}

class StudentScore{
    String student;
    int total;
    public StudentScore(String student, int total){
        this.student = student;
        this.total = total;
    }
}