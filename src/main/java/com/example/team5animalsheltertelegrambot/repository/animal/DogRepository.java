package com.example.team5animalsheltertelegrambot.repository.animal;

import com.example.team5animalsheltertelegrambot.entity.animal.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DogRepository extends JpaRepository<Dog, Integer> {

    @Modifying
    @Query(value = "UPDATE dog SET name = %:name%, age = %:age%, is_healthy = %:isHealthy%, is_vaccinated = %:isVaccinated% WHERE id = %:id%;", nativeQuery = true)
    Dog updateById(@Param("id") Integer id, @Param("name") String name, @Param("age") Integer age, @Param("isHealthy") Boolean isHealthy, @Param("isVaccinated") Boolean isVaccinated);

    List<Dog> findAllByHealthy(Boolean isHealthy);

    List<Dog> findAllByVaccinated(Boolean isVaccinated);
}
