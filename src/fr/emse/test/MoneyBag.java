package fr.emse.test;

import java.util.Vector;

public class MoneyBag implements IMoney {
	private Vector<Money> fMonies = new Vector<Money>();
	
	MoneyBag(Money m1, Money m2) {
		appendMoney(m1);
		appendMoney(m2);
	}
	
	MoneyBag(Money bag[]) {
		for (int i = 0; i < bag.length; i++)
			appendMoney(bag[i]);
	}
	
	private void appendMoney(Money m) {
		if (fMonies.isEmpty()) {
			fMonies.add(m);
	} else {
		int i = 0;
		while ((i < fMonies.size())
				&& (!(fMonies.get(i).currency().equals(m.currency()))))
			i++;
		if (i >= fMonies.size()) {
			fMonies.add(m);
		} else {
			fMonies.set(i, new Money(fMonies.get(i).amount() +
					m.amount(),
					m.currency()));
				}
			}
		}
	
	@Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true; // Same object
        }
        if (!(obj instanceof MoneyBag)) {
            return false; // Not a MoneyBag
        }
        MoneyBag other = (MoneyBag) obj;
        if (fMonies.size() != other.fMonies.size()) {
            return false; // Different number of Money objects
        }
        for (int i = 0; i < fMonies.size(); i++) {
            if (!fMonies.get(i).equals(other.fMonies.get(i))) {
                return false; // Different Money objects at a given index
            }
        }
        return true; // All Money objects are equal
    }
	
	@Override
	public IMoney add(IMoney m) {
		return m.addMoneyBag(this);
	}

	@Override
	public IMoney addMoneyBag(MoneyBag moneyBag) {
	    for (Money money : moneyBag.fMonies) {
	        appendMoney(money);
	    }
	    return this;
	}

	@Override
	public IMoney addMoney(Money money) {
	    appendMoney(money);
	    return this;
	}

	public void listMonies() {
	    System.out.println("Contenu de fMonies :");
	    for (Money m : fMonies) {
	        System.out.println(m.amount() + " " + m.currency());
	    }
	}
	
	
	public String displayMoney() {
	    for (Money m : fMonies) {
	        if (m.amount() != 0) {
	            return m.amount() + " " + m.currency();
	        }
	    }
		return null;
	}

}

