---- 권한
 INSERT INTO 권한 (authority_name) VALUES ('ADMIN');
 INSERT INTO 권한 (authority_name) VALUES ('USER');
 INSERT INTO 권한 (authority_name) VALUES ('INSTRUCTOR');

--공지사항
INSERT INTO 공지사항 (title, content, created_date)
VALUES
    ('긴급 휴강 안내', '강사님의 사정으로 인해 2025-01-01은 휴강으로 조정 되었습니다.', NOW()),
    ('서버 점검 안내', '저희 서비스의 원활한 운영을 위해 아래와 같이 서버 점검이 2025-01-16 진행될 예정입니다. 점검 시간 동안에는 서비스 이용이 일시적으로 중단될 수 있으니 양해 부탁드립니다. 점검이 완료되는 대로 정상 서비스를 재개할 예정이며, 점검 중에 불편을 끼쳐드려 대단히 죄송합니다. 고객님의 이해와 협조 부탁드립니다. 감사합니다.', NOW()),
    ('대규모 시스템 점검 안내', '안녕하세요, 고객님. 저희 시스템의 대규모 점검이 아래와 같이 진행될 예정입니다. 점검 기간 중에는 서비스 이용에 어려움이 있을 수 있으므로, 이용에 참고 부탁드립니다. 점검이 완료된 후 더욱 개선된 서비스를 제공할 수 있도록 노력하겠습니다. 이용에 불편을 드려 죄송합니다. 고객님의 너그러운 양해를 부탁드립니다. 감사합니다.', NOW()),
    ('2025 KCIA 한국소비자산업평가 "아카데미" 지역 결과 발표 우수업체선정', 'KCA 한국소비자평가는 대한소비자협의회가 주최하고 한국소비자평가가 주관하는 〈2025 KCIA 한국소비자산업평가 아카데미〉 경기 시흥, 양주, 양평, 여주, 오산, 의왕, 의정부, 이천, 파주, 평택, 포천, 하남, 화성, 수원, 안양, 용인 지역 평가 결과를 발표했습니다. 본 평가는 표준산업분류에 따른 업종별 소비자평가 결과를 발표함으로써 소비자기본법 제 4조에서 보장하는 소비자의 의견이 반영될 권리, 정보를 제공받을 권리, 선택할 권리 등 소비자의 8대 권리를 실현하고, 소비자에게 객관적이고 유용한 정보를 제공하여 소비생활의 질적 향상을 도모하는 데 목적이 있습니다. 2025 KCIA 한국소비자산업평가 "아카데미"는 국내 교육 산업의 활성화를 도모하며 양질의 교육 서비스 제공으로 소비자들에게 높은 평가를 받은 교육 시설을 매년 선정한 후 대중에 소개하기 위해 실시합니다. 지난 10월 ~ 11월 포털사이트 등의 리뷰 수 등을 기반으로 전국을 지역별로 나누어 사전조사를 실시한 결과, 상위 30.26% 이내의 평가를 받아 선발된 후보군에게 후보자 안내를 실시했으며, 최종적으로 전체 0.23% 이내의 우수 교육 시설이 아래의 평가 기준을 통해 선정되었습니다. 한국소비자평가는 해당 교육 시설을 이용한 소비자들의 실제 경험을 바탕으로 최종 평가를 거쳐 △시설 편의성 △성취 만족도 △상담 및 소통 만족도 △교육의 체계성 △교사의 전문성 △전반적 평가 총 6가지 최종 평가 기준에 따라 각 지역 및 부문별 1개에서 최대 3개의 우수 교육 시설을 선정했으며, 발표 명단은 다음과 같습니다.', NOW()),
    ('휴강 취소 안내', '2025-01-01 휴강은 취소되어 정상적으로 강의 진행합니다.', NOW()),
    ('폭설 임시 휴강 안내', '폭설로 인한 학원 장비 점검으로 2025-01-05부터 2025-01-08까지 일시적으로 임시 휴업 진행합니다.', NOW()),
    ('독감 안내', '현재 독감 유행으로 원생들의 건강상태가 우려됩니다. 원생님들께서는 개인 위생관리를 철저히 해주시고 몸 건강에 유의하시길 바랍니다.', NOW()),
    ('긴급 휴강 안내', '강사님의 사정으로 인해 2025-01-18은 휴강으로 조정되었습니다.', NOW()),
    ('새해맞이 이벤트 안내', '새해를 맞아 학업에 지친 수강생님들을 위해 조식 떡국 제공 이벤트를 진행합니다.', NOW());
