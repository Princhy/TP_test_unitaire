package fr.emse.test;

public class Money implements IMoney {
	
	private int fAmount;
	private String fCurrency;
	
	public Money(int amount, String currency) {
		fAmount = amount;
		fCurrency = currency;
	}
	
	public int amount() {
		return fAmount;
	}
	
	public String currency() {
		return fCurrency;
	}
	
	public String aboutMoney() {
		return fAmount + " " + fCurrency; 
	}
	
	public IMoney add(Money m) {
		if (m.currency().equals(currency()))
			return new Money(amount() + m.amount(), currency());
		return new MoneyBag(this, m);
	}
	
	@Override
	  public boolean equals(Object other) {
	    if (this == other) return true;
	    if (other == null || getClass() != other.getClass()) return false;
	    Money money = (Money) other;
	    return fAmount == money.fAmount && fCurrency.equals(money.fCurrency);
	  }
	
	@Override
	public IMoney add(IMoney m) {
		return m.addMoney(this);
	}

	@Override
	public IMoney addMoneyBag(MoneyBag moneyBag) {
		return null;
	}

	@Override
	public IMoney addMoney(Money money) {
		return null;
	}
}