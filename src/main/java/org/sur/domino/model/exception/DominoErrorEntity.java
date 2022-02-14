package org.sur.domino.model.exception;

public class DominoErrorEntity {

	private String error;

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((error == null) ? 0 : error.hashCode());
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
		DominoErrorEntity other = (DominoErrorEntity) obj;
		if (error == null) {
			if (other.error != null)
				return false;
		} else if (!error.equals(other.error))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DominoErrorEntity [error=" + error + "]";
	}

	public DominoErrorEntity(String error) {
		super();
		this.error = error;
	}

	public DominoErrorEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