-- 사용자
INSERT INTO 사용자 (user_name, password, email, real_name, birthdate,gender, user_authority, created_at, point)
VALUES
    ('admin', '$2b$12$A0kgVpplgbH3ZZ1E89441eacUXljTTt7nP8I3RdLtW0P6/CXdEnCm','admin1234@gmail.com','관리자','1999-01-01','남','ADMIN','2024-12-01',500000),
    ('pengsoo', '$2b$12$A0kgVpplgbH3ZZ1E89441eacUXljTTt7nP8I3RdLtW0P6/CXdEnCm', 'pengsoo@email.com', '백병열' , '1999-09-09','남', 'USER', '2024-12-03', 500000),
    ('totoro', '$2b$12$A0kgVpplgbH3ZZ1E89441eacUXljTTt7nP8I3RdLtW0P6/CXdEnCm', 'totoro@email.com', '강준우',  '1999-05-24','남', 'USER', '2024-12-15', 500000),
    ('fourbie', '$2b$12$A0kgVpplgbH3ZZ1E89441eacUXljTTt7nP8I3RdLtW0P6/CXdEnCm', 'fourbie@email.com', '정길수', '1999-06-06','남', 'USER', '2024-12-20', 500000),
    ('pororo', '$2b$12$A0kgVpplgbH3ZZ1E89441eacUXljTTt7nP8I3RdLtW0P6/CXdEnCm', 'pororo@email.com', '김성우', '1999-06-09','남', 'USER', '2024-12-30', 500000),
    ('panda', '$2b$12$A0kgVpplgbH3ZZ1E89441eacUXljTTt7nP8I3RdLtW0P6/CXdEnCm', 'panda@email.com', '곽두팔', '1994-11-11','남', 'INSTRUCTOR', '2025-01-01', 500000),
    ('eddie', '$2b$12$A0kgVpplgbH3ZZ1E89441eacUXljTTt7nP8I3RdLtW0P6/CXdEnCm', 'eddie@email.com', '강 인', '1995-09-21','남', 'INSTRUCTOR', '2025-01-15', 500000),
    ('tom', '$2b$12$A0kgVpplgbH3ZZ1E89441eacUXljTTt7nP8I3RdLtW0P6/CXdEnCm','tom12@gmail.com','김꽃분','1978-01-01','여','ADMIN','2025-02-25',500000),
    ('steve', '$2b$12$A0kgVpplgbH3ZZ1E89441eacUXljTTt7nP8I3RdLtW0P6/CXdEnCm', 'steve12@email.com', '김말자' , '1969-09-09','여', 'USER', '2025-02-28', 500000),
    ('json', '$2b$12$A0kgVpplgbH3ZZ1E89441eacUXljTTt7nP8I3RdLtW0P6/CXdEnCm', 'json12@email.com', '박미옥',  '1988-04-24','여', 'USER', '2025-03-01', 500000),
    ('tomcat', '$2b$12$A0kgVpplgbH3ZZ1E89441eacUXljTTt7nP8I3RdLtW0P6/CXdEnCm', 'tomcat12@email.com', '김철용', '1996-01-06','남', 'USER', NOW(), 500000),
    ('tomas', '$2b$12$A0kgVpplgbH3ZZ1E89441eacUXljTTt7nP8I3RdLtW0P6/CXdEnCm', 'tomas12@email.com', '곽두식', '1991-08-09','남', 'USER', NOW(), 500000),
    ('gerry', '$2b$12$A0kgVpplgbH3ZZ1E89441eacUXljTTt7nP8I3RdLtW0P6/CXdEnCm', 'gerry32@email.com', '박강훈', '1994-11-11','남', 'USER',NOW() , 500000);

