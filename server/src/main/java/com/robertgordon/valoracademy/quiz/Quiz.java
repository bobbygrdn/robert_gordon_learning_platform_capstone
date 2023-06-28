package com.robertgordon.valoracademy.quiz;

import java.util.List;

import javax.persistence.*;

import com.robertgordon.valoracademy.quiz_question.Quiz_Question;

import lombok.Data;

/**
 * `@Entity` is being used to map this class to a database table.
 * `@Table(name = "quizzes")` specifies the name of the table in the database
 * that
 * this entity will be mapped to.
 * `@Data` is a Lombok annotation that generates boilerplate code for getters,
 * setters, and other methods.
 */
@Entity
@Table(name = "quizzes")
@Data
public class Quiz {

    /**
     * `@Id` is an annotation used to mark the primary key of the entity.
     * `@GeneratedValue` is used to specify how the primary key should be generated.
     * `GenerationType.IDENTITY` specifies that the primary key should be generated
     * by
     * the database.
     * `private long id;` is a field that represents the primary key of the entity.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * `@Column(name = "title", nullable = false)` is an annotation used to specify
     * that the `title`
     * field should be mapped to a column in the database table named `title`.
     * The `nullable = false` parameter specifies that the `title` field cannot be
     * null in the database.
     * The `private String title;` line is declaring a field named `title` of type
     * `String` in the `Quiz` class.
     */
    @Column(name = "title", nullable = false, columnDefinition = "text", length = 10000000)
    private String title;

    /**
     * `@Column(name = "description", nullable = false)` is an annotation used to
     * specify that the `description`
     * field should be mapped to a column in the database table named `description`.
     * The `nullable = false` parameter specifies that the `description` field
     * cannot be null in the database.
     * The `private String description;` line is declaring a field named
     * `description` of type `String` in the `Quiz` class.
     */
    @Column(name = "description", nullable = false, columnDefinition = "text", length = 10000000)
    private String description;

    /**
     * `@Column(name = "published", nullable = false, columnDefinition = "boolean
     * default 'false'")` is an annotation used to
     * specify that the `isPublished`
     * field should be mapped to a column in the database table named
     * `published`.
     * The `nullable = false` parameter specifies that the `isPublished` field
     * cannot be null in the database.
     * The `columnDefinition` is used to define the default value of the column
     * which
     * in this case is set to false
     * The `private boolean isPublished;` line is declaring a field named
     * `isPublished` of type `boolean` in the `Quiz` class.
     */
    @Column(name = "published", nullable = false, columnDefinition = "TINYINT(1) default 0")
    private boolean isPublished;

    /**
     * `@Column(name = "finished", nullable = false, columnDefinition =
     * "varchar(255)
     * default 'false'")` is an annotation used to
     * specify that the `isUserFinished`
     * field should be mapped to a column in the database table named
     * `finished`.
     * The `nullable = false` parameter specifies that the `isUserFinished` field
     * cannot be null in the database.
     * The `columnDefinition` is used to define the default value of the column
     * which
     * in this case is set to false
     * The `private boolean isUserFinished;` line is declaring a field named
     * `isUserFinished` of type `boolean` in the `Quiz` class.
     */
    @Column(name = "finished", nullable = false, columnDefinition = "TINYINT(1) default 0")
    private boolean isUserFinished;

    /**
     * This code is defining a one-to-many relationship between the `Quiz_Question`
     * entity and the `Quiz` entity.
     * `JoinColumn` is being used to name the column `lesson_id`
     * in the `questions` table that references the `id` column in the `quizzes`
     * table.
     * `Private List<Quiz_Question> questions` is being used to save all the
     * questions
     * belonging to the `Quiz` in an `ArrayList`.
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "quiz_id")
    private List<Quiz_Question> questions;

}
