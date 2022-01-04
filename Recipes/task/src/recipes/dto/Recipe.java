package recipes.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.LastModifiedBy;
import recipes.dto.user.User;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
