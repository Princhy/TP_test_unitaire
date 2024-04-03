package fr.emse.test;

public interface IMoney {
	public IMoney add(IMoney aMoney);
	
	public IMoney addMoneyBag(MoneyBag moneyBag);

	public IMoney addMoney(Money money);
}
