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
(6, '강항해사', '항해사', 1, 2);

#문제2.
INSERT INTO 선박 (선박ID, 선박명, 선박종류, 도시ID, 현재선원수, 최소필요선원수) VALUES
(6, '오선스타호', '플루트', 3, 40, 20);

#문제3.
INSERT INTO 교역품 (교역품ID, 교역품명, 기준가격) VALUES
(5, '설탕', 800);

#문제4.
INSERT INTO 도시 (도시ID, 도시명) VALUES
(4, '암스테르담');

#문제5.
INSERT INTO 항해일지 (일지ID, 항해사ID, 출항일자, 귀환일자) VALUES
(1, 2, '2025-04-20', '2025-04-27');

#문제6.
INSERT INTO 거래기록 (거래ID, 항해사ID, 교역품ID, 수량, 거래가격, 거래일자) VALUES
(1, 1, 1, 100, 120000, '2025-04-26');

#문제7.
INSERT INTO 무기 (무기ID, 무기명, 공격력, 가격) VALUES
(1, '장검', 150, 3000);

#문제8.
INSERT INTO 길드원 (길드원ID, 길드ID, 항해사ID, 가입일자) VALUES
(1, 1, 6, '2025-04-28');

#문제9.
INSERT INTO 도시건물 (건물ID, 도시ID, 건물명, 기능) VALUES
(1, 1, '조선소', '선박 수릴 및 제작');

#문제10.
INSERT INTO 보물 (보물ID, 보물명, 가치, 발견도시ID, 위도, 경도) VALUES
(1, '황금항아리', 50000, 2, 37.3886, -5.9823);







