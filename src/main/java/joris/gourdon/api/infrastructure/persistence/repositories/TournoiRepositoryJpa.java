package joris.gourdon.api.infrastructure.persistence.repositories;

import joris.gourdon.api.infrastructure.persistence.entities.TournoiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TournoiRepositoryJpa extends JpaRepository<TournoiEntity, Integer> {
    @Query("SELECT t FROM TournoiEntity t " +
           "LEFT JOIN FETCH t.club " +
           "LEFT JOIN FETCH t.typeSurfaceEntity " +
           "LEFT JOIN FETCH t.typeTournoiEntity")
    List<TournoiEntity> findAllWithRelations();

    @Query("SELECT t FROM TournoiEntity t " +
           "LEFT JOIN FETCH t.club " +
           "LEFT JOIN FETCH t.typeSurfaceEntity " +
           "LEFT JOIN FETCH t.typeTournoiEntity " +
           "WHERE t.id = :id")
    Optional<TournoiEntity> findByIdWithRelations(Integer id);
} 