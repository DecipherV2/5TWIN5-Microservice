package tn.esprit.mscourse.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table( name ="Course")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCourse;
    private String titleCourse;
    private String thumbnailCourse;
    private String category;
    private String descriptionCourse;
    private String coach; // You can use ObjectId here if needed
    private Date DateCourse;
    //   private List<Lesson> lessons;
}

