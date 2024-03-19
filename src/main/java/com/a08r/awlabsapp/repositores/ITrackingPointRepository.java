package com.a08r.awlabsapp.repositores;

import com.a08r.awlabsapp.models.dto.TrackingPointDto;
import com.a08r.awlabsapp.models.trackpointentity.TrackingPointEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITrackingPointRepository extends JpaRepository<TrackingPointEntity,Long> {
     TrackingPointEntity findByBreakIdAndLabCode(int breakId, int labCode);
     TrackingPointEntity findByBreakId(int breakId);
}
