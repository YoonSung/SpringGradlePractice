package architree.yoon.domain;

import javax.persistence.*;

/**
 * Created by yoon on 15. 3. 25..
 */
@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pid;

    @Column
    private String id;

    @Column
    private String password;

    @Column
    private String name;

    @Column
    private int age;

    public User(){}

    public User(String id, String password, String name, int age) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.age = age;
    }

    public boolean isValid() {
        return true;
    }

    public String getName() {
        return this.name;
    }
}
