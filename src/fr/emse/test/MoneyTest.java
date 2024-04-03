package fr.emse.test;

import static org.junit.Assert.*;

import org.junit.Test;

import org.junit.Before;

public class MoneyTest {
	

	private Money f12CHF;
	private Money f14CHF;
	private Money f7USD;
	private Money f21USD;
	
	private MoneyBag fMB1;
	private MoneyBag fMB2;

	@Before
	public void setUp() {
		f12CHF= new Money(12, "CHF");
		f14CHF= new Money(14, "CHF");
		f7USD= new Money( 7, "USD");
		f21USD= new Money(21, "USD");
		fMB1 = new MoneyBag(f12CHF, f7USD);
		fMB2= new MoneyBag(f14CHF, f21USD);
	}
	
	@Test
	public void testMixedSimpleAdd() {
		Money bag[] = { f12CHF, f7USD };
		MoneyBag expected = new MoneyBag(bag);
		assertEquals(expected, f12CHF.add(f7USD));
	}


    @Test
    public void testBagSimpleAdd() {
        MoneyBag expected = new MoneyBag(f12CHF, f7USD);
        assertEquals(expected, f12CHF.add(f7USD));
    }

    @Test
    public void testSimpleBagAdd() {
		Money bag[] = { f12CHF, f7USD, f14CHF };
        MoneyBag expected = new MoneyBag(bag);
        assertEquals(expected, fMB1.addMoney(f14CHF));
    }

    @Test
    public void testBagBagAdd() {
		Money bag[] = { f12CHF, f7USD, f14CHF, f21USD};
        MoneyBag expected = new MoneyBag(bag);
        assertEquals(expected, fMB1.addMoneyBag(fMB2));
    }
}


