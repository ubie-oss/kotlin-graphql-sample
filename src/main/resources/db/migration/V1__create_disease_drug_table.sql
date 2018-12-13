DROP TABLE IF EXISTS drug;
CREATE TABLE drug
(
  name    TEXT NOT NULL,
  yj_code TEXT
);

DROP TABLE IF EXISTS kinki_drug;
CREATE TABLE kinki_drug
(
  yj_code       TEXT,
  kinki_yj_code TEXT
);

DROP TABLE IF EXISTS disease;
CREATE TABLE disease
(
  icd  TEXT,
  name TEXT
);

DROP TABLE IF EXISTS disease_kinki_drug;
CREATE TABLE disease_kinki_drug
(
  yj_code TEXT,
  icd     TEXT
);

INSERT INTO drug (name, yj_code) VALUES ('風邪薬1', '1111'), ('風邪薬2', '1111'), ('風邪薬3', '1111'), ('解熱剤', '2222'), ('喉のお薬', '3333');
INSERT INTO kinki_drug (yj_code, kinki_yj_code) VALUES ('1111', '3333'), ('3333', '1111');
INSERT INTO disease (icd, name) VALUES ('1', '風邪'), ('1', '酷い風邪'), ('2', '熱'), ('3', '喉の痛み');
INSERT INTO disease_kinki_drug (yj_code, icd) VALUES ('3333', '2');
