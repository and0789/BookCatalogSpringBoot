package com.itc.bookcatalogv2.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "author")
// @DynamicUpdate
@SQLDelete(sql = "UPDATE author SET deleted = true WHERE id = ?")
@Where(clause = "deleted=false")// agar tidak perlu menambahkan clausa tambahan
public class Author {

    // postgres -> bigserial
    // mysql -> autoincrement
    // strategy -> identity -> cons: batch insert disable
    // batch insert -> store procedure
    // strategy -> sequence -> pros: enable batch insert

    // Dynamic Update --> perfoma aplikasi akan meningkat jika jumlah kolom banyak sedangkan yang di update hanya satu atau dua kolom saja
    // perfoma aplikasi akan menurun jika kolomnya ada sedikit.


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_generator")
    @SequenceGenerator(name = "author_generator", sequenceName = "author_id_seq", allocationSize = 1)
    // Identity -> bigserial --> cocok untuk satu insert, sequence cocok untuk proses insert banyak, dengan enable batch insert
    private Long id;

    @Column(name = "name", nullable = false, columnDefinition = "varchar(300)")
    private String name;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @Column(name = "deleted", columnDefinition = "boolean default false")
    private Boolean deleted;
}
