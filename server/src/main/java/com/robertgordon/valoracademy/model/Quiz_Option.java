package com.robertgordon.valoracademy.model;

import javax.persistence.*;
import lombok.Data;

/** `@Entity` is being used to map this class to a database table. 
 * `@Table(name = "options")` specifies the name of the table in the database that
 * this entity will be mapped to. 
 * `@Data` is a Lombok annotation that generates boilerplate code for getters, setters,
 *  and other methods. */
@Entity
@Table(name = "options")
@Data
public class Quiz_Option {

     /** `@Id` is an annotation used to mark the primary key of the entity. 
     * `@GeneratedValue` is used to specify how the primary key should be generated. 
     * `GenerationType.IDENTITY` specifies that the primary key should be generated by
     *  the database. 
     * `private long id;` is a field that represents the primary key of the entity. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

     /** `@Column(name = "content", nullable = false)` is an annotation used to specify
      *  that the `content`
     *  field should be mapped to a column in the database table named `content`. 
     *  The `nullable = false` parameter specifies that the `content` field cannot be 
     * null in the database. 
     * The `private String content;` line is declaring a field named `content` of type 
     * `String` in the `Quiz_Option` class. */
    @Column(name = "content", nullable = false)
    private String content;

}
