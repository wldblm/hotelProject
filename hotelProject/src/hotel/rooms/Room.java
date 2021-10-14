package hotel.rooms;

import hotel.customers.Customer;

public class Room {
	private String roomType;
	private String view;
	
	private int maxAdult;
	private int maxChild;
	private int size;
	
	private double price;
	
	private String options[];
	
	private Customer customers[];
	
	public Room(String roomType, String view, int maxAdult, int maxChild, int size, double price, String options[]) {
		setRoomType(roomType);
		setView(view);
		setSize(size);
		setPrice(price);
		setMaxChild(maxChild);
		setMaxAdult(maxAdult);
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

	public int getMaxAdult() {
		return maxAdult;
	}

	public void setMaxAdult(int maxAdult) {
		this.maxAdult = maxAdult;
	}

	public int getMaxChild() {
		return maxChild;
	}

	public void setMaxChild(int maxChild) {
		this.maxChild = maxChild;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
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
	
	
	
}
