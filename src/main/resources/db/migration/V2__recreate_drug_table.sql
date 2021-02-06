CREATE EXTENSION IF NOT EXISTS pgcrypto;
DROP TABLE IF EXISTS drug;
CREATE TABLE drug
(
  id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
  name    TEXT NOT NULL,
  description TEXT,
  yj_code TEXT
);

INSERT INTO drug (name, description, yj_code) VALUES ('風邪薬1', '説明', '1111'), ('風邪薬2', '説明', '1111'), ('風邪薬3', NULL, '1111'), ('解熱剤', '解熱剤の説明', '2222'), ('喉のお薬', '喉を楽にする','3333');