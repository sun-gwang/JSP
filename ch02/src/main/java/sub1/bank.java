package sub1;

public class bank {
	private String bank;
	private String id;
	private String name;
	private int balance;
	
	public bank(String bank, String id, String name, int balance) {
		super();
		this.bank = bank;
		this.id = id;
		this.name = name;
		this.balance = balance;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "bank [bank=" + bank + ", id=" + id + ", name=" + name + ", balance=" + balance + "]";
	}
	
	
}
