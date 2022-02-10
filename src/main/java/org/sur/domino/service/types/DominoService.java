package org.sur.domino.service.types;


import java.util.List;
import org.springframework.stereotype.Service;
import org.sur.domino.model.DominoItem;
import org.sur.domino.model.DominoResponse;
import org.sur.domino.model.exception.DominoException;

@Service
public interface DominoService {
	
	public DominoResponse getHighestValueDominoChain(
			DominoItem initialDominoItem,
			List<DominoItem> dominoItemList
			) throws DominoException;
	
}


