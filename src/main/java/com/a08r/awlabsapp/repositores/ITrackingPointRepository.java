package com.a08r.awlabsapp.repositores;

import com.a08r.awlabsapp.models.dto.TrackingPointDto;
import com.a08r.awlabsapp.models.trackpointentity.TrackingPointEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITrackingPointRepository extends JpaRepository<TrackingPointEntity, Long> {
    List<TrackingPointEntity> findByBreakIdAndLabCode(int breakId, int labCode);

    List<TrackingPointEntity> findByBreakId(int breakId);

    List<TrackingPointDto> findByLabCode(int labCode);
}
