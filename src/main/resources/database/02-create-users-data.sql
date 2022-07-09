--liquibase formatted sql
--changeset DKorb:2

INSERT INTO roles (id, name)
VALUES (1, 'ROLE_ADMIN');
INSERT INTO roles (id, name)
VALUES (2, 'ROLE_USER');

INSERT INTO users (id, email, gender, name, password, username, age)
VALUES (1, 'admin@test.java', 'MALE', 'admin', '$2a$10$Zf/erN5zzrJ0p2Roq2IfNuNzrEBmsfvEoLlw51TzJ0MN5SHIjepg.', 'admin',
        '23');
INSERT INTO users (id, email, gender, name, password, username, age)
VALUES (2, 'user@test.java', 'FEMALE', 'user', '$2a$10$Tgder.wQZnquYF.LIQDXP.kPV/3SwOToSxETv4uZuSIhlrJEasDb.', 'user',
        '25');

INSERT INTO user_roles (user_id, role_id)
VALUES (1, 1);
INSERT INTO user_roles (user_id, role_id)
VALUES (2, 2);