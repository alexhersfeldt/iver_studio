package alexhersfeldt.iver_studio.Item.Entity;


import alexhersfeldt.iver_studio.User.Entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    String description;

    @Column(nullable = false)
    long price;

    @JsonIgnore
    @ManyToMany(mappedBy = "interested_items")
    private Set<User> users = new HashSet<>();



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return price == item.price && id.equals(item.id) && name.equals(item.name) && description.equals(item.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, price);
    }
}