--과목
INSERT INTO 과목 (title, explanation, price, instructor_name)
VALUES
    ('1종 자동.1종 수동 면허','1종 자동 면허는 자동변속기 차량만 운전할 수 있는 면허이며, 1종 수동 면허는 자동변속기와 수동변속기 차량 모두 운전할 수 있는 면허입니다.', 10000,'panda'),
    ('2종 보통 면허', '2종 보통면허는 승용차, 15인 이하 승합차, 3.5톤 이하 화물차 등을 운전할 수 있는 면허입니다.',10000,'panda'),
    ('1종 대형 면허', '1종 대형면허는 10톤 이상 대형 화물차 및 버스 등 대형 차량을 운전할 수 있는 면허입니다.',10000,'eddie'),
    ('2종 소형 면허','2종 소형면허는 4륜 이륜차와 3톤 이하 화물차, 9인 이하 승합차 등을 운전할 수 있는 면허입니다.',10000,'eddie');



-- 게시판
INSERT INTO 게시판 (title,content,user_name,created_date,modified_date)
VALUES
('2종소형 문의드립니다','안녕하세요 이번에 2종소형 면허 취득해보려고 학원에 등록좀 하려고하는데 2종소형 등록비용이나 준비물같은것이 뭐가 있나요?? 예를들어 증명사진 2장에 등록비만 들고가서 접수하면 되는건가요?? 그리고 바이크는 어떤종류로 시험을 보는지도 궁금합니다.','pengsoo',NOW(),NOW()),
('2종보통 수강료문의','2종보통 자동 수강료 문의드립니다','fourbie',NOW(),NOW()),
('2종소형 문의드립니다','관리자분 알려주세요 취득 까지는 대력 얼마 쯤 걸리나요?','tom',NOW(),NOW()),
('1종 보통 문의','1종 보통을 9월 말 쯤 하려고 하는데 그때 강습이 가능한지와 따는데 걸리는 대략적인 시간이 궁금합니다','steve',NOW(),NOW()),
('1종대형과 트레일러','1종 대형면허와 트레일러 면허를 동시 취득할 수 있다고 하는데 수강료 및 소요기간을 알고싶습니다.','steve',NOW(),NOW()),
('버스 지원 질문','제가 중구 선화동에 살고 있느데 혹시 통근 버스 운행은 하나요?','tomas',NOW(),NOW()),
('기능 시험','제가 기능 시험에 떨어져서 기능 시험만 따로 응시 하고 싶은데 혹시 가격이 얼만가요?','gerry',NOW(),NOW()),
('위치','혹시 위치는 어디있나요?','gerry',NOW(),NOW()),
('버스','근처에 버스정류장이 있나요?','pengsoo',NOW(),NOW()),
('기차','근처에 기차역이 있나요?','tomas',NOW(),NOW()),
('지하철 ','근처에 지하철역이 있나요?','totoro',NOW(),NOW()),
('택시 ','근처에 택시정류장이 있나요?','fourbie',NOW(),NOW());

-- 답글
INSERT INTO 답글 (user_name, comment, board_id)
VALUES
    ('totoro', '저도 궁금합니다.', 1),
    ('fourbie', '관리자분 알려주세요.', 1),
    ('tomcat', '문의 부탁드립니다.', 2),
    ('pengsoo', '아마 10000P 일듯.', 2),
    ('gerry', '2주 쯤?', 3),
    ('steve', '저도 궁금합니다.', 3),
    ('admin', '개인에 따라 2-3주 정도입니다.', 3),
    ('tom', '저도요.', 5),
    ('steve', '하는 걸로 알아요.', 6),
    ('steve', '그러게요.', 7),
    ('tom', '댓글입니다.', 7),
    ('fourbie', '나도 몰라요.', 7),
    ('tomas', '사이트 찾아보세요.', 8),
    ('totoro', '내 말이 ㅋㅋ.', 8),
    ('tomas', '있어요.', 9),
    ('fourbie', '그니까요.', 9),
    ('totoro', 'ㅇㅇ 있음.', 10),
    ('fourbie', '있는 듯.', 11),
    ('totoro', '아마도?.', 12);




