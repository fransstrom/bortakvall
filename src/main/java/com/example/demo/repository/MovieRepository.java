package com.example.demo.repository;


import com.example.demo.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository  extends JpaRepository<Movie, String>{

 /*   @Query(value="SELECT * FROM movie INNER JOIN customer ON Property.Property_id=:Rent.propertyid",nativeQuery=true)
    public List<Movie> findMovieByCustomer();*/
     List<Movie> findMovieByCustomerPersonnummer(String personnummer);




   /* @Query("select m.name from Rented r inner join Movie m on m.productId=r.movie.productId")
    List<Movie> findCustom();*/

}
