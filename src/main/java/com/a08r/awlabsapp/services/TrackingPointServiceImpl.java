package com.a08r.awlabsapp.services;

import com.a08r.awlabsapp.errors.RecordNotFoundException;
import com.a08r.awlabsapp.models.dto.TrackingPointDto;
import com.a08r.awlabsapp.models.mapper.ITrackingPointMapper;
import com.a08r.awlabsapp.models.mapper.TrackingPointMapperImp;
import com.a08r.awlabsapp.models.trackpointentity.TrackingPointEntity;
import com.a08r.awlabsapp.repositores.ITrackingPointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TrackingPointServiceImpl implements ITrackingPointService {

    private final ITrackingPointRepository iTrackingPointRepository;
    private static final ITrackingPointMapper TRACKING_POINT_MAPPER = new TrackingPointMapperImp();

    @Autowired
    public TrackingPointServiceImpl(ITrackingPointRepository iTrackingPointRepository) {
        this.iTrackingPointRepository = iTrackingPointRepository;
    }

    @Override
    public ResponseEntity<List<TrackingPointDto>> findAll() {
        List<TrackingPointEntity> trackingPointEntityList = iTrackingPointRepository.findAll();
        List<TrackingPointDto> trackingPointDtoList = trackingPointEntityList
                .stream()
                .map(TRACKING_POINT_MAPPER::trackingPointEntityTotrackingPointDto)
                .collect(Collectors.toList());
        return new ResponseEntity<>(trackingPointDtoList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<TrackingPointDto> findById(Long id) {
        Optional<TrackingPointEntity> trackingPointEntity = this.iTrackingPointRepository.findById(id);
        if (trackingPointEntity.isEmpty()) {
            throw new RecordNotFoundException("the item with id: " + id + " not found!....");
        }
        TrackingPointDto trackingPointDto = TRACKING_POINT_MAPPER.trackingPointEntityTotrackingPointDto(trackingPointEntity.get());
        return new ResponseEntity<>(trackingPointDto, HttpStatus.OK);

    }

    @Override
    public ResponseEntity<TrackingPointEntity> findByBreakId(int breakId) {
        TrackingPointEntity trackingPointElement = iTrackingPointRepository.findByBreakId(breakId);
        if (trackingPointElement == null) {
            throw new RecordNotFoundException("Sorry, The Break with Break_id: " + breakId  + " not found!...");
        }
        return new ResponseEntity<>(trackingPointElement, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<TrackingPointEntity> findByBreakIdAndLabCode(int breakId, int labCode) {
        TrackingPointEntity trackingPointElement = iTrackingPointRepository.findByBreakIdAndLabCode(breakId, labCode);
        if (trackingPointElement == null) {
            throw new RecordNotFoundException("Sorry, The Break with break_id and Lab_code : " + breakId + " AND " + labCode + " not found!...");
        }
        return new ResponseEntity<>(trackingPointElement, HttpStatus.OK);
    }
}