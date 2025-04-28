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
UPDATE 항해사
SET 직급 = '선장'
WHERE 항해사명 = '김항해사';

#문제2.
UPDATE 선박
SET 현재선원수 = 60
WHERE 선박명 = '블루오션호';

#문제3.
UPDATE 교역품
SET 기준가격 = 1100
WHERE 교역품명 = '향신료';

#문제4.
UPDATE 도시
SET 도시명 = '신리스본'
WHERE 도시명 ='리스본';

#문제5.
UPDATE 항해일지
SET 귀환일자 = '2025-05-01'
WHERE 항해사ID =2;

#문제6.
UPDATE 무기
SET 가격 = 가격 * 0.9
WHERE 무기명 = '장검';

#문제7.
UPDATE 선박업그레이드
SET 업그레이드명 = '신형강화'
WHERE 업그레이드명 = '구형강화';

#문제8.
UPDATE 길드원
SET 가입일자 = '2025-05-01'
WHERE 항해사ID = 6;

#문제9.
UPDATE 도시건물
SET 기능 = '최신 선박 제작'
WHERE 건물명 = '조선소';

#문제10.
UPDATE 보물
SET 위도 = 38.7169, 경도 = -9.1399
WHERE 보물명 = '황금항아리';























