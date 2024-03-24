package com.a08r.awlabsapp.services;

import com.a08r.awlabsapp.models.dto.TrackingPointDto;
import com.a08r.awlabsapp.models.trackpointentity.TrackingPointEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ITrackingPointService {
    ResponseEntity<List<TrackingPointDto>> findAll();
    ResponseEntity<TrackingPointDto> findById(Long id);
    ResponseEntity<List<TrackingPointEntity>> findByBreakId(int breakId);
    ResponseEntity<List<TrackingPointEntity>> findByBreakIdAndLabCode(int breakId, int labCode);
    ResponseEntity<List<TrackingPointDto>> findByLabCode(int labCode);
}
