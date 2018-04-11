package com.example.demo.repository;

import com.example.demo.entity.Movie;
import com.example.demo.entity.Rented;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RentedRepository extends JpaRepository<Rented, Long> {
/*

    @Query("select m.productId, r.rentdate from Movie m inner join Rented r on m.productId=r.movie.productId")
    List<Object[]> findCustom();
*/

@Query("select m.productId from Movie m inner join Rented r on m.productId=r.movie.productId")
List<Rented> findCustom();

}
