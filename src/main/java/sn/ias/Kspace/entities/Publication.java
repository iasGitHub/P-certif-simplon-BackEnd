package sn.ias.Kspace.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Publication {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    @Lob // annotation qui suggère à la bd de stocker des informations volumineuses
    @Column
    @NotNull
    private String content;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dateOfPublication;
    private Long nbreOfViews = 1L;
    private String picture;
    private boolean active = false;

    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    private Note note;

    @OneToMany(mappedBy = "publication", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Comment> comments = new LinkedHashSet<>();


}
