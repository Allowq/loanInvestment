package org.hackrussia.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hackrussia.dto.Request;
import org.hackrussia.dto.request.data.RegistryData;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegistryRequest extends Request {
    private RegistryData data;
}
