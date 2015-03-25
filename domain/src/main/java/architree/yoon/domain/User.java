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
    private Long id;

    @Column
    private String name;

    @Column
    private int age;
}
