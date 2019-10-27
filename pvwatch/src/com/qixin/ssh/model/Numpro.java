package com.qixin.ssh.model;

public class Numpro {
	private int numProId;
	private int productId;
	private String produName;
	private int number;
	public int getNumProId() {
		return numProId;
	}
	
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProduName() {
		return produName;
	}

	public void setProduName(String produName) {
		this.produName = produName;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void setNumProId(int numProId) {
		this.numProId = numProId;
	}

	@Override
	public String toString() {
		return "NumPro [NumProId=" + numProId + ", productId=" + productId
				+ ", produName=" + produName + ", number=" + number + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numProId;
		result = prime * result + number;
		result = prime * result
				+ ((produName == null) ? 0 : produName.hashCode());
		result = prime * result + productId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Numpro other = (Numpro) obj;
		if (numProId != other.numProId)
			return false;
		if (number != other.number)
			return false;
		if (produName == null) {
			if (other.produName != null)
				return false;
		} else if (!produName.equals(other.produName))
			return false;
		if (productId != other.productId)
			return false;
		return true;
	}
	
	
}