-- 자동차종류
INSERT INTO 자동차종류 (name)
VALUES
('승용차'),
('화물차'),
('승합차'),
('버스'),
('스포츠카'),
('SUV'),
('트럭'),
('전기차'),
('하이브리드차'),
('밴승용차'),
('15인 이하 승합차'),
('3.5톤 이하 화물차'),
('소형 트레일러'),
('4륜 이륜차'),
('10톤 이상 대형 화물차'),
('대형 버스 (승객 16인 이상)'),
('특수 차량 (크레인, 불도저 등)'),
('4륜 이륜차 (125cc 이하)'),
('3.5톤 이하 화물차'),
('9인 이하 승합차'),
('소형 트레일러'),
('경형 자동차 (일반적으로 660cc 이하)');

-- 이미지
INSERT INTO 이미지 (image_url,subject_id,file_name)
VALUES
('img1.1.GIF',1,'oneNormalExplain'),
('image.png',2,'twoNormalExplain'),
('bus0.jpg',3,'oneBigExplain'),
('img2.1.GIF',4,'twoSmallExplain');

-- 비디오
INSERT INTO 비디오 (video_url,subject_id,img_url)
VALUES
('/mp4/1종자동수동.mp4',1,'/img/img1.1.GIF'),
('/mp4/2종 보통.mp4',2,'/img/image.png'),
('/mp4/1종 대형.mp4',3,'/img/bus0.jpg'),
('/mp4/2종 소형.mp4',4,'/img/img2.1.GIF');

--수강신청
INSERT INTO 수강신청 (user_name, subject_id, purchase_time, subject_price, completed)
VALUES
('pororo', 1 ,'2025-01-02 10:00:00',10000,0),
('pororo', 2 ,'2025-01-02 11:00:00',10000,0),
('pororo',3,'2025-01-03 11:00:00',10000,1),
('fourbie', 1 ,'2025-01-02 10:00:00',10000,0),
('fourbie', 2 ,'2025-01-02 11:00:00',10000,0),
('fourbie',4,'2025-01-03 11:00:00',10000,1),
('totoro', 1 ,'2025-01-02 10:00:00',10000,0),
('totoro', 2 ,'2025-01-02 11:00:00',10000,0),
('totoro',3,'2025-01-03 11:00:00',10000,1),
('totoro', 4 ,'2025-01-02 10:00:00',10000,0),
('tom', 3 ,'2025-01-02 11:00:00',10000,0),
('tom',1,'2025-01-03 11:00:00',10000,1),
('steve', 2 ,'2025-01-02 10:00:00',10000,0),
('gerry', 1 ,'2025-01-02 11:00:00',10000,0),
('tomas',1,'2025-01-03 11:00:00',10000,1);

-- 장바구니
INSERT INTO 장바구니 (subject_id,user_name)
VALUES
(2,'totoro'),
(1,'pengsoo'),
(3,'pororo');

--
--subject_type
INSERT INTO subject_type (subject_id,type_id)
VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(1, 5),
(1, 6),
(1, 7),
(1, 8),
(1, 9),
(1, 10),
(1, 11),
(1, 12),
(1, 15),
(1, 16),
(1, 17),
(1, 18),
(1, 19),
(1, 20),
(1, 21),
(1, 22),
(2, 1),
(2, 2),
(2, 3),
(2, 5),
(2, 6),
(2, 7),
(2, 8),
(2, 9),
(2, 10),
(2, 11),
(2, 12),
(2, 19),
(2, 20),
(2, 21),
(2, 22),
(3, 2),
(3, 3),
(3, 4),
(3, 7),
(3, 15),
(3, 16),
(3, 17),
(4, 22),
(4, 18),
(4, 21);
----
---- 데이터 삭제 후 id를 1부터 다시 삽입하는 법
----DELETE FROM 공지사항;
----ALTER TABLE 공지사항 AUTO_INCREMENT = 1;
----
----
ALTER TABLE 장바구니 DROP FOREIGN KEY FK143xiyeukn5pxyutgd5hdekjs;
ALTER TABLE 장바구니 DROP INDEX UKko5l80niauxjt6seh7wtws999;

ALTER TABLE 장바구니 DROP FOREIGN KEY FK19yn8cr9b97eobdv7fkojxcst;
ALTER TABLE 장바구니 DROP INDEX UKmcfbxhp457ldnb04irg14pcjj;
--
