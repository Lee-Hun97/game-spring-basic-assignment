package com.gamebasic.game.entity;

import com.gamebasic.runcard.entity.RunCard;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "games")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 12)
    private String playerName;

    @Column(nullable = false)
    private int currentHp;

    @Column(nullable = false)
    private int currentFloor;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 16)
    private GamePhase phase;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 16)
    private GameStatus status;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "game")
    private List<RunCard> runCards = new ArrayList<>();

    public Game(String playerName) {
        this.playerName = playerName;
        this.currentHp = 99;
        this.currentFloor = 1;
        this.phase = GamePhase.REWARD;
        this.status = GameStatus.PLAYING;
    }

    public void rename(String playerName) {
        this.playerName = playerName;
    }

    public void updateProgress(
        int currentHp,
        int currentFloor,
        GamePhase phase,
        GameStatus status
    ) {
        this.currentHp = currentHp;
        this.currentFloor = currentFloor;
        this.phase = phase;
        this.status = status;
    }

//    public void updateName(
//            String playerName
//    ){
//        this.playerName = playerName;
//    }

    public boolean isFinished() {
        return status != GameStatus.PLAYING;
    }
}
