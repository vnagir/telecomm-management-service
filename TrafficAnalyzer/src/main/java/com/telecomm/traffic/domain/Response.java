package com.telecomm.traffic.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties
@JsonInclude(JsonInclude.Include.NON_NULL)
@Component
public class Response {

    @Getter
    @Setter
    private List<Tower> towers;

    @Getter
    @Setter
    private Map<String, Tower> savedTowers;

    @Getter
    @Setter
    private Tower towerInfo;

}
