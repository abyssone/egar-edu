package ru.absdev.document;

public class Passport extends Document {
    private String citizenship;
    private Long seriesAndNumber;
    public Passport(String ownerName, Long seriesAndNumber, String citizenship) {
        super(DocConst.PASSPORT.getCode(), ownerName);
        this.citizenship = citizenship;
        this.seriesAndNumber = seriesAndNumber;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public Long getSeriesAndNumber() {
        return seriesAndNumber;
    }

    public void setSeriesAndNumber(Long seriesAndNumber) {
        this.seriesAndNumber = seriesAndNumber;
    }
}
