CREATE TABLE battles (
    id BIGSERIAL PRIMARY KEY,
    character1_id BIGINT NOT NULL,
    character2_id BIGINT NOT NULL,
    winner_name VARCHAR(120),
    battle_result TEXT,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_battles_character1
        FOREIGN KEY (character1_id)
        REFERENCES characters(id),

    CONSTRAINT fk_battles_character2
        FOREIGN KEY (character2_id)
        REFERENCES characters(id)
);