package com.robertgordon.valoracademy.quiz_question;

import java.util.List;

import javax.persistence.*;

import com.robertgordon.valoracademy.quiz_answer.Quiz_Answer;
import com.robertgordon.valoracademy.quiz_option.Quiz_Option;

import lombok.Data;

/** `@Entity` is being used to map this class to a database table. 
 * `@Table(name = "questions")` specifies the name of the table in the database that
 * this entity will be mapped to. 
 * `@Data` is a Lombok annotation that generates boilerplate code for getters, setters,
 *  and other methods. */
@Entity
@Table(name = "questions")
@Data
public class Quiz_Question {

    /** `@Id` is an annotation used to mark the primary key of the entity. 
     * `@GeneratedValue` is used to specify how the primary key should be generated. 
     * `GenerationType.IDENTITY` specifies that the primary key should be generated by
     *  the database. 
     * `private long id;` is a field that represents the primary key of the entity. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** `@Column(name = "title", nullable = false)` is an annotation used to specify 
     * that the `title`
     * field should be mapped to a column in the database table named `title`. 
     * The `nullable = false` parameter specifies that the `title` field cannot be null 
     * in the database. 
     * The `private String title;` line is declaring a field named `title` of type 
     * `String` in the `Quiz_Question` class. */
    @Column(name = "title", nullable = false)
    private String title;

    /** `@Column(name = "content", nullable = false)` is an annotation used to specify 
     * that the `content`
     *  field should be mapped to a column in the database table named `content`. 
     *  The `nullable = false` parameter specifies that the `content` field cannot be 
     * null in the database. 
     * The `private String content;` line is declaring a field named `content` of type
     *  `String` in the `Quiz_Question` class. */
    @Column(name = "content", nullable = false)
    private String content;

     /** `@Column(name = "published", nullable = false, columnDefinition = "boolean 
     * default 'false'")` is an annotation used to 
     * specify that the `isPublished`
     *  field should be mapped to a column in the database table named 
     * `published`. 
     *  The `nullable = false` parameter specifies that the `isPublished` field 
     * cannot be null in the database. 
     * The `columnDefinition` is used to define the default value of the column which
     * in this case is set to false
     * The `private boolean isPublished;` line is declaring a field named `isPublished` of type `boolean` in the `Quiz_Question` class. */
    @Column(name = "published", nullable = false, columnDefinition = "boolean default 'false'")
    private boolean isPublished;

     /** This code is defining a one-to-many relationship between the `quiz_option` entity and the `Quiz_Question` entity.
     *  `JoinColumn` is being used to name the column `question_id`
     *  in the `options` table that references the `id` column in the `questions` 
     * table. 
     *  `Private List<Quiz_Option> options` is being used to save all the options
     *  belonging to the `Quiz_Question` in an `ArrayList`. */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private List<Quiz_Option> options;

     /** This code is defining a one-to-many relationship between the `Quiz_Answer` 
      * entity and the `Quiz_Question` entity.
     *  `JoinColumn` is being used to name the column `question_id`
     *  in the `answers` table that references the `id` column in the `questions` 
     * table. 
     *  `Private List<Quiz_Answer> answerss` is being used to save all the answers 
     * belonging to the `Quiz_Question` in an `ArrayList`. */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private List<Quiz_Answer> answers;

}
