package alexhersfeldt.iver_studio.User.Entity;


import alexhersfeldt.iver_studio.Item.Entity.Item;
import alexhersfeldt.iver_studio.User.DTO.UserRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true)
    private String email;

    @Column
    private String password;

    @Column
    private boolean admin = false;

    @ManyToMany
    @JoinTable(
            name = "interested_items",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "item_id", referencedColumnName = "id"))
    private Set<Item> interested_items = new HashSet<>();

    public void addItemToInterestedItems(Item item) {
        interested_items.add(item);
    }
}
