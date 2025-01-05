package gr.aueb.cf.cf6finalproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "foods")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double caloriesPerGram;

    @Column(nullable = false)
    private Double carbsPerGram;

    @Column(nullable = false)
    private Double proteinPerGram;

    @Column(nullable = false)
    private Double fatPerGram;

    @Column(nullable = false)
    private Double fiberPerGram;

    @Column(name = "vita_per_gram")            //hibernate was not mapping correctly
    private Double vitaminAPerGram;

    @Column(name = "vitb_per_gram")             //hibernate was not mapping correctly
    private Double vitaminBPerGram;

    @Column(name = "vitc_per_gram")             //hibernate was not mapping correctly
    private Double vitaminCPerGram;

    @Column(nullable = false)
    private Double ironPerGram;

    @Column(nullable = false)
    private Double calciumPerGram;
}
