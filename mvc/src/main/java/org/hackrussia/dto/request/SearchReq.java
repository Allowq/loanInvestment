package org.hackrussia.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hackrussia.dto.Request;
import org.hackrussia.model.Client;
import org.hackrussia.model.Proposition;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SearchReq extends Request {
    private Map<Client, Proposition> data;
}
