CREATE TABLE skill (
  id SERIAL PRIMARY KEY,
  hability_name VARCHAR(120) NOT NULL UNIQUE,
  description VARCHAR(120) NOT NULL,
  fire_power INT NOT NULL CHECK (fire_power >= 1),
  mana_spent INT NOT NULL CHECK (mana_spent >= 0),
  difficulty_learning INT NOT NULL CHECK (difficulty_learning >= 0),
  required_level INT NOT NULL CHECK (required_level >= 0)
);