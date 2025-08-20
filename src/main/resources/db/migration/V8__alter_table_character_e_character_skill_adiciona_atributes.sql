ALTER TABLE characters
ADD COLUMN strength INT DEFAULT 1 CHECK (strength >= 0),
ADD COLUMN intelligence INT DEFAULT 1 CHECK (intelligence >= 0),
ADD COLUMN dexterity INT DEFAULT 1 CHECK (dexterity >= 0),
ADD COLUMN stamina INT DEFAULT 1 CHECK (stamina >= 0),
ADD COLUMN levels INT DEFAULT 1 CHECK (level >= 1);