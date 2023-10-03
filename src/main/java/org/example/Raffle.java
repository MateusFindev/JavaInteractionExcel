package org.example;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Raffle {
    private int idContest;
    private String contestDate;
    private List<Integer> balls;
    private int winnersAmt6;
    private String distribution6;
    private int winnersAmt5;
    private String distribution5;
    private int winnersAmt4;
    private String distribution4;
}


