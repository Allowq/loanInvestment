package org.hackrussia.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hackrussia.dto.Request;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestPropClose extends Request {
    private boolean isClosed;
}
