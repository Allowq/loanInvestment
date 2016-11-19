package org.hackrussia.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InvestmentResp {
    private String id;
    private String investor;
    private String borrower;
    private float risk;
    private boolean isAcceptInvestor;
    private boolean isAcceptBorrower;
}
