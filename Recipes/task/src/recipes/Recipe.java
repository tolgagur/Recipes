package recipes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import recipes.user.User;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "recipe")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;
    @NotBlank
    public String name;

    @NotBlank
    public String category;

    @NotBlank
    public String description;
    @Column(name = "date")
    public LocalDateTime date = LocalDateTime.now();;

    @ElementCollection
    @CollectionTable(name="ingredients")
    public List<String> ingredients= new ArrayList<String>();

    @ElementCollection
    @CollectionTable(name="directions")
    public List<String> directions = new ArrayList<String>();


    @LastModifiedBy
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ADDED_BY")
    private User user;

}
