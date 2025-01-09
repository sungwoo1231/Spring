INSERT INTO authority (authority_name) VALUES ('ADMIN');
INSERT INTO authority (authority_name) VALUES ('USER');

INSERT INTO user (user_name, password, email, real_name, birthdate ,user_authority, created_at)
VALUES
('ADMIN',NOW()),
('USER', NOW());

INSERT INTO subject (title,explanation,type,price,imageUrl,videoUrl,instructor_fk)
VALUES


