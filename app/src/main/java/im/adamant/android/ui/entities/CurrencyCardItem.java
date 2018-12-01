package im.adamant.android.ui.entities;

import java.math.BigDecimal;

public class CurrencyCardItem {
    private BigDecimal balance;
    private String address;
    private String titleString;
    private int titleResource;
    private int backgroundLogoResource;
    private int precision;
    private String abbreviation;
    private int airdropLinkResource;
    private String airdropLinkString;

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTitleString() {
        return titleString;
    }

    public void setTitleString(String titleString) {
        this.titleString = titleString;
    }

    public int getTitleResource() {
        return titleResource;
    }

    public void setTitleResource(int titleResource) {
        this.titleResource = titleResource;
    }

    public int getBackgroundLogoResource() {
        return backgroundLogoResource;
    }

    public void setBackgroundLogoResource(int backgroundLogoResource) {
        this.backgroundLogoResource = backgroundLogoResource;
    }

    public int getPrecision() {
        return precision;
    }

    public void setPrecision(int precision) {
        this.precision = precision;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public int getAirdropLinkResource() {
        return airdropLinkResource;
    }

    public void setAirdropLinkResource(int airdropLinkResource) {
        this.airdropLinkResource = airdropLinkResource;
    }

    public String getAirdropLinkString() {
        return airdropLinkString;
    }

    public void setAirdropLinkString(String airdropLinkString) {
        this.airdropLinkString = airdropLinkString;
    }
}
