package com.gamebasic.game.dto;

import com.gamebasic.game.entity.GamePhase;
import com.gamebasic.game.entity.GameStatus;
import com.gamebasic.runcard.dto.CardResponse;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class GameSummaryResponse {
    private final Long id;
    private final String playerName;
    private final int currentHp;
    private final int currentFloor;
    private final GamePhase phase;
    private final GameStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private final Long deckSize;

//    public GameSummaryResponse(
//        Long id,
//        String playerName,
//        int currentHp,
//        int currentFloor,
//        GamePhase phase,
//        GameStatus status
//    ) {
//        this.id = id;
//        this.playerName = playerName;
//        this.currentHp = currentHp;
//        this.currentFloor = currentFloor;
//        this.phase = phase;
//        this.status = status;
//    }

    public GameSummaryResponse(
            Long id,
            String playerName,
            int currentHp,
            int currentFloor,
            GamePhase phase,
            GameStatus status,
            Long deckSize
    ) {
        this.id = id;
        this.playerName = playerName;
        this.currentHp = currentHp;
        this.currentFloor = currentFloor;
        this.phase = phase;
        this.status = status;
        this.deckSize = deckSize;
    }
}
