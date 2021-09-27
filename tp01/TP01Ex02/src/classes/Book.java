package classes;

public class Book {

	public String name;
	public Author[] authors;
	public Double price;
	public int qty  = 0;
	
	public Book(String name, Author[] authors, Double price) {
		this.name = name;
		this.authors = authors;
		this.price = price;
	}
	
	public Book(String name, Author[] authors, Double price, int qty) {
		this.name = name;
		this.authors = authors;
		this.price = price;
		this.qty = qty;
	}

	public String getName() {
		return name;
	}
	
	public Author[] getAuthors() {
		return authors;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}
	
	public String toString() {
		
		int i = 1;
		String toString = "Book[name=" + name + ",authors={";
				for(Author author : authors) {
					toString += "[name=" + author.getName() +
							",email=" + author.getEmail() +
							",gender=" + author.getGender() + "]";
					if(i < authors.length) {
						toString += ",";
					}
					i++;
				}
				toString += "},price=" + price + ",qty=" + qty + ".";
				return toString;
	}
	
	public String getAuthorNames() {
		int i = 1;
		String returnAuthors = "";
		for (Author author : authors) {
			returnAuthors += author;
			if(i < authors.length) {
				returnAuthors += ",";
			}
			i++;
		}
		return returnAuthors;
	}
}
