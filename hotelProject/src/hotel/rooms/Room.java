package hotel.rooms;

import hotel.customers.Customer;

public class Room {
	private String roomType;
	private String view;
	
	private String maxPer;
	private String size;
	
	private String price;
	
	private String options[];
	
	private Customer customers[];
	
	public Room(String roomType, String view,String maxPer , String size, String price, String options[]) {
		setRoomType(roomType);
		setView(view);
		setSize(size);
		setMaxPer(maxPer);
		setPrice(price);
		setOptions(options);
		customers = new Customer[3];
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
	}


	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String[] getOptions() {
		return options;
	}

	public void setOptions(String options[]) {
		this.options = options;
	}

	public Customer[] getCustomers() {
		return customers;
	}

	public void setCustomers(Customer customers[]) {
		this.customers = customers;
	}

	public String getMaxPer() {
		return maxPer;
	}

	public void setMaxPer(String maxPer) {
		this.maxPer = maxPer;
	}
	
	
	
}
