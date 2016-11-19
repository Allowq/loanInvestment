package org.hackrussia.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hackrussia.dto.Request;
import org.hackrussia.model.dto.PropositionDTO;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PropositionReq extends Request {
    private PropositionDTO data;
}
