package cn.ctyun.multi_datasource.entity;

public class Account {
    private Integer id;

    private String username;

    private String cardid;

    private Double balance;

    private Double moneyrate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getCardid() {
        return cardid;
    }

    public void setCardid(String cardid) {
        this.cardid = cardid == null ? null : cardid.trim();
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getMoneyrate() {
        return moneyrate;
    }

    public void setMoneyrate(Double moneyrate) {
        this.moneyrate = moneyrate;
    }
}