package org.sur.domino.model;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = DominoRequestDeserializer.class)
@Valid
public class DominoRequest {

	@NotNull
	@Valid
	private DominoItem initialDominoItem;
	
	@NotNull
	@Valid
	private List<DominoItem> dominoItems;
	
	public DominoItem getInitialDominoItem() {
		return initialDominoItem;
	}
	public void setInitialDominoItem(DominoItem initialDominoItem) {
		this.initialDominoItem = initialDominoItem;
	}
	public List<DominoItem> getDominoItems() {
		return dominoItems;
	}
	public void setDominoItems(List<DominoItem> dominoItems) {
		this.dominoItems = dominoItems;
	}
	
	
	public DominoRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public DominoRequest(@NotNull @Valid DominoItem initialDominoItem, @NotNull @Valid List<DominoItem> dominoItems) {
		super();
		this.initialDominoItem = initialDominoItem;
		this.dominoItems = dominoItems;
	}
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dominoItems == null) ? 0 : dominoItems.hashCode());
		result = prime * result + ((initialDominoItem == null) ? 0 : initialDominoItem.hashCode());
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
		DominoRequest other = (DominoRequest) obj;
		if (dominoItems == null) {
			if (other.dominoItems != null)
				return false;
		} else if (!dominoItems.equals(other.dominoItems))
			return false;
		if (initialDominoItem == null) {
			if (other.initialDominoItem != null)
				return false;
		} else if (!initialDominoItem.equals(other.initialDominoItem))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "DominoRequest [initialDominoItem=" + initialDominoItem + ", dominoItems=" + dominoItems + "]";
	}
	
}

