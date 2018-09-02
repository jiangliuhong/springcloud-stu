CREATE TABLE IF NOT EXISTS user (
  id          VARCHAR(45)     NOT NULL,
  username    VARCHAR(55)  NOT NULL,
  password   VARCHAR(255) NOT NULL,
  salt       VARCHAR(10)  NOT NULL,
  create_time TIMESTAMP    NOT NULL,
  PRIMARY KEY (id),
  UNIQUE (username ASC)
);
CREATE TABLE IF NOT EXISTS student (
  id          VARCHAR(45)     NOT NULL,
  name  VARCHAR(45) NOT NULL,
  num   VARCHAR(45) NOT NULL,
  PRIMARY KEY (id)
);