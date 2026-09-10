package com.gamebasic.runcard.dto;

import lombok.Getter;

@Getter
public class DeckCount {
    private final Long id;
    private final Long deckCount;

    public DeckCount(Long id, Long deckCount) {
        this.id = id;
        this.deckCount = deckCount;
    }
}
