package org.hackrussia.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PropositionDTO {
    private String id;
    private String title;
    private String disc;
    private double sum;
    private boolean isClosed;
}
