package org.example;

public class Raffle {
    private String idContest;
    private String contestDate;
    private String ball1;
    private String ball2;
    private String ball3;
    private String ball4;
    private String ball5;
    private String ball6;
    private String winnersAmt6;
    private String distribution6;
    private String winnersAmt5;
    private String distribution5;
    private String winnersAmt4;
    private String distribution4;

    public Raffle(String idContest, String contestDate, String ball1, String ball2, String ball3, String ball4, String ball5, String ball6, String qtdWinners6, String distribution6, String qtdWinners5, String distribution5, String qtdWinners4, String distribution4) {
        this.idContest = idContest;
        this.contestDate = contestDate;
        this.ball1 = ball1;
        this.ball2 = ball2;
        this.ball3 = ball3;
        this.ball4 = ball4;
        this.ball5 = ball5;
        this.ball6 = ball6;
        this.winnersAmt6 = winnersAmt6;
        this.distribution6 = distribution6;
        this.winnersAmt5 = winnersAmt5;
        this.distribution5 = distribution5;
        this.winnersAmt4 = winnersAmt4;
        this.distribution4 = distribution4;
    }

    public Raffle() {
    }

    public String getContestDate() {
        return contestDate;
    }

    public void setContestDate(String contestDate) {
        this.contestDate = contestDate;
    }

    public String getBall1() {
        return ball1;
    }

    public void setBall1(String ball1) {
        this.ball1 = ball1;
    }

    public String getBall2() {
        return ball2;
    }

    public void setBall2(String ball2) {
        this.ball2 = ball2;
    }

    public String getBall3() {
        return ball3;
    }

    public void setBall3(String ball3) {
        this.ball3 = ball3;
    }

    public String getBall4() {
        return ball4;
    }

    public void setBall4(String ball4) {
        this.ball4 = ball4;
    }

    public String getBall5() {
        return ball5;
    }

    public void setBall5(String ball5) {
        this.ball5 = ball5;
    }

    public String getBall6() {
        return ball6;
    }

    public void setBall6(String ball6) {
        this.ball6 = ball6;
    }


    public String getDistribution6() {
        return distribution6;
    }

    public void setDistribution6(String distribution6) {
        this.distribution6 = distribution6;
    }


    public String getDistribution5() {
        return distribution5;
    }

    public void setDistribution5(String distribution5) {
        this.distribution5 = distribution5;
    }

    public String getDistribution4() {
        return distribution4;
    }

    public void setDistribution4(String distribution4) {
        this.distribution4 = distribution4;
    }

    public String getIdContest() {
        return idContest;
    }

    public void setIdContest(String idContest) {
        this.idContest = idContest;
    }

    public String getWinnersAmt6() {
        return winnersAmt6;
    }

    public void setWinnersAmt6(String winnersAmt6) {
        this.winnersAmt6 = winnersAmt6;
    }

    public String getWinnersAmt5() {
        return winnersAmt5;
    }

    public void setWinnersAmt5(String winnersAmt5) {
        this.winnersAmt5 = winnersAmt5;
    }

    public String getWinnersAmt4() {
        return winnersAmt4;
    }

    public void setWinnersAmt4(String winnersAmt4) {
        this.winnersAmt4 = winnersAmt4;
    }
}
