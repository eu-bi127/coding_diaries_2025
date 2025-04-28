use my_cat;

-- 1. 길드 테이블
CREATE TABLE 길드 (
    길드ID INT PRIMARY KEY,
    길드명 VARCHAR(50)
);

INSERT INTO 길드 (길드ID, 길드명) VALUES
(1, '고양이길드'),
(2, '삼성'),
(3, 'LG');

-- 2. 도시 테이블
CREATE TABLE 도시 (
    도시ID INT PRIMARY KEY,
    도시명 VARCHAR(50)
);

INSERT INTO 도시 (도시ID, 도시명) VALUES
(1, '리스본'),
(2, '세비야'),
(3, '런던');

-- 3. 항해사 테이블
CREATE TABLE 항해사 (
    항해사ID INT PRIMARY KEY,
    항해사명 VARCHAR(50),
    직급 VARCHAR(20),
    소속길드ID INT,
    도시ID INT
);

INSERT INTO 항해사 (항해사ID, 항해사명, 직급, 소속길드ID, 도시ID) VALUES
(1, '김항해사', '항해사', 1, 1),
(2, '이선장', '선장', 1, 1),
(3, '박항해사', '항해사', 2, 2),
(4, '조항해사', '항해사', 2, 2),
(5, '최항해사', '선장', 3, 3);

-- 4. 선박 테이블
CREATE TABLE 선박 (
    선박ID INT PRIMARY KEY,
    선박명 VARCHAR(50),
    선박종류 VARCHAR(20),
    도시ID INT,
    현재선원수 INT,
    최소필요선원수 INT
);

INSERT INTO 선박 (선박ID, 선박명, 선박종류, 도시ID, 현재선원수, 최소필요선원수) VALUES
(1, '블루오션호', '바사', 1, 50, 20),
(2, '레드필드호', '갤리온', 2, 45, 25),
(3, '그린웨이호', '카락', 3, 60, 30),
(4, '썬더호', '갤리온', 1, 55, 22),
(5, '에메랄드호', '카락', 2, 48, 28);

use my_cat;

-- 5. 교역품 테이블
CREATE TABLE 교역품 (
    교역품ID INT PRIMARY KEY,
    교역품명 VARCHAR(50),
    기준가격 INT
);

INSERT INTO 교역품 (교역품ID, 교역품명, 기준가격) VALUES
(1, '향신료', 1000),
(2, '비단', 1500),
(3, '철광석', 500),
(4, '와인', 700);

-- 6. 도시-교역품 테이블
CREATE TABLE 도시교역품 (
    도시ID INT,
    교역품ID INT,
    구입가 INT,
    판매가 INT,
    PRIMARY KEY (도시ID, 교역품ID)
);

INSERT INTO 도시교역품 (도시ID, 교역품ID, 구입가, 판매가) VALUES
(1, 1, 800, 1200), -- 리스본, 향신료
(1, 4, 600, 900),  -- 리스본, 와인
(2, 2, 1300, 1700),-- 세비야, 비단
(2, 4, 650, 950),  -- 세비야, 와인
(3, 3, 450, 600),  -- 런던, 철광석
(3, 2, 1400, 1600);-- 런던, 비단




#문제1.
INSERT INTO 항해사 (항해사ID, 항해사명, 직급, 소속길드ID, 도시ID) VALUES
(99, '삭제대상항에사', '항해사', 1, 1);

DELETE FROM 항해사
WHERE 항해사명 = '삭제대상항해사';


#문제2.
INSERT INTO 선박 (선박ID, 선박명, 선박종류, 도시ID, 현재선원수, 최소필요선원수) VALUES
(99, '삭제대상호', '갤리온', 1, 30, 15);

DELETE FROM 선박
WHERE 선박명 = '삭제대상호';

#문제3.
INSERT INTO 교역품 (교역품ID, 교역품명, 기준가격) VALUES 
(99, '삭제대상교역품', 999);

DELETE FROM 교역품
WHERE 교역품명 = '삭제대상교역품';

#문제4.
INSERT INTO 도시 (도시ID, 도시명) VALUES
(99, '삭제대상도시');

DELETE FROM 도시
WHERE 도시명 = '삭제대상도시';

#문제5.
INSERT INTO 항해일지 (일지ID, 항해사ID, 출항일자, 귀환일자) VALUES
(99, 1, '2019-12-30', '2020-01-02');

DELETE FROM 항해일지
WHERE 출행일자 < '2020-01-01';

#문제6.
INSERT INTO 무기 (무기ID, 무기명, 공격려, 가격) VALUES
(99, '삭제대상무기', 50, 800);

DELETE FROM 무기
WHERE 가격 < 1000;

#문제7.
INSERT INTO 선박업그레이드 (업그레이드ID, 선박ID, 업그레이드명, 업그레이드날짜) VALUES
(99, 1, '구형강화', '2019-12-01');

DELETE FROM 선박업그레이드
WHERE 업그레이드날짜 < '2020-01-01';

#문제8.
INSERT INTO 길드원 (길드원ID, 길드ID, 항해사ID, 가입일자) VALUES
(99, 1, 1, '2019-11-30');

DELETE FROM 길드원
WHERE 가입일자 < '2020-01-01';

#문제9.
INSERT INTO 도시건물 (건물ID, 도시ID, 건물명, 기능) VALUES 
(99, 1, '삭제대상건물', '없음');

DELETE FROM 도시건물
WHERE 기능 = '없음';

#문제10.
INSERT INTO 보물(보물ID, 보물명, 가치, 발견도시ID, 위도, 경도) VALUES 
(99, '삭제대상보물', 10000, 1, 0.000000, -5.982300);

DELETE FROM 보물 
WHERE 위도 = 0 OR 경도 = 0;


 



