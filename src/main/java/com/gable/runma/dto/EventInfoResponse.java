package com.gable.runma.dto;

import com.gable.runma.model.RaceType;
import lombok.Data;

import java.util.List;

@Data
public class EventInfoResponse {

    String eventName;
    String location;

    List<RacetypeDetailResponse>  raceTypeDetailList;
}
