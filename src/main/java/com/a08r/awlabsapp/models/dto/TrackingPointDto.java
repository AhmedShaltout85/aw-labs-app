package com.a08r.awlabsapp.models.dto;


import lombok.*;

@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrackingPointDto {

    private String sectorName;
    private String labName;
    private int labCode;
    private int userId;
    private int breakId;
    private String breakDate;
    private String breakTime;
    private double locationX;
    private double locationY;
}

// we can use DTO class in this way
//public class TrackingPointDTO{
//    private final TrackingPointEntity ;
//
//    public TrackingPointDTO(TrackingPointEntity trackingPointEntity) {
//        this.trackingPointEntity = trackingPointEntity;
//    }
//}

//public record TrackingPointDto(String sectorName,
//                               String labName,
//                               int labCode,
//                               int breakId,
//                               String breakDate,
//                               String breakTime,
//                               double locationX,
//                               double locationY){}