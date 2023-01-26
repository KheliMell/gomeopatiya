package web.model;

import javax.persistence.*;

@SuppressWarnings("unused")
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "role",
            unique = true)
    private String name;

    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String role) {
        this.name = role;
    }

    //GrantedAuthority impl [Start]
//    @Override
//    public String getAuthority() {
//        return name;
//    }
    //GrantedAuthority impl [End]
}