package ex01;

public class Vehicle {

	private Owner owner;
	private int price;
	
	public Vehicle() {
	}

	
	public Vehicle(String string, String string2, int i) {
		owner = new Owner(string,string2);
		price = i;
	}


	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		if( obj instanceof Vehicle ) {
			Vehicle tmp = (Vehicle)obj;
			if(this.owner.equals(tmp.owner)) {
				result = true;
			} else {
				result = false;
			}
		}
		return result;
	}


	@Override
	public String toString() {
		return owner.toString() + "\n" + 
	           "차량정보 : 가격은 " +  price + "입니다";
	}
	
	
}
